package net.zaszas.booka.ui.client.widgets;

import net.zaszas.booka.ui.client.View;

public interface SwitchLayoutView {

    public static enum Transition {
	slideRight
    }

    void show(View view, Transition transition);

}
