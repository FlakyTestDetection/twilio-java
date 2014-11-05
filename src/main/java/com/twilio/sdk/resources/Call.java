package com.twilio.sdk.resources;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.util.concurrent.ListenableFuture;
import com.twilio.sdk.creators.CallCreator;
import com.twilio.sdk.readers.CallReader;
import com.twilio.sdk.updaters.CallUpdater;

import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.util.Map;

public class Call extends SidResource {

    public enum Status {
        QUEUED ("queued"),
        RINGING ("ringing"),
        IN_PROGRESS ("in-progress"),
        COMPLETED ("completed"),
        BUSY ("busy"),
        FAILED ("failed"),
        NO_ANSWER ("no-answer"),
        CANCELED ("canceled");

        private String status;

        Status(String status) {
            this.status = status;
        }

        public String toString() {
            return this.status;
        }

        @JsonCreator
        public static Status forValue(String value) {
            String munged = value.replace("-", "_").toUpperCase();
            return Status.valueOf(munged);
        }

    }

    public static CallCreator create(String to, String from, URI uri) {
        return new CallCreator(to, from, uri);
    }

    public static CallCreator create(String to, String from, String applicationSid) {
        return new CallCreator(to, from, applicationSid);
    }

    public static CallUpdater update() {
        return new CallUpdater();
    }

    public static CallReader list() {
        return new CallReader();
    }

    public static Call fetch(String sid) {
        return new CallReader().fetch(sid);
    }

    public static ListenableFuture<Call> fetchAsync(String sid) {
        return new CallReader().fetchAsync(sid);
    }

    private final String accountSid;
    private final String annotation;
    private final String answeredBy;
    private final String apiVersion;
    private final String callerName;
    private final String dateCreated;
    private final String dateUpdated;
    private final String direction;
    private final Integer duration;
    private final String endTime;
    private final String forwardedFrom;
    private final String from;
    private final String fromFormatted;
    private final String groupSid;
    private final String parentCallSid;
    private final String phoneNumberSid;
    private final Double price;
    private final String priceUnit;
    private final String sid;
    private final String startTime;
    private final Status status;
    private final Map<String, String> subresourceUris;
    private final String to;
    private final String toFormatted;
    private final String uri;

    @JsonCreator
    private Call(@JsonProperty("account_sid")       String accountSid,
                 @JsonProperty("annotation")        String annotation,
                 @JsonProperty("answered_by")       String answeredBy,
                 @JsonProperty("api_version")       String apiVersion,
                 @JsonProperty("caller_name")       String callerName,
                 @JsonProperty("date_created")      String dateCreated,
                 @JsonProperty("date_updated")      String dateUpdated,
                 @JsonProperty("direction")         String direction,
                 @JsonProperty("duration")          Integer duration,
                 @JsonProperty("end_time")          String endTime,
                 @JsonProperty("forwarded_from")    String forwardedFrom,
                 @JsonProperty("from")              String from,
                 @JsonProperty("from_formatted")    String fromFormatted,
                 @JsonProperty("group_sid")         String groupSid,
                 @JsonProperty("parent_call_sid")   String parentCallSid,
                 @JsonProperty("phone_number_sid")  String phoneNumberSid,
                 @JsonProperty("price")             Double price,
                 @JsonProperty("price_unit")        String priceUnit,
                 @JsonProperty("sid")               String sid,
                 @JsonProperty("start_time")        String startTime,
                 @JsonProperty("status")            Status status,
                 @JsonProperty("subresource_uris")  Map<String, String> subresourceUris,
                 @JsonProperty("to")                String to,
                 @JsonProperty("to_formatted")      String toFormatted,
                 @JsonProperty("uri")               String uri) {
        this.accountSid = accountSid;
        this.annotation = annotation;
        this.answeredBy = answeredBy;
        this.apiVersion = apiVersion;
        this.callerName = callerName;
        this.dateCreated = dateCreated;
        this.dateUpdated = dateUpdated;
        this.direction = direction;
        this.duration = duration;
        this.endTime = endTime;
        this.forwardedFrom = forwardedFrom;
        this.from = from;
        this.fromFormatted = fromFormatted;
        this.groupSid = groupSid;
        this.parentCallSid = parentCallSid;
        this.phoneNumberSid = phoneNumberSid;
        this.price = price;
        this.priceUnit = priceUnit;
        this.sid = sid;
        this.startTime = startTime;
        this.status = status;
        this.subresourceUris = subresourceUris;
        this.to = to;
        this.toFormatted = toFormatted;
        this.uri = uri;

    }

    public static Call fromJson(String json) {
        ObjectMapper mapper = new ObjectMapper();

        // Convert all checked exceptions to Runtime
        try {
            return mapper.readValue(json, Call.class);
        } catch (JsonMappingException e) {
            throw new RuntimeException(e.getMessage());
        } catch (JsonParseException e) {
            throw new RuntimeException(e.getMessage());
        } catch (IOException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public static Call fromJson(InputStream json) {
        ObjectMapper mapper = new ObjectMapper();

        // Convert all checked exceptions to Runtime
        try {
            return mapper.readValue(json, Call.class);
        } catch (JsonMappingException e) {
            throw new RuntimeException(e.getMessage());
        } catch (JsonParseException e) {
            throw new RuntimeException(e.getMessage());
        } catch (IOException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public final String getAccountSid() {
        return accountSid;
    }

    public final String getAnnotation() {
        return annotation;
    }

    public final String getAnsweredBy() {
        return answeredBy;
    }

    public final String getApiVersion() {
        return apiVersion;
    }

    public final String getCallerName() {
        return callerName;
    }

    public final String getDateCreated() {
        return dateCreated;
    }

    public final String getDateUpdated() {
        return dateUpdated;
    }

    public final String getDirection() {
        return direction;
    }

    public final Integer getDuration() {
        return duration != null ? duration : 0;
    }

    public final String getEndTime() {
        return endTime;
    }

    public final String getForwardedFrom() {
        return forwardedFrom;
    }

    public final String getFrom() {
        return from;
    }

    public final String getFromFormatted() {
        return fromFormatted;
    }

    public final String getGroupSid() {
        return groupSid;
    }

    public final String getParentCallSid() {
        return parentCallSid;
    }

    public final String getPhoneNumberSid() {
        return phoneNumberSid;
    }

    public final Double getPrice() {
        return price;
    }

    public final String getPriceUnit() {
        return priceUnit;
    }

    public final String getSid() {
        return sid;
    }

    public final String getStartTime() {
        return startTime;
    }

    public final Status getStatus() {
        return status;
    }

    public final Map<String, String> getSubresourceUris() {
        return subresourceUris;
    }

    public final String getTo() {
        return to;
    }

    public final String getToFormatted() {
        return toFormatted;
    }

    public final String getUri() {
        return uri;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Call call = (Call) o;

        if (accountSid != null ? !accountSid.equals(call.accountSid) : call.accountSid != null)
            return false;
        if (annotation != null ? !annotation.equals(call.annotation) : call.annotation != null)
            return false;
        if (answeredBy != null ? !answeredBy.equals(call.answeredBy) : call.answeredBy != null)
            return false;
        if (apiVersion != null ? !apiVersion.equals(call.apiVersion) : call.apiVersion != null)
            return false;
        if (callerName != null ? !callerName.equals(call.callerName) : call.callerName != null)
            return false;
        if (dateCreated != null ? !dateCreated.equals(call.dateCreated) : call.dateCreated != null)
            return false;
        if (dateUpdated != null ? !dateUpdated.equals(call.dateUpdated) : call.dateUpdated != null)
            return false;
        if (direction != null ? !direction.equals(call.direction) : call.direction != null)
            return false;
        if (duration != null ? !duration.equals(call.duration) : call.duration != null)
            return false;
        if (endTime != null ? !endTime.equals(call.endTime) : call.endTime != null)
            return false;
        if (forwardedFrom != null ? !forwardedFrom.equals(call.forwardedFrom) : call.forwardedFrom != null)
            return false;
        if (from != null ? !from.equals(call.from) : call.from != null)
            return false;
        if (fromFormatted != null ? !fromFormatted.equals(call.fromFormatted) : call.fromFormatted != null)
            return false;
        if (groupSid != null ? !groupSid.equals(call.groupSid) : call.groupSid != null)
            return false;
        if (parentCallSid != null ? !parentCallSid.equals(call.parentCallSid) : call.parentCallSid != null)
            return false;
        if (phoneNumberSid != null ? !phoneNumberSid.equals(call.phoneNumberSid) : call.phoneNumberSid != null)
            return false;
        if (price != null ? !price.equals(call.price) : call.price != null)
            return false;
        if (priceUnit != null ? !priceUnit.equals(call.priceUnit) : call.priceUnit != null)
            return false;
        if (sid != null ? !sid.equals(call.sid) : call.sid != null)
            return false;
        if (startTime != null ? !startTime.equals(call.startTime) : call.startTime != null)
            return false;
        if (status != call.status) return false;
        if (subresourceUris != null ? !subresourceUris.equals(call.subresourceUris) : call.subresourceUris != null)
            return false;
        if (to != null ? !to.equals(call.to) : call.to != null) return false;
        if (toFormatted != null ? !toFormatted.equals(call.toFormatted) : call.toFormatted != null)
            return false;
        if (uri != null ? !uri.equals(call.uri) : call.uri != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = accountSid != null ? accountSid.hashCode() : 0;
        result = 31 * result + (annotation != null ? annotation.hashCode() : 0);
        result = 31 * result + (answeredBy != null ? answeredBy.hashCode() : 0);
        result = 31 * result + (apiVersion != null ? apiVersion.hashCode() : 0);
        result = 31 * result + (callerName != null ? callerName.hashCode() : 0);
        result = 31 * result + (dateCreated != null ? dateCreated.hashCode() : 0);
        result = 31 * result + (dateUpdated != null ? dateUpdated.hashCode() : 0);
        result = 31 * result + (direction != null ? direction.hashCode() : 0);
        result = 31 * result + (duration != null ? duration.hashCode() : 0);
        result = 31 * result + (endTime != null ? endTime.hashCode() : 0);
        result = 31 * result + (forwardedFrom != null ? forwardedFrom.hashCode() : 0);
        result = 31 * result + (from != null ? from.hashCode() : 0);
        result = 31 * result + (fromFormatted != null ? fromFormatted.hashCode() : 0);
        result = 31 * result + (groupSid != null ? groupSid.hashCode() : 0);
        result = 31 * result + (parentCallSid != null ? parentCallSid.hashCode() : 0);
        result = 31 * result + (phoneNumberSid != null ? phoneNumberSid.hashCode() : 0);
        result = 31 * result + (price != null ? price.hashCode() : 0);
        result = 31 * result + (priceUnit != null ? priceUnit.hashCode() : 0);
        result = 31 * result + (sid != null ? sid.hashCode() : 0);
        result = 31 * result + (startTime != null ? startTime.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        result = 31 * result + (subresourceUris != null ? subresourceUris.hashCode() : 0);
        result = 31 * result + (to != null ? to.hashCode() : 0);
        result = 31 * result + (toFormatted != null ? toFormatted.hashCode() : 0);
        result = 31 * result + (uri != null ? uri.hashCode() : 0);
        return result;
    }
}
