package net.zaszas.booka.ui.client;

import net.zaszas.booka.ui.client.app.BookaAppView;
import net.zaszas.booka.ui.client.app.BookaAppWidget;
import net.zaszas.booka.ui.client.archives.ArchivesView;
import net.zaszas.booka.ui.client.archives.ArchivesWidget;
import net.zaszas.booka.ui.client.entrance.EntranceView;
import net.zaszas.booka.ui.client.entrance.EntranceWidget;
import net.zaszas.booka.ui.client.project.ProjectListView;
import net.zaszas.booka.ui.client.project.ProjectListWidget;

import com.google.gwt.inject.client.AbstractGinModule;

public class BookaUIModule extends AbstractGinModule {

    @Override
    protected void configure() {
	bind(BookaAppView.class).to(BookaAppWidget.class);
	bind(EntranceView.class).to(EntranceWidget.class);
	bind(ProjectListView.class).to(ProjectListWidget.class);
	bind(ArchivesView.class).to(ArchivesWidget.class);
    }

}
