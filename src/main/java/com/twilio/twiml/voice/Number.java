/**
 * This code was generated by
 * \ / _    _  _|   _  _
 *  | (_)\/(_)(_|\/| |(/_  v1.0.0
 *       /       /
 */

package com.twilio.twiml.voice;

import com.twilio.converter.Promoter;
import com.twilio.http.HttpMethod;
import com.twilio.twiml.TwiML;

import java.net.URI;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * TwiML wrapper for {@code <Number>}
 */
public class Number extends TwiML {
    public enum Event {
        INITIATED("initiated"),
        RINGING("ringing"),
        ANSWERED("answered"),
        COMPLETED("completed");

        private final String value;

        private Event(final String value) {
            this.value = value;
        }

        public String toString() {
            return value;
        }
    }

    private final String sendDigits;
    private final URI url;
    private final HttpMethod method;
    private final List<Number.Event> statusCallbackEvent;
    private final URI statusCallback;
    private final HttpMethod statusCallbackMethod;
    private final com.twilio.type.PhoneNumber phoneNumber;

    /**
     * For XML Serialization/Deserialization
     */
    private Number() {
        this(new Builder((com.twilio.type.PhoneNumber) null));
    }

    /**
     * Create a new {@code <Number>} element
     */
    private Number(Builder b) {
        super("Number", Collections.<TwiML>emptyList(), b.options);
        this.sendDigits = b.sendDigits;
        this.url = b.url;
        this.method = b.method;
        this.statusCallbackEvent = b.statusCallbackEvent;
        this.statusCallback = b.statusCallback;
        this.statusCallbackMethod = b.statusCallbackMethod;
        this.phoneNumber = b.phoneNumber;
    }

    /**
     * The body of the TwiML element
     * 
     * @return Element body as a string if present else null
     */
    protected String getElementBody() {
        return this.getPhoneNumber() == null ? null : this.getPhoneNumber().toString();
    }

    /**
     * Attributes to set on the generated XML element
     * 
     * @return A Map of attribute keys to values
     */
    protected Map<String, String> getElementAttributes() {
        // Preserve order of attributes
        Map<String, String> attrs = new HashMap<>();

        if (this.getSendDigits() != null) {
            attrs.put("sendDigits", this.getSendDigits());
        }
        if (this.getUrl() != null) {
            attrs.put("url", this.getUrl().toString());
        }
        if (this.getMethod() != null) {
            attrs.put("method", this.getMethod().toString());
        }
        if (this.getStatusCallbackEvents() != null) {
            attrs.put("statusCallbackEvent", this.getStatusCallbackEventsAsString());
        }
        if (this.getStatusCallback() != null) {
            attrs.put("statusCallback", this.getStatusCallback().toString());
        }
        if (this.getStatusCallbackMethod() != null) {
            attrs.put("statusCallbackMethod", this.getStatusCallbackMethod().toString());
        }

        return attrs;
    }

    /**
     * DTMF tones to play when the call is answered
     * 
     * @return DTMF tones to play when the call is answered
     */
    public String getSendDigits() {
        return sendDigits;
    }

    /**
     * TwiML URL
     * 
     * @return TwiML URL
     */
    public URI getUrl() {
        return url;
    }

    /**
     * TwiML URL method
     * 
     * @return TwiML URL method
     */
    public HttpMethod getMethod() {
        return method;
    }

    /**
     * Events to call status callback
     * 
     * @return Events to call status callback
     */
    public List<Number.Event> getStatusCallbackEvents() {
        return statusCallbackEvent;
    }

    protected String getStatusCallbackEventsAsString() {
        StringBuilder sb = new StringBuilder();
        Iterator<Number.Event> iter = this.getStatusCallbackEvents().iterator();
        while (iter.hasNext()) {
            sb.append(iter.next().toString());
            if (iter.hasNext()) {
                sb.append(" ");
            }
        }
        return sb.toString();
    }

    /**
     * Status callback URL
     * 
     * @return Status callback URL
     */
    public URI getStatusCallback() {
        return statusCallback;
    }

    /**
     * Status callback URL method
     * 
     * @return Status callback URL method
     */
    public HttpMethod getStatusCallbackMethod() {
        return statusCallbackMethod;
    }

    /**
     * Phone Number to dial
     * 
     * @return Phone Number to dial
     */
    public com.twilio.type.PhoneNumber getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * Create a new {@code <Number>} element
     */
    public static class Builder {
        private String sendDigits;
        private URI url;
        private HttpMethod method;
        private List<Number.Event> statusCallbackEvent;
        private URI statusCallback;
        private HttpMethod statusCallbackMethod;
        private com.twilio.type.PhoneNumber phoneNumber;
        private Map<String, String> options = new HashMap<>();

        /**
         * Create a {@code <Number>} with phoneNumber
         */
        public Builder(com.twilio.type.PhoneNumber phoneNumber) {
            this.phoneNumber = phoneNumber;
        }

        /**
         * Create a {@code <Number>} with phoneNumber
         */
        public Builder(String phoneNumber) {
            this.phoneNumber = Promoter.phoneNumberFromString(phoneNumber);
        }

        /**
         * DTMF tones to play when the call is answered
         */
        public Builder sendDigits(String sendDigits) {
            this.sendDigits = sendDigits;
            return this;
        }

        /**
         * TwiML URL
         */
        public Builder url(URI url) {
            this.url = url;
            return this;
        }

        /**
         * TwiML URL
         */
        public Builder url(String url) {
            this.url = Promoter.uriFromString(url);
            return this;
        }

        /**
         * TwiML URL method
         */
        public Builder method(HttpMethod method) {
            this.method = method;
            return this;
        }

        /**
         * Events to call status callback
         */
        public Builder statusCallbackEvents(List<Number.Event> statusCallbackEvent) {
            this.statusCallbackEvent = statusCallbackEvent;
            return this;
        }

        /**
         * Events to call status callback
         */
        public Builder statusCallbackEvents(Number.Event statusCallbackEvent) {
            this.statusCallbackEvent = Promoter.listOfOne(statusCallbackEvent);
            return this;
        }

        /**
         * Status callback URL
         */
        public Builder statusCallback(URI statusCallback) {
            this.statusCallback = statusCallback;
            return this;
        }

        /**
         * Status callback URL
         */
        public Builder statusCallback(String statusCallback) {
            this.statusCallback = Promoter.uriFromString(statusCallback);
            return this;
        }

        /**
         * Status callback URL method
         */
        public Builder statusCallbackMethod(HttpMethod statusCallbackMethod) {
            this.statusCallbackMethod = statusCallbackMethod;
            return this;
        }

        /**
         * Set additional attributes on this TwiML element that will appear in generated
         * XML.
         */
        public Builder option(String key, String value) {
            this.options.put(key, value);
            return this;
        }

        /**
         * Create and return resulting {@code <Number>} element
         */
        public Number build() {
            return new Number(this);
        }
    }
}