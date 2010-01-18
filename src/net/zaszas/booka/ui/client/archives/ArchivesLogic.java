package net.zaszas.booka.ui.client.archives;

import net.zaszas.booka.core.client.document.DocumentManager;
import net.zaszas.booka.core.client.document.ProjectDocuments;
import net.zaszas.booka.core.client.event.Listener;

import com.google.inject.Inject;

public class ArchivesLogic {
    private ArchivesView view;

    @Inject
    public ArchivesLogic(DocumentManager manager) {
	manager.onProjectDocuments(new Listener<ProjectDocuments>() {
	    @Override
	    public void handle(ProjectDocuments object) {
		view.setDocumentVisible(false);
	    }
	});
    }

    public void loadProject(int id) {

    }

    public void setView(ArchivesView view) {
	this.view = view;
    }

}
