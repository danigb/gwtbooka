package net.zaszas.booka.ui.client.archives.editor;

import net.zaszas.booka.core.client.document.Document;
import net.zaszas.booka.ui.client.View;
import net.zaszas.booka.ui.client.archives.editor.clip.ClipView;

public interface DocumentEditorView extends View {

    void add(View clipView);

    void addBefore(SlotView slot, ClipView clip);

    void clear();

    ClipView createClipView();

    SlotView createSlotView();

    void setDocument(Document document);

    void setDocumentVisible(boolean visible);

    void setPropertiesView(View view);

}
