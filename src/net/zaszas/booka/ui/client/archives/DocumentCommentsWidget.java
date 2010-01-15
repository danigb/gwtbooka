package net.zaszas.booka.ui.client.archives;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;

public class DocumentCommentsWidget extends Composite {

    interface DocumentCommentsWidgetUiBinder extends UiBinder<Widget, DocumentCommentsWidget> {
    }

    private static DocumentCommentsWidgetUiBinder uiBinder = GWT.create(DocumentCommentsWidgetUiBinder.class);

    public DocumentCommentsWidget() {
	initWidget(uiBinder.createAndBindUi(this));
    }

}
