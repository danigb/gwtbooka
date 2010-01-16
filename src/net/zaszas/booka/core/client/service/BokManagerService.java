package net.zaszas.booka.core.client.service;

import net.zaszas.booka.core.client.event.Collector;
import net.zaszas.booka.core.client.event.Listener;
import net.zaszas.booka.core.client.model.Bok;
import net.zaszas.booka.core.client.model.BokSearchResults;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.inject.Inject;

public class BokManagerService implements BokManager {
    private final BokServiceAsync service;
    private final Collector<Throwable> onFailure;

    @Inject
    public BokManagerService(BokServiceAsync service) {
	this.service = service;
	this.onFailure = new Collector<Throwable>();
    }

    @Override
    public void create(Bok bok, final Listener<Bok> listener) {
	service.create(bok, new AsyncCallback<Bok>() {
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

    protected void fireFailure(Throwable caught) {
	onFailure.fire(caught);
    }
}
