package com.ezycollect.infrastructure.controller;

import com.ezycollect.application.dto.WebhookRequest;
import com.ezycollect.application.service.WebhookApplicationService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/webhooks")
@CrossOrigin(origins = "*")
public class WebhookController {
  private final WebhookApplicationService webhookApplicationService;

  public WebhookController(WebhookApplicationService webhookApplicationService) {
    this.webhookApplicationService = webhookApplicationService;
  }

  @PostMapping
  public ResponseEntity<String> createWebhook(@RequestBody WebhookRequest request) {
    webhookApplicationService.createUrl(request);
    return ResponseEntity.status(HttpStatus.CREATED).body("test");
  }

}
