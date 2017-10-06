/**
 * This code was generated by
 * \ / _    _  _|   _  _
 *  | (_)\/(_)(_|\/| |(/_  v1.0.0
 *       /       /
 */

package com.twilio.rest.preview.accSecurity.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.twilio.Twilio;
import com.twilio.converter.DateConverter;
import com.twilio.converter.Promoter;
import com.twilio.exception.TwilioException;
import com.twilio.http.HttpMethod;
import com.twilio.http.Request;
import com.twilio.http.Response;
import com.twilio.http.TwilioRestClient;
import com.twilio.rest.Domains;
import mockit.Mocked;
import mockit.NonStrictExpectations;
import org.junit.Before;
import org.junit.Test;

import java.net.URI;

import static com.twilio.TwilioTest.serialize;
import static org.junit.Assert.*;

public class VerificationTest {
    @Mocked
    private TwilioRestClient twilioRestClient;

    @Before
    public void setUp() throws Exception {
        Twilio.init("AC123", "AUTH TOKEN");
    }

    @Test
    public void testCreateRequest() {
                    new NonStrictExpectations() {{
                        Request request = new Request(HttpMethod.POST,
                                                      Domains.PREVIEW.toString(),
                                                      "/Verification/Services/VAaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa/Verifications");
                        request.addPostParam("To", serialize("to"));
        request.addPostParam("Channel", serialize("channel"));
                        twilioRestClient.request(request);
                        times = 1;
                        result = new Response("", 500);
                        twilioRestClient.getAccountSid();
                        result = "AC123";
                    }};

        try {
            Verification.creator("VAaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa", "to", "channel").create();
            fail("Expected TwilioException to be thrown for 500");
        } catch (TwilioException e) {}
    }

    @Test
    public void testCreateVerificationResponse() {
        new NonStrictExpectations() {{
            twilioRestClient.request((Request) any);
            result = new Response("{\"sid\": \"VEaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa\",\"service_sid\": \"VAaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa\",\"account_sid\": \"ACaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa\",\"to\": \"+14159373912\",\"channel\": \"sms\",\"status\": \"pending\",\"valid\": null,\"date_created\": \"2015-07-30T20:00:00Z\",\"date_updated\": \"2015-07-30T20:00:00Z\"}", TwilioRestClient.HTTP_STATUS_CODE_CREATED);
            twilioRestClient.getObjectMapper();
            result = new ObjectMapper();
        }};

        Verification.creator("VAaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa", "to", "channel").create();
    }
}