package org.codeandmagic.affected.gwt.client.draw.line;

import org.codeandmagic.affected.gwt.client.dojowrapper.gfx.DojoGFX;
import org.codeandmagic.affected.gwt.client.dojowrapper.gfx.DojoPoint;
import org.codeandmagic.affected.gwt.client.dojowrapper.gfx.DojoStroke;
import org.codeandmagic.affected.gwt.client.draw.point.Point;

public class CurvedLine extends AbstractLine {
	protected DojoPoint startVector;
	protected DojoPoint endVector;

	public CurvedLine(DojoGFX gfx, DojoPoint start, DojoPoint end,
			DojoPoint startVector, DojoPoint endVector, DojoStroke stroke) {
		if (gfx == null) {
			throw new IllegalArgumentException("DojoGFX can't be null.");
		}
		if (start == null) {
			throw new IllegalArgumentException("Start DojoPoint can't be null.");
		}
		if (end == null) {
			throw new IllegalArgumentException("End DojoPoint can't be null.");
		}
		if (startVector == null) {
			throw new IllegalArgumentException(
					"StartVector DojoPoint can't be null.");
		}
		if (endVector == null) {
			throw new IllegalArgumentException(
					"EndVector DojoPoint can't be null.");
		}
		if (stroke == null) {
			throw new IllegalArgumentException("DojoStroke can't be null.");
		}

		this.gfx = gfx;
		this.start = start;
		this.end = end;
		this.startVector = startVector;
		this.endVector = endVector;

		this.start.addPointEventListener(this);
		this.end.addPointEventListener(this);
		this.startVector.addPointEventListener(this);
		this.endVector.addPointEventListener(this);

		this.createPath();
		this.setStroke(stroke);
	}

	public DojoPoint getStartVector() {
		return startVector;
	}

	public void setStartVector(DojoPoint startVector) {
		this.startVector = startVector;
	}

	public DojoPoint getEndVector() {
		return endVector;
	}

	public void setEndVector(DojoPoint endVector) {
		this.endVector = endVector;
	}

	public void onPointChange(Point p) {
		if (p == this.startVector || p == this.endVector || p == this.start
				|| p == this.end)
			updatePath();
	}

	@Override
	protected String getRawPath() {
		return "M" + this.start.getDojoX() + " " + this.start.getDojoY() + " C"
				+ this.startVector.getDojoX() + " "
				+ this.startVector.getDojoY() + " " + this.endVector.getDojoX()
				+ " " + this.endVector.getDojoY() + " " + this.end.getDojoX()
				+ " " + this.end.getDojoY();
	}

}
