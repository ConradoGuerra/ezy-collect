package com.ezycollect.infrastructure.database.repository;

import com.ezycollect.core.domain.webhook.entity.Webhook;
import com.ezycollect.core.domain.webhook.repository.WebhookRepository;
import com.ezycollect.infrastructure.database.mapper.WebhookMapper;
import org.springframework.stereotype.Component;

@Component
public class WebhookRepositoryJPA implements WebhookRepository {

  private final JpaWebhookRepository jpaWebhookRepository;
  private final WebhookMapper webhookMapper;

  public WebhookRepositoryJPA(JpaWebhookRepository jpaWebhookRepository, WebhookMapper webhookMapper) {
    this.jpaWebhookRepository = jpaWebhookRepository;
    this.webhookMapper = webhookMapper;
  }

  @Override
  public void save(Webhook webhook) {
    var webhookEntity = webhookMapper.toEntity(webhook);
    jpaWebhookRepository.save(webhookEntity);
  }
}
