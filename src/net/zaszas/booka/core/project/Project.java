package net.zaszas.booka.core.project;

import net.zaszas.booka.core.client.model.Bok;
import net.zaszas.booka.core.client.model.DelegatedBok;

public class Project extends DelegatedBok {
    public static final String TYPE = "Project";

    public Project(Bok bok) {
	super(bok);
    }

    @Override
    public String getBokType() {
	return TYPE;
    }
}
