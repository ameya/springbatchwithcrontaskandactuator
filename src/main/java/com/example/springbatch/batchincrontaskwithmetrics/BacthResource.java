package com.example.springbatch.batchincrontaskwithmetrics;

import lombok.SneakyThrows;
import org.springframework.batch.core.*;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.config.CronTask;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Ameya Shetti
 */
@RestController
@RequestMapping(value = "/api", produces = "application/hal+json")
public class BacthResource {

    @Autowired
    private JobBuilderFactory jobBuilderFactory;

    @Autowired
    private StepBuilderFactory stepBuilderFactory;

    @Autowired BatchItemProcessor batchItemProcessor;

    @Autowired
    private BatchItemReader batchItemReader;

    @Autowired
    private BatchItemWriter batchItemWriter;

    @Autowired private BatchJobListener batchJobListener;

    @Autowired
    private JobLauncher jobLauncher;

    @SneakyThrows
    @GetMapping("/test/{id}")
    public String get(@PathVariable("id") String id) {
        Job job = jobBuilderFactory.get("firstSpringBatchJob"+id).listener(batchJobListener).start(
            stepBuilderFactory.get("exampleJobStep")
                .<String, String>chunk(2)
                .reader(batchItemReader)
                    .processor(batchItemProcessor)
                .writer(batchItemWriter)
                .build()
        ).build();

        CronTask task = new CronTask(new Runnable() {
            Integer counter = 1;
            @SneakyThrows
            @Override
            public void run() {

                Map<String, JobParameter> parameters = new HashMap<>();
                JobParameters params = new JobParametersBuilder()
                        //.addString("JobID"+id, String.valueOf(System.currentTimeMillis()))
                        .addString("jobId", id)
                        .addString("executionCout",""+counter++)

                        .toJobParameters();
                JobExecution jobExecution = jobLauncher.run(job, params);

            }
        }, "1/10 * * * * *");

        ScheduledTaskRegistrar taskRegistrar = new ScheduledTaskRegistrar();
        taskRegistrar.addCronTask(task);
        taskRegistrar.afterPropertiesSet();

        return "OK";
    }



}
