package net.zaszas.booka.core.client.service;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface BokServiceAsync {
    void get(String id, AsyncCallback<String> callback);

    void search(BokQuery query, AsyncCallback<String> callback);
}
