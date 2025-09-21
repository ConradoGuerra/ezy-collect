package com.ezycollect.core.domain.payment.aggregate;

import java.util.ArrayList;
import java.util.List;

import com.ezycollect.core.domain.payment.entity.Payment;
import com.ezycollect.core.domain.payment.event.PaymentCreatedEvent;
import com.ezycollect.core.domain.payment.valueobject.CardNumber;
import com.ezycollect.core.domain.payment.valueobject.CustomerName;
import com.ezycollect.core.domain.payment.valueobject.ZipCode;

public class PaymentAggregate {
  private final Payment payment;
  private final List<PaymentCreatedEvent> createdPaymentEvents = new ArrayList<>();

  private PaymentAggregate(Payment payment) {
    this.payment = payment;
  }

  public static PaymentAggregate create(
      CustomerName customerName,
      ZipCode zipCode,
      CardNumber cardNumber) {

    Payment payment = new Payment(customerName, zipCode, cardNumber);
    PaymentAggregate aggregate = new PaymentAggregate(payment);
    aggregate.addPaymentCreatedEvent(payment);
    return aggregate;
  }

  public Payment getPayment() {
    return payment;
  }

  public List<PaymentCreatedEvent> getCreatedPaymentEvents() {
    return new ArrayList<>(createdPaymentEvents);
  }

  private void addPaymentCreatedEvent(Payment payment) {
    PaymentCreatedEvent paymentCreatedEvent = new PaymentCreatedEvent(payment);
    this.createdPaymentEvents.add(paymentCreatedEvent);
  }
}
