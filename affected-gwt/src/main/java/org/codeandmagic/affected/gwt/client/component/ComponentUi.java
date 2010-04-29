package org.codeandmagic.affected.gwt.client.component;

import org.codeandmagic.affected.component.Component;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.SpanElement;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;

public class ComponentUi extends Composite {
	// affected data
	private Component component;

	// gwt data
	private static ComponentUiUiBinder uiBinder = GWT
			.create(ComponentUiUiBinder.class);

	interface ComponentUiUiBinder extends UiBinder<Widget, ComponentUi> {
	}

	@UiField
	SpanElement prettyName;

	public ComponentUi(Component component) {
		initWidget(uiBinder.createAndBindUi(this));
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
