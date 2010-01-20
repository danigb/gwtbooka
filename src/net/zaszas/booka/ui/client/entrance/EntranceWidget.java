package net.zaszas.booka.ui.client.entrance;

import static com.google.gwt.dom.client.Style.Unit.PX;
import net.zaszas.booka.ui.client.entrance.project.ProjectListView;

import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.DockLayoutPanel;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;

public class EntranceWidget extends Composite implements EntranceView {
    private final DockLayoutPanel dock;
    private final EntranceLogic logic;

    @Inject
    public EntranceWidget(EntranceLogic logic, ProjectListView projects) {
	this.logic = logic;
	dock = new DockLayoutPanel(PX);
	initWidget(dock);
	dock.addEast((Widget) projects, 250);
	setWidth("100%");
	setHeight("100%");
    }

    @Override
    public void loadProjects() {
	logic.loadProjects();
    }
}
