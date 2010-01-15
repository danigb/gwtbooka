package net.zaszas.booka.core.client.model;

public interface Bok {

    String getBokType();

    String getDescription();

    int getId();

    String getTitle();

    void setBokType(String type);

    void setDescription(String text);

    void setTitle(String title);

}
