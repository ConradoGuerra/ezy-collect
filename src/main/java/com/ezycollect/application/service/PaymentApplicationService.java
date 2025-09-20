package com.ezycollect.application.service;

import com.ezycollect.application.dto.PaymentRequest;
import com.ezycollect.core.domain.payment.aggregate.PaymentAggregate;
import com.ezycollect.core.domain.payment.valueobject.CardNumber;
import com.ezycollect.core.domain.payment.valueobject.CustomerName;
import com.ezycollect.core.domain.payment.valueobject.ZipCode;
import com.ezycollect.infrastructure.publisher.SpringDomainEventPublisherAdapter;

public class PaymentApplicationService {
  private SpringDomainEventPublisherAdapter paymentEventPublisher;

  public PaymentApplicationService(SpringDomainEventPublisherAdapter paymentEventPublisher) {
    this.paymentEventPublisher = paymentEventPublisher;
  }

  public PaymentAggregate createPayment(PaymentRequest request) {
    CustomerName customerName = new CustomerName(request.getFirstName(), request.getLastName());
    ZipCode zipCode = new ZipCode(request.getZipCode());
    CardNumber cardNumber = new CardNumber(request.getCardNumber());
    PaymentAggregate paymentAggregate = PaymentAggregate.create(customerName, zipCode, cardNumber);

    paymentAggregate.getCreatedPaymentEvents()
        .forEach(event -> paymentEventPublisher.publish(event));

    return paymentAggregate;

  }
}
