package net.zaszas.booka.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.ui.RootLayoutPanel;
import com.google.gwt.user.client.ui.Widget;

public class BookaEntryPoint implements EntryPoint {

    @Override
    public void onModuleLoad() {
	BookaGinjector injector = GWT.create(BookaGinjector.class);
	RootLayoutPanel.get().add((Widget) injector.getBookaAppView());
    }

}
