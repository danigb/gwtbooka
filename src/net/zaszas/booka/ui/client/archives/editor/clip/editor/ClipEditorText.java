package net.zaszas.booka.ui.client.archives.editor.clip.editor;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;

public class ClipEditorText extends Composite implements ClipEditor {

    interface ClipEditorTextUiBinder extends UiBinder<Widget, ClipEditorText> {
    }

    private static ClipEditorTextUiBinder uiBinder = GWT.create(ClipEditorTextUiBinder.class);

    public ClipEditorText() {
	initWidget(uiBinder.createAndBindUi(this));
    }

}
