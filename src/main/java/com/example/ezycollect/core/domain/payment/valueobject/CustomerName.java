package com.example.ezycollect.core.domain.payment.valueobject;

public class CustomerName {
  private final String firstName;
  private final String lastName;

  public CustomerName(String firstName, String lastName) {
    this.firstName = firstName;
    this.lastName = lastName;
  }

  public String getFirstName() {
    return firstName;
  }

  public String getLastName() {
    return lastName;
  }
}
