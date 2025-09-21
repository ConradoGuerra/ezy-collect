package com.ezycollect.application.service;

import com.ezycollect.core.domain.payment.event.PaymentCreatedEvent;
import com.ezycollect.core.domain.webhook.entity.Webhook;
import com.ezycollect.core.domain.webhook.repository.WebhookRepository;

import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Logger;

@Service
public class PaymentEventObserver {

  private static final Logger logger = Logger.getLogger(PaymentEventObserver.class.getName());

  private final WebhookRepository webhookRepository;
  private final PaymentWebhookService webhookService;

  public PaymentEventObserver(WebhookRepository webhookRepository, PaymentWebhookService webhookService) {
    this.webhookRepository = webhookRepository;
    this.webhookService = webhookService;
  }

  @EventListener
  @Async
  public void handlePaymentCreatedEvent(PaymentCreatedEvent event) {
    List<Webhook> webhooks = webhookRepository.findWebhooks();
    logger.info("Found " + webhooks.size() + " webhooks to notify.");
    for (Webhook webhook : webhooks) {
      webhookService.sendWebhook(webhook.getUrl(), event);
    }
  }
}
