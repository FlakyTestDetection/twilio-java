/**
 * This code was generated by
 * \ / _    _  _|   _  _
 *  | (_)\/(_)(_|\/| |(/_  v1.0.0
 *       /       /
 */

package com.twilio.twiml.voice;

import com.twilio.converter.Promoter;
import com.twilio.http.HttpMethod;
import org.junit.Assert;
import org.junit.Test;

import java.net.URI;
import java.util.List;

/**
 * Test class for {@link Client}
 */
public class ClientTest {
    @Test
    public void testElementWithParams() {
        Client elem = new Client.Builder("name")
            .url(URI.create("https://example.com"))
            .method(HttpMethod.GET)
            .statusCallbackEvents(Promoter.listOfOne(Client.Event.INITIATED))
            .statusCallback(URI.create("https://example.com"))
            .statusCallbackMethod(HttpMethod.GET)
            .build();

        Assert.assertEquals(
            "<?xml version=\"1.0\" encoding=\"UTF-8\"?>" +
            "<Client method=\"GET\" statusCallback=\"https://example.com\" statusCallbackEvent=\"initiated\" statusCallbackMethod=\"GET\" url=\"https://example.com\">name</Client>",
            elem.toXml()
        );
    }
}