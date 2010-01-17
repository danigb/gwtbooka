package net.zaszas.rest.client;

import com.google.gwt.http.client.RequestCallback;

public interface RestServiceAsync {

    /**
     * Send a POST request to the root of a resource path. Used to call
     * <b>create</b> action in rails application
     * 
     * @param resource
     * @param params
     * @param format
     * @param callback
     */
    void create(String resource, Params params, String format, RequestCallback callback);

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
    void getList(String resource, Params params, String format, RequestCallback callback);

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
    void get(String resource, String id, String format, RequestCallback callback);

    /**
     * Get the host path used.
     * 
     * @return the host path
     * 
     * @see setHostPath
     */
    String getHostPath();

    /**
     * Change the hostPath url. The default is "/". This host path is prepended
     * to any call url
     * 
     * @param hostPath
     */
    void setHostPath(String hostPath);

    void update(String resource, String id, Params params, String format, RequestCallback callback);

}
