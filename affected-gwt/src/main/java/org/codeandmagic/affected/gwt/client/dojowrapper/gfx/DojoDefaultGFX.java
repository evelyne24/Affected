package org.codeandmagic.affected.gwt.client.dojowrapper.gfx;

public class DojoDefaultGFX {
	private static DojoGFX instance;

	public static DojoGFX getInstance() {
		return instance;
	}

	public static void setInstance(DojoGFX instance) {
		DojoDefaultGFX.instance = instance;
	}
}
