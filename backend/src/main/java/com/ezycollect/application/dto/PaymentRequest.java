package com.ezycollect.application.dto;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Request DTO for creating a new payment")
public class PaymentRequest {
  @Schema(description = "First name of the cardholder", example = "John", required = true)
  private String firstName;
  @Schema(description = "Last name of the cardholder", example = "Doe", required = true)
  private String lastName;
  @Schema(description = "Zip code of the cardholder", example = "90210", required = true)
  private String zipCode;
  @Schema(description = "Credit card number", example = "1234-5678-9012-3456", required = true)
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
