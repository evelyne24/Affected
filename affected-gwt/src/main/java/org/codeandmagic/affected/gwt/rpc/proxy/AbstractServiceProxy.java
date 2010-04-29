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
