package com.example.springbatch.batchincrontaskwithmetrics;


import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

/**
 * @author Ameya Shetti
 */
@Component
public class BatchItemProcessor implements ItemProcessor<String, String> {

    @Override
    public String process(String data) throws Exception {
        return data.toUpperCase();
    }

}