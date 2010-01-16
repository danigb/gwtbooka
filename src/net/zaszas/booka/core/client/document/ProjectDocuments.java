package net.zaszas.booka.core.client.document;

import java.util.ArrayList;
import java.util.Iterator;

import net.zaszas.booka.core.client.model.BokSearchResults;
import net.zaszas.booka.core.client.project.Project;

public class ProjectDocuments implements Iterable<Document> {

    private final Project project;
    private final ArrayList<Document> list;

    public ProjectDocuments(Project project, BokSearchResults results) {
	this.project = project;
	this.list = new ArrayList<Document>();
	setResults(results);
    }

    public Project getProject() {
	return project;
    }

    @Override
    public Iterator<Document> iterator() {
	return list.iterator();
    }

    private void setResults(BokSearchResults results) {
	list.clear();
	int total = results.getSize();
	for (int index = 0; index < total; index++) {
	    list.add(new Document(results.get(index)));
	}
    }
}
