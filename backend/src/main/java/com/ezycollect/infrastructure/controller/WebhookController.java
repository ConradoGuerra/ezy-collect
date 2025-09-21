package com.ezycollect.infrastructure.controller;

import com.ezycollect.application.dto.WebhookRequest;
import com.ezycollect.application.dto.WebhookResponse;
import com.ezycollect.application.service.WebhookApplicationService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/webhooks")
@Tag(name = "Webhook", description = "Webhook management APIs")
public class WebhookController {
  private final WebhookApplicationService webhookApplicationService;

  public WebhookController(WebhookApplicationService webhookApplicationService) {
    this.webhookApplicationService = webhookApplicationService;
  }

  @PostMapping
  @Operation(summary = "Create a new webhook", description = "Registers a new webhook URL for receiving payment events")
  @ApiResponses({
      @ApiResponse(responseCode = "201", description = "Webhook created successfully", content = @Content(mediaType = "application/json", schema = @Schema(implementation = String.class))),
      @ApiResponse(responseCode = "400", description = "Invalid webhook data provided", content = @Content(mediaType = "application/json", schema = @Schema(implementation = String.class))),
      @ApiResponse(responseCode = "500", description = "Internal server error", content = @Content(mediaType = "application/json", schema = @Schema(implementation = String.class)))
  })
  public ResponseEntity<WebhookResponse> createWebhook(
      @Parameter(description = "Webhook configuration details", required = true) @RequestBody WebhookRequest request) {
    try {
      webhookApplicationService.createUrl(request);

      WebhookResponse response = new WebhookResponse("Webhook created");
      return ResponseEntity.status(HttpStatus.CREATED).body(response);
    } catch (Exception e) {
      WebhookResponse response = new WebhookResponse("Failed to create webhook: " + e.getMessage());
      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
          .body(response);
    }
  }
}
