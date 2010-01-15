package net.zaszas.booka.xfunctional.core.client;

import net.zaszas.booka.core.client.model.Bok;
import net.zaszas.booka.core.client.model.BokJSO;
import net.zaszas.booka.core.client.model.BokSearchResults;
import net.zaszas.booka.core.client.model.UserSession;
import net.zaszas.booka.core.client.service.BokQuery;
import net.zaszas.booka.core.client.service.BokServiceAsyncJSON;
import net.zaszas.booka.core.client.service.UserSessionServiceAsyncJSON;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.RootLayoutPanel;

public class BookaServicesTest implements EntryPoint {

    private FlowPanel output;
    private UserSessionServiceAsyncJSON userService;
    private BokServiceAsyncJSON bokService;

    @Override
    public void onModuleLoad() {
	output = new FlowPanel();
	RootLayoutPanel.get().add(output);
	userService = new UserSessionServiceAsyncJSON();
	bokService = new BokServiceAsyncJSON();
	initSession();
    }

    private void initSession() {
	print("Init user session");
	userService.create("dani", "secret", new AsyncCallback<UserSession>() {
	    @Override
	    public void onFailure(Throwable caught) {
		print("User session failure: " + caught);
	    }

	    @Override
	    public void onSuccess(UserSession session) {
		print("UserSession!");
		bokService.setAuthToken(session.getToken());
		createBok();
	    }
	});
    }

    private void print(String string) {
	output.add(new HTML(string));
    }

    protected void createBok() {
	Bok bok = BokJSO.newInstance();
	bok.setDescription("Description");
	bok.setTitle("My title");
	bok.setBokType("Project");
	print("Bok: " + bok);

	print("Sending create:");
	bokService.create(bok, new AsyncCallback<Bok>() {
	    @Override
	    public void onFailure(Throwable caught) {
		print("Failure: " + caught);
	    }

	    @Override
	    public void onSuccess(Bok bok) {
		print("Success: " + bok.getTitle());
		searchBoks();
	    }
	});

    }

    void searchBoks() {
	print("Sending search request:");
	BokQuery query = new BokQuery();
	query.bokTypeEquals("Project");
	bokService.search(query, new AsyncCallback<BokSearchResults>() {
	    @Override
	    public void onFailure(Throwable caught) {
		print("Failure: " + caught);
	    }

	    @Override
	    public void onSuccess(BokSearchResults results) {
		print("Success: " + results.getSize());
	    }
	});
    }

}
