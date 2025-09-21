package com.ezycollect.infrastructure.controller;

import com.ezycollect.application.dto.PaymentRequest;
import com.ezycollect.application.dto.PaymentResponse;
import com.ezycollect.application.service.PaymentApplicationService;
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
@RequestMapping("/api/payments")
@Tag(name = "Payment", description = "Payment management APIs")
public class PaymentController {

    private final PaymentApplicationService paymentApplicationService;

    public PaymentController(PaymentApplicationService paymentApplicationService) {
        this.paymentApplicationService = paymentApplicationService;
    }

    @PostMapping
    @Operation(summary = "Create a new payment", description = "Creates a payment with the provided details")
    @ApiResponses({
        @ApiResponse(responseCode = "201", description = "Payment created successfully",
            content = @Content(mediaType = "application/json",
                schema = @Schema(implementation = PaymentResponse.class))),
        @ApiResponse(responseCode = "400", description = "Invalid payment data provided",
            content = @Content(mediaType = "application/json",
                schema = @Schema(implementation = PaymentResponse.class)))
    })
    public ResponseEntity<PaymentResponse> createPayment(
            @Parameter(description = "Payment details", required = true)
            @RequestBody PaymentRequest paymentRequest) {
        try {
            paymentApplicationService.createPayment(paymentRequest);
            PaymentResponse response = new PaymentResponse("Payment created");
            return ResponseEntity.status(HttpStatus.CREATED).body(response);
        } catch (Exception e) {
            PaymentResponse response = new PaymentResponse("Unable to create a payment");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
        }
    }
}
