package net.zaszas.booka.ui.client.archives.editor;

import net.zaszas.booka.ui.client.archives.editor.clip.ClipView;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;

public class DocumentEditorWidget extends Composite implements DocumentEditorView {

    interface DocumentEditorWidgetUiBinder extends UiBinder<Widget, DocumentEditorWidget> {
    }

    private static DocumentEditorWidgetUiBinder uiBinder = GWT.create(DocumentEditorWidgetUiBinder.class);

    @UiField
    Label title, description;

    @UiField
    FlowPanel content, page;

    @Inject
    public DocumentEditorWidget(DocumentEditorLogic logic) {
	initWidget(uiBinder.createAndBindUi(this));
	logic.setView(this);
    }

    @Override
    public void add(ClipView clipView) {
	content.add((Widget) clipView);
    }

    @Override
    public void clear() {
	content.clear();
    }

    @Override
    public ClipView createClipView() {
	return null;
    }

    @Override
    public void setDocumentDescription(String text) {
	description.setText(text);
    }

    @Override
    public void setDocumentTitle(String text) {
	title.setText(text);
    }

    @Override
    public void setDocumentVisible(boolean visible) {
	page.setVisible(visible);
    }

}
