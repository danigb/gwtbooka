package net.zaszas.booka.ui.client.app;

import net.zaszas.booka.core.client.project.ProjectManager;

import com.google.inject.Inject;

public class NavigationLogic {

    private NavigationView view;

    @Inject
    public NavigationLogic(ProjectManager manager) {
    }

    public void setView(NavigationView view) {
	this.view = view;
    }
}
