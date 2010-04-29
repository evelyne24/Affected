package org.codeandmagic.affected.gwt.client;

import org.codeandmagic.affected.gwt.client.component.CreateComponentDialog;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;

public class AppMenu extends Composite {

	private static AppMenuUiBinder uiBinder = GWT.create(AppMenuUiBinder.class);

	interface AppMenuUiBinder extends UiBinder<Widget, AppMenu> {
	}

	@UiField
	Anchor createComponent;
	@UiField
	Anchor deleteComponent;

	public AppMenu() {
		initWidget(uiBinder.createAndBindUi(this));
	}

	@UiHandler("createComponent")
	void onCreateComponentClicked(ClickEvent event) {
		// show create dialog
		CreateComponentDialog dialog = new CreateComponentDialog();
		dialog.show();
		dialog.center();
	}

	@UiHandler("deleteComponent")
	void onDeleteComponentClicked(ClickEvent event) {
		// show delete dialog
		Window.alert("Delete component");
	}

}
