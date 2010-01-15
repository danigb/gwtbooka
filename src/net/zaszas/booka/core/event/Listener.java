package net.zaszas.booka.core.event;

public interface Listener<T> {
    void handle(T object);
}
