package net.zaszas.booka.client;

import net.zaszas.booka.core.client.session.SessionManager;
import net.zaszas.booka.ui.client.app.BookaAppView;
import net.zaszas.rest.client.RestServiceAsync;

import com.allen_sauer.gwt.log.client.Log;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Element;
import com.google.gwt.user.client.Command;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.DeferredCommand;
import com.google.gwt.user.client.ui.RootLayoutPanel;
import com.google.gwt.user.client.ui.Widget;

public class BookaEntryPoint implements EntryPoint {

    private static final String CONFIG_HOST = "booka.serverPath";

    public static final String getMeta(final String id) {
	String value = null;
	final Element element = DOM.getElementById(id);
	if (element != null) {
	    value = element.getPropertyString("content");
	}
	return value;
    }

    @Override
    public void onModuleLoad() {
	Log.setUncaughtExceptionHandler();

	DeferredCommand.addCommand(new Command() {
	    public void execute() {
		onModuleLoad2();
	    }
	});
    }

    protected void onModuleLoad2() {
	Log.debug("Loading...");

	BookaGinjector injector = GWT.create(BookaGinjector.class);
	RestServiceAsync restService = injector.getRestServiceAsync();
	String hostPath = getMeta(CONFIG_HOST);
	restService.setHostPath(hostPath);

	SessionManager sessionManager = injector.getSessionManager();
	sessionManager.login("Test", "secret");

	BookaAppView bookaApp = injector.getBookaAppView();
	RootLayoutPanel.get().add((Widget) bookaApp);
	GWT.log("Loading complete.", null);

    }
}
