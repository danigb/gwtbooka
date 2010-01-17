package net.zaszas.booka.core.client.session;

import net.zaszas.booka.core.client.event.Collector;
import net.zaszas.booka.core.client.event.Listener;
import net.zaszas.booka.core.client.model.UserSession;
import net.zaszas.booka.core.client.model.UserSessionJSO;
import net.zaszas.booka.core.client.service.RestCallback;
import net.zaszas.booka.core.client.service.RestManager;
import net.zaszas.rest.client.Params;

import com.google.gwt.core.client.JsonUtils;
import com.google.inject.Inject;

public class DefaultSessionManager implements SessionManager {
    private static final String RESOURCE = "user_sessions";
    private static final String JSON = "json";

    private final Collector<SessionManager> onLoggedIn;
    private final Collector<SessionManager> onLoggedOut;
    private String authToken;
    private UserSession userSession;
    private final RestManager manager;

    @Inject
    public DefaultSessionManager(RestManager manager) {
	this.manager = manager;
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
	Params params = new Params().With("user[name]", name).With("user[password]", password);
	manager.create("session.create", RESOURCE, params, JSON, new RestCallback() {
	    @Override
	    public void onSuccess(String text) {
		UserSessionJSO userSessionJSO = JsonUtils.unsafeEval(text);
		handleUserSession(userSessionJSO);
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

    protected void handleUserSession(UserSession session) {
	authToken = session.getToken();
	userSession = session;
	fireLoggedIn();
    }

}
