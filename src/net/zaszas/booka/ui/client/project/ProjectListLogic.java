package net.zaszas.booka.ui.client.project;

import java.util.List;

import net.zaszas.booka.core.client.event.Listener;
import net.zaszas.booka.core.client.project.Project;
import net.zaszas.booka.core.client.project.ProjectManager;
import net.zaszas.booka.ui.client.Router;

import com.google.gwt.user.client.History;
import com.google.inject.Inject;

public class ProjectListLogic {

    private ProjectListView view;

    @Inject
    public ProjectListLogic(ProjectManager manager) {
	manager.onProjectList(new Listener<List<Project>>() {
	    @Override
	    public void handle(List<Project> projects) {
		view.clearList();
		for (Project project : projects) {
		    ProjectView pv = view.createProjectView();
		    pv.setProject(project);
		    view.add(pv);
		}
	    }
	});
    }

    public void onProjectClicked(Project project) {
	History.newItem(Router.project_path(project.getId()));

    }

    public void setView(ProjectListView view) {
	this.view = view;
    }

}
