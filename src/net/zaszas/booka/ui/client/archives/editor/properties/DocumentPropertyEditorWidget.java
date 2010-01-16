package net.zaszas.booka.ui.client.archives.editor.properties;

import net.zaszas.booka.core.client.document.Document;
import net.zaszas.booka.ui.client.archives.editor.DocumentEditorLogic;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;

public class DocumentPropertyEditorWidget extends Composite implements DocumentPropertyEditorView {

    interface DocumentPropertyEditorWidgetUiBinder extends UiBinder<Widget, DocumentPropertyEditorWidget> {
    }

    private static DocumentPropertyEditorWidgetUiBinder uiBinder = GWT
	    .create(DocumentPropertyEditorWidgetUiBinder.class);

    @UiField
    TextBox title;
    @UiField
    TextArea description;

    private DocumentEditorLogic logic;

    public DocumentPropertyEditorWidget() {
	initWidget(uiBinder.createAndBindUi(this));
    }

    @Override
    public String getDescription() {
	return description.getText();
    }

    @Override
    public String getTitle() {
	return title.getText();
    }

    @UiHandler("cancel")
    public void onCancel(ClickEvent evt) {
	logic.onPropertiesEditCancel();
    }

    @UiHandler("save")
    public void onSave(ClickEvent evt) {
	logic.onPropertiesSave();
    }

    @Override
    public void setDocument(Document document) {
	title.setText(document.getTitle());
	description.setText(document.getDescription());
    }

    @Override
    public void setLogic(DocumentEditorLogic logic) {
	this.logic = logic;
    }

}
