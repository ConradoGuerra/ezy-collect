package com.ezycollect.core.domain.payment.aggregate;

import com.ezycollect.core.domain.payment.entity.Payment;
import com.ezycollect.core.domain.payment.event.PaymentCreatedEvent;
import com.ezycollect.core.domain.payment.valueobject.CardNumber;
import com.ezycollect.core.domain.payment.valueobject.CustomerName;
import com.ezycollect.core.domain.payment.valueobject.ZipCode;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

@DisplayName("PaymentAggregate Tests")
class PaymentAggregateTest {

  @Test
  @DisplayName("Should create a PaymentAggregate with correct payment")
  void shouldCreatePaymentAggregateWithCorrectPayment() {
    String firstName = "John";
    String lastName = "Doe";
    CustomerName customerName = new CustomerName(firstName, lastName);
    ZipCode zipCode = new ZipCode("75200");
    CardNumber cardNumber = new CardNumber("1234-1234-1234-1234");

    PaymentAggregate paymentAggregate = PaymentAggregate.create(customerName, zipCode, cardNumber);

    assertThat(paymentAggregate).isNotNull();
    assertThat(paymentAggregate.getPayment()).isNotNull();

    Payment payment = paymentAggregate.getPayment();
    assertThat(payment.getFirstName()).isEqualTo(firstName);
    assertThat(payment.getLastName()).isEqualTo(lastName);
    assertThat(payment.getZipCode()).isEqualTo("75200");
    assertThat(payment.getCardNumber()).isNotNull();
  }

  @Test
  @DisplayName("Should maintain immutability of created aggregate")
  void shouldMaintainImmutabilityOfCreatedAggregate() {
    CustomerName customerName = new CustomerName("Alice", "Johnson");
    ZipCode zipCode = new ZipCode("54321");
    CardNumber cardNumber = new CardNumber("9876-5432-1098-7654");

    PaymentAggregate paymentAggregate = PaymentAggregate.create(customerName, zipCode, cardNumber);

    Payment payment1 = paymentAggregate.getPayment();
    Payment payment2 = paymentAggregate.getPayment();

    assertThat(payment1).isSameAs(payment2);
  }

  @Test
  @DisplayName("Should create an event after creating a payment")
  void shouldCreateEventAfterCreatingPayment() {
    CustomerName customerName = new CustomerName("Alice", "Johnson");
    ZipCode zipCode = new ZipCode("54321");
    CardNumber cardNumber = new CardNumber("9876-5432-1098-7654");

    PaymentAggregate paymentAggregate = PaymentAggregate.create(customerName, zipCode, cardNumber);

    List<PaymentCreatedEvent> paymentCreatedEvents = paymentAggregate.getCreatedPaymentEvents();

    PaymentCreatedEvent actualEvent = paymentCreatedEvents.get(0);
    Payment actualPayment = actualEvent.getPayment();

    assertThat(actualPayment.getFirstName()).isEqualTo(customerName.getFirstName());
    assertThat(actualPayment.getLastName()).isEqualTo(customerName.getLastName());
    assertThat(actualPayment.getZipCode()).isEqualTo(zipCode.getValue());
    assertThat(actualPayment.getCardNumber()).isEqualTo(cardNumber.getNumber());
  }
}
