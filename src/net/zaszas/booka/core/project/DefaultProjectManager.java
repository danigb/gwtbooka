package net.zaszas.booka.core.project;

import java.util.List;

import net.zaszas.booka.core.client.service.BokServiceAsync;
import net.zaszas.booka.core.event.Collector;
import net.zaszas.booka.core.event.Listener;

import com.google.inject.Inject;

public class DefaultProjectManager implements ProjectManager {

    Collector<List<Project>> onProjects = new Collector<List<Project>>();
    private final BokServiceAsync service;

    @Inject
    public DefaultProjectManager(BokServiceAsync service) {
	this.service = service;
    }

    @Override
    public void onProjectList(Listener<List<Project>> listener) {
	onProjects.add(listener);
    }

}
