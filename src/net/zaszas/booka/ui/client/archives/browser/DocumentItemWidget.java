package net.zaszas.booka.ui.client.archives.browser;

import net.zaszas.booka.core.client.document.Document;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.SpanElement;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;

public class DocumentItemWidget extends Composite implements DocumentItemView {

    interface DocumentItemWidgetUiBinder extends UiBinder<Widget, DocumentItemWidget> {
    }

    private static DocumentItemWidgetUiBinder uiBinder = GWT.create(DocumentItemWidgetUiBinder.class);

    @UiField
    Label title;

    @UiField
    SpanElement description, extra;

    private Document document;

    private final DocumentBrowserLogic logic;

    public DocumentItemWidget(DocumentBrowserLogic logic) {
	this.logic = logic;
	initWidget(uiBinder.createAndBindUi(this));
    }

    @Override
    public Document getDocument() {
	return document;
    }

    @UiHandler("title")
    public void onShow(ClickEvent event) {
	logic.onItemClicked(this);
    }

    public void setDocument(Document document) {
	this.document = document;
	title.setText(document.getTitle());
	description.setInnerText(document.getDescription());
	extra.setInnerText("Este es el id: " + document.getId());
    }
}
