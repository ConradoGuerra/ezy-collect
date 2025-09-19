package com.example.ezycollect.core.domain.payment.valueobject;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

import static org.assertj.core.api.Assertions.*;

@DisplayName("ZipCode Tests")
class ZipCodeTest {

  @Test
  @DisplayName("Should create a ZipCode with the expected value")
  void shouldCreateZipCode() {

    ZipCode zipCode = new ZipCode("75200");

    assertThat(zipCode).isNotNull();
    assertThat(zipCode.getValue()).isEqualTo("75200");
  }
}
