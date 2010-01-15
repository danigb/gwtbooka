package net.zaszas.booka.ui.client;

import net.zaszas.booka.ui.client.app.BookaAppView;
import net.zaszas.booka.ui.client.app.BookaAppWidget;

import com.google.gwt.inject.client.AbstractGinModule;

public class BookaUIModule extends AbstractGinModule {

    @Override
    protected void configure() {
	bind(BookaAppView.class).to(BookaAppWidget.class);
    }

}
