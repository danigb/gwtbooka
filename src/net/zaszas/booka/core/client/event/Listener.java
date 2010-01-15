package net.zaszas.booka.core.client.event;

public interface Listener<T> {
    void handle(T object);
}
