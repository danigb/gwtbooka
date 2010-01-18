package net.zaszas.booka.ui.client.archives;

import static com.google.gwt.dom.client.Style.Unit.PX;
import net.zaszas.booka.ui.client.archives.browser.DocumentBrowserView;
import net.zaszas.booka.ui.client.archives.comments.DocumentCommentsView;
import net.zaszas.booka.ui.client.archives.editor.DocumentEditorView;

import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.DockLayoutPanel;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;

public class ArchivesWidget extends Composite implements ArchivesView {

    private final DockLayoutPanel dock;
    private final DocumentEditorView editor;

    @Inject
    public ArchivesWidget(ArchivesLogic logic, DocumentEditorView editor, DocumentBrowserView documents,
	    DocumentCommentsView comments) {
	this.editor = editor;
	dock = new DockLayoutPanel(PX);
	initWidget(dock);
	dock.addWest((Widget) documents, 250);
	dock.addEast((Widget) comments, 250);
	dock.add((Widget) editor);
	logic.setView(this);
    }

    @Override
    public void setDocumentVisible(boolean visible) {
	editor.setDocumentVisible(visible);
    }

}
