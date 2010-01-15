package net.zaszas.booka.core.client.model;

import com.google.gwt.core.client.JavaScriptObject;

public class UserSessionJSO extends JavaScriptObject implements UserSession {

    protected UserSessionJSO() {
    }

    public final native String getToken() /*-{
        return this.token;
    }-*/;
}
