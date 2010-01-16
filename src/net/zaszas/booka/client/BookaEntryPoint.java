package net.zaszas.booka.client;

import net.zaszas.booka.core.client.session.SessionManager;
import net.zaszas.booka.ui.client.app.BookaAppView;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.ui.RootLayoutPanel;
import com.google.gwt.user.client.ui.Widget;

public class BookaEntryPoint implements EntryPoint {

    @Override
    public void onModuleLoad() {
	GWT.log("Loading...", null);
	BookaGinjector injector = GWT.create(BookaGinjector.class);

	SessionManager sessionManager = injector.getSessionManager();
	sessionManager.login("Test", "secret");

	BookaAppView bookaApp = injector.getBookaAppView();
	RootLayoutPanel.get().add((Widget) bookaApp);
	GWT.log("Loading complete.", null);
    }
}
