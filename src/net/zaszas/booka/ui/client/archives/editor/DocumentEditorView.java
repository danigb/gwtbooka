package net.zaszas.booka.ui.client.archives.editor;

import net.zaszas.booka.core.client.document.Document;
import net.zaszas.booka.ui.client.View;
import net.zaszas.booka.ui.client.archives.editor.clip.ClipView;
import net.zaszas.booka.ui.client.archives.editor.clip.editor.ClipEditor;
import net.zaszas.booka.ui.client.archives.editor.slot.SlotView;

public interface DocumentEditorView extends View {

    void add(View view);

    void clear();

    ClipView createClipView(ClipEditor editor);

    SlotView createSlotView();

    void insert(View view, int beforeIndex);

    void setDocument(Document document);

    void setDocumentVisible(boolean visible);

    void setPropertiesView(View view);

}
