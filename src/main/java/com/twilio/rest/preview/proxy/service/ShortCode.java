/**
 * This code was generated by
 * \ / _    _  _|   _  _
 *  | (_)\/(_)(_|\/| |(/_  v1.0.0
 *       /       /
 */

package com.twilio.rest.preview.proxy.service;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.base.MoreObjects;
import com.twilio.base.Resource;
import com.twilio.converter.Converter;
import com.twilio.converter.DateConverter;
import com.twilio.exception.ApiConnectionException;
import com.twilio.exception.ApiException;
import com.twilio.exception.RestException;
import com.twilio.http.HttpMethod;
import com.twilio.http.Request;
import com.twilio.http.Response;
import com.twilio.http.TwilioRestClient;
import com.twilio.rest.Domains;
import org.joda.time.DateTime;

import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * PLEASE NOTE that this class contains preview products that are subject to
 * change. Use them with caution. If you currently do not have developer preview
 * access, please contact help@twilio.com.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ShortCode extends Resource {
    private static final long serialVersionUID = 158453184063477L;

    /**
     * Create a ShortCodeCreator to execute create.
     * 
     * @param pathServiceSid The service_sid
     * @param sid Delete by unique shortcode Sid
     * @return ShortCodeCreator capable of executing the create
     */
    public static ShortCodeCreator creator(final String pathServiceSid, 
                                           final String sid) {
        return new ShortCodeCreator(pathServiceSid, sid);
    }

    /**
     * Create a ShortCodeDeleter to execute delete.
     * 
     * @param pathServiceSid The service_sid
     * @param pathSid Delete by unique shortcode Sid
     * @return ShortCodeDeleter capable of executing the delete
     */
    public static ShortCodeDeleter deleter(final String pathServiceSid, 
                                           final String pathSid) {
        return new ShortCodeDeleter(pathServiceSid, pathSid);
    }

    /**
     * Create a ShortCodeReader to execute read.
     * 
     * @param pathServiceSid The service_sid
     * @return ShortCodeReader capable of executing the read
     */
    public static ShortCodeReader reader(final String pathServiceSid) {
        return new ShortCodeReader(pathServiceSid);
    }

    /**
     * Create a ShortCodeFetcher to execute fetch.
     * 
     * @param pathServiceSid The service_sid
     * @param pathSid Fetch by unique shortcode Sid
     * @return ShortCodeFetcher capable of executing the fetch
     */
    public static ShortCodeFetcher fetcher(final String pathServiceSid, 
                                           final String pathSid) {
        return new ShortCodeFetcher(pathServiceSid, pathSid);
    }

    /**
     * Converts a JSON String into a ShortCode object using the provided
     * ObjectMapper.
     * 
     * @param json Raw JSON String
     * @param objectMapper Jackson ObjectMapper
     * @return ShortCode object represented by the provided JSON
     */
    public static ShortCode fromJson(final String json, final ObjectMapper objectMapper) {
        // Convert all checked exceptions to Runtime
        try {
            return objectMapper.readValue(json, ShortCode.class);
        } catch (final JsonMappingException | JsonParseException e) {
            throw new ApiException(e.getMessage(), e);
        } catch (final IOException e) {
            throw new ApiConnectionException(e.getMessage(), e);
        }
    }

    /**
     * Converts a JSON InputStream into a ShortCode object using the provided
     * ObjectMapper.
     * 
     * @param json Raw JSON InputStream
     * @param objectMapper Jackson ObjectMapper
     * @return ShortCode object represented by the provided JSON
     */
    public static ShortCode fromJson(final InputStream json, final ObjectMapper objectMapper) {
        // Convert all checked exceptions to Runtime
        try {
            return objectMapper.readValue(json, ShortCode.class);
        } catch (final JsonMappingException | JsonParseException e) {
            throw new ApiException(e.getMessage(), e);
        } catch (final IOException e) {
            throw new ApiConnectionException(e.getMessage(), e);
        }
    }

    private final String sid;
    private final String accountSid;
    private final String serviceSid;
    private final DateTime dateCreated;
    private final DateTime dateUpdated;
    private final String shortCode;
    private final String countryCode;
    private final List<Map<String, Object>> capabilities;
    private final URI url;

    @JsonCreator
    private ShortCode(@JsonProperty("sid")
                      final String sid, 
                      @JsonProperty("account_sid")
                      final String accountSid, 
                      @JsonProperty("service_sid")
                      final String serviceSid, 
                      @JsonProperty("date_created")
                      final String dateCreated, 
                      @JsonProperty("date_updated")
                      final String dateUpdated, 
                      @JsonProperty("short_code")
                      final String shortCode, 
                      @JsonProperty("country_code")
                      final String countryCode, 
                      @JsonProperty("capabilities")
                      final List<Map<String, Object>> capabilities, 
                      @JsonProperty("url")
                      final URI url) {
        this.sid = sid;
        this.accountSid = accountSid;
        this.serviceSid = serviceSid;
        this.dateCreated = DateConverter.iso8601DateTimeFromString(dateCreated);
        this.dateUpdated = DateConverter.iso8601DateTimeFromString(dateUpdated);
        this.shortCode = shortCode;
        this.countryCode = countryCode;
        this.capabilities = capabilities;
        this.url = url;
    }

    /**
     * Returns The A string that uniquely identifies this resource.
     * 
     * @return A string that uniquely identifies this resource
     */
    public final String getSid() {
        return this.sid;
    }

    /**
     * Returns The Account Sid..
     * 
     * @return Account Sid.
     */
    public final String getAccountSid() {
        return this.accountSid;
    }

    /**
     * Returns The Service Sid..
     * 
     * @return Service Sid.
     */
    public final String getServiceSid() {
        return this.serviceSid;
    }

    /**
     * Returns The The date this resource was created.
     * 
     * @return The date this resource was created
     */
    public final DateTime getDateCreated() {
        return this.dateCreated;
    }

    /**
     * Returns The The date this resource was last updated.
     * 
     * @return The date this resource was last updated
     */
    public final DateTime getDateUpdated() {
        return this.dateUpdated;
    }

    /**
     * Returns The The short code. e.g., 894546..
     * 
     * @return The short code. e.g., 894546.
     */
    public final String getShortCode() {
        return this.shortCode;
    }

    /**
     * Returns The The ISO 3166-1 alpha-2 country code.
     * 
     * @return The ISO 3166-1 alpha-2 country code
     */
    public final String getCountryCode() {
        return this.countryCode;
    }

    /**
     * Returns The Indicate if a shortcode can receive messages.
     * 
     * @return Indicate if a shortcode can receive messages
     */
    public final List<Map<String, Object>> getCapabilities() {
        return this.capabilities;
    }

    /**
     * Returns The The URL of this resource..
     * 
     * @return The URL of this resource.
     */
    public final URI getUrl() {
        return this.url;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        ShortCode other = (ShortCode) o;

        return Objects.equals(sid, other.sid) && 
               Objects.equals(accountSid, other.accountSid) && 
               Objects.equals(serviceSid, other.serviceSid) && 
               Objects.equals(dateCreated, other.dateCreated) && 
               Objects.equals(dateUpdated, other.dateUpdated) && 
               Objects.equals(shortCode, other.shortCode) && 
               Objects.equals(countryCode, other.countryCode) && 
               Objects.equals(capabilities, other.capabilities) && 
               Objects.equals(url, other.url);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sid,
                            accountSid,
                            serviceSid,
                            dateCreated,
                            dateUpdated,
                            shortCode,
                            countryCode,
                            capabilities,
                            url);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                          .add("sid", sid)
                          .add("accountSid", accountSid)
                          .add("serviceSid", serviceSid)
                          .add("dateCreated", dateCreated)
                          .add("dateUpdated", dateUpdated)
                          .add("shortCode", shortCode)
                          .add("countryCode", countryCode)
                          .add("capabilities", capabilities)
                          .add("url", url)
                          .toString();
    }
}