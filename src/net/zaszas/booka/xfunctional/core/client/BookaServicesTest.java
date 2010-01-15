package net.zaszas.booka.xfunctional.core.client;

import net.zaszas.booka.core.client.model.BokJSO;
import net.zaszas.booka.core.client.model.UserSession;
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
	// searchBoks();
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
	BokJSO bok = BokJSO.newInstance();
	bok.setDescription("Description");
	print("Bok: " + bok);

	print("Sending create:");
	bokService.create(bok, new AsyncCallback<String>() {
	    @Override
	    public void onFailure(Throwable caught) {
		print("Failure: " + caught);
	    }

	    @Override
	    public void onSuccess(String result) {
		print("Success: " + result);
	    }
	});

    }

    void searchBoks() {
	print("Sending search request:");
	bokService.search(null, new AsyncCallback<String>() {
	    @Override
	    public void onFailure(Throwable caught) {
		print("Failure: " + caught);
	    }

	    @Override
	    public void onSuccess(String result) {
		print("Success: " + result);
	    }
	});
    }

}
