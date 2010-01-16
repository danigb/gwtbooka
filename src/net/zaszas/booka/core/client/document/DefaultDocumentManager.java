package net.zaszas.booka.core.client.document;

import net.zaszas.booka.core.client.event.Collector;
import net.zaszas.booka.core.client.event.Listener;
import net.zaszas.booka.core.client.model.BokSearchResults;
import net.zaszas.booka.core.client.project.Project;
import net.zaszas.booka.core.client.service.BokManager;
import net.zaszas.booka.core.client.service.BokQuery;

import com.google.inject.Inject;

public class DefaultDocumentManager implements DocumentManager {
    private final BokManager manager;
    private final Collector<ProjectDocuments> onDocuments;

    @Inject
    public DefaultDocumentManager(BokManager manager) {
	this.manager = manager;
	this.onDocuments = new Collector<ProjectDocuments>();
    }

    @Override
    public void getDocuments(final Project project) {
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
    public void onProjectDocuments(Listener<ProjectDocuments> listener) {
	onDocuments.add(listener);
    }

}
