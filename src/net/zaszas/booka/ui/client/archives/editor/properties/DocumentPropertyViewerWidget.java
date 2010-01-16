package net.zaszas.booka.ui.client.archives.editor.properties;

import net.zaszas.booka.core.client.document.Document;
import net.zaszas.booka.ui.client.archives.editor.DocumentEditorLogic;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.Event;
import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;

public class DocumentPropertyViewerWidget extends Composite implements DocumentPropertyViewerView {

    interface DocumentPropertyViewerWidgetUiBinder extends UiBinder<Widget, DocumentPropertyViewerWidget> {
    }
    @UiField
    Label title, description;

    @UiField
    Anchor edit;

    private static DocumentPropertyViewerWidgetUiBinder uiBinder = GWT
	    .create(DocumentPropertyViewerWidgetUiBinder.class);

    private DocumentEditorLogic logic;

    public DocumentPropertyViewerWidget() {
	initWidget(uiBinder.createAndBindUi(this));
	sinkEvents(Event.ONMOUSEOVER | Event.ONMOUSEOUT);
	edit.setVisible(false);
    }

    @Override
    public void onBrowserEvent(Event event) {
	int type = event.getTypeInt();
	if (type == Event.ONMOUSEOVER) {
	    addStyleName("active");
	    edit.setVisible(true);
	} else if (type == Event.ONMOUSEOUT) {
	    removeStyleName("active");
	    edit.setVisible(false);
	}
	super.onBrowserEvent(event);
    }

    @UiHandler("edit")
    public void onEdit(ClickEvent e) {
	logic.onEditProperties();
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
