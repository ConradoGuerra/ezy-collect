package com.ezycollect;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = "com.ezycollect")
@EnableJpaRepositories(basePackages = "com.ezycollect.infrastructure.database.repository")
@EntityScan(basePackages = "com.ezycollect.infrastructure.database.entity")
public class EzyCollectApplication {

  public static void main(String[] args) {
    SpringApplication.run(EzyCollectApplication.class, args);
  }

}
