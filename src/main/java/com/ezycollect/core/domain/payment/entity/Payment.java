
package com.ezycollect.core.domain.payment.entity;

import java.util.UUID;

import com.ezycollect.core.domain.payment.valueobject.CardNumber;
import com.ezycollect.core.domain.payment.valueobject.CustomerName;
import com.ezycollect.core.domain.payment.valueobject.ZipCode;

class Payment {
  private final UUID id;
  private final CustomerName customerName;
  private final ZipCode zipCode;
  private final CardNumber cardNumber;

  public Payment(CustomerName customerName, ZipCode zipCode, CardNumber cardNumber) {
    this.id = UUID.randomUUID();
    this.customerName = customerName;
    this.zipCode = zipCode;
    this.cardNumber = cardNumber;

  }

  public UUID getId() {
    return id;
  }

  public String getFirstName() {
    return customerName.getFirstName();
  }

  public String getLastName() {
    return customerName.getLastName();
  }

  public String getZipCode() {
    return zipCode.getValue();
  }

  public String getCardNumber() {
    return cardNumber.getNumber();
  }

}
