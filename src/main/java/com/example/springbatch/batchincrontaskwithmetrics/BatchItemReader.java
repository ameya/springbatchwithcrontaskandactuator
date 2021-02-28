package com.example.springbatch.batchincrontaskwithmetrics;

import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;
import org.springframework.stereotype.Component;

/**
 * @author Ameya Shetti
 */
@Component
public class BatchItemReader implements ItemReader<String> {

    private String[] messages = {
            "Welcome to Spring Batch Example",
            "We use H2 Database for this example"};

    private int count = 0;

    @Override
    public String read() throws Exception, UnexpectedInputException,
            ParseException, NonTransientResourceException {

        if (count < messages.length) {
            return messages[count++];
        } else {
            count = 0;
        }
        return null;
    }

}
