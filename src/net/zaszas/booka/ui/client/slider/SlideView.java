package net.zaszas.booka.ui.client.slider;

import net.zaszas.booka.ui.client.View;

public interface SlideView {

    public static enum Transition {
	slideRight
    }

    void show(View view, Transition transition);

}
