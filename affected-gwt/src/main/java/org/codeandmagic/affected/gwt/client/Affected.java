package org.codeandmagic.affected.gwt.client;

import org.codeandmagic.affected.gwt.client.dojowrapper.gfx.DojoDefaultGFX;
import org.codeandmagic.affected.gwt.client.dojowrapper.gfx.DojoGFX;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.RootPanel;

public class Affected implements EntryPoint {

	private static Affected instance;

	public void onModuleLoad() {
		instance = this;
		subscribeLoad();
	}

	/**
	 * Subscribing to dojo OnLoad event.
	 */
	private native void subscribeLoad()
	/*-{
		$wnd.dojo.addOnLoad(@org.codeandmagic.affected.gwt.client.Affected::doDojoLoad());
	}-*/;

	/**
	 * Method called after dojo loaded.
	 */
	public static void doDojoLoad() {
		instance.realOnLoad();
	}

	private void realOnLoad() {
		RootPanel root = RootPanel.get("gfx_holder");
		FlowPanel gfxRoot = new FlowPanel();
		DojoDefaultGFX.setInstance(new DojoGFX(gfxRoot));
		root.add(gfxRoot);

	}
}
