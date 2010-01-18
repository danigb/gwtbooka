package net.zaszas.booka.ui.client.archives.editor.clip;

import net.zaszas.booka.core.client.document.Clip;
import net.zaszas.booka.ui.client.widgets.SwitchLayoutPanel;
import net.zaszas.booka.ui.client.widgets.SwitchLayoutView;

import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;

public class ClipWidget extends Composite implements ClipView {
    private final SwitchLayoutView slide;
    private final ClipViewerView viewer;

    public ClipWidget() {
	this.viewer = new ClipViewerWidget();
	this.slide = new SwitchLayoutPanel();
	initWidget((Widget) viewer);
	// slide.show(viewer, Transition.slideRight);
    }

    @Override
    public void setClip(Clip clip) {
	viewer.setClip(clip);
    }

}
