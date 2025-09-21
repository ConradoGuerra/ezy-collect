package com.ezycollect;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.retry.annotation.EnableRetry;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication(scanBasePackages = "com.ezycollect")
@EnableJpaRepositories(basePackages = "com.ezycollect.infrastructure.database.repository")
@EntityScan(basePackages = "com.ezycollect.infrastructure.database.entity")
@EnableRetry
@EnableAsync
public class EzyCollectApplication {

  public static void main(String[] args) {
    SpringApplication.run(EzyCollectApplication.class, args);
  }

}
