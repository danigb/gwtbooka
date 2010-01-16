package net.zaszas.booka.ui.client.archives.browser;

import net.zaszas.booka.core.client.document.Document;
import net.zaszas.booka.core.client.document.DocumentManager;
import net.zaszas.booka.core.client.document.ProjectDocuments;
import net.zaszas.booka.core.client.event.Listener;

import com.google.inject.Inject;

public class DocumentBrowserLogic {

    private DocumentBrowserView view;
    private final DocumentManager documentManager;

    @Inject
    public DocumentBrowserLogic(final DocumentManager documentManager) {
	this.documentManager = documentManager;

	documentManager.onProjectDocuments(new Listener<ProjectDocuments>() {
	    @Override
	    public void handle(final ProjectDocuments documents) {
		view.clear();
		for (Document d : documents) {
		    DocumentItemView item = view.add();
		    item.setDocument(d);
		}
	    }
	});
    }

    public void onItemClicked(DocumentItemView itemView) {
	documentManager.getDocumentClips(itemView.getDocument());
    }

    public void setView(DocumentBrowserView view) {
	this.view = view;
    }
}
