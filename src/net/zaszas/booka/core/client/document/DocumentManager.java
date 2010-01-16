package net.zaszas.booka.core.client.document;

import net.zaszas.booka.core.client.event.Listener;
import net.zaszas.booka.core.client.project.Project;

public interface DocumentManager {

    public void createDocument(Document document);

    public void getDocumentClips(Document document);

    public void getProjectDocuments(Project project);

    public void onProjectDocuments(Listener<ProjectDocuments> listener);

    public void update(Document document);

    void onDocumentsClips(Listener<DocumentClips> listener);
}
