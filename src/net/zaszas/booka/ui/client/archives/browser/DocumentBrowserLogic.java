package net.zaszas.booka.ui.client.archives.browser;

import net.zaszas.booka.core.client.document.Document;
import net.zaszas.booka.core.client.document.DocumentManager;
import net.zaszas.booka.core.client.document.ProjectDocuments;
import net.zaszas.booka.core.client.event.Listener;
import net.zaszas.booka.core.client.project.Project;

import com.google.inject.Inject;

public class DocumentBrowserLogic {

    private DocumentBrowserView view;
    private final DocumentManager documentManager;
    private ProjectDocuments currentDocuments;

    @Inject
    public DocumentBrowserLogic(final DocumentManager documentManager) {
	this.documentManager = documentManager;
	this.currentDocuments = null;

	documentManager.onProjectDocuments(new Listener<ProjectDocuments>() {
	    @Override
	    public void handle(final ProjectDocuments documents) {
		currentDocuments = documents;
		view.clear();
		for (Document d : documents) {
		    DocumentItemView item = view.add();
		    item.setDocument(d);
		}
		view.setCreateVisible(true);
	    }
	});
    }

    public void onItemClicked(DocumentItemView itemView) {
	documentManager.getDocumentClips(itemView.getDocument());
    }

    public void onNewDocument() {
	assert currentDocuments != null : "You should receive onNewDocument event without documents loaded previously";
	Project currentProject = currentDocuments.getProject();
	Document document = currentProject.newDocument("Sin título");
	documentManager.createDocument(document);
	documentManager.getProjectDocuments(currentProject);
    }

    public void setView(DocumentBrowserView view) {
	this.view = view;
	view.setCreateVisible(currentDocuments != null);
    }
}
