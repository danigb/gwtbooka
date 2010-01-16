package net.zaszas.booka.ui.client.register;

import java.util.HashMap;

import net.zaszas.booka.ui.client.View;

import com.google.gwt.core.client.GWT;
import com.google.inject.Provider;

/**
 * Registra las vistas de la aplicacion
 * 
 * SINGLETON
 * 
 */
public class DefaultViewRegistry implements ViewRegistry {
    private final HashMap<String, Provider<? extends View>> providers;

    public DefaultViewRegistry() {
	GWT.log("REGISTRY CREATED", null);
	providers = new HashMap<String, Provider<? extends View>>();
    }

    public Provider<? extends View> get(String key) {
	return providers.get(key);
    }

    public void register(String key, Provider<? extends View> viewProvider) {
	GWT.log("REGISTRY: " + key, null);
	providers.put(key, viewProvider);
    }
}
