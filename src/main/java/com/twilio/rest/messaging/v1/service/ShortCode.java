/**
 * This code was generated by
 * \ / _    _  _|   _  _
 *  | (_)\/(_)(_|\/| |(/_  v1.0.0
 *       /       /
 */

package com.twilio.rest.messaging.v1.service;

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
 * PLEASE NOTE that this class contains beta products that are subject to
 * change. Use them with caution.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ShortCode extends Resource {
    private static final long serialVersionUID = 158453184063477L;

    /**
     * Create a ShortCodeCreator to execute create.
     * 
     * @param pathServiceSid The service_sid
     * @param shortCodeSid The short_code_sid
     * @return ShortCodeCreator capable of executing the create
     */
    public static ShortCodeCreator creator(final String pathServiceSid, 
                                           final String shortCodeSid) {
        return new ShortCodeCreator(pathServiceSid, shortCodeSid);
    }

    /**
     * Create a ShortCodeDeleter to execute delete.
     * 
     * @param pathServiceSid The service_sid
     * @param pathSid The sid
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
     * @param pathSid The sid
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
     * Returns The The sid.
     * 
     * @return The sid
     */
    public final String getSid() {
        return this.sid;
    }

    /**
     * Returns The The account_sid.
     * 
     * @return The account_sid
     */
    public final String getAccountSid() {
        return this.accountSid;
    }

    /**
     * Returns The The service_sid.
     * 
     * @return The service_sid
     */
    public final String getServiceSid() {
        return this.serviceSid;
    }

    /**
     * Returns The The date_created.
     * 
     * @return The date_created
     */
    public final DateTime getDateCreated() {
        return this.dateCreated;
    }

    /**
     * Returns The The date_updated.
     * 
     * @return The date_updated
     */
    public final DateTime getDateUpdated() {
        return this.dateUpdated;
    }

    /**
     * Returns The The short_code.
     * 
     * @return The short_code
     */
    public final String getShortCode() {
        return this.shortCode;
    }

    /**
     * Returns The The country_code.
     * 
     * @return The country_code
     */
    public final String getCountryCode() {
        return this.countryCode;
    }

    /**
     * Returns The The capabilities.
     * 
     * @return The capabilities
     */
    public final List<Map<String, Object>> getCapabilities() {
        return this.capabilities;
    }

    /**
     * Returns The The url.
     * 
     * @return The url
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