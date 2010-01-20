package net.zaszas.booka.ui.client.entrance.project;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;

public class ProjectListWidget extends Composite implements ProjectListView {

    interface ProjectListWidgetUiBinder extends UiBinder<Widget, ProjectListWidget> {
    }

    private static ProjectListWidgetUiBinder uiBinder = GWT.create(ProjectListWidgetUiBinder.class);

    @UiField
    FlowPanel list;

    private final ProjectListLogic logic;

    @Inject
    public ProjectListWidget(ProjectListLogic logic) {
	this.logic = logic;
	initWidget(uiBinder.createAndBindUi(this));
	logic.setView(this);
    }

    @Override
    public void add(ProjectView projectView) {
	list.add((Widget) projectView);
    }

    @Override
    public void clearList() {
	list.clear();
    }

    @Override
    public ProjectView createProjectView() {
	ProjectWidget projectWidget = new ProjectWidget(logic);
	return projectWidget;
    }

}
