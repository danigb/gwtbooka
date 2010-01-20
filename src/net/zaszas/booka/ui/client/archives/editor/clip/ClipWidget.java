package net.zaszas.booka.ui.client.archives.editor.clip;

import net.zaszas.booka.core.client.document.Clip;
import net.zaszas.booka.ui.client.archives.editor.clip.editor.ClipEditor;
import net.zaszas.booka.ui.client.utils.Effects;

import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Widget;

public class ClipWidget extends Composite implements ClipView {
    private final ClipViewerView viewer;
    private final ClipEditor editor;

    public ClipWidget(ClipEditor editor) {
	this.editor = editor;
	this.viewer = new ClipViewerWidget();
	FlowPanel panel = new FlowPanel();
	panel.add((Widget) editor);
	panel.add((Widget) viewer);
	initWidget(panel);
	Effects.hide(editor);
	Effects.hide(viewer);
    }

    @Override
    public void setClip(Clip clip) {
	viewer.setClip(clip);
    }

    @Override
    public void setEditorVisible(boolean visible) {
	Effects.slideDown(editor);
    }

}
