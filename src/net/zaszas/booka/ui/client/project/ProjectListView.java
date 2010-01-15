package net.zaszas.booka.ui.client.project;

import net.zaszas.booka.ui.client.View;

public interface ProjectListView extends View {

    void add(ProjectView projectView);

    void clearList();

    ProjectView createProjectView();

}
