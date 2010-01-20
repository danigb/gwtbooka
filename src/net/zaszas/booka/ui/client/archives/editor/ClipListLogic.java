package net.zaszas.booka.ui.client.archives.editor;

import java.util.ArrayList;

import net.zaszas.booka.core.client.document.Clip;
import net.zaszas.booka.core.client.document.Document;
import net.zaszas.booka.core.client.document.DocumentClips;
import net.zaszas.booka.ui.client.View;
import net.zaszas.booka.ui.client.archives.editor.clip.ClipView;
import net.zaszas.booka.ui.client.archives.editor.clip.editor.ClipEditorText;
import net.zaszas.booka.ui.client.archives.editor.slot.SlotView;
import net.zaszas.booka.ui.client.archives.editor.slot.SlotWidget;
import net.zaszas.booka.ui.client.utils.Effects;

import com.google.gwt.core.client.GWT;

public class ClipListLogic {

    private final DocumentEditorView view;
    private final ArrayList<View> items;

    public ClipListLogic(DocumentEditorView view) {
	this.view = view;
	this.items = new ArrayList<View>();
    }

    public ClipView addPairAfter(SlotWidget slot) {
	int index = items.indexOf(slot) + 1;
	assert index > 0;
	SlotView slotView = createSlotView();
	ClipView clipView = createClipView();
	if (index == items.size()) { // last
	    addItem(slotView);
	    addItem(clipView);
	} else {
	    insertBefore(slotView, index);
	    insertBefore(clipView, index);
	}
	return clipView;

    }

    public void setList(DocumentClips clips) {
	GWT.log("CLL: setList", null);
	Document document = clips.getDocument();
	view.setDocument(document);
	int index = 0;
	SlotView slot = getSlot(index);
	Effects.fadeIn(slot);
	for (Clip clip : clips) {
	    ClipView clipView = getClipView(index + 1);
	    clipView.setClip(clip);
	    Effects.fadeIn(clipView);
	    index += 2;
	    slot = getSlot(index);
	    Effects.fadeIn(slot);
	}
	for (; index < items.size(); index++) {
	    GWT.log("HIDE " + index, null);
	    Effects.fadeOut(items.get(index));
	}
	view.setDocumentVisible(true);

    }

    private void addItem(View item) {
	items.add(item);
	view.add(item);
    }

    private ClipView createClipView() {
	return view.createClipView(new ClipEditorText());
    }

    private SlotView createSlotView() {
	return view.createSlotView();
    }

    private ClipView getClipView(int index) {
	assert index <= items.size() : "You have to get the in order";
	ClipView clipView;
	if (index < items.size()) {
	    clipView = (ClipView) items.get(index);
	} else {
	    GWT.log("CLL new clip!", null);
	    clipView = createClipView();
	    addItem(clipView);
	}
	return clipView;
    }

    private SlotView getSlot(int index) {
	assert index <= items.size() : "You have to get the in order";
	SlotView slotView;
	if (index < items.size()) {
	    slotView = (SlotView) items.get(index);
	} else {
	    GWT.log("CLL new slot!", null);
	    slotView = createSlotView();
	    view.add(slotView);
	    items.add(slotView);
	}
	return slotView;
    }

    private void insertBefore(View child, int index) {
	items.add(index, view);
	view.insert(child, index);
    }

}
