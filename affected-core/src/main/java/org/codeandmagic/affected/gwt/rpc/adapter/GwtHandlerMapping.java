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
