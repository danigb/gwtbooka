package net.zaszas.booka.ui.client;

import net.zaszas.booka.ui.client.app.BookaAppView;
import net.zaszas.booka.ui.client.app.NavigationView;
import net.zaszas.booka.ui.client.archives.ArchivesView;
import net.zaszas.booka.ui.client.entrance.EntranceView;
import net.zaszas.booka.ui.client.project.ProjectListView;

import com.google.gwt.inject.client.GinModules;
import com.google.gwt.inject.client.Ginjector;

@GinModules(BookaUIModule.class)
public interface BookaUIGinjector extends Ginjector {
    ArchivesView getArchivesView();

    BookaAppView getBookaAppView();

    EntranceView getEntranceView();

    NavigationView getNavigationView();

    ProjectListView getProjectListView();
}
