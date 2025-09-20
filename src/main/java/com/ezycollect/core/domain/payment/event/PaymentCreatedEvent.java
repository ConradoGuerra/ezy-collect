package com.ezycollect.core.domain.payment.event;

import java.time.LocalDateTime;

import com.ezycollect.core.domain.payment.entity.Payment;

public class PaymentCreatedEvent {
  private final Payment payment;
  private final LocalDateTime occurredOn;

  public PaymentCreatedEvent(Payment payment) {
    this.payment = payment;
    this.occurredOn = LocalDateTime.now();
  }

  public Payment getPayment() {
    return payment;
  }

  public LocalDateTime getOccurredOn() {
    return occurredOn;
  }
}
