package net.zaszas.booka.core.client.service;

import net.zaszas.booka.core.client.model.UserSession;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface UserSessionServiceAsync {
    void create(String name, String password, AsyncCallback<UserSession> callback);
}
