package net.zaszas.booka.ui.client.archives.editor.clip;

import net.zaszas.booka.core.client.document.Clip;
import net.zaszas.booka.ui.client.slider.SlideLayoutPanel;
import net.zaszas.booka.ui.client.slider.SlideView;
import net.zaszas.booka.ui.client.slider.SlideView.Transition;

import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;

public class ClipWidget extends Composite implements ClipView {
    private final SlideView slide;
    private final ClipViewerView viewer;

    public ClipWidget(ClipViewerView viewer) {
	this.viewer = viewer;
	this.slide = new SlideLayoutPanel();
	initWidget((Widget) slide);
	slide.show(viewer, Transition.slideRight);
    }

    @Override
    public void setClip(Clip clip) {
	viewer.setClip(clip);
    }

}
