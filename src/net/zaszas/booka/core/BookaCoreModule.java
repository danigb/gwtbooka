package net.zaszas.booka.core;

import net.zaszas.booka.core.client.service.BokServiceAsync;
import net.zaszas.booka.core.client.service.BokServiceAsyncJSON;
import net.zaszas.booka.core.client.service.UserSessionServiceAsync;
import net.zaszas.booka.core.client.service.UserSessionServiceAsyncJSON;
import net.zaszas.booka.core.project.DefaultProjectManager;
import net.zaszas.booka.core.project.ProjectManager;

import com.google.gwt.inject.client.AbstractGinModule;
import com.google.inject.Singleton;

public class BookaCoreModule extends AbstractGinModule {
    @Override
    protected void configure() {
	bind(BokServiceAsync.class).to(BokServiceAsyncJSON.class).in(Singleton.class);
	bind(UserSessionServiceAsync.class).to(UserSessionServiceAsyncJSON.class).in(Singleton.class);
	bind(ProjectManager.class).to(DefaultProjectManager.class).in(Singleton.class);
    }

}
