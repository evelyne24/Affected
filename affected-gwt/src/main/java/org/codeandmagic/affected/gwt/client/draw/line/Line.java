package org.codeandmagic.affected.gwt.client.draw.line;

import org.codeandmagic.affected.gwt.client.dojowrapper.gfx.DojoGFX;
import org.codeandmagic.affected.gwt.client.dojowrapper.gfx.DojoPoint;
import org.codeandmagic.affected.gwt.client.dojowrapper.gfx.DojoStroke;

public class Line extends AbstractLine {

	public Line(DojoGFX gfx, DojoPoint start, DojoPoint end, DojoStroke stroke) {
		if (gfx == null) {
			throw new IllegalArgumentException("DojoGFX can't be null.");
		}
		if (start == null) {
			throw new IllegalArgumentException("Start DojoPoint can't be null.");
		}
		if (end == null) {
			throw new IllegalArgumentException("End DojoPoint can't be null.");
		}
		if (stroke == null) {
			throw new IllegalArgumentException("DojoStroke can't be null.");
		}

		this.gfx = gfx;
		this.start = start;
		this.end = end;

		this.start.addPointEventListener(this);
		this.end.addPointEventListener(this);

		this.createPath();
		this.setStroke(stroke);
	}

	@Override
	protected String getRawPath() {
		return "M" + this.start.getDojoX() + " " + this.start.getDojoY() + " L"
				+ this.end.getDojoX() + " " + this.end.getDojoY();
	}

}
