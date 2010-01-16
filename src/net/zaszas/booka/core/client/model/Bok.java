package net.zaszas.booka.core.client.model;

public interface Bok {

    String getBody();

    String getBokType();

    String getDescription();

    int getId();

    int getParentId();

    String getTitle();

    int getUserId();

    String getUserName();

    void setBody(String body);

    void setBokType(String type);

    void setDescription(String text);

    void setParentId(int id);

    void setTitle(String title);

    void setUserId(int id);
}
