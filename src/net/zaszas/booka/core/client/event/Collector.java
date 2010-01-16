package net.zaszas.booka.core.client.event;

import java.util.ArrayList;

public class Collector<T> {
    private ArrayList<Listener<T>> listeners;
    private ArrayList<Listener<T>> toAdd;
    private ArrayList<Listener<T>> toRemove;

    public Collector() {
	listeners = null;
	toAdd = null;
    }

    public void add(final Listener<T> listener) {
	if (toAdd == null) {
	    toAdd = new ArrayList<Listener<T>>();
	}
	toAdd.add(listener);
    }

    public void fire(final T event) {
	addPending();
	removePending();
	fire(event, listeners);
	fire(event, toAdd);
	addPending();
	removePending();
    }

    public void remove(final Listener<T> listener) {
	if (toRemove == null) {
	    toRemove = new ArrayList<Listener<T>>();
	}
	toRemove.add(listener);
    }

    private void addPending() {
	if (toAdd != null) {
	    if (listeners == null) {
		this.listeners = new ArrayList<Listener<T>>();
	    }
	    listeners.addAll(toAdd);
	    toAdd = null;
	}
    }

    private void fire(final T event, final ArrayList<Listener<T>> listenerList) {
	if (listenerList != null) {
	    for (final Listener<T> listener : listenerList) {
		listener.handle(event);
	    }
	}
    }

    private void removePending() {
	if (toRemove != null) {
	    if (listeners != null) {
		listeners.removeAll(toRemove);
	    }
	    toRemove = null;
	}
    }

}
