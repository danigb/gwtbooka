package net.zaszas.rest.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.http.client.RequestBuilder;
import com.google.gwt.http.client.RequestCallback;
import com.google.gwt.http.client.RequestException;

public class RestServiceAsyncImpl implements RestServiceAsync {
    private static final String EMPTY = "";

    private String hostPath;

    public RestServiceAsyncImpl() {
	this.hostPath = "/";
    }

    @Override
    public void create(String resource, Params params, String format, RequestCallback callback) {
	String url = getPath(resource, null, format);
	RequestBuilder builder = new RequestBuilder(RequestBuilder.POST, url);
	builder.setHeader("Content-type", "application/x-www-form-urlencoded");
	try {
	    builder.sendRequest(params.toString(), callback);
	} catch (RequestException e) {
	    callback.onError(null, e);
	}
    }

    @Override
    public void getList(String resource, Params params, String format, RequestCallback callback) {
	String url = getPath(resource, null, format);
	url += (params != null) ? "?" + params.toString() : EMPTY;
	RequestBuilder builder = new RequestBuilder(RequestBuilder.GET, url);
	try {
	    builder.sendRequest(null, callback);
	} catch (RequestException e) {
	    callback.onError(null, e);
	}

    }

    @Override
    public void get(String resource, String id, String format, RequestCallback callback) {
	String url = getPath(resource, id, format);
	RequestBuilder builder = new RequestBuilder(RequestBuilder.GET, url);
	builder.setHeader("Content-type", "application/x-www-form-urlencoded");
	builder.setCallback(callback);
	try {
	    builder.send();
	} catch (RequestException e) {
	    callback.onError(null, e);
	}
    }

    @Override
    public String getHostPath() {
	return hostPath;
    }

    public String getPath(String resource, String id, String format) {
	assert resource != null : "Resource is required";
	assert format != null : "Format is required";
	String middle = (id != null) ? "/" + id : EMPTY;
	return hostPath + resource + middle + "." + format;
    }

    @Override
    public void setHostPath(String hostPath) {
	assert hostPath != null : "Host path can't be null";
	if (hostPath.length() == 0 || hostPath.charAt(hostPath.length() - 1) != '/') {
	    hostPath += "/";
	}
	GWT.log("REST host path: " + hostPath, null);
	this.hostPath = hostPath;
    }

    @Override
    public void update(String resource, String id, Params params, String format, RequestCallback callback) {
	String url = getPath(resource, id, format);
	RequestBuilder builder = new RequestBuilder(RequestBuilder.POST, url);
	builder.setHeader("Content-type", "application/x-www-form-urlencoded");
	params.put("_method", "put");
	try {
	    builder.sendRequest(params.toString(), callback);
	} catch (RequestException e) {
	    callback.onError(null, e);
	}

    }
}
