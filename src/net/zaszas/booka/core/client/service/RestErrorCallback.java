package net.zaszas.booka.core.client.service;

public interface RestErrorCallback {
    void onError(String requestId, Throwable exception);
}
