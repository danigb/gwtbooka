package net.zaszas.booka.ui.client.archives.editor;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;

public class DocumentEditorWidget extends Composite implements DocumentEditorView {

    interface DocumentEditorWidgetUiBinder extends UiBinder<Widget, DocumentEditorWidget> {
    }

    private static DocumentEditorWidgetUiBinder uiBinder = GWT.create(DocumentEditorWidgetUiBinder.class);

    public DocumentEditorWidget() {
	initWidget(uiBinder.createAndBindUi(this));
    }

}
