
package com.ezycollect.core.domain.payment.entity;

import org.junit.jupiter.api.Test;

import com.ezycollect.core.domain.payment.valueobject.CardNumber;
import com.ezycollect.core.domain.payment.valueobject.CustomerName;
import com.ezycollect.core.domain.payment.valueobject.ZipCode;
import com.ezycollect.infrastructure.encryption.MostSimpleEncryptionService;

import org.junit.jupiter.api.DisplayName;

import static org.assertj.core.api.Assertions.*;

import java.util.UUID;

@DisplayName("PaymentEntity Tests")
class PaymentEntityTest {

  @Test
  @DisplayName("Should create a PaymentEntity")
  void shouldCreatePaymentEntity() {

    String firstName = "John";
    String lastName = "Doe";
    CustomerName customerName = new CustomerName(firstName, lastName);

    ZipCode zipCode = new ZipCode("75200");
    String numberOfACard = "1234-1234-1234-1234";

    CardNumber cardNumber = new CardNumber(numberOfACard);
    MostSimpleEncryptionService encryptionService = new MostSimpleEncryptionService();
    String cardEncrypted = encryptionService.encrypt(numberOfACard);

    Payment payment = new Payment(customerName, zipCode, cardNumber);

    assertThat(payment.getId()).isInstanceOf(UUID.class);
    assertThat(payment.getFirstName()).isEqualTo(firstName);
    assertThat(payment.getLastName()).isEqualTo(lastName);
    assertThat(payment.getZipCode()).isEqualTo("75200");
    assertThat(payment.getCardNumber()).isEqualTo(cardEncrypted);
  }
}
