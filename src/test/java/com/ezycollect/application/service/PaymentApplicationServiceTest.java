package com.ezycollect.application.service;

import com.ezycollect.application.dto.PaymentRequest;
import com.ezycollect.core.domain.payment.aggregate.PaymentAggregate;
import com.ezycollect.core.domain.payment.event.PaymentCreatedEvent;
import com.ezycollect.infrastructure.encryption.MostSimpleEncryptionService;
import com.ezycollect.infrastructure.publisher.SpringDomainEventPublisherAdapter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.Mockito.*;

@DisplayName("PaymentApplicationService Tests")
class PaymentApplicationServiceTest {

  private PaymentApplicationService paymentApplicationService;

  @Mock
  private SpringDomainEventPublisherAdapter mockEventPublisher;

  @BeforeEach
  void setUp() {
    MockitoAnnotations.openMocks(this);
    paymentApplicationService = new PaymentApplicationService(mockEventPublisher);
  }

  @Test
  @DisplayName("Should create payment and publish events successfully")
  void shouldCreatePaymentAndPublishEventsSuccessfully() {
    PaymentRequest request = new PaymentRequest("John", "Doe", "12345", "1234-5678-9012-3456");

    PaymentAggregate result = paymentApplicationService.createPayment(request);
    String encryptedCardNumber = new MostSimpleEncryptionService().encrypt(request.getCardNumber());

    assertThat(result).isNotNull();
    assertThat(result.getPayment()).isNotNull();
    assertThat(result.getPayment().getFirstName()).isEqualTo("John");
    assertThat(result.getPayment().getLastName()).isEqualTo("Doe");
    assertThat(result.getPayment().getZipCode()).isEqualTo("12345");
    assertThat(result.getPayment().getCardNumber()).isEqualTo(encryptedCardNumber);

    verify(mockEventPublisher, times(1)).publish(any(PaymentCreatedEvent.class));
  }
}
