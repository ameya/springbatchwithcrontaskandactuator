package com.example.springbatch.batchincrontaskwithmetrics;

import org.springframework.boot.actuate.metrics.MetricsEndpoint;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
/**
 * @author Ameya Shetti
 */
@Component
public class BatchPerJobMetricContext {
    private Map<String,MetricsEndpoint.MetricResponse> concurrentHashMap;

    public Map<String, MetricsEndpoint.MetricResponse> put(String key, MetricsEndpoint.MetricResponse value){
        initialize();
        concurrentHashMap.put(key,value);
        return concurrentHashMap;
    }

    public MetricsEndpoint.MetricResponse get(String key){
        initialize();
        return concurrentHashMap.containsKey(key) ? concurrentHashMap.get(key) : null;
    }

    public Map<String, MetricsEndpoint.MetricResponse> getAll(){
        initialize();
        return concurrentHashMap;
    }

    private void initialize(){
        if(concurrentHashMap==null){
            concurrentHashMap = new ConcurrentHashMap<>();
        }
    }
}
