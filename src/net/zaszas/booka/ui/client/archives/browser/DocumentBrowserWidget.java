package net.zaszas.booka.ui.client.archives.browser;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;

public class DocumentBrowserWidget extends Composite implements DocumentBrowserView {

    interface DocumentBrowserWidgetUiBinder extends UiBinder<Widget, DocumentBrowserWidget> {
    }

    private static DocumentBrowserWidgetUiBinder uiBinder = GWT.create(DocumentBrowserWidgetUiBinder.class);

    @UiField
    FlowPanel list;

    @UiField
    Anchor create;

    private final DocumentBrowserLogic logic;

    @Inject
    public DocumentBrowserWidget(DocumentBrowserLogic logic) {
	this.logic = logic;
	initWidget(uiBinder.createAndBindUi(this));
	logic.setView(this);
    }

    @Override
    public DocumentItemView add() {
	DocumentItemWidget item = new DocumentItemWidget(logic);
	list.add(item);
	return item;
    }

    @Override
    public void clear() {
	list.clear();
    }

    @UiHandler("create")
    public void onCreate(ClickEvent event) {
	logic.onNewDocument();
    }

    @Override
    public void setCreateVisible(boolean visible) {
	create.setVisible(visible);
    }

}
