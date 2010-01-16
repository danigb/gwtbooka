package net.zaszas.booka.core.client;

import net.zaszas.booka.core.client.document.DefaultDocumentManager;
import net.zaszas.booka.core.client.document.DocumentManager;
import net.zaszas.booka.core.client.project.DefaultProjectManager;
import net.zaszas.booka.core.client.project.ProjectManager;
import net.zaszas.booka.core.client.service.BokManager;
import net.zaszas.booka.core.client.service.BokManagerService;
import net.zaszas.booka.core.client.service.BokServiceAsync;
import net.zaszas.booka.core.client.service.BokServiceAsyncJSON;
import net.zaszas.booka.core.client.service.UserSessionServiceAsync;
import net.zaszas.booka.core.client.service.UserSessionServiceAsyncJSON;
import net.zaszas.booka.core.client.session.DefaultSessionManager;
import net.zaszas.booka.core.client.session.SessionManager;

import com.google.gwt.inject.client.AbstractGinModule;
import com.google.inject.Singleton;

public class BookaCoreModule extends AbstractGinModule {
    @Override
    protected void configure() {
	bind(BokServiceAsync.class).to(BokServiceAsyncJSON.class).in(Singleton.class);
	bind(BokManager.class).to(BokManagerService.class).in(Singleton.class);
	bind(UserSessionServiceAsync.class).to(UserSessionServiceAsyncJSON.class).in(Singleton.class);
	bind(ProjectManager.class).to(DefaultProjectManager.class).in(Singleton.class);
	bind(DocumentManager.class).to(DefaultDocumentManager.class).in(Singleton.class);
	bind(SessionManager.class).to(DefaultSessionManager.class).in(Singleton.class);
    }

}
