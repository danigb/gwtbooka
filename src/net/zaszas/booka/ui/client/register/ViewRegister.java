package net.zaszas.booka.ui.client.register;

import net.zaszas.booka.ui.client.archives.ArchivesView;
import net.zaszas.booka.ui.client.entrance.EntranceView;

import com.google.gwt.core.client.GWT;
import com.google.inject.Inject;
import com.google.inject.Provider;

public class ViewRegister {
    @Inject
    public ViewRegister(ViewRegistry viewRegistry, Provider<EntranceView> entranceProvider,
	    Provider<ArchivesView> archivesProvider) {
	GWT.log("VIEW REGISTER INIT", null);
	viewRegistry.register(EntranceView.KEY, entranceProvider);
	viewRegistry.register(ArchivesView.KEY, archivesProvider);
    }
}
