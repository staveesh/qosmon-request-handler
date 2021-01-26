package com.taveeshsharma.requesthandler.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.data.mongodb.core.mapping.Field;

public class JobDescription {

    private MeasurementDescription measurementDescription;
    private Integer nodeCount;
    private Integer jobInterval;

    public JobDescription(MeasurementDescription measurementDescription, Integer nodeCount, Integer jobInterval) {
        this.measurementDescription = measurementDescription;
        this.nodeCount = nodeCount;
        this.jobInterval = jobInterval;
    }

    @JsonProperty("measurement_description")
    public MeasurementDescription getMeasurementDescription() {
        return measurementDescription;
    }

    public void setMeasurementDescription(MeasurementDescription measurementDescription) {
        this.measurementDescription = measurementDescription;
    }
    @JsonProperty("node_count")
    public Integer getNodeCount() {
        return nodeCount;
    }

    public void setNodeCount(Integer nodeCount) {
        this.nodeCount = nodeCount;
    }
    @JsonProperty("job_interval")
    public Integer getJobInterval() {
        return jobInterval;
    }

    public void setJobInterval(Integer jobInterval) {
        this.jobInterval = jobInterval;
    }

    @Override
    public String toString() {
        return "JobDescription{" +
                "measurementDescription=" + measurementDescription +
                ", nodeCount=" + nodeCount +
                ", jobInterval=" + jobInterval +
                '}';
    }
}
