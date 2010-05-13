package org.codeandmagic.affected.gwt.client.dojowrapper.gfx;

import com.google.gwt.core.client.JavaScriptObject;

/**
 * Dojo GFX Group wrapper.
 * 
 * @author Evelina Vrabie
 * 
 */
public class DojoGFXGroup extends DojoGFX {
	private final JavaScriptObject group;

	public DojoGFXGroup(DojoGFX gfx) {
		super(gfx);

		this.group = nativeCreateGroup(gfx.getSurface());
	}

	private native JavaScriptObject nativeCreateGroup(JavaScriptObject surface)
	/*-{
		return surface.createGroup();
	}-*/;

	public JavaScriptObject getSurface() {
		return group;
	}
}
