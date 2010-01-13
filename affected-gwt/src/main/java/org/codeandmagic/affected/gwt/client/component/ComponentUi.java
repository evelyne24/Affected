/*******************************************************************************
 * Copyright© 2010 Cristian Vrabie, Evelina Petronela Vrabie
 * 
 * This file is part of Affected.
 * 
 * Affected is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * Affected is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 * 
 * You should have received a copy of the GNU Lesser General Public License
 * along with Affected.  If not, see <http://www.gnu.org/licenses/>.
 ******************************************************************************/

package org.codeandmagic.affected.gwt.client.component;

import org.codeandmagic.affected.component.Component;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.DivElement;
import com.google.gwt.dom.client.SpanElement;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;

public class ComponentUi extends Composite {
	// affected data
	private Component component;

	// gwt data
	private static ComponentUiUiBinder uiBinder = GWT.create(ComponentUiUiBinder.class);

	interface ComponentUiUiBinder extends UiBinder<DivElement, ComponentUi> {}

	@UiField
	SpanElement prettyName;

	public ComponentUi(Component component) {
		setElement(uiBinder.createAndBindUi(this));
		this.component = component;
		init();

	}

	public void init() {
		prettyName.setInnerText(component.getPrettyName());
	}

	public Component getComponent() {
		return component;
	}

	public void setComponent(Component component) {
		this.component = component;
	}

	public SpanElement getPrettyName() {
		return prettyName;
	}

	public void setPrettyName(SpanElement name) {
		this.prettyName = name;
	}
}
