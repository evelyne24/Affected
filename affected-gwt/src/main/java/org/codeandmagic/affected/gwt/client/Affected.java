package org.codeandmagic.affected.gwt.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;

public class Affected implements EntryPoint {

	/**
	 * This is the entry point method.
	 */
	public void onModuleLoad() {

		RootPanel.get().add(new Label("hello gwt!"));
	}
}
