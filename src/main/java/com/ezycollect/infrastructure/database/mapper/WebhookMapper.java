package com.ezycollect.infrastructure.database.mapper;

import com.ezycollect.core.domain.webhook.entity.Webhook;
import com.ezycollect.infrastructure.database.entity.WebhookEntity;
import org.springframework.stereotype.Component;

@Component
public class WebhookMapper {

  public WebhookEntity toEntity(Webhook webhook) {
    return new WebhookEntity(
        webhook.getId(),
        webhook.getUrl());
  }

}
