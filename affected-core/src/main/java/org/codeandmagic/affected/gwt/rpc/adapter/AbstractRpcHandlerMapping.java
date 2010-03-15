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
