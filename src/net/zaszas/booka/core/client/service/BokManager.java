package net.zaszas.booka.core.client.service;

import net.zaszas.booka.core.client.event.Listener;
import net.zaszas.booka.core.client.model.Bok;
import net.zaszas.booka.core.client.model.BokSearchResults;

/**
 * A BokServiceAsync with some goodies: it handles session authentication and
 * centralices all the errors in a callback
 * 
 */
public interface BokManager {
    void create(Bok bok, Listener<Bok> listener);

    void get(String id, Listener<Bok> listener);

    void onFailure(Listener<Throwable> listener);

    void search(BokQuery query, Listener<BokSearchResults> listener);
}
