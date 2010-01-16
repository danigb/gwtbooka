package net.zaszas.booka.ui.client.archives;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;

public class DocumentBrowserWidget extends Composite implements DocumentBrowserView {

    interface DocumentBrowserWidgetUiBinder extends UiBinder<Widget, DocumentBrowserWidget> {
    }

    private static DocumentBrowserWidgetUiBinder uiBinder = GWT.create(DocumentBrowserWidgetUiBinder.class);

    public DocumentBrowserWidget() {
	initWidget(uiBinder.createAndBindUi(this));
    }

}
