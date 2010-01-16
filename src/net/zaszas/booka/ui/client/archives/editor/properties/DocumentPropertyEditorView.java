package net.zaszas.booka.ui.client.archives.editor.properties;

import net.zaszas.booka.core.client.document.Document;
import net.zaszas.booka.ui.client.View;
import net.zaszas.booka.ui.client.archives.editor.DocumentEditorLogic;

public interface DocumentPropertyEditorView extends View {

    String getDescription();

    String getTitle();

    void setDocument(Document document);

    void setLogic(DocumentEditorLogic logic);

}
