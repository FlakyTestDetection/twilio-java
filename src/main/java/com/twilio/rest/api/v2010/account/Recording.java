/**
 * This code was generated by
 * \ / _    _  _|   _  _
 *  | (_)\/(_)(_|\/| |(/_  v1.0.0
 *       /       /
 */

package com.twilio.rest.api.v2010.account;

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
import com.twilio.converter.Promoter;
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
import java.util.Map;
import java.util.Objects;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Recording extends Resource {
    private static final long serialVersionUID = 163262699813470L;

    public enum Source {
        DIALVERB("DialVerb"),
        CONFERENCE("Conference"),
        OUTBOUNDAPI("OutboundAPI"),
        TRUNKING("Trunking"),
        RECORDVERB("RecordVerb");

        private final String value;

        private Source(final String value) {
            this.value = value;
        }

        public String toString() {
            return value;
        }

        /**
         * Generate a Source from a string.
         * @param value string value
         * @return generated Source
         */
        @JsonCreator
        public static Source forValue(final String value) {
            return Promoter.enumFromString(value, Source.values());
        }
    }

    public enum Status {
        PROCESSING("processing"),
        COMPLETED("completed");

        private final String value;

        private Status(final String value) {
            this.value = value;
        }

        public String toString() {
            return value;
        }

        /**
         * Generate a Status from a string.
         * @param value string value
         * @return generated Status
         */
        @JsonCreator
        public static Status forValue(final String value) {
            return Promoter.enumFromString(value, Status.values());
        }
    }

    /**
     * Create a RecordingFetcher to execute fetch.
     * 
     * @param pathAccountSid The account_sid
     * @param pathSid Fetch by unique recording Sid
     * @return RecordingFetcher capable of executing the fetch
     */
    public static RecordingFetcher fetcher(final String pathAccountSid, 
                                           final String pathSid) {
        return new RecordingFetcher(pathAccountSid, pathSid);
    }

    /**
     * Create a RecordingFetcher to execute fetch.
     * 
     * @param pathSid Fetch by unique recording Sid
     * @return RecordingFetcher capable of executing the fetch
     */
    public static RecordingFetcher fetcher(final String pathSid) {
        return new RecordingFetcher(pathSid);
    }

    /**
     * Create a RecordingDeleter to execute delete.
     * 
     * @param pathAccountSid The account_sid
     * @param pathSid Delete by unique recording Sid
     * @return RecordingDeleter capable of executing the delete
     */
    public static RecordingDeleter deleter(final String pathAccountSid, 
                                           final String pathSid) {
        return new RecordingDeleter(pathAccountSid, pathSid);
    }

    /**
     * Create a RecordingDeleter to execute delete.
     * 
     * @param pathSid Delete by unique recording Sid
     * @return RecordingDeleter capable of executing the delete
     */
    public static RecordingDeleter deleter(final String pathSid) {
        return new RecordingDeleter(pathSid);
    }

    /**
     * Create a RecordingReader to execute read.
     * 
     * @param pathAccountSid The account_sid
     * @return RecordingReader capable of executing the read
     */
    public static RecordingReader reader(final String pathAccountSid) {
        return new RecordingReader(pathAccountSid);
    }

    /**
     * Create a RecordingReader to execute read.
     * 
     * @return RecordingReader capable of executing the read
     */
    public static RecordingReader reader() {
        return new RecordingReader();
    }

    /**
     * Converts a JSON String into a Recording object using the provided
     * ObjectMapper.
     * 
     * @param json Raw JSON String
     * @param objectMapper Jackson ObjectMapper
     * @return Recording object represented by the provided JSON
     */
    public static Recording fromJson(final String json, final ObjectMapper objectMapper) {
        // Convert all checked exceptions to Runtime
        try {
            return objectMapper.readValue(json, Recording.class);
        } catch (final JsonMappingException | JsonParseException e) {
            throw new ApiException(e.getMessage(), e);
        } catch (final IOException e) {
            throw new ApiConnectionException(e.getMessage(), e);
        }
    }

    /**
     * Converts a JSON InputStream into a Recording object using the provided
     * ObjectMapper.
     * 
     * @param json Raw JSON InputStream
     * @param objectMapper Jackson ObjectMapper
     * @return Recording object represented by the provided JSON
     */
    public static Recording fromJson(final InputStream json, final ObjectMapper objectMapper) {
        // Convert all checked exceptions to Runtime
        try {
            return objectMapper.readValue(json, Recording.class);
        } catch (final JsonMappingException | JsonParseException e) {
            throw new ApiException(e.getMessage(), e);
        } catch (final IOException e) {
            throw new ApiConnectionException(e.getMessage(), e);
        }
    }

    private final String accountSid;
    private final String apiVersion;
    private final String callSid;
    private final DateTime dateCreated;
    private final DateTime dateUpdated;
    private final String duration;
    private final String sid;
    private final String price;
    private final String priceUnit;
    private final Recording.Status status;
    private final Integer channels;
    private final Recording.Source source;
    private final String uri;
    private final String encryptionType;
    private final Map<String, Object> encryptionDetails;

    @JsonCreator
    private Recording(@JsonProperty("account_sid")
                      final String accountSid, 
                      @JsonProperty("api_version")
                      final String apiVersion, 
                      @JsonProperty("call_sid")
                      final String callSid, 
                      @JsonProperty("date_created")
                      final String dateCreated, 
                      @JsonProperty("date_updated")
                      final String dateUpdated, 
                      @JsonProperty("duration")
                      final String duration, 
                      @JsonProperty("sid")
                      final String sid, 
                      @JsonProperty("price")
                      final String price, 
                      @JsonProperty("price_unit")
                      final String priceUnit, 
                      @JsonProperty("status")
                      final Recording.Status status, 
                      @JsonProperty("channels")
                      final Integer channels, 
                      @JsonProperty("source")
                      final Recording.Source source, 
                      @JsonProperty("uri")
                      final String uri, 
                      @JsonProperty("encryption_type")
                      final String encryptionType, 
                      @JsonProperty("encryption_details")
                      final Map<String, Object> encryptionDetails) {
        this.accountSid = accountSid;
        this.apiVersion = apiVersion;
        this.callSid = callSid;
        this.dateCreated = DateConverter.rfc2822DateTimeFromString(dateCreated);
        this.dateUpdated = DateConverter.rfc2822DateTimeFromString(dateUpdated);
        this.duration = duration;
        this.sid = sid;
        this.price = price;
        this.priceUnit = priceUnit;
        this.status = status;
        this.channels = channels;
        this.source = source;
        this.uri = uri;
        this.encryptionType = encryptionType;
        this.encryptionDetails = encryptionDetails;
    }

    /**
     * Returns The The unique sid that identifies this account.
     * 
     * @return The unique sid that identifies this account
     */
    public final String getAccountSid() {
        return this.accountSid;
    }

    /**
     * Returns The The version of the API in use during the recording..
     * 
     * @return The version of the API in use during the recording.
     */
    public final String getApiVersion() {
        return this.apiVersion;
    }

    /**
     * Returns The The call during which the recording was made..
     * 
     * @return The call during which the recording was made.
     */
    public final String getCallSid() {
        return this.callSid;
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
     * Returns The The length of the recording, in seconds..
     * 
     * @return The length of the recording, in seconds.
     */
    public final String getDuration() {
        return this.duration;
    }

    /**
     * Returns The A string that uniquely identifies this recording.
     * 
     * @return A string that uniquely identifies this recording
     */
    public final String getSid() {
        return this.sid;
    }

    /**
     * Returns The The price.
     * 
     * @return The price
     */
    public final String getPrice() {
        return this.price;
    }

    /**
     * Returns The The price_unit.
     * 
     * @return The price_unit
     */
    public final String getPriceUnit() {
        return this.priceUnit;
    }

    /**
     * Returns The The status.
     * 
     * @return The status
     */
    public final Recording.Status getStatus() {
        return this.status;
    }

    /**
     * Returns The The channels.
     * 
     * @return The channels
     */
    public final Integer getChannels() {
        return this.channels;
    }

    /**
     * Returns The The source.
     * 
     * @return The source
     */
    public final Recording.Source getSource() {
        return this.source;
    }

    /**
     * Returns The The URI for this resource.
     * 
     * @return The URI for this resource
     */
    public final String getUri() {
        return this.uri;
    }

    /**
     * Returns The The type of encryption used for this resource..
     * 
     * @return The type of encryption used for this resource.
     */
    public final String getEncryptionType() {
        return this.encryptionType;
    }

    /**
     * Returns The The encryption_details.
     * 
     * @return The encryption_details
     */
    public final Map<String, Object> getEncryptionDetails() {
        return this.encryptionDetails;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Recording other = (Recording) o;

        return Objects.equals(accountSid, other.accountSid) && 
               Objects.equals(apiVersion, other.apiVersion) && 
               Objects.equals(callSid, other.callSid) && 
               Objects.equals(dateCreated, other.dateCreated) && 
               Objects.equals(dateUpdated, other.dateUpdated) && 
               Objects.equals(duration, other.duration) && 
               Objects.equals(sid, other.sid) && 
               Objects.equals(price, other.price) && 
               Objects.equals(priceUnit, other.priceUnit) && 
               Objects.equals(status, other.status) && 
               Objects.equals(channels, other.channels) && 
               Objects.equals(source, other.source) && 
               Objects.equals(uri, other.uri) && 
               Objects.equals(encryptionType, other.encryptionType) && 
               Objects.equals(encryptionDetails, other.encryptionDetails);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountSid,
                            apiVersion,
                            callSid,
                            dateCreated,
                            dateUpdated,
                            duration,
                            sid,
                            price,
                            priceUnit,
                            status,
                            channels,
                            source,
                            uri,
                            encryptionType,
                            encryptionDetails);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                          .add("accountSid", accountSid)
                          .add("apiVersion", apiVersion)
                          .add("callSid", callSid)
                          .add("dateCreated", dateCreated)
                          .add("dateUpdated", dateUpdated)
                          .add("duration", duration)
                          .add("sid", sid)
                          .add("price", price)
                          .add("priceUnit", priceUnit)
                          .add("status", status)
                          .add("channels", channels)
                          .add("source", source)
                          .add("uri", uri)
                          .add("encryptionType", encryptionType)
                          .add("encryptionDetails", encryptionDetails)
                          .toString();
    }
}