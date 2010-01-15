package net.zaszas.booka.core.client.model;

public class DelegatedBok implements Bok {
    private final Bok delegate;

    public DelegatedBok(Bok delegate) {
	this.delegate = delegate;
    }

    @Override
    public String getBokType() {
	return delegate.getBokType();
    }

    @Override
    public String getDescription() {
	return delegate.getDescription();
    }

    @Override
    public String getTitle() {
	return delegate.getTitle();
    }

    @Override
    public void setBokType(String type) {
	delegate.setBokType(type);
    }

    @Override
    public void setDescription(String text) {
	delegate.setDescription(text);
    }

    @Override
    public void setTitle(String title) {
	delegate.setTitle(title);
    }

}
