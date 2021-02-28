package com.example.springbatch.batchincrontaskwithmetrics;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.stereotype.Component;

import java.util.Map;
/**
 * @author Ameya Shetti
 */
@Component
@Endpoint(id = "spring.batch.executions")
public class BatchMetricEndpoint {

    @Autowired
    BatchAllJobsMetricContext batchAllJobsMetricContext;

    @ReadOperation
    public Map<String, BatchPerJobMetricContext> features() {
        return batchAllJobsMetricContext.getAll();
    }
}
