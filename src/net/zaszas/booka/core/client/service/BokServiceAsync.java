package net.zaszas.booka.core.client.service;

import net.zaszas.booka.core.client.model.Bok;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface BokServiceAsync {
    void create(Bok bok, AsyncCallback<String> callback);

    void get(String id, AsyncCallback<String> callback);

    void search(BokQuery query, AsyncCallback<String> callback);
}
