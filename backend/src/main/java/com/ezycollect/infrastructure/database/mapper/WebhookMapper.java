package com.ezycollect.infrastructure.database.mapper;

import com.ezycollect.core.domain.webhook.entity.Webhook;
import com.ezycollect.core.domain.webhook.valueobject.URL;
import com.ezycollect.infrastructure.database.entity.WebhookEntity;
import org.springframework.stereotype.Component;

@Component
public class WebhookMapper {

  public WebhookEntity toEntity(Webhook webhook) {
    System.out.println(webhook.getId());
    return new WebhookEntity(
        webhook.getId(),
        webhook.getUrl());
  }

  public Webhook toDomain(WebhookEntity webhookEntity) {
    return new Webhook(webhookEntity.getId(), new URL(webhookEntity.getUrl()));
  }

}
