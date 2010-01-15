package net.zaszas.booka.core.client.service;

import net.zaszas.booka.core.client.model.Bok;
import net.zaszas.booka.core.client.model.BokSearchResults;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface BokServiceAsync {
    void create(Bok bok, AsyncCallback<Bok> callback);

    void get(String id, AsyncCallback<Bok> callback);

    void search(BokQuery query, AsyncCallback<BokSearchResults> callback);
}
