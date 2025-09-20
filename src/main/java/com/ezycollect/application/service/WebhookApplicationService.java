package com.ezycollect.application.service;

import org.springframework.stereotype.Service;

import com.ezycollect.application.dto.WebhookRequest;
import com.ezycollect.core.domain.webhook.entity.Webhook;
import com.ezycollect.core.domain.webhook.valueobject.URL;

@Service
public class WebhookApplicationService {
  public void createUrl(WebhookRequest webhookRequest) {
    URL url = new URL(webhookRequest.getUrl());
    new Webhook(url);
    System.out.println(url);

  }
}
