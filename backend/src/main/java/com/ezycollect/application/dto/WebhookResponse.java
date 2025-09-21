package com.ezycollect.application.dto;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Response DTO for webhook operations")
public class WebhookResponse {
  private String message;

  public WebhookResponse(String message) {
    this.message = message;
  }

  public String getMessage() {
    return message;
  }

}
