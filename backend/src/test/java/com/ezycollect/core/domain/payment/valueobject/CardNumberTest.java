package com.ezycollect.core.domain.payment.valueobject;

import org.junit.jupiter.api.Test;

import com.ezycollect.infrastructure.encryption.MostSimpleEncryptionService;

import org.junit.jupiter.api.DisplayName;

import static org.assertj.core.api.Assertions.*;

@DisplayName("CardNumber Tests")
class CardNumberTest {

  @Test
  @DisplayName("Should create a CardNumber already encrypted")
  void shouldCreateCardNumberEncrypted() {

    String numberOfACard = "1234-1234-1234-1234";
    CardNumber cardNumber = new CardNumber(numberOfACard);

    MostSimpleEncryptionService encryptionService = new MostSimpleEncryptionService();
    String cardEncrypted = encryptionService.encrypt(numberOfACard);

    assertThat(cardNumber.getNumber()).isEqualTo(cardEncrypted);
  }
}
