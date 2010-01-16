package net.zaszas.booka.ui.client.project;

import java.util.List;

import net.zaszas.booka.core.client.document.DocumentManager;
import net.zaszas.booka.core.client.event.Listener;
import net.zaszas.booka.core.client.project.Project;
import net.zaszas.booka.core.client.project.ProjectManager;

import com.google.inject.Inject;

public class ProjectListLogic {

    private ProjectListView view;
    private final DocumentManager documents;

    @Inject
    public ProjectListLogic(ProjectManager projects, DocumentManager documents) {
	this.documents = documents;
	projects.onProjectList(new Listener<List<Project>>() {
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
	documents.getDocuments(project);
    }

    public void setView(ProjectListView view) {
	this.view = view;
    }

}
