package com.twilio.sdk.readers.api.v2010.account;

import com.twilio.sdk.clients.TwilioRestClient;
import com.twilio.sdk.exceptions.ApiConnectionException;
import com.twilio.sdk.exceptions.ApiException;
import com.twilio.sdk.http.HttpMethod;
import com.twilio.sdk.http.Request;
import com.twilio.sdk.http.Response;
import com.twilio.sdk.readers.Reader;
import com.twilio.sdk.resources.Page;
import com.twilio.sdk.resources.ResourceSet;
import com.twilio.sdk.resources.RestException;
import com.twilio.sdk.resources.api.v2010.account.Message;

public class MessageReader extends Reader<Message> {
    private final String accountSid;
    private com.twilio.types.PhoneNumber to;
    private com.twilio.types.PhoneNumber from;
    private String dateSent;

    /**
     * Construct a new MessageReader.
     * 
     * @param accountSid The account_sid
     */
    public MessageReader(final String accountSid) {
        this.accountSid = accountSid;
    }

    /**
     * Filter by messages to this number.
     * 
     * @param to Filter by messages to this number
     * @return this
     */
    public MessageReader byTo(final com.twilio.types.PhoneNumber to) {
        this.to = to;
        return this;
    }

    /**
     * Only show messages from this phone number.
     * 
     * @param from Filter by from number
     * @return this
     */
    public MessageReader byFrom(final com.twilio.types.PhoneNumber from) {
        this.from = from;
        return this;
    }

    /**
     * Filter messages sent by this date.
     * 
     * @param dateSent Filter by date sent
     * @return this
     */
    public MessageReader byDateSent(final String dateSent) {
        this.dateSent = dateSent;
        return this;
    }

    /**
     * Make the request to the Twilio API to perform the read.
     * 
     * @param client TwilioRestClient with which to make the request
     * @return Message ResourceSet
     */
    @Override
    public ResourceSet<Message> execute(final TwilioRestClient client) {
        return new ResourceSet<>(this, client, firstPage());
    }

    /**
     * Make the request to the Twilio API to perform the read.
     * 
     * @param client TwilioRestClient with which to make the request
     * @return Message ResourceSet
     */
    @Override
    @SuppressWarnings("checkstyle:linelength")
    public Page<Message> firstPage(final TwilioRestClient client) {
        Request request = new Request(
            HttpMethod.GET,
            TwilioRestClient.Domains.API,
            "/2010-04-01/Accounts/" + this.accountSid + "/Messages.json",
            client.getAccountSid()
        );
        
        addQueryParams(request);
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
    public Page<Message> nextPage(final Page<Message> page, 
                                  final TwilioRestClient client) {
        Request request = new Request(
            HttpMethod.GET,
            page.getNextPageUri(),
            client.getAccountSid()
        );
        return pageForRequest(client, request);
    }

    /**
     * Generate a Page of Message Resources for a given request.
     * 
     * @param client TwilioRestClient with which to make the request
     * @param request Request to generate a page for
     * @return Page for the Request
     */
    private Page<Message> pageForRequest(final TwilioRestClient client, final Request request) {
        Response response = client.request(request);
        
        if (response == null) {
            throw new ApiConnectionException("Message read failed: Unable to connect to server");
        } else if (response.getStatusCode() != TwilioRestClient.HTTP_STATUS_CODE_OK) {
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
            "messages",
            response.getContent(),
            Message.class,
            client.getObjectMapper()
        );
    }

    /**
     * Add the requested query string arguments to the Request.
     * 
     * @param request Request to add query string arguments to
     */
    private void addQueryParams(final Request request) {
        if (to != null) {
            request.addQueryParam("To", to.toString());
        }
        
        if (from != null) {
            request.addQueryParam("From", from.toString());
        }
        
        if (dateSent != null) {
            request.addQueryParam("DateSent", dateSent);
        }
        
        request.addQueryParam("PageSize", Integer.toString(getPageSize()));
    }
}