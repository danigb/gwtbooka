package net.zaszas.booka.core.client.service;

import com.google.gwt.http.client.URL;

public class Params {
    private final StringBuffer buffer;
    private boolean isFirst;

    public Params() {
	buffer = new StringBuffer();
	isFirst = true;
    }

    @Override
    public String toString() {
	return buffer.toString();
    }

    public Params With(String key, String value) {
	if (isFirst) {
	    isFirst = false;
	} else {
	    buffer.append("&");
	}
	buffer.append(URL.encode(key)).append("=").append(URL.encodeComponent(value));
	return this;
    }
}
