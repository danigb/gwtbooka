package net.zaszas.booka.client;

import net.zaszas.booka.core.client.BookaCoreGinjector;
import net.zaszas.booka.core.client.BookaCoreModule;
import net.zaszas.booka.ui.client.BookaUIGinjector;
import net.zaszas.booka.ui.client.BookaUIModule;

import com.google.gwt.inject.client.GinModules;

@GinModules( { BookaCoreModule.class, BookaUIModule.class })
public interface BookaGinjector extends BookaCoreGinjector, BookaUIGinjector {

}
