package net.zaszas.booka.core.project;

import java.util.List;

import net.zaszas.booka.core.event.Listener;

public interface ProjectManager {
    public void onProjectList(Listener<List<Project>> listener);
}
