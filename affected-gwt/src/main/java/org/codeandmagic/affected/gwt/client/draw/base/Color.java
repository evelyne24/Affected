package org.codeandmagic.affected.gwt.client.draw.base;

public class Color {
	private final String color;

	// predefined colors
	public static final Color BLACK = new Color(0, 0, 0);
	public static final Color RED = new Color(255, 0, 0);
	public static final Color GRAY = new Color(100, 100, 100);

	public Color(String color) {
		this.color = color;
	}

	public Color(int red, int green, int blue) {
		this.color = getStringColor(red, green, blue);
	}

	public String getColor() {
		return color;
	}

	private String getStringColor(int red, int green, int blue) {
		return "#" + appendLeadZero(Integer.toHexString(red))
				+ appendLeadZero(Integer.toHexString(green))
				+ appendLeadZero(Integer.toHexString(blue));
	}

	private String appendLeadZero(String hexByte) {
		if (hexByte.length() == 1)
			return "0" + hexByte;
		else
			return hexByte;
	}
}
