package net.zaszas.booka.core.client.service;

import net.zaszas.booka.core.client.session.SessionManager;
import net.zaszas.rest.client.Params;

import com.google.inject.Inject;

public class AuthorizedRestManager implements RestManager {

    private final RestManager delegate;
    private final SessionManager session;

    @Inject
    public AuthorizedRestManager(RestManager delegate, SessionManager session) {
	this.delegate = delegate;
	this.session = session;
    }

    @Override
    public void create(String requestId, String resource, Params params, String format, RestCallback callback) {
	assert session.isLoggedIn() : "You can't create without logged in first.";
	params.put("authenticity_token", session.getAuthToken());
	delegate.create(requestId, resource, params, format, callback);
    }

    @Override
    public void get(String requestId, String resource, String id, String format, RestCallback callback) {
	delegate.get(requestId, resource, id, format, callback);
    }

    @Override
    public String getHostPath() {
	return delegate.getHostPath();
    }

    @Override
    public void getList(String requestId, String resource, Params params, String format, RestCallback callback) {
	delegate.getList(requestId, resource, params, format, callback);
    }

    @Override
    public void onError(RestErrorCallback callback) {
	delegate.onError(callback);
    }

    @Override
    public void setHostPath(String hostPath) {
	delegate.setHostPath(hostPath);
    }

    @Override
    public void update(String requestId, String resource, String id, Params params, String format,
	    RestCallback restCallback) {
	assert session.isLoggedIn() : "You can't update without logged in first.";
	params.put("authenticity_token", session.getAuthToken());
	delegate.update(requestId, resource, id, params, format, restCallback);
    }

}
