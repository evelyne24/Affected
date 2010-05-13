package org.codeandmagic.affected.gwt.client.draw.rectangle;

import org.codeandmagic.affected.gwt.client.dojowrapper.gfx.DojoAbstractPath;
import org.codeandmagic.affected.gwt.client.dojowrapper.gfx.DojoGFX;
import org.codeandmagic.affected.gwt.client.dojowrapper.gfx.DojoStroke;
import org.codeandmagic.affected.gwt.client.draw.point.Point;
import org.codeandmagic.affected.gwt.client.draw.point.PointEventListener;

public class Rectangle extends DojoAbstractPath implements PointEventListener {
	private Point point;
	private Point size;
	private boolean deleted = false;

	public Rectangle(DojoGFX gfx, Point point, Point size, DojoStroke stroke) {
		if (gfx == null) {
			throw new IllegalArgumentException("DojoGFX can't be null.");
		}
		if (point == null) {
			throw new IllegalArgumentException("Start DojoPoint can't be null.");
		}
		if (size == null) {
			throw new IllegalArgumentException("End DojoPoint can't be null.");
		}
		if (stroke == null) {
			throw new IllegalArgumentException("DojoStroke can't be null.");
		}

		this.gfx = gfx;
		this.point = point;
		this.size = size;

		this.point.addPointEventListener(this);
		this.size.addPointEventListener(this);

		this.createPath();
		this.setStroke(stroke);
	}

	@Override
	protected String getRawPath() {
		return "M" + this.point.getX() + " " + this.point.getY() + " h"
				+ this.size.getX() + " v" + this.size.getY() + " h-"
				+ this.size.getX() + " Z";
	}

	public void onPointChange(Point p) {
		updatePath();
	}

	public void onPointDelete(Point p) {
		if (!deleted) {
			this.deleted = true;

			this.point.delete();
			this.size.delete();

			this.remove();
		}
	}
}
