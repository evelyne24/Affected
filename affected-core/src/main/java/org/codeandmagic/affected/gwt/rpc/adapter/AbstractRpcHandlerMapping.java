package org.codeandmagic.affected.gwt.rpc.adapter;

import org.springframework.web.servlet.handler.AbstractDetectingUrlHandlerMapping;

import com.google.gwt.user.client.rpc.RemoteService;

public abstract class AbstractRpcHandlerMapping extends
		AbstractDetectingUrlHandlerMapping {
	protected String prefix = "/rpc/";
	protected String suffix = "";

	protected String[] buildUrls(Class<?> handlerType, String beanName) {

		String remoteServiceName = handlerType.getClass().getName();
		Class<?>[] interfaces = handlerType.getInterfaces();
		for (Class<?> itf : interfaces) {
			// find the interface that extends RemoteService
			if (RemoteService.class.isAssignableFrom(itf)) {
				remoteServiceName = itf.getName();
			}
		}

		if (remoteServiceName == null) {
			throw new IllegalArgumentException(
					"Unable to generate name for "
							+ handlerType.getName()
							+ "; cannot locate interface that is a subclass of RemoteService");
		}

		StringBuilder sb = new StringBuilder();
		sb.append(prefix);

		// String classPath = StringUtils.replace(remoteServiceName,".", "/");
		String className = remoteServiceName.substring(remoteServiceName
				.lastIndexOf('.') + 1, remoteServiceName
				.lastIndexOf("RpcService"));
		sb.append(className.substring(0, 1).toLowerCase());
		sb.append(className.substring(1));

		sb.append(suffix);

		return new String[] { sb.toString() };
	}

	public final void setPrefix(String prefix) {
		this.prefix = prefix;
	}

	public final void setSuffix(String suffix) {
		this.suffix = suffix;
	}
}
