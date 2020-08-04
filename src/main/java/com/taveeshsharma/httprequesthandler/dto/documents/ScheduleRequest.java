package com.taveeshsharma.httprequesthandler.dto.documents;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.taveeshsharma.httprequesthandler.dto.JobDescription;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(value = "job_data")
public class ScheduleRequest {
    private String requestType;
    private JobDescription jobDescription;
    private String userId;

    @JsonProperty("request_type")
    public String getRequestType() {
        return requestType;
    }

    public void setRequestType(String requestType) {
        this.requestType = requestType;
    }

    @JsonProperty("job_description")
    public JobDescription getJobDescription() {
        return jobDescription;
    }

    public void setJobDescription(JobDescription jobDescription) {
        this.jobDescription = jobDescription;
    }

    @JsonProperty("user_id")
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "ScheduleRequest{" +
                "requestType='" + requestType + '\'' +
                ", jobDescription=" + jobDescription +
                ", userId='" + userId + '\'' +
                '}';
    }
}