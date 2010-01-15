package net.zaszas.booka.core.client.service;

import com.google.gwt.http.client.Request;
import com.google.gwt.http.client.RequestBuilder;
import com.google.gwt.http.client.RequestCallback;
import com.google.gwt.http.client.RequestException;
import com.google.gwt.http.client.Response;
import com.google.gwt.user.client.rpc.AsyncCallback;

public class BokServiceAsyncJSON implements BokServiceAsync {

    private static final String URL = "/data/docs";

    @Override
    public void get(String id, final AsyncCallback<String> callback) {
	String url = URL + "/" + id + ".json";
	RequestBuilder builder = new RequestBuilder(RequestBuilder.GET, url);
	builder.setCallback(new RequestCallback() {
	    @Override
	    public void onError(Request request, Throwable exception) {
		callback.onFailure(exception);
	    }

	    @Override
	    public void onResponseReceived(Request request, Response response) {
		callback.onSuccess(response.getText());
	    }
	});
	try {
	    builder.send();
	} catch (RequestException e) {
	    callback.onFailure(e);
	}
    }

    @Override
    public void search(BokQuery query, final AsyncCallback<String> callback) {
	String url = URL + ".json";
	RequestBuilder builder = new RequestBuilder(RequestBuilder.GET, url);
	String data = "";
	try {
	    builder.sendRequest(data, new RequestCallback() {
		@Override
		public void onError(Request request, Throwable exception) {
		    callback.onFailure(exception);
		}

		@Override
		public void onResponseReceived(Request request, Response response) {
		    callback.onSuccess(response.getText());
		}
	    });
	} catch (RequestException e) {
	    callback.onFailure(e);
	}

    }
}
