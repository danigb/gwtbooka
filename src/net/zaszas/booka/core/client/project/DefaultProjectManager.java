package net.zaszas.booka.core.client.project;

import java.util.ArrayList;
import java.util.List;

import net.zaszas.booka.core.client.event.Collector;
import net.zaszas.booka.core.client.event.Listener;
import net.zaszas.booka.core.client.model.BokSearchResultsJSO;
import net.zaszas.booka.core.client.service.AuthorizedRestManager;
import net.zaszas.booka.core.client.service.BokQuery;
import net.zaszas.booka.core.client.service.RestCallback;
import net.zaszas.booka.core.client.service.RestManager;

import com.google.gwt.core.client.JsonUtils;
import com.google.inject.Inject;

public class DefaultProjectManager implements ProjectManager {
    private static final String RESOURCE = "boks";
    private static final String FORMAT = "json";

    Collector<List<Project>> onProjects = new Collector<List<Project>>();
    private final RestManager manager;

    @Inject
    public DefaultProjectManager(AuthorizedRestManager manager) {
	this.manager = manager;
    }

    @Override
    public void getProjectList() {
	BokQuery query = new BokQuery();
	query.bokTypeEquals(Project.TYPE);

	manager.getList("projects.list", RESOURCE, query.toParams(), FORMAT, new RestCallback() {
	    @Override
	    public void onSuccess(String text) {
		handleResults(JsonUtils.<BokSearchResultsJSO> unsafeEval(text));
	    }
	});

    }

    @Override
    public void onProjectList(Listener<List<Project>> listener) {
	onProjects.add(listener);
    }

    protected void fireProjectList(ArrayList<Project> list) {
	onProjects.fire(list);
    }

    protected void handleResults(BokSearchResultsJSO results) {
	ArrayList<Project> list = new ArrayList<Project>();
	int total = results.getSize();
	for (int index = 0; index < total; index++) {
	    list.add(new Project(results.get(index)));
	}
	fireProjectList(list);
    }

}
