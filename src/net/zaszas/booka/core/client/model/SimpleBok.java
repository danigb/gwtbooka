package net.zaszas.booka.core.client.model;

public class SimpleBok implements Bok {

    private String body;
    private String bokType;
    private String description;
    private int id;
    private int parentId;
    private String title;
    private int userId;
    private String userName;

    @Override
    public String getBody() {
	return this.body;
    }

    @Override
    public String getBokType() {
	return this.bokType;
    }

    @Override
    public String getDescription() {
	return this.description;
    }

    @Override
    public int getId() {
	return this.id;
    }

    @Override
    public int getParentId() {
	return this.parentId;
    }

    @Override
    public String getTitle() {
	return this.title;
    }

    @Override
    public int getUserId() {
	return this.userId;
    }

    @Override
    public String getUserName() {
	return this.userName;
    }

    @Override
    public void setBody(String body) {
	this.body = body;
    }

    @Override
    public void setBokType(String type) {
	this.bokType = type;
    }

    @Override
    public void setDescription(String text) {
	this.description = text;
    }

    @Override
    public void setParentId(int id) {
	this.parentId = id;
    }

    @Override
    public void setTitle(String title) {
	this.title = title;
    }

    @Override
    public void setUserId(int id) {
	userId = id;
    }

    public void setUserName(String userName) {
	this.userName = userName;
    }

}
