package org.codeandmagic.affected.gwt.client.draw.anchor;

import org.codeandmagic.affected.gwt.client.dojowrapper.gfx.DojoPoint;
import org.codeandmagic.affected.gwt.client.draw.point.Point;
import org.codeandmagic.affected.gwt.client.draw.point.PointEventListener;

public class Anchor implements PointEventListener {
	private boolean deleted = false;

	private DojoPoint anchorPoint;
	private DojoPoint anchorDirectionPoint;
	private DojoPoint anchorVectorPoint;
	private AnchorEventListenerCollection anchorVectorEventListeners;

	public Anchor() {
		this.anchorPoint = new DojoPoint();
		this.anchorDirectionPoint = new DojoPoint();
		this.anchorPoint.addPointEventListener(this);
	}

	public DojoPoint getAnchorPoint() {
		return this.anchorPoint;
	}

	public DojoPoint getAnchorVectorPoint() {
		return this.anchorVectorPoint;
	}

	public DojoPoint getAnchorDirectionPoint() {
		return this.anchorDirectionPoint;
	}

	public void setAnchorVectorPoint(DojoPoint vectorPoint) {
		if (this.anchorVectorPoint != vectorPoint) {
			if (this.anchorVectorPoint != null)
				this.anchorVectorPoint.removePointEventListener(this);

			this.anchorVectorPoint = vectorPoint;

			if (this.anchorVectorPoint != null)
				this.anchorVectorPoint.addPointEventListener(this);
		}
	}

	private void doVectorPointChanged() {
		if (this.anchorVectorEventListeners != null)
			this.anchorVectorEventListeners.fireAnchorVectorPointChanged(this);
	}

	public void addAnchorVectorEventListener(AnchorEventListener listener) {
		if (this.anchorVectorEventListeners == null) {
			this.anchorVectorEventListeners = new AnchorEventListenerCollection();
		}
		this.anchorVectorEventListeners.add(listener);
	}

	public void removeAnchorVectorEventListener(AnchorEventListener listener) {
		if (this.anchorVectorEventListeners != null) {
			this.anchorVectorEventListeners.remove(listener);
		}
	}

	public void onPointChange(Point p) {
		this.doVectorPointChanged();
	}

	public void onPointDelete(Point p) {
		if (p == this.anchorPoint) {
			delete();
		}
	}

	public void delete() {
		if (!this.deleted) {
			this.deleted = true;

			this.anchorPoint.delete();
			this.anchorDirectionPoint.delete();
			this.anchorVectorPoint.delete();

			if (this.anchorVectorEventListeners != null)
				this.anchorVectorEventListeners.fireAnchorDeleted(this);
		}
	}

	public boolean isDeleted() {
		return deleted;
	}
}
