package net.zaszas.booka.ui.client.app;

import net.zaszas.booka.ui.client.Router;

import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.user.client.History;

public class HistoryManager {

    private final BookaAppLogic logic;

    public HistoryManager(BookaAppLogic logic) {
	this.logic = logic;
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
	    logic.loadProjects();
	} else if (token.matches(Router.REGEX_ARCHIVES)) {
	}
    }
}
