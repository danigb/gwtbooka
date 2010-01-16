package net.zaszas.booka.ui.client.archives.editor;

import net.zaszas.booka.ui.client.View;
import net.zaszas.booka.ui.client.archives.editor.clip.ClipView;

public interface DocumentEditorView extends View {

    void add(ClipView clipView);

    void clear();

    ClipView createClipView();

    void setDocumentDescription(String description);

    void setDocumentTitle(String title);

    void setDocumentVisible(boolean visible);

}
