package net.zaszas.booka.ui.client.app;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;

public class NavigationWidget extends Composite {

    interface NavigationWidgetUiBinder extends UiBinder<Widget, NavigationWidget> {
    }

    private static NavigationWidgetUiBinder uiBinder = GWT.create(NavigationWidgetUiBinder.class);

    public NavigationWidget() {
	initWidget(uiBinder.createAndBindUi(this));
    }

}
