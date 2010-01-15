package net.zaszas.booka.ui.client.app;

import net.zaszas.booka.ui.client.BookaUIGinjector;
import net.zaszas.booka.ui.client.Router;
import net.zaszas.booka.ui.client.archives.ArchivesView;
import net.zaszas.booka.ui.client.entrance.EntranceView;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.user.client.History;

public class BookaAppLogic {
    private final BookaUIGinjector injector;
    private final BookaAppView view;
    private EntranceView entrance;
    private ArchivesView archives;

    public BookaAppLogic(BookaUIGinjector injector, BookaAppView view) {
	this.injector = injector;
	this.view = view;

	GWT.log("Starting logic", null);
	History.addValueChangeHandler(new ValueChangeHandler<String>() {
	    @Override
	    public void onValueChange(ValueChangeEvent<String> event) {
		handleToken(event.getValue());
	    }
	});
	History.fireCurrentHistoryState();
    }

    public void handleToken(String token) {
	if (token.matches(Router.REGEX_HOME) || token.matches(Router.REGEX_ENTRANCE)) {
	    GWT.log("Loading entrance...", null);
	    view.show(getEntrance());
	    entrance.loadProjects();
	} else if (token.matches(Router.REGEX_ARCHIVES)) {
	    GWT.log("Loading archives", null);
	    view.show(getArchives());
	    archives.loadProject(Router.getProjectFromArchives(token));
	}
    }

    private ArchivesView getArchives() {
	if (this.archives == null) {
	    this.archives = injector.getArchivesView();
	}
	return this.archives;
    }

    private EntranceView getEntrance() {
	if (this.entrance == null) {
	    this.entrance = injector.getEntranceView();
	}
	return entrance;
    }

}
