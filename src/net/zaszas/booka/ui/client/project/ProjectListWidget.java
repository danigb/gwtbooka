package net.zaszas.booka.ui.client.project;

import java.util.List;

import net.zaszas.booka.core.event.Listener;
import net.zaszas.booka.core.project.Project;
import net.zaszas.booka.core.project.ProjectManager;

import com.google.inject.Inject;

public class ProjectListWidget implements ProjectListView {
    @Inject
    public ProjectListWidget(ProjectManager manager) {
	manager.onProjectList(new Listener<List<Project>>() {
	    @Override
	    public void handle(List<Project> object) {

	    }
	});
    }
}
