package net.zaszas.booka.core.client.model;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsonUtils;

public class BokJSO extends JavaScriptObject implements Bok {

    public static BokJSO newInstance() {
	return JsonUtils.unsafeEval("{'bok':{}}");
    }

    protected BokJSO() {
    }

    public final native String getDescription() /*-{
        return this.bok.description;
    }-*/;

    public final native String getTitle() /*-{
        return this.bok.title;
    }-*/;

    public final native void setDescription(String text) /*-{
        this.bok.description = text;
    }-*/;

}
