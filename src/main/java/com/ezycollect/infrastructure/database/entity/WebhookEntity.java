package com.ezycollect.infrastructure.database.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.util.UUID;

@Entity
@Table(name = "webhooks")
public class WebhookEntity {

  @Id
  private UUID id;
  private String url;

  public WebhookEntity() {
  }

  public WebhookEntity(UUID id, String url) {
    this.id = id;
    this.url = url;
  }

  public UUID getId() {
    return id;
  }

  public String getUrl() {
    return url;
  }

}
