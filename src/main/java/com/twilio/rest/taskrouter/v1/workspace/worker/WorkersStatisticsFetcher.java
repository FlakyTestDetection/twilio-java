/**
 * This code was generated by
 * \ / _    _  _|   _  _
 *  | (_)\/(_)(_|\/| |(/_  v1.0.0
 *       /       /
 */

package com.twilio.rest.taskrouter.v1.workspace.worker;

import com.twilio.base.Fetcher;
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

public class WorkersStatisticsFetcher extends Fetcher<WorkersStatistics> {
    private final String pathWorkspaceSid;
    private Integer minutes;
    private DateTime startDate;
    private DateTime endDate;
    private String taskQueueSid;
    private String taskQueueName;
    private String friendlyName;
    private String taskChannel;

    /**
     * Construct a new WorkersStatisticsFetcher.
     * 
     * @param pathWorkspaceSid The workspace_sid
     */
    public WorkersStatisticsFetcher(final String pathWorkspaceSid) {
        this.pathWorkspaceSid = pathWorkspaceSid;
    }

    /**
     * The minutes.
     * 
     * @param minutes The minutes
     * @return this
     */
    public WorkersStatisticsFetcher setMinutes(final Integer minutes) {
        this.minutes = minutes;
        return this;
    }

    /**
     * The start_date.
     * 
     * @param startDate The start_date
     * @return this
     */
    public WorkersStatisticsFetcher setStartDate(final DateTime startDate) {
        this.startDate = startDate;
        return this;
    }

    /**
     * The end_date.
     * 
     * @param endDate The end_date
     * @return this
     */
    public WorkersStatisticsFetcher setEndDate(final DateTime endDate) {
        this.endDate = endDate;
        return this;
    }

    /**
     * The task_queue_sid.
     * 
     * @param taskQueueSid The task_queue_sid
     * @return this
     */
    public WorkersStatisticsFetcher setTaskQueueSid(final String taskQueueSid) {
        this.taskQueueSid = taskQueueSid;
        return this;
    }

    /**
     * The task_queue_name.
     * 
     * @param taskQueueName The task_queue_name
     * @return this
     */
    public WorkersStatisticsFetcher setTaskQueueName(final String taskQueueName) {
        this.taskQueueName = taskQueueName;
        return this;
    }

    /**
     * The friendly_name.
     * 
     * @param friendlyName The friendly_name
     * @return this
     */
    public WorkersStatisticsFetcher setFriendlyName(final String friendlyName) {
        this.friendlyName = friendlyName;
        return this;
    }

    /**
     * The task_channel.
     * 
     * @param taskChannel The task_channel
     * @return this
     */
    public WorkersStatisticsFetcher setTaskChannel(final String taskChannel) {
        this.taskChannel = taskChannel;
        return this;
    }

    /**
     * Make the request to the Twilio API to perform the fetch.
     * 
     * @param client TwilioRestClient with which to make the request
     * @return Fetched WorkersStatistics
     */
    @Override
    @SuppressWarnings("checkstyle:linelength")
    public WorkersStatistics fetch(final TwilioRestClient client) {
        Request request = new Request(
            HttpMethod.GET,
            Domains.TASKROUTER.toString(),
            "/v1/Workspaces/" + this.pathWorkspaceSid + "/Workers/Statistics",
            client.getRegion()
        );

        addQueryParams(request);
        Response response = client.request(request);

        if (response == null) {
            throw new ApiConnectionException("WorkersStatistics fetch failed: Unable to connect to server");
        } else if (!TwilioRestClient.SUCCESS.apply(response.getStatusCode())) {
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

        return WorkersStatistics.fromJson(response.getStream(), client.getObjectMapper());
    }

    /**
     * Add the requested query string arguments to the Request.
     * 
     * @param request Request to add query string arguments to
     */
    private void addQueryParams(final Request request) {
        if (minutes != null) {
            request.addQueryParam("Minutes", minutes.toString());
        }

        if (startDate != null) {
            request.addQueryParam("StartDate", startDate.toString());
        }

        if (endDate != null) {
            request.addQueryParam("EndDate", endDate.toString());
        }

        if (taskQueueSid != null) {
            request.addQueryParam("TaskQueueSid", taskQueueSid);
        }

        if (taskQueueName != null) {
            request.addQueryParam("TaskQueueName", taskQueueName);
        }

        if (friendlyName != null) {
            request.addQueryParam("FriendlyName", friendlyName);
        }

        if (taskChannel != null) {
            request.addQueryParam("TaskChannel", taskChannel);
        }
    }
}