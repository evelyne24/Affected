/*******************************************************************************
 * Copyright© 2010 Cristian Vrabie, Evelina Petronela Vrabie
 *   
 * This file is part of Affected.
 *   
 * Affected is free software: you can redistribute it and/or modify 
 * it under the terms of the GNU Lesser General Public License as published by 
 * the Free Software Foundation, either version 3 of the License, 
 * or (at your option) any later version.
 *   
 * Affected is distributed in the hope that it will be useful, 
 * but WITHOUT ANY WARRANTY; without even the implied   warranty of 
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the 
 * GNU Lesser General Public License for more details.
 *   
 * You should have received a copy of the GNU Lesser General Public License
 * along with Affected.  If not, see <http://www.gnu.org/licenses/>
 ******************************************************************************/
package org.codeandmagic.affected.gwt.rpc.adapter;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.HashMap;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.beanlib.hibernate3.Hibernate3BeanReplicator;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.context.ServletContextAware;
import org.springframework.web.servlet.HandlerAdapter;
import org.springframework.web.servlet.ModelAndView;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.server.rpc.RPC;
import com.google.gwt.user.server.rpc.RPCRequest;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;

/**
 * Spring HandlerAdapter to dispatch GWT-RPC requests. Relies on handlers
 * registered by GwtHandlerMapper
 */
public class GwtRcpEndPointHandlerAdapter extends RemoteServiceServlet
		implements HandlerAdapter, ServletContextAware {
	private static final long serialVersionUID = 1L;

	private Log log = LogFactory.getLog(GwtRcpEndPointHandlerAdapter.class);

	private ServletContext servletContext;
	private final Hibernate3BeanReplicator replicator = new Hibernate3BeanReplicator();

	private final HashMap<String, Object> serviceProxysCache = new HashMap<String, Object>();

	@Override
	public ServletContext getServletContext() {
		return this.servletContext;
	}

	public void setServletContext(ServletContext arg0) {
		this.servletContext = arg0;
	}

	@SuppressWarnings("unchecked")
	private static ThreadLocal handlerHolder = new ThreadLocal();

	public long getLastModified(HttpServletRequest request, Object handler) {
		return -1;
	}

	@SuppressWarnings("unchecked")
	public ModelAndView handle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {

		this.log.debug("Forwarding request '" + request.getRequestURI() + "?"
				+ request.getQueryString() + "' to handler '" + handler + "'");

		try {
			// store the handler for retrieval in processCall()
			handlerHolder.set(handler);
			// delegates the parameter deserialization and method invoking to
			// RemoteServiceServlet
			doPost(request, response);
		} finally {
			// clear out thread local to avoid resource leak
			handlerHolder.set(null);
		}

		return null;
	}

	protected Object getCurrentHandler() {
		return handlerHolder.get();
	}

	public boolean supports(Object handler) {
		return handler instanceof RemoteService
				&& handler.getClass().isAnnotationPresent(GwtRpcEndPoint.class);
	}

	private Object getProxyForService(Object service) {
		if (!this.serviceProxysCache.containsKey(service.getClass().getName())) {
			synchronized (this) {
				this.serviceProxysCache.put(service.getClass().getName(),
						RpcServiceProxy.newInstance(service, replicator));
			}
		}
		return this.serviceProxysCache.get(service.getClass().getName());
	}

	@Override
	public String processCall(String payload) throws SerializationException {
		try {
			// decode request parameters
			RPCRequest rpcRequest = RPC.decodeRequest(payload,
					getCurrentHandler().getClass());

			// create proxy that will translate any hibernate specific beans
			// in standard java beans
			Object proxy = this.getProxyForService(getCurrentHandler());

			String retVal = RPC.invokeAndEncodeResponse(proxy, rpcRequest
					.getMethod(), rpcRequest.getParameters());
			return retVal;

		} catch (Throwable t) {
			log.debug("Sending exception to GWT: ", t);
			return RPC.encodeResponseForFailure(null, t);
		}
	}
}

class RpcServiceProxy implements InvocationHandler {
	private Object obj;
	private Hibernate3BeanReplicator replicator;

	public static Object newInstance(Object obj,
			Hibernate3BeanReplicator replicator2) {
		return Proxy.newProxyInstance(obj.getClass().getClassLoader(), obj
				.getClass().getInterfaces(), new RpcServiceProxy(obj,
				replicator2));
	}

	private RpcServiceProxy(Object obj, Hibernate3BeanReplicator replicator2) {
		this.obj = obj;
		this.replicator = replicator2;
	}

	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		Object result = method.invoke(obj, args);
		return replicator.deepCopy(result);
	}

}
