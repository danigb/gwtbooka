package net.zaszas.booka.core.client.project;

import java.util.ArrayList;
import java.util.List;

import net.zaszas.booka.core.client.event.Collector;
import net.zaszas.booka.core.client.event.Listener;
import net.zaszas.booka.core.client.model.BokSearchResults;
import net.zaszas.booka.core.client.service.BokQuery;
import net.zaszas.booka.core.client.service.BokServiceAsync;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.inject.Inject;

public class DefaultProjectManager implements ProjectManager {

    Collector<List<Project>> onProjects = new Collector<List<Project>>();
    private final BokServiceAsync service;

    @Inject
    public DefaultProjectManager(BokServiceAsync service) {
	this.service = service;
    }

    @Override
    public void getProjectList() {
	BokQuery query = new BokQuery();
	query.bokTypeEquals(Project.TYPE);
	service.search(query, new AsyncCallback<BokSearchResults>() {
	    @Override
	    public void onFailure(Throwable caught) {
	    }

	    @Override
	    public void onSuccess(BokSearchResults result) {
		ArrayList<Project> list = new ArrayList<Project>();
		int total = result.getSize();
		for (int index = 0; index < total; index++) {
		    list.add(new Project(result.get(index)));
		}
		fireProjectList(list);
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

}
