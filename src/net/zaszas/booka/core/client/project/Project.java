package net.zaszas.booka.core.client.project;

import net.zaszas.booka.core.client.document.Document;
import net.zaszas.booka.core.client.model.Bok;
import net.zaszas.booka.core.client.model.BokJSO;
import net.zaszas.booka.core.client.model.DelegatedBok;

public class Project extends DelegatedBok {
    public static final String TYPE = "Project";

    public Project(Bok bok) {
	super(bok, TYPE);
    }

    @Override
    public String getBokType() {
	return TYPE;
    }

    public Document newDocument(String title) {
	Document document = new Document(BokJSO.newInstance(Document.TYPE));
	document.setTitle(title);
	document.setParentId(this.getId());
	return document;
    }
}
