package net.zaszas.booka.ui.client;

import net.zaszas.booka.ui.client.app.BookaAppView;
import net.zaszas.booka.ui.client.app.BookaAppWidget;
import net.zaszas.booka.ui.client.app.NavigationView;
import net.zaszas.booka.ui.client.app.NavigationWidget;
import net.zaszas.booka.ui.client.archives.ArchivesView;
import net.zaszas.booka.ui.client.archives.ArchivesWidget;
import net.zaszas.booka.ui.client.archives.DocumentBrowserView;
import net.zaszas.booka.ui.client.archives.DocumentBrowserWidget;
import net.zaszas.booka.ui.client.archives.DocumentCommentsView;
import net.zaszas.booka.ui.client.archives.DocumentCommentsWidget;
import net.zaszas.booka.ui.client.entrance.EntranceView;
import net.zaszas.booka.ui.client.entrance.EntranceWidget;
import net.zaszas.booka.ui.client.project.ProjectListView;
import net.zaszas.booka.ui.client.project.ProjectListWidget;

import com.google.gwt.inject.client.AbstractGinModule;

public class BookaUIModule extends AbstractGinModule {

    @Override
    protected void configure() {
	bind(BookaAppView.class).to(BookaAppWidget.class);
	bind(NavigationView.class).to(NavigationWidget.class);

	// entrance
	bind(EntranceView.class).to(EntranceWidget.class);
	bind(ProjectListView.class).to(ProjectListWidget.class);

	// archives
	bind(ArchivesView.class).to(ArchivesWidget.class);
	bind(DocumentBrowserView.class).to(DocumentBrowserWidget.class);
	bind(DocumentCommentsView.class).to(DocumentCommentsWidget.class);
    }

}
