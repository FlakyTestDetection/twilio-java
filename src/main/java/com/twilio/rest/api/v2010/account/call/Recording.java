/**
 * This code was generated by
 * \ / _    _  _|   _  _
 *  | (_)\/(_)(_|\/| |(/_  v1.0.0
 *       /       /
 */

package com.twilio.rest.api.v2010.account.call;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
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
import java.math.BigDecimal;
import java.util.Currency;
import java.util.Map;
import java.util.Objects;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Recording extends Resource {
    private static final long serialVersionUID = 231172714460621L;

    public enum Status {
        IN_PROGRESS("in-progress"),
        PAUSED("paused"),
        STOPPED("stopped"),
        PROCESSING("processing"),
        COMPLETED("completed"),
        FAILED("failed");

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

    public enum Source {
        DIALVERB("DialVerb"),
        CONFERENCE("Conference"),
        OUTBOUNDAPI("OutboundAPI"),
        TRUNKING("Trunking"),
        RECORDVERB("RecordVerb"),
        STARTCALLRECORDINGAPI("StartCallRecordingAPI"),
        STARTCONFERENCERECORDINGAPI("StartConferenceRecordingAPI");

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

    /**
     * Create a RecordingFetcher to execute fetch.
     * 
     * @param pathAccountSid The account_sid
     * @param pathCallSid The call_sid
     * @param pathSid The sid
     * @return RecordingFetcher capable of executing the fetch
     */
    public static RecordingFetcher fetcher(final String pathAccountSid, 
                                           final String pathCallSid, 
                                           final String pathSid) {
        return new RecordingFetcher(pathAccountSid, pathCallSid, pathSid);
    }

    /**
     * Create a RecordingFetcher to execute fetch.
     * 
     * @param pathCallSid The call_sid
     * @param pathSid The sid
     * @return RecordingFetcher capable of executing the fetch
     */
    public static RecordingFetcher fetcher(final String pathCallSid, 
                                           final String pathSid) {
        return new RecordingFetcher(pathCallSid, pathSid);
    }

    /**
     * Create a RecordingDeleter to execute delete.
     * 
     * @param pathAccountSid The account_sid
     * @param pathCallSid The call_sid
     * @param pathSid The sid
     * @return RecordingDeleter capable of executing the delete
     */
    public static RecordingDeleter deleter(final String pathAccountSid, 
                                           final String pathCallSid, 
                                           final String pathSid) {
        return new RecordingDeleter(pathAccountSid, pathCallSid, pathSid);
    }

    /**
     * Create a RecordingDeleter to execute delete.
     * 
     * @param pathCallSid The call_sid
     * @param pathSid The sid
     * @return RecordingDeleter capable of executing the delete
     */
    public static RecordingDeleter deleter(final String pathCallSid, 
                                           final String pathSid) {
        return new RecordingDeleter(pathCallSid, pathSid);
    }

    /**
     * Create a RecordingReader to execute read.
     * 
     * @param pathAccountSid The account_sid
     * @param pathCallSid The call_sid
     * @return RecordingReader capable of executing the read
     */
    public static RecordingReader reader(final String pathAccountSid, 
                                         final String pathCallSid) {
        return new RecordingReader(pathAccountSid, pathCallSid);
    }

    /**
     * Create a RecordingReader to execute read.
     * 
     * @param pathCallSid The call_sid
     * @return RecordingReader capable of executing the read
     */
    public static RecordingReader reader(final String pathCallSid) {
        return new RecordingReader(pathCallSid);
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
    private final String conferenceSid;
    private final DateTime dateCreated;
    private final DateTime dateUpdated;
    private final String duration;
    private final String sid;
    private final BigDecimal price;
    private final String uri;
    private final Map<String, Object> encryptionDetails;
    private final Currency priceUnit;
    private final Recording.Status status;
    private final Integer channels;
    private final Recording.Source source;
    private final Integer errorCode;

    @JsonCreator
    private Recording(@JsonProperty("account_sid")
                      final String accountSid, 
                      @JsonProperty("api_version")
                      final String apiVersion, 
                      @JsonProperty("call_sid")
                      final String callSid, 
                      @JsonProperty("conference_sid")
                      final String conferenceSid, 
                      @JsonProperty("date_created")
                      final String dateCreated, 
                      @JsonProperty("date_updated")
                      final String dateUpdated, 
                      @JsonProperty("duration")
                      final String duration, 
                      @JsonProperty("sid")
                      final String sid, 
                      @JsonProperty("price")
                      final BigDecimal price, 
                      @JsonProperty("uri")
                      final String uri, 
                      @JsonProperty("encryption_details")
                      final Map<String, Object> encryptionDetails, 
                      @JsonProperty("price_unit")
                      @JsonDeserialize(using = com.twilio.converter.CurrencyDeserializer.class)
                      final Currency priceUnit, 
                      @JsonProperty("status")
                      final Recording.Status status, 
                      @JsonProperty("channels")
                      final Integer channels, 
                      @JsonProperty("source")
                      final Recording.Source source, 
                      @JsonProperty("error_code")
                      final Integer errorCode) {
        this.accountSid = accountSid;
        this.apiVersion = apiVersion;
        this.callSid = callSid;
        this.conferenceSid = conferenceSid;
        this.dateCreated = DateConverter.rfc2822DateTimeFromString(dateCreated);
        this.dateUpdated = DateConverter.rfc2822DateTimeFromString(dateUpdated);
        this.duration = duration;
        this.sid = sid;
        this.price = price;
        this.uri = uri;
        this.encryptionDetails = encryptionDetails;
        this.priceUnit = priceUnit;
        this.status = status;
        this.channels = channels;
        this.source = source;
        this.errorCode = errorCode;
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
     * Returns The The api_version.
     * 
     * @return The api_version
     */
    public final String getApiVersion() {
        return this.apiVersion;
    }

    /**
     * Returns The The call_sid.
     * 
     * @return The call_sid
     */
    public final String getCallSid() {
        return this.callSid;
    }

    /**
     * Returns The The conference_sid.
     * 
     * @return The conference_sid
     */
    public final String getConferenceSid() {
        return this.conferenceSid;
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
     * Returns The The duration.
     * 
     * @return The duration
     */
    public final String getDuration() {
        return this.duration;
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
     * Returns The The price.
     * 
     * @return The price
     */
    public final BigDecimal getPrice() {
        return this.price;
    }

    /**
     * Returns The The uri.
     * 
     * @return The uri
     */
    public final String getUri() {
        return this.uri;
    }

    /**
     * Returns The The encryption_details.
     * 
     * @return The encryption_details
     */
    public final Map<String, Object> getEncryptionDetails() {
        return this.encryptionDetails;
    }

    /**
     * Returns The The price_unit.
     * 
     * @return The price_unit
     */
    public final Currency getPriceUnit() {
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
     * Returns The The error_code.
     * 
     * @return The error_code
     */
    public final Integer getErrorCode() {
        return this.errorCode;
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
               Objects.equals(conferenceSid, other.conferenceSid) && 
               Objects.equals(dateCreated, other.dateCreated) && 
               Objects.equals(dateUpdated, other.dateUpdated) && 
               Objects.equals(duration, other.duration) && 
               Objects.equals(sid, other.sid) && 
               Objects.equals(price, other.price) && 
               Objects.equals(uri, other.uri) && 
               Objects.equals(encryptionDetails, other.encryptionDetails) && 
               Objects.equals(priceUnit, other.priceUnit) && 
               Objects.equals(status, other.status) && 
               Objects.equals(channels, other.channels) && 
               Objects.equals(source, other.source) && 
               Objects.equals(errorCode, other.errorCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountSid,
                            apiVersion,
                            callSid,
                            conferenceSid,
                            dateCreated,
                            dateUpdated,
                            duration,
                            sid,
                            price,
                            uri,
                            encryptionDetails,
                            priceUnit,
                            status,
                            channels,
                            source,
                            errorCode);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                          .add("accountSid", accountSid)
                          .add("apiVersion", apiVersion)
                          .add("callSid", callSid)
                          .add("conferenceSid", conferenceSid)
                          .add("dateCreated", dateCreated)
                          .add("dateUpdated", dateUpdated)
                          .add("duration", duration)
                          .add("sid", sid)
                          .add("price", price)
                          .add("uri", uri)
                          .add("encryptionDetails", encryptionDetails)
                          .add("priceUnit", priceUnit)
                          .add("status", status)
                          .add("channels", channels)
                          .add("source", source)
                          .add("errorCode", errorCode)
                          .toString();
    }
}