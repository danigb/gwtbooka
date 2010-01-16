package net.zaszas.booka.ui.client;

import net.zaszas.booka.ui.client.app.BookaAppView;
import net.zaszas.booka.ui.client.app.BookaAppWidget;
import net.zaszas.booka.ui.client.app.NavigationView;
import net.zaszas.booka.ui.client.app.NavigationWidget;
import net.zaszas.booka.ui.client.archives.ArchivesView;
import net.zaszas.booka.ui.client.archives.ArchivesWidget;
import net.zaszas.booka.ui.client.archives.browser.DocumentBrowserView;
import net.zaszas.booka.ui.client.archives.browser.DocumentBrowserWidget;
import net.zaszas.booka.ui.client.archives.comments.DocumentCommentsView;
import net.zaszas.booka.ui.client.archives.comments.DocumentCommentsWidget;
import net.zaszas.booka.ui.client.archives.editor.DocumentEditorView;
import net.zaszas.booka.ui.client.archives.editor.DocumentEditorWidget;
import net.zaszas.booka.ui.client.archives.editor.clip.ClipViewerView;
import net.zaszas.booka.ui.client.archives.editor.clip.ClipViewerWidget;
import net.zaszas.booka.ui.client.archives.editor.properties.DocumentPropertyEditorView;
import net.zaszas.booka.ui.client.archives.editor.properties.DocumentPropertyEditorWidget;
import net.zaszas.booka.ui.client.archives.editor.properties.DocumentPropertyViewerView;
import net.zaszas.booka.ui.client.archives.editor.properties.DocumentPropertyViewerWidget;
import net.zaszas.booka.ui.client.entrance.EntranceView;
import net.zaszas.booka.ui.client.entrance.EntranceWidget;
import net.zaszas.booka.ui.client.project.ProjectListView;
import net.zaszas.booka.ui.client.project.ProjectListWidget;
import net.zaszas.booka.ui.client.register.DefaultViewRegistry;
import net.zaszas.booka.ui.client.register.ViewRegister;
import net.zaszas.booka.ui.client.register.ViewRegistry;

import com.google.gwt.inject.client.AbstractGinModule;
import com.google.inject.Singleton;

public class BookaUIModule extends AbstractGinModule {

    @Override
    protected void configure() {
	// application
	bind(BookaAppView.class).to(BookaAppWidget.class).in(Singleton.class);
	bind(NavigationView.class).to(NavigationWidget.class);

	// entrance
	bind(EntranceView.class).to(EntranceWidget.class);
	bind(ProjectListView.class).to(ProjectListWidget.class);

	// archives
	bind(ArchivesView.class).to(ArchivesWidget.class);
	bind(DocumentBrowserView.class).to(DocumentBrowserWidget.class);
	bind(DocumentCommentsView.class).to(DocumentCommentsWidget.class);
	bind(DocumentEditorView.class).to(DocumentEditorWidget.class);
	bind(ClipViewerView.class).to(ClipViewerWidget.class);
	bind(DocumentPropertyViewerView.class).to(DocumentPropertyViewerWidget.class);
	bind(DocumentPropertyEditorView.class).to(DocumentPropertyEditorWidget.class);

	// registry
	bind(ViewRegistry.class).to(DefaultViewRegistry.class).in(Singleton.class);
	bind(ViewRegister.class).asEagerSingleton();
    }

}
