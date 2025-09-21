package com.ezycollect.application.dto;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Response DTO for payment operations")
public class PaymentResponse {
  @Schema(description = "A message indicating the result of the payment operation", example = "Payment created")
  private String message;

  public PaymentResponse(String message) {
    this.message = message;
  }

  public String getMessage() {
    return message;
  }

}
