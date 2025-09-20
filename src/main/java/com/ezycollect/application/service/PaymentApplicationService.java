package com.ezycollect.application.service;

import org.springframework.stereotype.Service;

import com.ezycollect.application.dto.PaymentRequest;
import com.ezycollect.core.domain.payment.aggregate.PaymentAggregate;
import com.ezycollect.core.domain.payment.valueobject.CardNumber;
import com.ezycollect.core.domain.payment.valueobject.CustomerName;
import com.ezycollect.core.domain.payment.valueobject.ZipCode;
import com.ezycollect.infrastructure.database.entity.PaymentEntity;
import com.ezycollect.infrastructure.database.mapper.PaymentMapper;
import com.ezycollect.infrastructure.database.repository.PaymentRepository;
import com.ezycollect.infrastructure.publisher.SpringDomainEventPublisherAdapter;

@Service
public class PaymentApplicationService {
  private SpringDomainEventPublisherAdapter paymentEventPublisher;
  private PaymentRepository paymentRepository;

  public PaymentApplicationService(SpringDomainEventPublisherAdapter paymentEventPublisher,
      PaymentRepository paymentRepository) {
    this.paymentEventPublisher = paymentEventPublisher;
    this.paymentRepository = paymentRepository;
  }

  public PaymentAggregate createPayment(PaymentRequest request) {
    CustomerName customerName = new CustomerName(request.getFirstName(), request.getLastName());
    ZipCode zipCode = new ZipCode(request.getZipCode());
    CardNumber cardNumber = new CardNumber(request.getCardNumber());
    PaymentAggregate paymentAggregate = PaymentAggregate.create(customerName, zipCode, cardNumber);

    PaymentEntity paymentDTO = new PaymentMapper().toEntity(paymentAggregate.getPayment());

    paymentRepository.save(paymentDTO);
    paymentAggregate.getCreatedPaymentEvents()
        .forEach(event -> paymentEventPublisher.publish(event));

    return paymentAggregate;

  }
}
