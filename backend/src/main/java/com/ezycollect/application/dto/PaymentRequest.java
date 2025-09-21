package com.ezycollect.application.dto;

public class PaymentRequest {
  private String firstName;
  private String lastName;
  private String zipCode;
  private String cardNumber;

  public PaymentRequest(String firstName, String lastName, String zipCode, String cardNumber) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.zipCode = zipCode;
    this.cardNumber = cardNumber;
  }

  public String getFirstName() {
    return firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public String getZipCode() {
    return zipCode;
  }

  public String getCardNumber() {
    return cardNumber;
  }
}
