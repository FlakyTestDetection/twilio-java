/**
 * This code was generated by
 * \ / _    _  _|   _  _
 *  | (_)\/(_)(_|\/| |(/_  v1.0.0
 *       /       /
 */

package com.twilio.rest.proxy.v1.service;

import com.twilio.base.Creator;
import com.twilio.exception.ApiConnectionException;
import com.twilio.exception.ApiException;
import com.twilio.exception.RestException;
import com.twilio.http.HttpMethod;
import com.twilio.http.Request;
import com.twilio.http.Response;
import com.twilio.http.TwilioRestClient;
import com.twilio.rest.Domains;

/**
 * PLEASE NOTE that this class contains beta products that are subject to
 * change. Use them with caution.
 */
public class PhoneNumberCreator extends Creator<PhoneNumber> {
    private final String pathServiceSid;
    private String sid;
    private com.twilio.type.PhoneNumber phoneNumber;

    /**
     * Construct a new PhoneNumberCreator.
     * 
     * @param pathServiceSid Service Sid.
     */
    public PhoneNumberCreator(final String pathServiceSid) {
        this.pathServiceSid = pathServiceSid;
    }

    /**
     * A 34 character string that uniquely identifies this Phone Number..
     * 
     * @param sid A string that uniquely identifies this Phone Number.
     * @return this
     */
    public PhoneNumberCreator setSid(final String sid) {
        this.sid = sid;
        return this;
    }

    /**
     * The phone_number.
     * 
     * @param phoneNumber The phone_number
     * @return this
     */
    public PhoneNumberCreator setPhoneNumber(final com.twilio.type.PhoneNumber phoneNumber) {
        this.phoneNumber = phoneNumber;
        return this;
    }

    /**
     * Make the request to the Twilio API to perform the create.
     * 
     * @param client TwilioRestClient with which to make the request
     * @return Created PhoneNumber
     */
    @Override
    @SuppressWarnings("checkstyle:linelength")
    public PhoneNumber create(final TwilioRestClient client) {
        Request request = new Request(
            HttpMethod.POST,
            Domains.PROXY.toString(),
            "/v1/Services/" + this.pathServiceSid + "/PhoneNumbers",
            client.getRegion()
        );

        addPostParams(request);
        Response response = client.request(request);

        if (response == null) {
            throw new ApiConnectionException("PhoneNumber creation failed: Unable to connect to server");
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

        return PhoneNumber.fromJson(response.getStream(), client.getObjectMapper());
    }

    /**
     * Add the requested post parameters to the Request.
     * 
     * @param request Request to add post params to
     */
    private void addPostParams(final Request request) {
        if (sid != null) {
            request.addPostParam("Sid", sid);
        }

        if (phoneNumber != null) {
            request.addPostParam("PhoneNumber", phoneNumber.toString());
        }
    }
}