package com.ezycollect.infrastructure.publisher;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.stereotype.Component;

import com.ezycollect.core.domain.port.DomainEventPublisherPort;

import java.util.logging.Logger;

@Component
public class SpringDomainEventPublisherAdapter implements DomainEventPublisherPort, ApplicationEventPublisherAware {
  private static final Logger logger = Logger.getLogger(SpringDomainEventPublisherAdapter.class.getName());
  private ApplicationEventPublisher eventPublisher;

  @Override
  public void setApplicationEventPublisher(ApplicationEventPublisher eventPublisher) {
    this.eventPublisher = eventPublisher;
  }

  @Override
  public void publish(Object event) {
    if (eventPublisher != null) {
      logger.info("Publishing domain event: " + event.getClass().getSimpleName());
      eventPublisher.publishEvent(event);
    } else {
      logger.warning("Event publisher not initialized, cannot publish event: " + event.getClass().getSimpleName());
    }
  }
}
