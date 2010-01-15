package net.zaszas.booka.core.client.project;

import java.util.List;

import net.zaszas.booka.core.client.event.Listener;

public interface ProjectManager {
    public void getProjectList();

    public void onProjectList(Listener<List<Project>> listener);
}
