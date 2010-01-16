package net.zaszas.booka.core.client.model;

public interface BokSearchResults {
    final BokSearchResults NONE = new BokSearchResults() {
	@Override
	public Bok get(int index) {
	    return null;
	}

	@Override
	public int getSize() {
	    return 0;
	}
    };

    Bok get(int index);

    int getSize();
}
