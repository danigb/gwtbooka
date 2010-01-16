package net.zaszas.booka.core.client.document;

import net.zaszas.booka.core.client.model.BokSearchResults;

public class DocumentClips {

    private final Document document;

    public DocumentClips(Document document, BokSearchResults results) {
	this.document = document;

    }

    public Document getDocument() {
	return document;
    }

}
