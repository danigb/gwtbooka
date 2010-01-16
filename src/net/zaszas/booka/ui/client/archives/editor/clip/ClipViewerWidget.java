package net.zaszas.booka.ui.client.archives.editor.clip;

import net.zaszas.booka.core.client.document.Clip;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;

public class ClipViewerWidget extends Composite implements ClipViewerView {

    interface ClipViewerWidgetUiBinder extends UiBinder<Widget, ClipViewerWidget> {
    }

    private static ClipViewerWidgetUiBinder uiBinder = GWT.create(ClipViewerWidgetUiBinder.class);

    @UiField
    HTML content;

    @Inject
    public ClipViewerWidget(ClipViewerLogic logic) {
	initWidget(uiBinder.createAndBindUi(this));
    }

    @Override
    public void setClip(Clip clip) {
	content.setHTML(clip.getBody());
    }

}
