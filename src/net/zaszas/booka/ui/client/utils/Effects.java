package net.zaszas.booka.ui.client.utils;

import net.zaszas.booka.ui.client.View;

import com.google.gwt.user.client.Element;
import com.google.gwt.user.client.ui.Widget;

public class Effects {

    static EffectLibrary library = new JqueryEffects();

    public static void fadeIn(View view) {
	library.fadeIn(e(view));
    }

    public static void fadeOut(View view) {
	library.fadeOut(e(view));
    }

    public static void fadeOut(Widget widget) {
	library.fadeOut(e(widget));
    }

    public static void hide(View view) {
	library.hide(e(view));
    }

    public static void hide(Widget widget) {
	library.hide(e(widget));
    }

    public static void hover(View view, String cssClass) {
	library.hover(e(view), cssClass);
    }

    public static void hoverColors(View view, String hover, String out) {
	library.hoverColors(e(view), hover, out);
    }

    public static void slideDown(View view) {
	library.slideDown(e(view));
    }

    private static Element e(View view) {
	return ((Widget) view).getElement();
    }

    private static Element e(Widget widget) {
	return widget.getElement();
    }
}
