package net.zaszas.booka.core.client.service;

import net.zaszas.booka.core.client.model.UserSession;
import net.zaszas.booka.core.client.model.UserSessionJSO;
import net.zaszas.rest.client.Params;
import net.zaszas.rest.client.RestServiceAsync;

import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.JsonUtils;
import com.google.gwt.http.client.Request;
import com.google.gwt.http.client.RequestCallback;
import com.google.gwt.http.client.Response;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.inject.Inject;

public class UserSessionServiceAsyncJSON implements UserSessionServiceAsync {
    private static final String RESOURCE = "user_sessions";
    private final RestServiceAsync service;

    @Inject
    public UserSessionServiceAsyncJSON(RestServiceAsync service) {
	this.service = service;
    }

    @Override
    public void create(String name, String password, final AsyncCallback<UserSession> callback) {
	Params params = new Params().With("user[name]", name).With("user[password]", password);

	service.create(RESOURCE, params, "json", new RequestCallback() {
	    @Override
	    public void onError(Request request, Throwable exception) {
		callback.onFailure(exception);
	    }

	    @Override
	    public void onResponseReceived(Request request, Response response) {
		String responseText = response.getText();
		GWT.log("CREATE user session: " + responseText, null);
		UserSessionJSO userSession = JsonUtils.<UserSessionJSO> unsafeEval(responseText);
		callback.onSuccess(userSession);
	    }
	});

    }
}
