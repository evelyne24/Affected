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

	interface CreateComponentDialogUiBinder extends
			UiBinder<HTMLPanel, CreateComponentDialog> {
	}

	@UiField
	TextBox name;
	@UiField
	TextBox tag;
	@UiField
	Button cancel;
	@UiField
	Button ok;

	public CreateComponentDialog() {
		setWidget(uiBinder.createAndBindUi(this));
		// set dialog caption
		setText("Create a Component");

		setAnimationEnabled(true);
		setGlassEnabled(true);
	}

	@UiHandler("cancel")
	void onCancelClicked(ClickEvent event) {
		hide();
	}

	@UiHandler("ok")
	void onOkClicked(ClickEvent event) {
		createComponent();
	}

	private void createComponent() {

		// notify the drawing area to insert a new component with the given
		// details

	}

}
