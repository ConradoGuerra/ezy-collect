package com.ezycollect.infrastructure.database.mapper;

import com.ezycollect.core.domain.payment.entity.Payment;
import com.ezycollect.infrastructure.database.entity.PaymentEntity;
import org.springframework.stereotype.Component;

@Component
public class PaymentMapper {

  public PaymentEntity toEntity(Payment payment) {
    return new PaymentEntity(
        payment.getId(),
        payment.getFirstName(),
        payment.getLastName(),
        payment.getZipCode(),
        payment.getCardNumber());
  }

}
