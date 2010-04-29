package org.codeandmagic.affected.gwt.client;

import org.codeandmagic.affected.gwt.client.component.ComponentUi;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;

public class DrawingArea extends Composite {

	private static DrawingAreaUiBinder uiBinder = GWT
			.create(DrawingAreaUiBinder.class);

	interface DrawingAreaUiBinder extends UiBinder<Widget, DrawingArea> {
	}

	public DrawingArea() {
		initWidget(uiBinder.createAndBindUi(this));
	}

	@UiField
	AbsolutePanel canvas;

	public void addComponent(ComponentUi compUi) {
		canvas.add(compUi, 10, 40);
	}
}
