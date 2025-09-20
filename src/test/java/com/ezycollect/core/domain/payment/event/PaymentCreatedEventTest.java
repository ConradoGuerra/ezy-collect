package com.ezycollect.core.domain.payment.event;

import com.ezycollect.core.domain.payment.valueobject.CustomerName;
import com.ezycollect.core.domain.payment.valueobject.ZipCode;
import com.ezycollect.core.domain.payment.valueobject.CardNumber;
import com.ezycollect.core.domain.payment.entity.Payment;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

import static org.assertj.core.api.Assertions.*;

@DisplayName("PaymentCreatedEvent Tests")
class PaymentCreatedEventTest {

  @Test
  @DisplayName("Should create a PaymentCreatedEvent with correct values")
  void shouldCreatePaymentCreatedEventWithCorrectValues() {
    String firstName = "John";
    String lastName = "Doe";
    CustomerName customerName = new CustomerName(firstName, lastName);
    ZipCode zipCode = new ZipCode("75200");
    CardNumber cardNumber = new CardNumber("1234-1234-1234-1234");
    Payment payment = new Payment(customerName, zipCode, cardNumber);

    PaymentCreatedEvent event = new PaymentCreatedEvent(payment);

    assertThat(event.getPayment().getId()).isNotNull();
    assertThat(event.getPayment().getFirstName()).isEqualTo(firstName);
    assertThat(event.getPayment().getLastName()).isEqualTo(lastName);
    assertThat(event.getPayment().getZipCode()).isEqualTo("75200");
    assertThat(event.getOccurredOn()).isNotNull();
  }

}
