package org.codeandmagic.affected.gwt.client.draw.line;

import org.codeandmagic.affected.gwt.client.dojowrapper.gfx.DojoAbstractPath;
import org.codeandmagic.affected.gwt.client.dojowrapper.gfx.DojoPoint;
import org.codeandmagic.affected.gwt.client.draw.point.Point;
import org.codeandmagic.affected.gwt.client.draw.point.PointEventListener;

public abstract class AbstractLine extends DojoAbstractPath implements
		PointEventListener {

	protected DojoPoint start;
	protected DojoPoint end;
	private boolean deleted = false;

	public DojoPoint getStart() {
		return start;
	}

	public void setStart(DojoPoint start) {
		this.start = start;
	}

	public DojoPoint getEnd() {
		return end;
	}

	public void setEnd(DojoPoint end) {
		this.end = end;
	}

	public void onPointChange(Point p) {
		if (p == this.start || p == this.end)
			updatePath();
	}

	public void onPointDelete(Point p) {
		//      -   .
		if (p == this.start || p == this.end)
			this.delete();
	}

	public void delete() {
		if (!deleted) {
			this.deleted = true;

			this.start.delete();
			this.end.delete();

			this.remove();
		}
	}
}
