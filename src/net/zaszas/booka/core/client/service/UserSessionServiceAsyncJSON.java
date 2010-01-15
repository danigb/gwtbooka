package net.zaszas.booka.core.client.service;

import net.zaszas.booka.core.client.model.UserSession;
import net.zaszas.booka.core.client.model.UserSessionJSO;

import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.JsonUtils;
import com.google.gwt.http.client.Request;
import com.google.gwt.http.client.RequestBuilder;
import com.google.gwt.http.client.RequestCallback;
import com.google.gwt.http.client.RequestException;
import com.google.gwt.http.client.Response;
import com.google.gwt.user.client.rpc.AsyncCallback;

public class UserSessionServiceAsyncJSON implements UserSessionServiceAsync {
    private static final String URL = "/data/user_sessions";

    @Override
    public void create(String name, String password, final AsyncCallback<UserSession> callback) {
	String url = URL + ".json";
	RequestBuilder builder = new RequestBuilder(RequestBuilder.POST, url);
	try {
	    builder.sendRequest("", new RequestCallback() {
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
	} catch (RequestException e) {
	    callback.onFailure(e);
	}
    }

}
