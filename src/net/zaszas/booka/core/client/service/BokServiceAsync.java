package net.zaszas.booka.core.client.service;

import net.zaszas.booka.core.client.model.Bok;
import net.zaszas.booka.core.client.model.BokSearchResults;
import net.zaszas.rest.client.Params;

import com.google.gwt.user.client.rpc.AsyncCallback;

/**
 * The asyc part of the Bok Service.
 * 
 * Usually you will use BokManager instead
 * 
 * @see BokManager
 */
public interface BokServiceAsync {
    /**
     * Create a new bok
     * @param params TODO
     * @param bok
     * @param callback
     */
    void post(Params params, Bok bok, AsyncCallback<Bok> callback);

    /**
     * Get a bok with the given id
     * 
     * @param id
     * @param callback
     */
    void get(String id, AsyncCallback<Bok> callback);

    /**
     * Search for a list of boks with a given query
     * 
     * @param query
     * @param callback
     */
    void search(BokQuery query, AsyncCallback<BokSearchResults> callback);
}
