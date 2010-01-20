package net.zaszas.booka.ui.client.archives.editor.clip;

import net.zaszas.booka.core.client.document.Clip;
import net.zaszas.booka.ui.client.View;

public interface ClipView extends View {

    void setClip(Clip clip);

    void setEditorVisible(boolean visible);

}
