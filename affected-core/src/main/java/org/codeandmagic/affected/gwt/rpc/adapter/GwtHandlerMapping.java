package org.codeandmagic.affected.gwt.rpc.adapter;

import org.springframework.util.StringUtils;

/**
 * Spring HandlerMapping that detects beans annotated with @GwtRpcEndPoint and
 * registers their URLs.
 * 
 */
public class GwtHandlerMapping extends AbstractRpcHandlerMapping {

	public GwtHandlerMapping() {
		this.suffix = ".gwt";
	}

	@Override
	protected final String[] determineUrlsForHandler(String beanName) {
		String[] urls = new String[0];

		Class<?> handlerType = getApplicationContext().getType(beanName);
		if (handlerType.isAnnotationPresent(GwtRpcEndPoint.class)) {
			GwtRpcEndPoint endPointAnnotation = handlerType
					.getAnnotation(GwtRpcEndPoint.class);
			if (StringUtils.hasText(endPointAnnotation.value())) {
				urls = new String[] { endPointAnnotation.value() };
			} else {
				urls = buildUrls(handlerType, beanName);
			}
		}

		return urls;
	}
}
