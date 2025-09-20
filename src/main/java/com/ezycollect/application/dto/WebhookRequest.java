package com.ezycollect.application.dto;

public class WebhookRequest {
  private String url;

  public WebhookRequest(String url) {
    this.url = url;
  }

  public String getUrl() {
    return url;
  }

}
