package net.zaszas.booka.core.client.service;

import net.zaszas.booka.core.client.event.Collector;
import net.zaszas.booka.core.client.event.Listener;
import net.zaszas.booka.core.client.model.Bok;
import net.zaszas.booka.core.client.model.BokSearchResults;
import net.zaszas.booka.core.client.session.SessionManager;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.inject.Inject;

/**
 * BokManagerService implementstion
 * 
 * @see BokManager
 * 
 */
public class BokManagerService implements BokManager {
    private final BokServiceAsync service;
    private final Collector<Throwable> onFailure;
    private final SessionManager session;

    @Inject
    public BokManagerService(BokServiceAsync service, SessionManager session) {
	this.service = service;
	this.session = session;
	this.onFailure = new Collector<Throwable>();
    }

    @Override
    public void get(String id, final Listener<Bok> listener) {
	service.get(id, new AsyncCallback<Bok>() {
	    @Override
	    public void onFailure(Throwable caught) {
		fireFailure(caught);
	    }

	    @Override
	    public void onSuccess(Bok result) {
		listener.handle(result);
	    }
	});
    }

    @Override
    public void onFailure(Listener<Throwable> listener) {
	onFailure.add(listener);
    }

    @Override
    public void post(Bok bok, final Listener<Bok> listener) {
	send(bok, listener, new Params());
    }

    @Override
    public void put(Bok bok, final Listener<Bok> listener) {
	send(bok, listener, new Params().With("_method", "put"));
    }

    @Override
    public void search(BokQuery query, final Listener<BokSearchResults> listener) {
	service.search(query, new AsyncCallback<BokSearchResults>() {
	    @Override
	    public void onFailure(Throwable caught) {
		fireFailure(caught);
	    }

	    @Override
	    public void onSuccess(BokSearchResults result) {
		listener.handle(result);
	    }
	});
    }

    private void send(Bok bok, final Listener<Bok> listener, Params p) {
	assert session.isLoggedIn() : "You can't post without logged in first.";
	p.put("authenticity_token", session.getAuthToken());
	bok.setUserId(session.getUserId());

	service.post(p, bok, new AsyncCallback<Bok>() {
	    @Override
	    public void onFailure(Throwable caught) {
		fireFailure(caught);
	    }

	    @Override
	    public void onSuccess(Bok result) {
		listener.handle(result);
	    }
	});
    }

    protected void fireFailure(Throwable caught) {
	onFailure.fire(caught);
    }
}
