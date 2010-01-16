package net.zaszas.booka.ui.client.register;

import net.zaszas.booka.ui.client.View;

import com.google.inject.Provider;

public interface ViewRegistry {
    Provider<? extends View> get(String key);

    void register(String key, Provider<? extends View> entranceProvider);

}
