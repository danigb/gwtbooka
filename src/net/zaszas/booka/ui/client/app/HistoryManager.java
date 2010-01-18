package net.zaszas.booka.ui.client.app;

import net.zaszas.booka.core.client.document.DocumentManager;
import net.zaszas.booka.core.client.document.ProjectDocuments;
import net.zaszas.booka.core.client.event.Listener;
import net.zaszas.booka.core.client.project.ProjectManager;
import net.zaszas.booka.ui.client.Router;

import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.user.client.History;

public class HistoryManager {

    private final BookaAppLogic logic;
    private String currentProjectId;
    private final DocumentManager documents;
    private final ProjectManager projects;

    public HistoryManager(BookaAppLogic logic, ProjectManager projects, DocumentManager documents) {
	this.logic = logic;
	this.projects = projects;
	this.documents = documents;
	this.currentProjectId = null;
	History.addValueChangeHandler(new ValueChangeHandler<String>() {
	    @Override
	    public void onValueChange(ValueChangeEvent<String> event) {
		handleToken(event.getValue());
	    }
	});

	documents.onProjectDocuments(new Listener<ProjectDocuments>() {
	    @Override
	    public void handle(ProjectDocuments documents) {
		currentProjectId = documents.getProject().getId();
		History.newItem(Router.project_path(currentProjectId), false);
	    }
	});

	History.fireCurrentHistoryState();
    }

    public void handleToken(String token) {
	if (token.matches(Router.REGEX_HOME) || token.matches(Router.REGEX_ENTRANCE)) {
	    logic.loadProjects();
	} else if (Router.isProjectPath(token)) {
	    String id = Router.getProjectId(token);
	}
    }
}
