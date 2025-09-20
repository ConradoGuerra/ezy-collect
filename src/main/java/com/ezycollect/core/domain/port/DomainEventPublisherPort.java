package com.ezycollect.core.domain.port;

public interface DomainEventPublisherPort {
  void publish(Object event);
}
