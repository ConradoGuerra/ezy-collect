package com.ezycollect.core.domain.webhook.repository;

import com.ezycollect.core.domain.webhook.entity.Webhook;

public interface WebhookRepository {
  void save(Webhook webhook);
}
