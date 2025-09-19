package com.example.ezycollect;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = { DataSourceAutoConfiguration.class })
public class EzyCollectApplication {

  public static void main(String[] args) {
    SpringApplication.run(EzyCollectApplication.class, args);
  }

}
