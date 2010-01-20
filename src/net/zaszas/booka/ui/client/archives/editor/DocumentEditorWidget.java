package net.zaszas.booka.ui.client.archives.editor;

import net.zaszas.booka.core.client.document.Document;
import net.zaszas.booka.ui.client.View;
import net.zaszas.booka.ui.client.archives.editor.clip.ClipView;
import net.zaszas.booka.ui.client.archives.editor.clip.ClipWidget;
import net.zaszas.booka.ui.client.archives.editor.clip.editor.ClipEditor;
import net.zaszas.booka.ui.client.archives.editor.properties.DocumentPropertyEditorView;
import net.zaszas.booka.ui.client.archives.editor.properties.DocumentPropertyViewerView;
import net.zaszas.booka.ui.client.archives.editor.slot.SlotView;
import net.zaszas.booka.ui.client.archives.editor.slot.SlotWidget;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;

public class DocumentEditorWidget extends Composite implements DocumentEditorView {

    interface DocumentEditorWidgetUiBinder extends UiBinder<Widget, DocumentEditorWidget> {
    }

    private static DocumentEditorWidgetUiBinder uiBinder = GWT.create(DocumentEditorWidgetUiBinder.class);

    @UiField
    FlowPanel content, page;

    @UiField
    SimplePanel properties;

    private final DocumentEditorLogic logic;

    @Inject
    public DocumentEditorWidget(DocumentEditorLogic logic, DocumentPropertyViewerView propertyViewer,
	    DocumentPropertyEditorView propertyEditor) {
	this.logic = logic;
	initWidget(uiBinder.createAndBindUi(this));
	logic.setViews(this, propertyViewer, propertyEditor);
    }

    @Override
    public void add(View view) {
	GWT.log("DEW add", null);
	content.add((Widget) view);
    }

    @Override
    public void clear() {
	content.clear();
    }

    @Override
    public ClipView createClipView(ClipEditor editor) {
	return new ClipWidget(editor);
    }

    @Override
    public SlotView createSlotView() {
	return new SlotWidget(logic);
    }

    @Override
    public void insert(View view, int beforeIndex) {
	content.insert((Widget) view, beforeIndex);
    }

    @Override
    public void setDocument(Document document) {
	logic.setDocument(document);
    }

    @Override
    public void setDocumentVisible(boolean visible) {
	page.setVisible(visible);
    }

    @Override
    public void setPropertiesView(View view) {
	properties.setWidget((Widget) view);
    }

}
