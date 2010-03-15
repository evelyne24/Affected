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
package org.codeandmagic.affected.gwt.client;

import java.util.List;

import org.codeandmagic.affected.component.Component;
import org.codeandmagic.affected.gwt.rpc.proxy.AbstractServiceProxy;
import org.codeandmagic.affected.gwt.rpc.service.ComponentRpcService;
import org.codeandmagic.affected.gwt.rpc.service.ComponentRpcServiceAsync;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.RootLayoutPanel;

public class Affected implements EntryPoint {

	private static AffectedUiBinder uiBinder = GWT
			.create(AffectedUiBinder.class);

	interface AffectedUiBinder extends UiBinder<HorizontalPanel, Affected> {
	}

	@UiField
	AppMenu appMenu;
	@UiField
	DrawingArea drawingArea;

	private ComponentRpcServiceAsync componentService;

	private void initServices() {
		componentService = GWT.create(ComponentRpcService.class);
		AbstractServiceProxy.initService(componentService);
	}

	public void onModuleLoad() {
		initServices();

		// Create the ui defined in Affected.ui.xml
		HorizontalPanel mainWidget = uiBinder.createAndBindUi(this);
		RootLayoutPanel.get().add(mainWidget);

		componentService.getAll(new AsyncCallback<List<Component>>() {

			public void onSuccess(List<Component> arg0) {
				Window.alert(arg0 + " ");
			}

			public void onFailure(Throwable arg0) {
				Window.alert("Failure!");
			}
		});
	}
}
