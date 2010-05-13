package org.codeandmagic.affected.gwt.client.draw.anchor;

import java.util.ArrayList;
import java.util.Iterator;

public class AnchorEventListenerCollection extends
		ArrayList<AnchorEventListener> {

	private static final long serialVersionUID = -9147402051515200042L;

	public void fireAnchorVectorPointChanged(Anchor sender) {
		for (Iterator<AnchorEventListener> it = iterator(); it.hasNext();) {
			AnchorEventListener listener = (AnchorEventListener) it.next();
			listener.anchorVectorPointChanged(sender);
		}
	}

	@SuppressWarnings("unchecked")
	public void fireAnchorDeleted(Anchor sender) {
		ArrayList<AnchorEventListener> copy = (ArrayList<AnchorEventListener>) this
				.clone();
		for (Iterator<AnchorEventListener> it = copy.iterator(); it.hasNext();) {
			AnchorEventListener listener = (AnchorEventListener) it.next();
			listener.anchorDeleted(sender);
		}
	}
}
