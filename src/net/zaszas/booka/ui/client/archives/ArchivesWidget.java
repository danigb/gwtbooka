package net.zaszas.booka.ui.client.archives;

import static com.google.gwt.dom.client.Style.Unit.PX;
import net.zaszas.booka.ui.client.archives.browser.DocumentBrowserView;
import net.zaszas.booka.ui.client.archives.comments.DocumentCommentsView;

import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.DockLayoutPanel;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;

public class ArchivesWidget extends Composite implements ArchivesView {

    private final ArchivesLogic logic;
    private final DockLayoutPanel dock;

    @Inject
    public ArchivesWidget(ArchivesLogic logic, DocumentBrowserView documents, DocumentCommentsView comments) {
	this.logic = logic;
	dock = new DockLayoutPanel(PX);
	initWidget(dock);
	dock.addWest((Widget) documents, 250);
	dock.addEast((Widget) comments, 250);
    }

    @Override
    public void loadProject(int projectId) {
	logic.loadProject(projectId);
    }
}
