package org.codeandmagic.affected.gwt.client.dojowrapper.gfx;

import org.codeandmagic.affected.gwt.client.draw.base.Color;

import com.google.gwt.core.client.JavaScriptObject;

public class DojoStroke {
	private final JavaScriptObject stroke;

	// predefined strokes
	public static final DojoStroke RED_BOLD_STROKE = new DojoStroke(
			Color.RED, 10);

	public static final DojoStroke BLACK_BOLD_STROKE = new DojoStroke(
			Color.BLACK, 8);

	public static final DojoStroke GRAY_BOLD_STROKE = new DojoStroke(
			Color.GRAY, 2);

	public static final DojoStroke GRAY_STROKE = new DojoStroke(Color.GRAY,
			1);

	public DojoStroke(Color color, int width) {
		this.stroke = getNativeStroke(color.getColor(), width);
	}

	public static void applyStroke(DojoShape shape, DojoStroke stroke) {
		if (shape == null || shape.getShape() == null)
			throw new IllegalArgumentException("DojoShape can't be null.");

		if (stroke == null)
			throw new IllegalArgumentException("DojoStroke can't be null.");

		setNativeStroke(shape.getShape(), stroke.stroke);
	}

	private static native JavaScriptObject getNativeStroke(String color_,
			int width_)
	/*-{
		return {color: color_, width: width_};
	}-*/;

	private static native JavaScriptObject setNativeStroke(
			JavaScriptObject shape, JavaScriptObject stroke)
	/*-{
		return shape.setStroke(stroke);
	}-*/;
}
