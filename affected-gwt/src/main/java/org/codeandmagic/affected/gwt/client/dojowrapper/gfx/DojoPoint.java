package org.codeandmagic.affected.gwt.client.dojowrapper.gfx;

import org.codeandmagic.affected.gwt.client.draw.point.Point;

public class DojoPoint extends Point {

	public void setDojoPoint(int x, int y) {
		super.setPoint(x/* + DojoDefaultGFX.getInstsnce().getAbsoluteLeft()*/,
				y/* + DojoDefaultGFX.getInstsnce().getAbsoluteTop()*/);
	}

	public void setDojoX(int x) {
		super.setX(x/* + DojoDefaultGFX.getInstsnce().getAbsoluteLeft()*/);
	}

	public void setDojoY(int y) {
		super.setY(y/* + DojoDefaultGFX.getInstsnce().getAbsoluteTop()*/);
	}

	public int getDojoX() {
		return super.getX();// - DojoDefaultGFX.getInstsnce().getAbsoluteLeft();
	}

	public int getDojoY() {
		return super.getY();// - DojoDefaultGFX.getInstsnce().getAbsoluteTop();
	}
}
