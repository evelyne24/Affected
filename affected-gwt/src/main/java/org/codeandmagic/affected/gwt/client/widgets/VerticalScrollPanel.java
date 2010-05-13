package org.codeandmagic.affected.gwt.client.widgets;

import com.google.gwt.event.dom.client.HasScrollHandlers;
import com.google.gwt.event.dom.client.ScrollEvent;
import com.google.gwt.event.dom.client.ScrollHandler;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.Element;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.gwt.user.client.ui.UIObject;

public class VerticalScrollPanel extends SimplePanel implements
		HasScrollHandlers {

	public VerticalScrollPanel() {
		setAlwaysShowScrollBars(false);
	}

	public HandlerRegistration addScrollHandler(ScrollHandler handler) {
		return addDomHandler(handler, ScrollEvent.getType());
	}

	public void setAlwaysShowScrollBars(boolean alwaysShow, Element element) {
		DOM.setStyleAttribute(element, "overflowX", "hidden");
		DOM.setStyleAttribute(element, "overflowY", alwaysShow ? "scroll"
				: "auto");
	}

	public void setAlwaysShowScrollBars(boolean alwaysShow) {
		setAlwaysShowScrollBars(alwaysShow, getElement());
	}

	public void setHorizontalScrollPosition(int position) {
		DOM.setElementPropertyInt(getElement(), "scrollLeft", position);
	}

	public void setScrollPosition(int position) {
		DOM.setElementPropertyInt(getElement(), "scrollTop", position);
	}

	public void ensureVisible(UIObject item) {
		Element scroll = getElement();
		Element element = item.getElement();
		ensureVisibleImpl(scroll, element);
	}

	private native void ensureVisibleImpl(Element scroll, Element e)
	/*-{
		if (!e)
		  return; 
	
		var item = e;
		var realOffset = 0;
		while (item && (item != scroll)) {
		  realOffset += item.offsetTop;
		  item = item.offsetParent;
		}
	
		scroll.scrollTop = realOffset - scroll.offsetHeight / 2;
	}-*/;

}
