package com.ezycollect.infrastructure.config;

import com.ezycollect.application.service.PaymentApplicationService;
import com.ezycollect.infrastructure.publisher.SpringDomainEventPublisherAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PaymentConfig {

  @Bean
  public PaymentApplicationService paymentApplicationService(SpringDomainEventPublisherAdapter publisher) {
    return new PaymentApplicationService(publisher);
  }
}
