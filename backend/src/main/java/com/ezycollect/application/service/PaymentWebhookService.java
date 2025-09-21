package com.ezycollect.application.service;

import com.ezycollect.core.domain.payment.event.PaymentCreatedEvent;
import com.ezycollect.utils.JsonConverter;

import org.springframework.http.MediaType;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Recover;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;

import java.util.logging.Logger;

@Service
public class PaymentWebhookService {

  private static final Logger logger = Logger.getLogger(PaymentWebhookService.class.getName());
  private final RestTemplate restTemplate;

  public PaymentWebhookService(RestTemplate restTemplate) {
    this.restTemplate = restTemplate;
  }

  @Retryable(maxAttempts = 3, backoff = @Backoff(delay = 1000, multiplier = 2))
  public void sendWebhook(String url, PaymentCreatedEvent event) {
    String payload;
    try {
      payload = JsonConverter.toJson(event);
    } catch (Exception e) {
      logger.warning("Failed to serialize event to JSON: " + e.getMessage());
      return;
    }

    HttpHeaders headers = new HttpHeaders();
    headers.setContentType(MediaType.APPLICATION_JSON);
    HttpEntity<String> entity = new HttpEntity<>(payload, headers);
    logger.info("Sending POST request to webhook: " + url + ", body: " + payload);
    restTemplate.postForObject(url, entity, String.class);
  }

  @Recover
  public void recover(Exception ex, String url, Object requestBody) {
    logger.warning("Failed to POST after retries: " + ex.getMessage());
  }
}
