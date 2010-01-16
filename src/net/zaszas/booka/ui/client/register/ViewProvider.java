package net.zaszas.booka.ui.client.register;

import java.util.HashMap;

import net.zaszas.booka.ui.client.View;

import com.google.gwt.core.client.GWT;
import com.google.inject.Inject;
import com.google.inject.Provider;

/**
 * Se encarga de crear las vistas de la aplicación
 * 
 * No es singleton
 * 
 */
public class ViewProvider {
    private final ViewRegistry viewRegistry;
    private final HashMap<String, View> instances;

    @Inject
    public ViewProvider(ViewRegistry viewRegistry) {
	this.viewRegistry = viewRegistry;
	instances = new HashMap<String, View>();
    }

    public View get(String key) {
	GWT.log("GET VIEW: " + key, null);
	View view = instances.get(key);
	if (view == null) {
	    Provider<? extends View> provider = viewRegistry.get(key);
	    view = provider != null ? provider.get() : null;
	    instances.put(key, view);
	}
	assert view != null : "The view can't be null";
	return view;
    }

}
