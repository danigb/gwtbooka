package net.zaszas.booka.core;

import net.zaszas.booka.core.client.service.BokServiceAsync;
import net.zaszas.booka.core.client.service.UserSessionServiceAsync;
import net.zaszas.booka.core.project.ProjectManager;

import com.google.gwt.inject.client.Ginjector;

public interface BookaCoreGinjector extends Ginjector {
    BokServiceAsync getBokService();

    ProjectManager getProjectManager();

    UserSessionServiceAsync getUserSessionService();
}
