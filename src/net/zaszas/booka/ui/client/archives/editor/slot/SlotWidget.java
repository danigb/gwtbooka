package net.zaszas.booka.ui.client.archives.editor.slot;

import net.zaszas.booka.ui.client.archives.editor.DocumentEditorLogic;
import net.zaszas.booka.ui.client.archives.editor.clip.editor.ClipEditor;
import net.zaszas.booka.ui.client.utils.Effects;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Widget;

public class SlotWidget extends Composite implements SlotView {

    interface SlotWidgetUiBinder extends UiBinder<Widget, SlotWidget> {
    }

    private static SlotWidgetUiBinder uiBinder = GWT.create(SlotWidgetUiBinder.class);
    private final DocumentEditorLogic logic;

    @UiField
    Anchor close;

    @UiField
    FlowPanel actions, slot;
    private ClipEditor editor;

    public SlotWidget(final DocumentEditorLogic logic) {
	this.logic = logic;
	initWidget(uiBinder.createAndBindUi(this));
	addAction("Text", "Texto");
	addAction("Video", "Vídeo");
    }

    public void setEditor(ClipEditor clipEditor) {
	this.editor = clipEditor;
	Effects.hide(editor);
	slot.insert((Widget) clipEditor, slot.getWidgetIndex(actions));
	Effects.fadeOut(actions);
	Effects.fadeIn(editor);
    }

    private void addAction(final String key, String label) {
	Anchor anchor = new Anchor(label);
	actions.add(anchor);
	anchor.addClickHandler(new ClickHandler() {
	    @Override
	    public void onClick(ClickEvent event) {
		logic.onSlotClicked(SlotWidget.this, key);
	    }
	});
    }

}
