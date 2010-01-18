package net.zaszas.booka.core.client;

import net.zaszas.booka.core.client.document.DocumentManager;
import net.zaszas.booka.core.client.project.ProjectManager;
import net.zaszas.booka.core.client.service.RestManager;
import net.zaszas.booka.core.client.session.SessionManager;
import net.zaszas.rest.client.RestServiceAsync;

import com.google.gwt.inject.client.GinModules;
import com.google.gwt.inject.client.Ginjector;

@GinModules(BookaCoreModule.class)
public interface BookaCoreGinjector extends Ginjector {

    DocumentManager getDocumentManager();

    ProjectManager getProjectManager();

    RestManager getRestManager();

    RestServiceAsync getRestServiceAsync();

    SessionManager getSessionManager();

}
