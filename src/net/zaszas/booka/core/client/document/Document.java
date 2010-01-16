package net.zaszas.booka.core.client.document;

import net.zaszas.booka.core.client.model.Bok;
import net.zaszas.booka.core.client.model.DelegatedBok;

public class Document extends DelegatedBok {
    public static final String TYPE = "Document";

    public Document(Bok delegate) {
	super(delegate);
    }
}
