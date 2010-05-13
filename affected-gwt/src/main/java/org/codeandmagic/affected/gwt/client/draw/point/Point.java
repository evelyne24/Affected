package org.codeandmagic.affected.gwt.client.draw.point;

public class Point {
	private int x;
	private int y;
	private boolean deleted = false;
	private PointEventListenerCollection pointChangeListeners;

	public Point() {
		this(0, 0);
	}

	public Point(int x, int y) {
		this.setPoint(x, y);
	}

	public Point(Point p) {
		this.setPoint(p);
	}

	public void setPoint(int x, int y) {
		if (this.x != x || this.y != y) {
			this.x = x;
			this.y = y;
			doPointChange();
		}
	}

	public boolean setPointSilently(int x, int y) {
		if (this.x != x || this.y != y) {
			this.x = x;
			this.y = y;

			return true;
		}
		return false;
	}

	public void setPoint(Point p) {
		if (p == null) {
			throw new IllegalArgumentException("Point can't be null.");
		}

		setPoint(p.x, p.y);
	}

	public int getX() {
		return this.x;
	}

	public void setX(int x) {
		if (this.x != x) {
			this.x = x;
			doPointChange();
		}
	}

	public int getY() {
		return this.y;
	}

	public void setY(int y) {
		if (this.y != y) {
			this.y = y;
			doPointChange();
		}
	}

	public void delete() {
		if (!this.deleted) {
			this.deleted = true;

			if (this.pointChangeListeners != null)
				this.pointChangeListeners.fireDelete(this);
		}
	}

	public void doPointChange() {
		if (this.pointChangeListeners != null)
			this.pointChangeListeners.fireChange(this);
	}

	public void addPointEventListener(PointEventListener listener) {
		if (this.pointChangeListeners == null) {
			this.pointChangeListeners = new PointEventListenerCollection();
		}
		this.pointChangeListeners.add(listener);
	}

	public void removePointEventListener(PointEventListener listener) {
		if (this.pointChangeListeners != null) {
			this.pointChangeListeners.remove(listener);
		}
	}

	public boolean isDeleted() {
		return deleted;
	}
}
