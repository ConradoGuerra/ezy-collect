package com.ezycollect.application.dto;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Request DTO for creating a new webhook")
public class WebhookRequest {
  @Schema(description = "URL for the webhook", example = "https://example.com/webhook", required = true)
  private String url;

  public WebhookRequest(String url) {
    this.url = url;
  }

  public String getUrl() {
    return url;
  }

}
