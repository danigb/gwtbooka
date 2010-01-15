package net.zaszas.booka.core.client.service;

import java.util.Map;

import net.zaszas.booka.core.client.model.Bok;
import net.zaszas.booka.core.client.model.BokJSO;
import net.zaszas.booka.core.client.model.BokSearchResults;
import net.zaszas.booka.core.client.model.BokSearchResultsJSO;

import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.JsonUtils;
import com.google.gwt.http.client.Request;
import com.google.gwt.http.client.RequestBuilder;
import com.google.gwt.http.client.RequestCallback;
import com.google.gwt.http.client.RequestException;
import com.google.gwt.http.client.Response;
import com.google.gwt.user.client.rpc.AsyncCallback;

public class BokServiceAsyncJSON implements BokServiceAsync {

    private static final String URL = "/data/boks";
    private String authToken;

    @Override
    public void create(Bok bok, final AsyncCallback<Bok> callback) {
	String url = URL + ".json";
	RequestBuilder builder = new RequestBuilder(RequestBuilder.POST, url);
	builder.setHeader("Content-type", "application/x-www-form-urlencoded");

	Params p = new Params().With("authenticity_token", authToken);
	encode(bok, p);
	GWT.log("PARAMS: " + p.toString(), null);
	try {
	    builder.sendRequest(p.toString(), new RequestCallback() {
		@Override
		public void onError(Request request, Throwable exception) {
		    callback.onFailure(exception);
		}

		@Override
		public void onResponseReceived(Request request, Response response) {
		    BokJSO bok = JsonUtils.unsafeEval(response.getText());
		    callback.onSuccess(bok);
		}
	    });
	} catch (RequestException e) {
	    callback.onFailure(e);
	}
    }

    @Override
    public void get(String id, final AsyncCallback<Bok> callback) {
	String url = URL + "/" + id + ".json";
	RequestBuilder builder = new RequestBuilder(RequestBuilder.GET, url);
	builder.setCallback(new RequestCallback() {
	    @Override
	    public void onError(Request request, Throwable exception) {
		callback.onFailure(exception);
	    }

	    @Override
	    public void onResponseReceived(Request request, Response response) {
		BokJSO bok = JsonUtils.unsafeEval(response.getText());
		callback.onSuccess(bok);
	    }
	});
	try {
	    builder.send();
	} catch (RequestException e) {
	    callback.onFailure(e);
	}
    }

    @Override
    public void search(BokQuery query, final AsyncCallback<BokSearchResults> callback) {
	String url = URL + ".json";
	RequestBuilder builder = new RequestBuilder(RequestBuilder.GET, url);
	Params p = encode(query, new Params());
	try {
	    builder.sendRequest(p.toString(), new RequestCallback() {
		@Override
		public void onError(Request request, Throwable exception) {
		    callback.onFailure(exception);
		}

		@Override
		public void onResponseReceived(Request request, Response response) {
		    BokSearchResultsJSO results = JsonUtils.unsafeEval(response.getText());
		    callback.onSuccess(results);
		}
	    });
	} catch (RequestException e) {
	    callback.onFailure(e);
	}

    }

    public void setAuthToken(String authToken) {
	this.authToken = authToken;
    }

    private Params encode(Bok bok, Params p) {
	p.put("bok[title]", bok.getTitle());
	p.put("bok[description]", bok.getDescription());
	p.put("bok[bok_type]", bok.getBokType());
	return p;
    }

    private Params encode(BokQuery query, Params p) {
	Map<String, String> map = query.getMap();
	for (String key : map.keySet()) {
	    p.put("search[" + key + "]", map.get(key));
	}
	return p;
    }
}
