/**
 * This code was generated by
 * \ / _    _  _|   _  _
 *  | (_)\/(_)(_|\/| |(/_  v1.0.0
 *       /       /
 */

package com.twilio.rest.api.v2010.account.incomingphonenumber;

import com.twilio.base.Page;
import com.twilio.base.Reader;
import com.twilio.base.ResourceSet;
import com.twilio.converter.Promoter;
import com.twilio.exception.ApiConnectionException;
import com.twilio.exception.ApiException;
import com.twilio.exception.RestException;
import com.twilio.http.HttpMethod;
import com.twilio.http.Request;
import com.twilio.http.Response;
import com.twilio.http.TwilioRestClient;
import com.twilio.rest.Domains;

public class LocalReader extends Reader<Local> {
    private String pathAccountSid;
    private Boolean beta;
    private String friendlyName;
    private com.twilio.type.PhoneNumber phoneNumber;
    private String origin;

    /**
     * Construct a new LocalReader.
     */
    public LocalReader() {
    }

    /**
     * Construct a new LocalReader.
     * 
     * @param pathAccountSid The account_sid
     */
    public LocalReader(final String pathAccountSid) {
        this.pathAccountSid = pathAccountSid;
    }

    /**
     * The beta.
     * 
     * @param beta The beta
     * @return this
     */
    public LocalReader setBeta(final Boolean beta) {
        this.beta = beta;
        return this;
    }

    /**
     * The friendly_name.
     * 
     * @param friendlyName The friendly_name
     * @return this
     */
    public LocalReader setFriendlyName(final String friendlyName) {
        this.friendlyName = friendlyName;
        return this;
    }

    /**
     * The phone_number.
     * 
     * @param phoneNumber The phone_number
     * @return this
     */
    public LocalReader setPhoneNumber(final com.twilio.type.PhoneNumber phoneNumber) {
        this.phoneNumber = phoneNumber;
        return this;
    }

    /**
     * The phone_number.
     * 
     * @param phoneNumber The phone_number
     * @return this
     */
    public LocalReader setPhoneNumber(final String phoneNumber) {
        return setPhoneNumber(Promoter.phoneNumberFromString(phoneNumber));
    }

    /**
     * The origin.
     * 
     * @param origin The origin
     * @return this
     */
    public LocalReader setOrigin(final String origin) {
        this.origin = origin;
        return this;
    }

    /**
     * Make the request to the Twilio API to perform the read.
     * 
     * @param client TwilioRestClient with which to make the request
     * @return Local ResourceSet
     */
    @Override
    public ResourceSet<Local> read(final TwilioRestClient client) {
        return new ResourceSet<>(this, client, firstPage(client));
    }

    /**
     * Make the request to the Twilio API to perform the read.
     * 
     * @param client TwilioRestClient with which to make the request
     * @return Local ResourceSet
     */
    @Override
    @SuppressWarnings("checkstyle:linelength")
    public Page<Local> firstPage(final TwilioRestClient client) {
        this.pathAccountSid = this.pathAccountSid == null ? client.getAccountSid() : this.pathAccountSid;
        Request request = new Request(
            HttpMethod.GET,
            Domains.API.toString(),
            "/2010-04-01/Accounts/" + this.pathAccountSid + "/IncomingPhoneNumbers/Local.json",
            client.getRegion()
        );

        addQueryParams(request);
        return pageForRequest(client, request);
    }

    /**
     * Retrieve the target page from the Twilio API.
     * 
     * @param targetUrl API-generated URL for the requested results page
     * @param client TwilioRestClient with which to make the request
     * @return Local ResourceSet
     */
    @Override
    @SuppressWarnings("checkstyle:linelength")
    public Page<Local> getPage(final String targetUrl, final TwilioRestClient client) {
        this.pathAccountSid = this.pathAccountSid == null ? client.getAccountSid() : this.pathAccountSid;
        Request request = new Request(
            HttpMethod.GET,
            targetUrl
        );

        return pageForRequest(client, request);
    }

    /**
     * Retrieve the next page from the Twilio API.
     * 
     * @param page current page
     * @param client TwilioRestClient with which to make the request
     * @return Next Page
     */
    @Override
    public Page<Local> nextPage(final Page<Local> page, 
                                final TwilioRestClient client) {
        Request request = new Request(
            HttpMethod.GET,
            page.getNextPageUrl(
                Domains.API.toString(),
                client.getRegion()
            )
        );
        return pageForRequest(client, request);
    }

    /**
     * Retrieve the previous page from the Twilio API.
     * 
     * @param page current page
     * @param client TwilioRestClient with which to make the request
     * @return Previous Page
     */
    @Override
    public Page<Local> previousPage(final Page<Local> page, 
                                    final TwilioRestClient client) {
        Request request = new Request(
            HttpMethod.GET,
            page.getPreviousPageUrl(
                Domains.API.toString(),
                client.getRegion()
            )
        );
        return pageForRequest(client, request);
    }

    /**
     * Generate a Page of Local Resources for a given request.
     * 
     * @param client TwilioRestClient with which to make the request
     * @param request Request to generate a page for
     * @return Page for the Request
     */
    private Page<Local> pageForRequest(final TwilioRestClient client, final Request request) {
        Response response = client.request(request);

        if (response == null) {
            throw new ApiConnectionException("Local read failed: Unable to connect to server");
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

        return Page.fromJson(
            "incoming_phone_numbers",
            response.getContent(),
            Local.class,
            client.getObjectMapper()
        );
    }

    /**
     * Add the requested query string arguments to the Request.
     * 
     * @param request Request to add query string arguments to
     */
    private void addQueryParams(final Request request) {
        if (beta != null) {
            request.addQueryParam("Beta", beta.toString());
        }

        if (friendlyName != null) {
            request.addQueryParam("FriendlyName", friendlyName);
        }

        if (phoneNumber != null) {
            request.addQueryParam("PhoneNumber", phoneNumber.toString());
        }

        if (origin != null) {
            request.addQueryParam("Origin", origin);
        }

        if (getPageSize() != null) {
            request.addQueryParam("PageSize", Integer.toString(getPageSize()));
        }
    }
}