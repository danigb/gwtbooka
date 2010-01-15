package net.zaszas.booka.ui.client.entrance;

import net.zaszas.booka.core.client.project.ProjectManager;

import com.google.inject.Inject;

public class EntranceLogic {
    private final ProjectManager manager;

    @Inject
    public EntranceLogic(ProjectManager manager) {
	this.manager = manager;
    }

    public void loadProjects() {
	manager.getProjectList();
    }

}
