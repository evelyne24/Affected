package org.codeandmagic.affected.gwt.client.widgets;

import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.ui.PushButton;

public class FlyButton extends PushButton {
	public FlyButton(String title, String styleName) {
		super();

		this.setVisible(false);
		this.setStyleName(styleName);
		this.setTitle(title);
		DOM.setStyleAttribute(this.getElement(), "position", "absolute");
	}

	public void setTop(int top) {
		DOM.setStyleAttribute(this.getElement(), "top", top + "px");
	}

	public void setRight(int right) {
		DOM.setStyleAttribute(this.getElement(), "right", right + "px");
	}

	public void setLeft(int left) {
		DOM.setStyleAttribute(this.getElement(), "left", left + "px");
	}

	public void setBottom(int bottom) {
		DOM.setStyleAttribute(this.getElement(), "bottom", bottom + "px");
	}
}
