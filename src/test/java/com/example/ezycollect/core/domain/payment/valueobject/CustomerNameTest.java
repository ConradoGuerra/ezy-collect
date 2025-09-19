package com.example.ezycollect.core.domain.payment.valueobject;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

import static org.assertj.core.api.Assertions.*;

@DisplayName("CustomerName Tests")
class CustomerNameTest {

  @Test
  @DisplayName("Should create CustomerName with valid names")
  void shouldCreateCustomerNameWithValidNames() {
    String firstName = "John";
    String lastName = "Doe";

    CustomerName customerName = new CustomerName(firstName, lastName);

    assertThat(customerName).isNotNull();
    assertThat(customerName.getFirstName()).isEqualTo("John");
    assertThat(customerName.getLastName()).isEqualTo("Doe");
  }
}
