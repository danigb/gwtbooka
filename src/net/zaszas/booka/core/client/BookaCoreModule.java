package net.zaszas.booka.core.client;

import net.zaszas.booka.core.client.document.DefaultDocumentManager;
import net.zaszas.booka.core.client.document.DocumentManager;
import net.zaszas.booka.core.client.project.DefaultProjectManager;
import net.zaszas.booka.core.client.project.ProjectManager;
import net.zaszas.booka.core.client.service.RestManager;
import net.zaszas.booka.core.client.service.RestManagerImpl;
import net.zaszas.booka.core.client.session.DefaultSessionManager;
import net.zaszas.booka.core.client.session.SessionManager;
import net.zaszas.rest.client.RestServiceAsync;
import net.zaszas.rest.client.RestServiceAsyncImpl;

import com.google.gwt.inject.client.AbstractGinModule;
import com.google.inject.Singleton;

public class BookaCoreModule extends AbstractGinModule {
    @Override
    protected void configure() {
	bind(RestManager.class).to(RestManagerImpl.class).in(Singleton.class);
	bind(RestServiceAsync.class).to(RestServiceAsyncImpl.class).in(Singleton.class);
	bind(ProjectManager.class).to(DefaultProjectManager.class).in(Singleton.class);
	bind(DocumentManager.class).to(DefaultDocumentManager.class).in(Singleton.class);
	bind(SessionManager.class).to(DefaultSessionManager.class).in(Singleton.class);
    }

}
