# springbatchwithcrontaskandactuator
SpringBatch with CronTask and Custom Actuator Endpoint

clone or import to IDE setup lombak for Intillij if required.

Run applicaiotn.

GET http://localhost:8080/api/test/MyJob1 to Create a batch job with id MyJob1

GET http://localhost:8080/actuator/spring.batch.executions check mertics.

{
  "1": {
    "all": {
      "Execution 1": {
        "name": "spring.batch.job",
        "description": "Job duration",
        "baseUnit": "seconds",
        "measurements": [
          {
            "statistic": "COUNT",
            "value": 2.0
          },
          {
            "statistic": "TOTAL_TIME",
            "value": 0.0371528
          },
          {
            "statistic": "MAX",
            "value": 0.024562
          }
        ],
        "availableTags": [
          {
            "tag": "name",
            "values": [
              "firstSpringBatchJob1",
              "firstSpringBatchJobMyJob1"
            ]
          },
          {
            "tag": "status",
            "values": [
              "COMPLETED"
            ]
          }
        ]
      },
      "Execution 2": {
        "name": "spring.batch.job",
        "description": "Job duration",
        "baseUnit": "seconds",
        "measurements": [
          {
            "statistic": "COUNT",
            "value": 5.0
          },
          {
            "statistic": "TOTAL_TIME",
            "value": 0.0667012
          },
          {
            "statistic": "MAX",
            "value": 0.024562
          }
        ],
        "availableTags": [
          {
            "tag": "name",
            "values": [
              "firstSpringBatchJob1",
              "firstSpringBatchJobMyJob1"
            ]
          },
          {
            "tag": "status",
            "values": [
              "COMPLETED"
            ]
          }
        ]
      },
      "Execution 3": {
        "name": "spring.batch.job",
        "description": "Job duration",
        "baseUnit": "seconds",
        "measurements": [
          {
            "statistic": "COUNT",
            "value": 4.0
          },
          {
            "statistic": "TOTAL_TIME",
            "value": 0.058685799999999996
          },
          {
            "statistic": "MAX",
            "value": 0.024562
          }
        ],
        "availableTags": [
          {
            "tag": "name",
            "values": [
              "firstSpringBatchJob1",
              "firstSpringBatchJobMyJob1"
            ]
          },
          {
            "tag": "status",
            "values": [
              "COMPLETED"
            ]
          }
        ]
      }
    }
  },
  "MyJob1": {
    "all": {
      "Execution 1": {
        "name": "spring.batch.job",
        "description": "Job duration",
        "baseUnit": "seconds",
        "measurements": [
          {
            "statistic": "COUNT",
            "value": 2.0
          },
          {
            "statistic": "TOTAL_TIME",
            "value": 0.0371528
          },
          {
            "statistic": "MAX",
            "value": 0.024562
          }
        ],
        "availableTags": [
          {
            "tag": "name",
            "values": [
              "firstSpringBatchJob1",
              "firstSpringBatchJobMyJob1"
            ]
          },
          {
            "tag": "status",
            "values": [
              "COMPLETED"
            ]
          }
        ]
      },
      "Execution 2": {
        "name": "spring.batch.job",
        "description": "Job duration",
        "baseUnit": "seconds",
        "measurements": [
          {
            "statistic": "COUNT",
            "value": 5.0
          },
          {
            "statistic": "TOTAL_TIME",
            "value": 0.0667012
          },
          {
            "statistic": "MAX",
            "value": 0.024562
          }
        ],
        "availableTags": [
          {
            "tag": "name",
            "values": [
              "firstSpringBatchJob1",
              "firstSpringBatchJobMyJob1"
            ]
          },
          {
            "tag": "status",
            "values": [
              "COMPLETED"
            ]
          }
        ]
      },
      "Execution 3": {
        "name": "spring.batch.job",
        "description": "Job duration",
        "baseUnit": "seconds",
        "measurements": [
          {
            "statistic": "COUNT",
            "value": 4.0
          },
          {
            "statistic": "TOTAL_TIME",
            "value": 0.058685799999999996
          },
          {
            "statistic": "MAX",
            "value": 0.024562
          }
        ],
        "availableTags": [
          {
            "tag": "name",
            "values": [
              "firstSpringBatchJob1",
              "firstSpringBatchJobMyJob1"
            ]
          },
          {
            "tag": "status",
            "values": [
              "COMPLETED"
            ]
          }
        ]
      }
    }
  }
}

Solution for https://stackoverflow.com/questions/66379927/is-there-an-sample-code-available-to-capture-spring-batch-micro-metrics/66405849#66405849



