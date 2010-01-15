package net.zaszas.booka.core.client.service;

import java.util.HashMap;
import java.util.Map;

public class BokQuery {

    private final HashMap<String, String> query;

    public BokQuery() {
	query = new HashMap<String, String>();
    }

    public void bokTypeEquals(String bokType) {
	query.put("username_equals", bokType);
    }

    public Map<String, String> getMap() {
	return query;
    }
}
