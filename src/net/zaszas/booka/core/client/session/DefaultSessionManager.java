package net.zaszas.booka.core.client.session;

import net.zaszas.booka.core.client.event.Collector;
import net.zaszas.booka.core.client.event.Listener;
import net.zaszas.booka.core.client.model.UserSession;
import net.zaszas.booka.core.client.service.UserSessionServiceAsync;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.inject.Inject;

public class DefaultSessionManager implements SessionManager {
    private final UserSessionServiceAsync service;
    private final Collector<SessionManager> onLoggedIn;
    private final Collector<SessionManager> onLoggedOut;
    private String authToken;
    private UserSession userSession;

    @Inject
    public DefaultSessionManager(UserSessionServiceAsync service) {
	this.service = service;
	this.onLoggedIn = new Collector<SessionManager>();
	this.onLoggedOut = new Collector<SessionManager>();
	this.authToken = null;
	this.userSession = null;
    }

    @Override
    public String getAuthToken() {
	return authToken;
    }

    @Override
    public int getUserId() {
	assert userSession != null;
	return userSession.getUserId();
    }

    @Override
    public UserSession getUserSession() {
	return userSession;
    }

    @Override
    public boolean isLoggedIn() {
	return authToken != null;
    }

    @Override
    public void login(String name, String password) {
	service.create(name, password, new AsyncCallback<UserSession>() {
	    @Override
	    public void onFailure(Throwable caught) {
	    }

	    @Override
	    public void onSuccess(UserSession session) {
		authToken = session.getToken();
		userSession = session;
		fireLoggedIn();
	    }
	});
    }

    @Override
    public void logout() {
	this.userSession = null;
	this.authToken = null;
	fireLoggedOut();
    }

    @Override
    public void onLoggedIn(Listener<SessionManager> listener) {
	onLoggedIn.add(listener);
    }

    @Override
    public void onLoggedOut(Listener<SessionManager> listener) {
	onLoggedOut.add(listener);
    }

    protected void fireLoggedIn() {
	onLoggedIn.fire(this);
    }

    protected void fireLoggedOut() {
	onLoggedOut.fire(this);
    }

}
