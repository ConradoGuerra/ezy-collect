package com.ezycollect.core.domain.payment.valueobject;

import com.ezycollect.infrastructure.encryption.MostSimpleEncryptionService;

public class CardNumber {
  private final String number;

  public CardNumber(String number) {
    MostSimpleEncryptionService encryptionService = new MostSimpleEncryptionService();
    this.number = encryptionService.encrypt(number);
  }

  public String getNumber() {
    return number;
  }

}
