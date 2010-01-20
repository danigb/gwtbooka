package net.zaszas.booka.ui.client.entrance.project;

import net.zaszas.booka.core.client.project.Project;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;

public class ProjectWidget extends Composite implements ProjectView {

    interface ProjectWidgetUiBinder extends UiBinder<Widget, ProjectWidget> {
    }

    private static ProjectWidgetUiBinder uiBinder = GWT.create(ProjectWidgetUiBinder.class);

    @UiField
    Anchor title;

    private final ProjectListLogic logic;

    private Project project;

    public ProjectWidget(ProjectListLogic logic) {
	this.logic = logic;
	initWidget(uiBinder.createAndBindUi(this));
    }

    @UiHandler("title")
    public void onClick(ClickEvent evt) {
	logic.onProjectClicked(project);
    }

    @Override
    public void setProject(Project project) {
	this.project = project;
	title.setText(project.getTitle());
    }

}
