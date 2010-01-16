package net.zaszas.booka.ui.client.app;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;

public class NavigationWidget extends Composite implements NavigationView {

    interface NavigationWidgetUiBinder extends UiBinder<Widget, NavigationWidget> {
    }

    private static NavigationWidgetUiBinder uiBinder = GWT.create(NavigationWidgetUiBinder.class);

    @Inject
    public NavigationWidget(NavigationLogic logic) {
	logic.setView(this);
	initWidget(uiBinder.createAndBindUi(this));
    }

}
