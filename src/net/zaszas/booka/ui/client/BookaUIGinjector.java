package net.zaszas.booka.ui.client;

import net.zaszas.booka.ui.client.project.ProjectListView;

import com.google.gwt.inject.client.Ginjector;

public interface BookaUIGinjector extends Ginjector {
    ProjectListView getProjectListView();
}
