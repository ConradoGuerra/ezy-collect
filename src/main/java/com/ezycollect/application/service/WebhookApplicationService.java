package com.ezycollect.application.service;

import org.springframework.stereotype.Service;

import com.ezycollect.application.dto.WebhookRequest;
import com.ezycollect.core.domain.webhook.entity.Webhook;
import com.ezycollect.core.domain.webhook.repository.WebhookRepository;
import com.ezycollect.core.domain.webhook.valueobject.URL;

@Service
public class WebhookApplicationService {

  private final WebhookRepository webhookRepository;

  public WebhookApplicationService(WebhookRepository webhookRepository) {
    this.webhookRepository = webhookRepository;
  }

  public void createUrl(WebhookRequest webhookRequest) {
    URL url = new URL(webhookRequest.getUrl());
    Webhook webhook = new Webhook(url);
    webhookRepository.save(webhook);
  }
}
