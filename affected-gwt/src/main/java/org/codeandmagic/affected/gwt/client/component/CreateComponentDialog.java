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
package org.codeandmagic.affected.gwt.client.component;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.TextBox;

public class CreateComponentDialog extends DialogBox {

	private static CreateComponentDialogUiBinder uiBinder = GWT
			.create(CreateComponentDialogUiBinder.class);

	interface CreateComponentDialogUiBinder extends UiBinder<HTMLPanel, CreateComponentDialog> {}

	@UiField TextBox name;
	@UiField TextBox tag;
	@UiField Button cancel;
	@UiField Button ok;

	public CreateComponentDialog() {
		setWidget(uiBinder.createAndBindUi(this));
		// set dialog caption
		setText("Create a Component");

		setAnimationEnabled(true);
		setGlassEnabled(true);
	}

	@UiHandler("cancel") void onCancelClicked(ClickEvent event) {
		hide();
	}

	@UiHandler("ok") void onOkClicked(ClickEvent event) {
		createComponent();
	}

	private void createComponent() {

	// notify the drawing area to insert a new component with the given details

	}

}
