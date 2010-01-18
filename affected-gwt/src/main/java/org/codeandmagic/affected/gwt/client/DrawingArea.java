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

package org.codeandmagic.affected.gwt.client;

import org.codeandmagic.affected.gwt.client.component.ComponentUi;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;

public class DrawingArea extends Composite {

	private static DrawingAreaUiBinder uiBinder = GWT.create(DrawingAreaUiBinder.class);

	interface DrawingAreaUiBinder extends UiBinder<Widget, DrawingArea> {}

	public DrawingArea() {
		initWidget(uiBinder.createAndBindUi(this));
	}

	@UiField AbsolutePanel canvas;

	public void addComponent(ComponentUi compUi) {
		canvas.add(compUi, 10, 40);
	}
}
