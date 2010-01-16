package net.zaszas.booka.ui.client.archives.editor;

import net.zaszas.booka.core.client.document.Clip;
import net.zaszas.booka.core.client.document.Document;
import net.zaszas.booka.core.client.document.DocumentClips;
import net.zaszas.booka.core.client.document.DocumentManager;
import net.zaszas.booka.core.client.event.Listener;
import net.zaszas.booka.ui.client.archives.editor.clip.ClipView;

import com.google.inject.Inject;

public class DocumentEditorLogic {

    private DocumentEditorView view;
    private DocumentClips current;

    @Inject
    public DocumentEditorLogic(DocumentManager manager) {
	this.current = null;

	manager.onDocumentsClips(new Listener<DocumentClips>() {
	    @Override
	    public void handle(DocumentClips clips) {
		view.clear();
		current = clips;
		Document document = clips.getDocument();
		view.setDocumentTitle(document.getTitle());
		view.setDocumentDescription(document.getDescription());
		for (Clip clip : clips) {
		    ClipView clipView = view.createClipView();
		    clipView.setClip(clip);
		    view.add(clipView);
		}
		view.setDocumentVisible(true);
	    }
	});
    }

    public void setView(DocumentEditorView view) {
	this.view = view;
	view.setDocumentVisible(current != null);
    }

}
