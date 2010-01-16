package net.zaszas.booka.core.client.session;

import net.zaszas.booka.core.client.event.Listener;
import net.zaszas.booka.core.client.model.UserSession;

public interface SessionManager {

    String getAuthToken();

    int getUserId();

    UserSession getUserSession();

    boolean isLoggedIn();

    void login(String name, String password);

    void logout();

    void onLoggedIn(Listener<SessionManager> listener);

    void onLoggedOut(Listener<SessionManager> listener);

}
