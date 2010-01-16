package net.zaszas.booka.core.client.project;

import java.util.ArrayList;
import java.util.List;

import net.zaszas.booka.core.client.event.Collector;
import net.zaszas.booka.core.client.event.Listener;
import net.zaszas.booka.core.client.model.BokSearchResults;
import net.zaszas.booka.core.client.service.BokManager;
import net.zaszas.booka.core.client.service.BokQuery;

import com.google.inject.Inject;

public class DefaultProjectManager implements ProjectManager {

    Collector<List<Project>> onProjects = new Collector<List<Project>>();
    private final BokManager manager;

    @Inject
    public DefaultProjectManager(BokManager manager) {
	this.manager = manager;
    }

    @Override
    public void getProjectList() {
	BokQuery query = new BokQuery();
	query.bokTypeEquals(Project.TYPE);
	manager.search(query, new Listener<BokSearchResults>() {

	    @Override
	    public void handle(BokSearchResults results) {
		ArrayList<Project> list = new ArrayList<Project>();
		int total = results.getSize();
		for (int index = 0; index < total; index++) {
		    list.add(new Project(results.get(index)));
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
