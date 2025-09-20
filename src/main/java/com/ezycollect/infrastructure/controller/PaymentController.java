package com.ezycollect.infrastructure.controller;

import com.ezycollect.application.dto.PaymentRequest;
import com.ezycollect.application.dto.PaymentResponse;
import com.ezycollect.application.service.PaymentApplicationService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/payments")
@CrossOrigin(origins = "*") // Configure appropriately for your environment
public class PaymentController {

  private final PaymentApplicationService paymentApplicationService;

  public PaymentController(PaymentApplicationService paymentApplicationService) {
    this.paymentApplicationService = paymentApplicationService;
  }

  @PostMapping
  public ResponseEntity<PaymentResponse> createPayment(@RequestBody PaymentRequest paymentRequest) {
    try {
      paymentApplicationService.createPayment(paymentRequest);

      PaymentResponse response = new PaymentResponse("Payment created");
      return ResponseEntity.status(HttpStatus.CREATED).body(response);
    } catch (Exception e) {
      PaymentResponse response = new PaymentResponse("Unable to create a payment");
      return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }
  }

  @GetMapping("/health")
  public ResponseEntity<String> healthCheck() {
    return ResponseEntity.ok("Payment service is running");
  }
}
