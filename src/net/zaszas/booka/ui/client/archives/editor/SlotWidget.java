package net.zaszas.booka.ui.client.archives.editor;

import com.allen_sauer.gwt.log.client.Log;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;

public class SlotWidget extends Composite implements SlotView {

    interface SlotWidgetUiBinder extends UiBinder<Widget, SlotWidget> {
    }

    private static SlotWidgetUiBinder uiBinder = GWT.create(SlotWidgetUiBinder.class);
    private final DocumentEditorLogic logic;

    @UiField
    Label slot;

    public SlotWidget(final DocumentEditorLogic logic) {
	this.logic = logic;
	initWidget(uiBinder.createAndBindUi(this));
	// slot.addClickHandler(new ClickHandler() {
	// @Override
	// public void onClick(ClickEvent event) {
	// }
	// });
    }

    @UiHandler("slot")
    public void onClick(ClickEvent evt) {
	Log.debug("\nSLOT");
	logic.onSlotClicked(SlotWidget.this);
    }
}
