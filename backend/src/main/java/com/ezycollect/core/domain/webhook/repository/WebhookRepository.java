package com.ezycollect.core.domain.webhook.repository;

import java.util.List;

import com.ezycollect.core.domain.webhook.entity.Webhook;

public interface WebhookRepository {
  void save(Webhook webhook);
  List<Webhook> findWebhooks();
}
