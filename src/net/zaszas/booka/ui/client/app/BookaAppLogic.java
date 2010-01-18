package net.zaszas.booka.ui.client.app;

import java.util.List;

import net.zaszas.booka.core.client.document.DocumentManager;
import net.zaszas.booka.core.client.document.ProjectDocuments;
import net.zaszas.booka.core.client.event.Listener;
import net.zaszas.booka.core.client.project.Project;
import net.zaszas.booka.core.client.project.ProjectManager;
import net.zaszas.booka.ui.client.archives.ArchivesView;
import net.zaszas.booka.ui.client.entrance.EntranceView;
import net.zaszas.booka.ui.client.register.ViewProvider;

import com.google.inject.Inject;

public class BookaAppLogic {

    private BookaAppWidget view;
    private String currentViewKey;
    private final ProjectManager projects;

    @Inject
    public BookaAppLogic(final ViewProvider provider, ProjectManager projects, DocumentManager documents) {
	this.projects = projects;
	this.currentViewKey = null;

	projects.onProjectList(new Listener<List<Project>>() {
	    @Override
	    public void handle(List<Project> object) {
		currentViewKey = EntranceView.KEY;
		view.show(provider.get(currentViewKey));
	    }
	});

	documents.onProjectDocuments(new Listener<ProjectDocuments>() {
	    @Override
	    public void handle(ProjectDocuments documents) {
		currentViewKey = ArchivesView.KEY;
		view.show(provider.get(currentViewKey));
	    }
	});

	new HistoryManager(this, projects, documents);
    }

    public void loadProjects() {
	if (currentViewKey != EntranceView.KEY) {
	    projects.getProjectList();
	}
    }

    public void setView(BookaAppWidget view) {
	this.view = view;
    }

}
