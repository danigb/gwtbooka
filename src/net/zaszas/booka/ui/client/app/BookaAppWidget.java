package net.zaszas.booka.ui.client.app;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;

public class BookaAppWidget extends Composite implements BookaAppView {

    interface BookaAppWidgetUiBinder extends UiBinder<Widget, BookaAppWidget> {
    }

    private static BookaAppWidgetUiBinder uiBinder = GWT.create(BookaAppWidgetUiBinder.class);

    public BookaAppWidget() {
	initWidget(uiBinder.createAndBindUi(this));
    }

}
