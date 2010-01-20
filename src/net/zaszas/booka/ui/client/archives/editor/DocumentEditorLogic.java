package net.zaszas.booka.ui.client.archives.editor;

import net.zaszas.booka.core.client.document.Clip;
import net.zaszas.booka.core.client.document.Document;
import net.zaszas.booka.core.client.document.DocumentClips;
import net.zaszas.booka.core.client.document.DocumentManager;
import net.zaszas.booka.core.client.event.Listener;
import net.zaszas.booka.ui.client.archives.editor.clip.ClipView;
import net.zaszas.booka.ui.client.archives.editor.properties.DocumentPropertyEditorView;
import net.zaszas.booka.ui.client.archives.editor.properties.DocumentPropertyViewerView;
import net.zaszas.booka.ui.client.archives.editor.slot.SlotWidget;

import com.google.inject.Inject;

public class DocumentEditorLogic {

    private DocumentEditorView view;
    private final DocumentClips current;
    private DocumentPropertyViewerView propertyViewer;
    private DocumentPropertyEditorView propertyEditor;
    private final DocumentManager manager;
    private ClipListLogic list;

    @Inject
    public DocumentEditorLogic(DocumentManager manager) {
	this.manager = manager;
	this.current = null;

	manager.onDocumentsClips(new Listener<DocumentClips>() {
	    @Override
	    public void handle(DocumentClips clips) {
		list.setList(clips);
	    }
	});
    }

    public void onEditProperties() {
	propertyEditor.setDocument(current.getDocument());
	view.setPropertiesView(propertyEditor);
    }

    public void onPropertiesEditCancel() {
	view.setPropertiesView(propertyViewer);
    }

    public void onPropertiesSave() {
	Document document = current.getDocument();
	document.setTitle(propertyEditor.getTitle());
	document.setDescription(propertyEditor.getDescription());
	propertyViewer.setDocument(document);
	view.setPropertiesView(propertyViewer);
	manager.update(document);
    }

    public void onSlotClicked(SlotWidget slot, String key) {
	ClipView clipView = list.addPairAfter(slot);
	Clip clip = new Clip();
	clip.setBody("Esto es un clip");
	clipView.setClip(clip);
	clipView.setEditorVisible(false);
    }

    public void setDocument(Document document) {
	propertyViewer.setDocument(document);
	propertyEditor.setDocument(document);
    }

    public void setViews(DocumentEditorView view, DocumentPropertyViewerView propertyViewer,
	    DocumentPropertyEditorView propertyEditor) {
	this.view = view;
	this.propertyViewer = propertyViewer;
	this.propertyEditor = propertyEditor;
	propertyViewer.setLogic(this);
	propertyEditor.setLogic(this);

	view.setDocumentVisible(current != null);
	view.setPropertiesView(propertyViewer);

	list = new ClipListLogic(view);
    }

}
