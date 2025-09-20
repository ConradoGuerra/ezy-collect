package com.ezycollect.infrastructure.database.entity;

import jakarta.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "payments")
public class PaymentEntity {

  @Id
  @Column(name = "id", updatable = false, nullable = false)
  private UUID id;

  @Column(name = "first_name", nullable = false, length = 50)
  private String firstName;

  @Column(name = "last_name", nullable = false, length = 50)
  private String lastName;

  @Column(name = "zip_code", nullable = false, length = 10)
  private String zipCode;

  @Column(name = "card_number", nullable = false, length = 20)
  private String cardNumber;

  public PaymentEntity() {
  }

  public PaymentEntity(UUID id, String firstName, String lastName, String zipCode, String cardNumber) {
    this.id = id;
    this.firstName = firstName;
    this.lastName = lastName;
    this.zipCode = zipCode;
    this.cardNumber = cardNumber;
  }

  public UUID getId() {
    return id;
  }

  public String getFirstName() {
    return firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public String getZipCode() {
    return zipCode;
  }

  public String getCardNumber() {
    return cardNumber;
  }

}
