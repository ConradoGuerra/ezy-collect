package com.ezycollect.core.domain.webhook.entity;

import java.util.UUID;

import com.ezycollect.core.domain.webhook.valueobject.URL;

public class Webhook {
  private UUID id;
  private URL url;

  public Webhook(URL url) {
    this.id = UUID.randomUUID();
    this.url = url;
  }

  public UUID getId() {
    return id;
  }

  public URL getUrl() {
    return url;
  }

}
