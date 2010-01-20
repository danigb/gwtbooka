package net.zaszas.booka.core.client.document;

import net.zaszas.booka.core.client.model.Bok;
import net.zaszas.booka.core.client.model.BokJSO;
import net.zaszas.booka.core.client.model.DelegatedBok;

public class Clip extends DelegatedBok {

    public static final String TYPE = "Clip";

    public Clip() {
	super(BokJSO.newInstance(TYPE), TYPE);
    }

    public Clip(Bok delegate) {
	super(delegate, TYPE);
    }

}
