package org.codeandmagic.affected.gwt.client.widgets;

import org.codeandmagic.affected.gwt.client.draw.point.Point;

import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HasHTML;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.PopupPanel;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.gwt.user.client.ui.Widget;

public class ContentBox extends PopupPanel implements HasHTML {
	protected Point point;
	protected Point size;

	private HTML caption;
	private Widget child;

	private boolean dragging;
	private int dragStartX;
	private int dragStartY;

	private FlowPanel panel;
	private SimplePanel captionPanelContainer;
	private HorizontalPanel captionPanel;

	private FlyButton btnCollapse;
	private FlyButton btnExtend;

	private SimplePanel backgroundPanel;

	private int heightBeforeCollapse;
	private int captionPanelContainerHeight = 20;

	public String getHTML() {
		// TODO Auto-generated method stub
		return null;
	}

	public void setHTML(String arg0) {
		// TODO Auto-generated method stub

	}

	public String getText() {
		// TODO Auto-generated method stub
		return null;
	}

	public void setText(String arg0) {
		// TODO Auto-generated method stub

	}
}
