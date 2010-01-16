package net.zaszas.booka.ui.client.widgets;

import static com.google.gwt.dom.client.Style.Unit.PCT;
import static com.google.gwt.dom.client.Style.Unit.PX;
import net.zaszas.booka.ui.client.View;

import com.google.gwt.layout.client.Layout.AnimationCallback;
import com.google.gwt.layout.client.Layout.Layer;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.LayoutPanel;
import com.google.gwt.user.client.ui.Widget;

public class SwitchLayoutPanel extends Composite implements SwitchLayoutView {

    private final LayoutPanel panel;
    private View currentView;

    public SwitchLayoutPanel() {
	panel = new LayoutPanel();
	initWidget(panel);
	currentView = null;
    }

    @Override
    public void show(View view, Transition transition) {
	if (currentView != view) {
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
		    if (old != null)
			panel.remove((Widget) old);
		}

		@Override
		public void onLayout(Layer layer, double progress) {
		}
	    });
	}
    }

}
