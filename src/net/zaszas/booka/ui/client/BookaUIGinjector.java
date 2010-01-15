package net.zaszas.booka.ui.client;

import net.zaszas.booka.ui.client.app.BookaAppView;
import net.zaszas.booka.ui.client.project.ProjectListView;

import com.google.gwt.inject.client.Ginjector;

public interface BookaUIGinjector extends Ginjector {
    BookaAppView getBookaAppView();

    ProjectListView getProjectListView();
}
