package net.zaszas.booka.core.client.model;

public interface Bok {

    String getBokType();

    String getDescription();

    String getTitle();

    void setBokType(String type);

    void setDescription(String text);

    void setTitle(String title);

}
