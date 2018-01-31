/**
 * This code was generated by
 * \ / _    _  _|   _  _
 *  | (_)\/(_)(_|\/| |(/_  v1.0.0
 *       /       /
 */

package com.twilio.rest.studio.v1.flow.engagement;

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
import java.util.Map;
import java.util.Objects;

/**
 * PLEASE NOTE that this class contains beta products that are subject to
 * change. Use them with caution.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Step extends Resource {
    private static final long serialVersionUID = 99874208172157L;

    /**
     * Create a StepReader to execute read.
     * 
     * @param pathFlowSid The flow_sid
     * @param pathEngagementSid The engagement_sid
     * @return StepReader capable of executing the read
     */
    public static StepReader reader(final String pathFlowSid, 
                                    final String pathEngagementSid) {
        return new StepReader(pathFlowSid, pathEngagementSid);
    }

    /**
     * Create a StepFetcher to execute fetch.
     * 
     * @param pathFlowSid The flow_sid
     * @param pathEngagementSid The engagement_sid
     * @param pathSid The sid
     * @return StepFetcher capable of executing the fetch
     */
    public static StepFetcher fetcher(final String pathFlowSid, 
                                      final String pathEngagementSid, 
                                      final String pathSid) {
        return new StepFetcher(pathFlowSid, pathEngagementSid, pathSid);
    }

    /**
     * Converts a JSON String into a Step object using the provided ObjectMapper.
     * 
     * @param json Raw JSON String
     * @param objectMapper Jackson ObjectMapper
     * @return Step object represented by the provided JSON
     */
    public static Step fromJson(final String json, final ObjectMapper objectMapper) {
        // Convert all checked exceptions to Runtime
        try {
            return objectMapper.readValue(json, Step.class);
        } catch (final JsonMappingException | JsonParseException e) {
            throw new ApiException(e.getMessage(), e);
        } catch (final IOException e) {
            throw new ApiConnectionException(e.getMessage(), e);
        }
    }

    /**
     * Converts a JSON InputStream into a Step object using the provided
     * ObjectMapper.
     * 
     * @param json Raw JSON InputStream
     * @param objectMapper Jackson ObjectMapper
     * @return Step object represented by the provided JSON
     */
    public static Step fromJson(final InputStream json, final ObjectMapper objectMapper) {
        // Convert all checked exceptions to Runtime
        try {
            return objectMapper.readValue(json, Step.class);
        } catch (final JsonMappingException | JsonParseException e) {
            throw new ApiException(e.getMessage(), e);
        } catch (final IOException e) {
            throw new ApiConnectionException(e.getMessage(), e);
        }
    }

    private final String sid;
    private final String accountSid;
    private final String flowSid;
    private final String engagementSid;
    private final String name;
    private final Map<String, Object> context;
    private final String transitionedFrom;
    private final String transitionedTo;
    private final DateTime dateCreated;
    private final DateTime dateUpdated;
    private final URI url;

    @JsonCreator
    private Step(@JsonProperty("sid")
                 final String sid, 
                 @JsonProperty("account_sid")
                 final String accountSid, 
                 @JsonProperty("flow_sid")
                 final String flowSid, 
                 @JsonProperty("engagement_sid")
                 final String engagementSid, 
                 @JsonProperty("name")
                 final String name, 
                 @JsonProperty("context")
                 final Map<String, Object> context, 
                 @JsonProperty("transitioned_from")
                 final String transitionedFrom, 
                 @JsonProperty("transitioned_to")
                 final String transitionedTo, 
                 @JsonProperty("date_created")
                 final String dateCreated, 
                 @JsonProperty("date_updated")
                 final String dateUpdated, 
                 @JsonProperty("url")
                 final URI url) {
        this.sid = sid;
        this.accountSid = accountSid;
        this.flowSid = flowSid;
        this.engagementSid = engagementSid;
        this.name = name;
        this.context = context;
        this.transitionedFrom = transitionedFrom;
        this.transitionedTo = transitionedTo;
        this.dateCreated = DateConverter.iso8601DateTimeFromString(dateCreated);
        this.dateUpdated = DateConverter.iso8601DateTimeFromString(dateUpdated);
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
     * Returns The The flow_sid.
     * 
     * @return The flow_sid
     */
    public final String getFlowSid() {
        return this.flowSid;
    }

    /**
     * Returns The The engagement_sid.
     * 
     * @return The engagement_sid
     */
    public final String getEngagementSid() {
        return this.engagementSid;
    }

    /**
     * Returns The The name.
     * 
     * @return The name
     */
    public final String getName() {
        return this.name;
    }

    /**
     * Returns The The context.
     * 
     * @return The context
     */
    public final Map<String, Object> getContext() {
        return this.context;
    }

    /**
     * Returns The The transitioned_from.
     * 
     * @return The transitioned_from
     */
    public final String getTransitionedFrom() {
        return this.transitionedFrom;
    }

    /**
     * Returns The The transitioned_to.
     * 
     * @return The transitioned_to
     */
    public final String getTransitionedTo() {
        return this.transitionedTo;
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

        Step other = (Step) o;

        return Objects.equals(sid, other.sid) && 
               Objects.equals(accountSid, other.accountSid) && 
               Objects.equals(flowSid, other.flowSid) && 
               Objects.equals(engagementSid, other.engagementSid) && 
               Objects.equals(name, other.name) && 
               Objects.equals(context, other.context) && 
               Objects.equals(transitionedFrom, other.transitionedFrom) && 
               Objects.equals(transitionedTo, other.transitionedTo) && 
               Objects.equals(dateCreated, other.dateCreated) && 
               Objects.equals(dateUpdated, other.dateUpdated) && 
               Objects.equals(url, other.url);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sid,
                            accountSid,
                            flowSid,
                            engagementSid,
                            name,
                            context,
                            transitionedFrom,
                            transitionedTo,
                            dateCreated,
                            dateUpdated,
                            url);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                          .add("sid", sid)
                          .add("accountSid", accountSid)
                          .add("flowSid", flowSid)
                          .add("engagementSid", engagementSid)
                          .add("name", name)
                          .add("context", context)
                          .add("transitionedFrom", transitionedFrom)
                          .add("transitionedTo", transitionedTo)
                          .add("dateCreated", dateCreated)
                          .add("dateUpdated", dateUpdated)
                          .add("url", url)
                          .toString();
    }
}