package net.zaszas.booka.ui.client.app;

import static com.google.gwt.dom.client.Style.Unit.PX;
import net.zaszas.booka.ui.client.View;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.LayoutPanel;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;

public class BookaAppWidget extends Composite implements BookaAppView {

    interface BookaAppWidgetUiBinder extends UiBinder<Widget, BookaAppWidget> {
    }

    private static BookaAppWidgetUiBinder uiBinder = GWT.create(BookaAppWidgetUiBinder.class);

    @UiField
    SimplePanel north;

    @UiField
    LayoutPanel center;

    private final SlideLayoutPanel slideLayout;

    @Inject
    public BookaAppWidget(BookaAppLogic logic, NavigationView navigationView) {
	logic.setView(this);
	initWidget(uiBinder.createAndBindUi(this));
	this.slideLayout = new SlideLayoutPanel();
	north.setWidget((Widget) navigationView);
	center.add(slideLayout);
	center.setWidgetLeftRight(slideLayout, 0, PX, 0, PX);
	center.setWidgetTopBottom(slideLayout, 0, PX, 0, PX);
	center.forceLayout();
    }

    @Override
    public void show(View view) {
	slideLayout.show(view);
    }

}
