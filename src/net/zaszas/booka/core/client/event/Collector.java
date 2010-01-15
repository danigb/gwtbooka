package net.zaszas.booka.core.client.event;

import java.util.ArrayList;

public class Collector<T> extends ArrayList<Listener<T>> {
    private static final long serialVersionUID = 1L;

    public void fire(T object) {
	for (Listener<T> listener : this) {
	    listener.handle(object);
	}
    }

}
