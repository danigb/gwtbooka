package net.zaszas.booka.core.client.service;

import java.util.Map;

import net.zaszas.booka.core.client.model.Bok;
import net.zaszas.booka.core.client.model.BokJSO;
import net.zaszas.booka.core.client.model.BokSearchResults;
import net.zaszas.booka.core.client.model.BokSearchResultsJSO;
import net.zaszas.rest.client.Params;
import net.zaszas.rest.client.RestServiceAsync;

import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.JsonUtils;
import com.google.gwt.http.client.Request;
import com.google.gwt.http.client.RequestCallback;
import com.google.gwt.http.client.Response;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.inject.Inject;

public class BokServiceAsyncJSON implements BokServiceAsync {

    private static final String RESOURCE = "boks";
    private final RestServiceAsync service;

    @Inject
    public BokServiceAsyncJSON(RestServiceAsync service) {
	this.service = service;
    }

    @Override
    public void get(String id, final AsyncCallback<Bok> callback) {
	service.get(RESOURCE, id, "json", new RequestCallback() {
	    @Override
	    public void onError(Request request, Throwable exception) {
		handleException(exception, callback);
	    }

	    @Override
	    public void onResponseReceived(Request request, Response response) {
		handleBokResponse(response, callback);
	    }
	});

    }

    @Override
    public void post(Params params, Bok bok, final AsyncCallback<Bok> callback) {
	encode(bok, params);
	service.create(RESOURCE, params, "json", new RequestCallback() {
	    @Override
	    public void onError(Request request, Throwable exception) {
		handleException(exception, callback);
	    }

	    @Override
	    public void onResponseReceived(Request request, Response response) {
		handleBokResponse(response, callback);
	    }

	});
    }

    @Override
    public void search(BokQuery query, final AsyncCallback<BokSearchResults> callback) {
	Params p = encode(query, new Params());

	service.getList(RESOURCE, p, "json", new RequestCallback() {
	    @Override
	    public void onError(Request request, Throwable exception) {
		callback.onFailure(exception);
	    }

	    @Override
	    public void onResponseReceived(Request request, Response response) {
		String responseText = response.getText();
		GWT.log("SEARCH " + responseText, null);
		BokSearchResultsJSO results = JsonUtils.unsafeEval(responseText);
		callback.onSuccess(results);
	    }
	});

    }

    private Params encode(Bok bok, Params p) {
	p.put("bok[title]", bok.getTitle());
	p.put("bok[description]", bok.getDescription());
	p.put("bok[bok_type]", bok.getBokType());
	p.put("bok[parent_id]", "" + bok.getParentId());
	p.put("bok[user_id]", "" + bok.getUserId());
	return p;
    }

    private Params encode(BokQuery query, Params p) {
	Map<String, String> map = query.getMap();
	for (String key : map.keySet()) {
	    p.put("search[" + key + "]", map.get(key));
	}
	return p;
    }

    private void handleBokResponse(Response response, final AsyncCallback<Bok> callback) {
	String responseText = response.getText();
	GWT.log("BOK: " + responseText, null);
	BokJSO bok = JsonUtils.unsafeEval(responseText);
	callback.onSuccess(bok);
    }

    private void handleException(Throwable exception, final AsyncCallback<Bok> callback) {
	GWT.log("EXCEPTION BokService", exception);
	callback.onFailure(exception);
    }
}
