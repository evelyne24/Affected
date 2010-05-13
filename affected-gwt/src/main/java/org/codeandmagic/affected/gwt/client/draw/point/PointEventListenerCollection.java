package org.codeandmagic.affected.gwt.client.draw.point;

import java.util.ArrayList;
import java.util.Iterator;

public class PointEventListenerCollection extends ArrayList<PointEventListener> {
	private static final long serialVersionUID = -48767045160784454L;

	public void fireChange(Point sender) {
		for (Iterator<PointEventListener> it = iterator(); it.hasNext();) {
			PointEventListener listener = (PointEventListener) it.next();
			listener.onPointChange(sender);
		}
	}

	public void fireDelete(Point sender) {
		for (Iterator<PointEventListener> it = iterator(); it.hasNext();) {
			PointEventListener listener = (PointEventListener) it.next();
			listener.onPointDelete(sender);
		}
	}
}
