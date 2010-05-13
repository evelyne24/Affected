package org.codeandmagic.affected.gwt.client.dojowrapper.gfx;

import org.codeandmagic.affected.gwt.client.draw.base.Color;

import com.google.gwt.core.client.JavaScriptObject;

public class DojoShape {
	protected JavaScriptObject shape;
	protected DojoGFX gfx;

	public JavaScriptObject getShape() {
		return shape;
	}

	public void setStroke(DojoStroke stroke) {
		DojoStroke.applyStroke(this, stroke);
	}

	public void setFill(Color color) {
		nativeSetFill(this.shape, color.getColor());
	}

	public void remove() {
		nativeRemovePath(this.gfx.getSurface(), this.shape, true);
	}

	private static native JavaScriptObject nativeRemovePath(
			JavaScriptObject surface, JavaScriptObject shape, boolean silently)
	/*-{
		return surface.remove(shape, silently);
	}-*/;

	private static native JavaScriptObject nativeSetFill(
			JavaScriptObject shape, String color)
	/*-{
		return shape.setFill(color);
	}-*/;
}
