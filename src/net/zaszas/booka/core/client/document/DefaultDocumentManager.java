package net.zaszas.booka.core.client.document;

import net.zaszas.booka.core.client.event.Collector;
import net.zaszas.booka.core.client.event.Listener;
import net.zaszas.booka.core.client.model.BokJSO;
import net.zaszas.booka.core.client.model.BokSearchResults;
import net.zaszas.booka.core.client.model.BokSearchResultsJSO;
import net.zaszas.booka.core.client.model.BokToParams;
import net.zaszas.booka.core.client.project.Project;
import net.zaszas.booka.core.client.service.AuthorizedRestManager;
import net.zaszas.booka.core.client.service.BokQuery;
import net.zaszas.booka.core.client.service.RestCallback;
import net.zaszas.booka.core.client.service.RestManager;
import net.zaszas.rest.client.Params;

import com.google.gwt.core.client.JsonUtils;
import com.google.inject.Inject;

public class DefaultDocumentManager implements DocumentManager {
    private static final String RESOURCE = "boks";
    private static final String JSON = "json";

    private final Collector<ProjectDocuments> onDocuments;
    private final Collector<DocumentClips> onClips;
    private final Collector<Document> onSaved;
    private final RestManager manager;

    @Inject
    public DefaultDocumentManager(AuthorizedRestManager manager) {
	this.manager = manager;
	this.onDocuments = new Collector<ProjectDocuments>();
	this.onClips = new Collector<DocumentClips>();
	this.onSaved = new Collector<Document>();
    }

    @Override
    public void createDocument(final Document document) {
	Params params = BokToParams.encode(document, new Params());
	assert params != null : "JODER!";
	manager.create("documents.create", RESOURCE, params, JSON, new RestCallback() {
	    @Override
	    public void onSuccess(String text) {
		BokJSO bok = JsonUtils.unsafeEval(text);
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
	Params params = query.toParams();
	manager.getList("documents.clips", RESOURCE, params, JSON, new RestCallback() {
	    @Override
	    public void onSuccess(String text) {
		BokSearchResultsJSO results = JsonUtils.unsafeEval(text);
		onClips.fire(new DocumentClips(document, results));
	    }
	});
    }

    @Override
    public void getProjectDocuments(final Project project) {
	BokQuery query = new BokQuery();
	query.bokTypeEquals(Document.TYPE);
	query.bokParentEquals(project.getId());

	manager.getList("documents.documents", RESOURCE, query.toParams(), JSON, new RestCallback() {
	    @Override
	    public void onSuccess(String text) {
		BokSearchResultsJSO results = JsonUtils.unsafeEval(text);
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
	Params params = BokToParams.encode(document, new Params());
	manager.update("documents.update", RESOURCE, document.getIdString(), params, JSON, new RestCallback() {
	    @Override
	    public void onSuccess(String text) {

	    }
	});

	// onSaved.fire(new Document(bok));
    }

}
