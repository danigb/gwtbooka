package net.zaszas.booka.core.client.service;

import net.zaszas.rest.client.Params;

/**
 * A rest service with centralized errors
 */
public interface RestManager {
    /**
     * Send a POST request to the root of a resource path. Used to call
     * <b>create</b> action in rails application
     * 
     * @param resource
     * @param params
     * @param format
     * @param callback
     */
    void create(String requestId, String resource, Params params, String format, RestCallback callback);

    /**
     * Send a GET request to the given id of a resource path. Used to call
     * <b>show</b> action in rails aplication
     * 
     * @param resource
     *            Resource name (ie: users)
     * @param id
     *            The id of the resource
     * @param format
     *            The format of the response
     * @param callback
     *            The request callback
     */
    void get(String requestId, String resource, String id, String format, RestCallback callback);

    /**
     * Get the host path used.
     * 
     * @return the host path
     * 
     * @see setHostPath
     */
    String getHostPath();

    /**
     * Send a GET request to the root of a resource path. Used to call
     * <b>index</b> action in rails application
     * 
     * @param resource
     *            The resource name (ie: users)
     * @param params
     *            The optional params to be sent with the GET request, can be
     *            null
     * @param format
     *            format of the response
     * @param callback
     *            the request callback
     */
    void getList(String requestId, String resource, Params params, String format, RestCallback callback);

    void onError(RestErrorCallback callback);

    /**
     * Change the hostPath url. The default is "/". This host path is prepended
     * to any call url
     * 
     * @param hostPath
     */
    void setHostPath(String hostPath);

    void update(String requestId, String resource, String id, Params params, String format, RestCallback restCallback);
}
