package net.zaszas.booka.ui.client.slider;

import static com.google.gwt.dom.client.Style.Unit.PCT;
import static com.google.gwt.dom.client.Style.Unit.PX;
import net.zaszas.booka.ui.client.View;

import com.google.gwt.core.client.GWT;
import com.google.gwt.layout.client.Layout.AnimationCallback;
import com.google.gwt.layout.client.Layout.Layer;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.LayoutPanel;
import com.google.gwt.user.client.ui.Widget;

public class SlideLayoutPanel extends Composite implements SlideView {

    private final LayoutPanel panel;
    private View currentView;

    public SlideLayoutPanel() {
	panel = new LayoutPanel();
	initWidget(panel);
	currentView = null;
    }

    @Override
    public void show(View view, Transition transition) {
	GWT.log("Add view to slide" + view, null);
	panel.add((Widget) view);
	panel.setWidgetTopBottom((Widget) view, 0, PX, 0, PX);
	panel.setWidgetLeftWidth((Widget) view, 0, PX, 0, PCT);
	panel.forceLayout();

	if (currentView != null) {
	    panel.setWidgetRightWidth((Widget) currentView, 0, PX, 0, PX);
	}
	panel.setWidgetLeftWidth((Widget) view, 0, PX, 100, PCT);
	final View old = currentView;
	currentView = view;
	panel.animate(500, new AnimationCallback() {
	    @Override
	    public void onAnimationComplete() {
	    }

	    @Override
	    public void onLayout(Layer layer, double progress) {
		if (old != null)
		    panel.remove((Widget) old);
	    }
	});
    }

}
