package com.example.springbatch.batchincrontaskwithmetrics;

import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobExecutionListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.metrics.MetricsEndpoint;
import org.springframework.stereotype.Component;

/**
 * @author Ameya Shetti
 */
@Component
public class BatchJobListener implements JobExecutionListener {

    @Autowired
    private MetricsEndpoint metricsEndpoint;

    @Autowired
    BatchAllJobsMetricContext batchAllJobsMetricContext;

    @Autowired
    BatchPerJobMetricContext batchPerJobMetricContext;

    @Override
    public void beforeJob(JobExecution jobExecution) {

    }

    @Override
    public void afterJob(JobExecution jobExecution) {
        MetricsEndpoint.MetricResponse metricResponse = metricsEndpoint.metric("spring.batch.job",null);

        String key = jobExecution.getJobParameters().getString("jobId");
        String execution = "Execution "+jobExecution.getJobParameters().getString("executionCout");
        if(batchAllJobsMetricContext.hasKey(key)){
           batchAllJobsMetricContext.get(key).put(execution,metricResponse);
        }else{
            batchPerJobMetricContext.put(execution,metricResponse);
            batchAllJobsMetricContext.put(key,batchPerJobMetricContext);
        }

    }

}
