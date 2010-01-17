package net.zaszas.booka.core.client.service;

import java.util.ArrayList;

import net.zaszas.rest.client.Params;
import net.zaszas.rest.client.RestServiceAsync;

import com.google.gwt.http.client.Request;
import com.google.gwt.http.client.RequestCallback;
import com.google.gwt.http.client.Response;
import com.google.inject.Inject;

public class RestManagerImpl implements RestManager {
    private final RestServiceAsync service;
    private final ArrayList<RestErrorCallback> errorCallbacks;

    @Inject
    public RestManagerImpl(RestServiceAsync service) {
	this.service = service;
	this.errorCallbacks = new ArrayList<RestErrorCallback>();
    }

    @Override
    public void create(final String requestId, String resource, Params params, String format,
	    final RestCallback callback) {

	service.create(resource, params, format, new RequestCallback() {
	    @Override
	    public void onError(Request request, Throwable exception) {
		fireError(requestId, exception);
	    }

	    @Override
	    public void onResponseReceived(Request request, Response response) {
		handleResponse(requestId, response, callback);
	    }
	});
    }

    @Override
    public void get(final String requestId, String resource, String id, String format, final RestCallback callback) {
	service.get(resource, id, format, new RequestCallback() {
	    @Override
	    public void onError(Request request, Throwable exception) {
		fireError(requestId, exception);
	    }

	    @Override
	    public void onResponseReceived(Request request, Response response) {
		handleResponse(requestId, response, callback);
	    }
	});
    }

    @Override
    public String getHostPath() {
	return service.getHostPath();
    }

    @Override
    public void getList(final String requestId, String resource, Params params, String format,
	    final RestCallback callback) {
	service.getList(resource, params, format, new RequestCallback() {

	    @Override
	    public void onError(Request request, Throwable exception) {
		fireError(requestId, exception);
	    }

	    @Override
	    public void onResponseReceived(Request request, Response response) {
		handleResponse(requestId, response, callback);
	    }
	});
    }

    @Override
    public void onError(RestErrorCallback callback) {
	errorCallbacks.add(callback);
    }

    @Override
    public void setHostPath(String hostPath) {
	service.setHostPath(hostPath);
    }

    @Override
    public void update(final String requestId, String resource, String id, Params params, String format,
	    final RestCallback callback) {

	service.update(resource, id, params, format, new RequestCallback() {
	    @Override
	    public void onError(Request request, Throwable exception) {
		fireError(requestId, exception);
	    }

	    @Override
	    public void onResponseReceived(Request request, Response response) {
		handleResponse(requestId, response, callback);
	    }
	});
    }

    protected void fireError(String requestId, Throwable exception) {
	for (RestErrorCallback callback : errorCallbacks) {
	    callback.onError(requestId, exception);
	}
    }

    protected void handleResponse(String requestId, Response response, RestCallback callback) {
	callback.onSuccess(response.getText());
    }

}
