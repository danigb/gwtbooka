package net.zaszas.booka.core.client.document;

import net.zaszas.booka.core.client.event.Listener;
import net.zaszas.booka.core.client.project.Project;

public interface DocumentManager {

    public void getDocumentClips(Document document);

    public void getDocuments(Project project);

    public void onProjectDocuments(Listener<ProjectDocuments> listener);

    void onDocumentsClips(Listener<DocumentClips> listener);
}
