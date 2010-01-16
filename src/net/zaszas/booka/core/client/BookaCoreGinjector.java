package net.zaszas.booka.core.client;

import net.zaszas.booka.core.client.project.ProjectManager;
import net.zaszas.booka.core.client.service.BokServiceAsync;
import net.zaszas.booka.core.client.service.UserSessionServiceAsync;

import com.google.gwt.inject.client.GinModules;
import com.google.gwt.inject.client.Ginjector;

@GinModules(BookaCoreModule.class)
public interface BookaCoreGinjector extends Ginjector {
    BokServiceAsync getBokService();

    ProjectManager getProjectManager();

    UserSessionServiceAsync getUserSessionService();
}
