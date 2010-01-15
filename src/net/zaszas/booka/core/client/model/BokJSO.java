package net.zaszas.booka.core.client.model;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsonUtils;

public class BokJSO extends JavaScriptObject implements Bok {

    public static BokJSO newInstance() {
	return JsonUtils.unsafeEval("{'bok':{}}");
    }

    protected BokJSO() {
    }

    @Override
    public final native String getBokType() /*-{
        return this.bok.bok_type;
    }-*/;

    @Override
    public final native String getDescription() /*-{
        return this.bok.description;
    }-*/;

    @Override
    public final native int getId() /*-{
        return this.bok.id;
    }-*/;

    @Override
    public final native String getTitle() /*-{
        return this.bok.title;
    }-*/;

    @Override
    public final native void setBokType(String type) /*-{
        this.bok.bok_type = type;
    }-*/;

    @Override
    public final native void setDescription(String text) /*-{
        this.bok.description = text;
    }-*/;

    @Override
    public final native void setTitle(String title) /*-{
        this.bok.title = title;
    }-*/;

}
