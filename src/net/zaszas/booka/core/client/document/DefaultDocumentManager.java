package net.zaszas.booka.core.client.document;

import net.zaszas.booka.core.client.event.Collector;
import net.zaszas.booka.core.client.event.Listener;
import net.zaszas.booka.core.client.model.Bok;
import net.zaszas.booka.core.client.model.BokSearchResults;
import net.zaszas.booka.core.client.project.Project;
import net.zaszas.booka.core.client.service.BokManager;
import net.zaszas.booka.core.client.service.BokQuery;

import com.google.inject.Inject;

public class DefaultDocumentManager implements DocumentManager {
    private final BokManager manager;
    private final Collector<ProjectDocuments> onDocuments;
    private final Collector<DocumentClips> onClips;
    private final Collector<Document> onSaved;

    @Inject
    public DefaultDocumentManager(BokManager manager) {
	this.manager = manager;
	this.onDocuments = new Collector<ProjectDocuments>();
	this.onClips = new Collector<DocumentClips>();
	this.onSaved = new Collector<Document>();
    }

    @Override
    public void createDocument(final Document document) {
	manager.post(document, new Listener<Bok>() {
	    @Override
	    public void handle(Bok bok) {
		Document document = new Document(bok);
		onClips.fire(new DocumentClips(document, BokSearchResults.NONE));
	    }
	});
    }

    @Override
    public void getDocumentClips(final Document document) {
	BokQuery query = new BokQuery();
	query.bokParentEquals(document.getId());
	query.bokTypeEquals(Clip.TYPE);
	manager.search(query, new Listener<BokSearchResults>() {
	    @Override
	    public void handle(BokSearchResults results) {
		onClips.fire(new DocumentClips(document, results));
	    }
	});
    }

    @Override
    public void getProjectDocuments(final Project project) {
	BokQuery query = new BokQuery();
	query.bokTypeEquals(Document.TYPE);
	query.bokParentEquals(project.getId());
	manager.search(query, new Listener<BokSearchResults>() {
	    @Override
	    public void handle(BokSearchResults results) {
		onDocuments.fire(new ProjectDocuments(project, results));
	    }
	});
    }

    @Override
    public void onDocumentsClips(Listener<DocumentClips> listener) {
	onClips.add(listener);
    }

    @Override
    public void onProjectDocuments(Listener<ProjectDocuments> listener) {
	onDocuments.add(listener);
    }

    @Override
    public void update(Document document) {
	manager.put(document, new Listener<Bok>() {
	    @Override
	    public void handle(Bok bok) {
		onSaved.fire(new Document(bok));
	    }
	});
    }

}
