package net.zaszas.booka.core.client.model;

import com.google.gwt.core.client.JavaScriptObject;

public class BokSearchResultsJSO extends JavaScriptObject implements BokSearchResults {

    protected BokSearchResultsJSO() {
    }

    public final native Bok get(int index) /*-{
        return this[index];
    }-*/;

    public final native int getSize() /*-{
        return this.length;
    }-*/;
}
