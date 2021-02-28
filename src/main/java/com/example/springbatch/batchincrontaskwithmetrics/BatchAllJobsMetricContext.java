package com.example.springbatch.batchincrontaskwithmetrics;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
/**
 * @author Ameya Shetti
 */
@Component
@Scope("singleton")
public class BatchAllJobsMetricContext {

    private Map<String, BatchPerJobMetricContext> concurrentHashMap;

    public Map<String, BatchPerJobMetricContext> put(String key, BatchPerJobMetricContext value){
        initialize();
        concurrentHashMap.put(key,value);
        return concurrentHashMap;
    }

    public boolean hasKey(String key){
        initialize();
        return concurrentHashMap.containsKey(key);
    }

    public BatchPerJobMetricContext get(String key){
        initialize();
        return concurrentHashMap.containsKey(key) ? concurrentHashMap.get(key) : null;
    }

    public Map<String, BatchPerJobMetricContext> getAll(){
        initialize();
        return concurrentHashMap;
    }

    private void initialize(){
        if(concurrentHashMap==null){
            concurrentHashMap = new ConcurrentHashMap<>();
        }
    }
}
