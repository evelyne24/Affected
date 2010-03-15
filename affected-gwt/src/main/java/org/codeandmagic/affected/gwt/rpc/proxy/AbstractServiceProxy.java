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
package org.codeandmagic.affected.gwt.rpc.proxy;

import com.google.gwt.user.client.rpc.ServiceDefTarget;

public abstract class AbstractServiceProxy {

	protected final static String prefix = "/affected/rpc/";
	protected final static String sufix = ".gwt";

	private AbstractServiceProxy() {
	}

	public static void initService(Object service) {
		// sets the url = prefix + service class name +suffix
		ServiceDefTarget target = (ServiceDefTarget) service;
		String serviceName = service.getClass().getName();
		StringBuffer sb = new StringBuffer();
		sb.append(prefix);

		serviceName = serviceName.substring(serviceName.lastIndexOf('.') + 1,
				serviceName.lastIndexOf("RpcService"));
		sb.append(serviceName.substring(0, 1).toLowerCase());
		sb.append(serviceName.substring(1));

		sb.append(sufix);
		target.setServiceEntryPoint(sb.toString());
	}
}
