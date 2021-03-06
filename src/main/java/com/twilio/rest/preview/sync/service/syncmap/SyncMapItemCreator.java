/**
 * This code was generated by
 * \ / _    _  _|   _  _
 *  | (_)\/(_)(_|\/| |(/_  v1.0.0
 *       /       /
 */

package com.twilio.rest.preview.sync.service.syncmap;

import com.twilio.base.Creator;
import com.twilio.converter.Converter;
import com.twilio.exception.ApiConnectionException;
import com.twilio.exception.ApiException;
import com.twilio.exception.RestException;
import com.twilio.http.HttpMethod;
import com.twilio.http.Request;
import com.twilio.http.Response;
import com.twilio.http.TwilioRestClient;
import com.twilio.rest.Domains;

import java.util.Map;

/**
 * PLEASE NOTE that this class contains preview products that are subject to
 * change. Use them with caution. If you currently do not have developer preview
 * access, please contact help@twilio.com.
 */
public class SyncMapItemCreator extends Creator<SyncMapItem> {
    private final String pathServiceSid;
    private final String pathMapSid;
    private final String key;
    private final Map<String, Object> data;

    /**
     * Construct a new SyncMapItemCreator.
     * 
     * @param pathServiceSid The service_sid
     * @param pathMapSid The map_sid
     * @param key The key
     * @param data The data
     */
    public SyncMapItemCreator(final String pathServiceSid, 
                              final String pathMapSid, 
                              final String key, 
                              final Map<String, Object> data) {
        this.pathServiceSid = pathServiceSid;
        this.pathMapSid = pathMapSid;
        this.key = key;
        this.data = data;
    }

    /**
     * Make the request to the Twilio API to perform the create.
     * 
     * @param client TwilioRestClient with which to make the request
     * @return Created SyncMapItem
     */
    @Override
    @SuppressWarnings("checkstyle:linelength")
    public SyncMapItem create(final TwilioRestClient client) {
        Request request = new Request(
            HttpMethod.POST,
            Domains.PREVIEW.toString(),
            "/Sync/Services/" + this.pathServiceSid + "/Maps/" + this.pathMapSid + "/Items",
            client.getRegion()
        );

        addPostParams(request);
        Response response = client.request(request);

        if (response == null) {
            throw new ApiConnectionException("SyncMapItem creation failed: Unable to connect to server");
        } else if (!TwilioRestClient.SUCCESS.apply(response.getStatusCode())) {
            RestException restException = RestException.fromJson(response.getStream(), client.getObjectMapper());
            if (restException == null) {
                throw new ApiException("Server Error, no content");
            }

            throw new ApiException(
                restException.getMessage(),
                restException.getCode(),
                restException.getMoreInfo(),
                restException.getStatus(),
                null
            );
        }

        return SyncMapItem.fromJson(response.getStream(), client.getObjectMapper());
    }

    /**
     * Add the requested post parameters to the Request.
     * 
     * @param request Request to add post params to
     */
    private void addPostParams(final Request request) {
        if (key != null) {
            request.addPostParam("Key", key);
        }

        if (data != null) {
            request.addPostParam("Data", Converter.mapToJson(data));
        }
    }
}