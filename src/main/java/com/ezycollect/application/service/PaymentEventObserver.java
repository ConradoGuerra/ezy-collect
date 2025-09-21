package com.ezycollect.application.service;

import com.ezycollect.core.domain.payment.event.PaymentCreatedEvent;
import com.ezycollect.core.domain.webhook.entity.Webhook;
import com.ezycollect.core.domain.webhook.repository.WebhookRepository;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Logger;

@Service
public class PaymentEventObserver {

  private static final Logger logger = Logger.getLogger(PaymentEventObserver.class.getName());

  private final WebhookRepository webhookRepository;

  public PaymentEventObserver(WebhookRepository webhookRepository) {
    this.webhookRepository = webhookRepository;
  }

  @EventListener
  public void handlePaymentCreatedEvent(PaymentCreatedEvent event) {
    List<Webhook> webhooks = webhookRepository.findWebhooks();
    logger.info("Found " + webhooks.size() + " webhooks to notify.");
    for (Webhook webhook : webhooks) {
      try {
        logger.info("Sending event to webhook: " + webhook.getUrl() + " with payload: " + event.getPayment().getId());
      } catch (Exception e) {
        logger.warning("Failed to send event to webhook: " + webhook.getUrl() + " - " + e.getMessage());
      }
    }
  }
}
