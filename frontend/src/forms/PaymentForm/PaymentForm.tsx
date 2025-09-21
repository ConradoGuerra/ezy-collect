"use client";

import { useState, FormEvent } from "react";
import styles from "../../app/page.module.css";

interface PaymentData {
  firstName: string;
  lastName: string;
  zipCode: string;
  cardNumber: string;
}

const PaymentForm = () => {
  const [firstName, setFirstName] = useState<string>("");
  const [lastName, setLastName] = useState<string>("");
  const [zipCode, setZipCode] = useState<string>("");
  const [cardNumber, setCardNumber] = useState<string>("");

  const handleSubmit = async (e: FormEvent) => {
    e.preventDefault();
    const paymentData: PaymentData = {
      firstName,
      lastName,
      zipCode,
      cardNumber,
    };

    try {
      const response = await fetch("http://localhost:8080/api/payments", {
        method: "POST",
        headers: {
          "Content-Type": "application/json",
        },
        body: JSON.stringify(paymentData),
      });

      if (response.ok) {
        setFirstName("");
        setLastName("");
        setZipCode("");
        setCardNumber("");
        alert("Payment created successfully!");
      } else {
        alert("Failed to create payment.");
      }
    } catch (error) {
      console.error("Error creating payment:", error);
      alert("Error creating payment.");
    }
  };

  return (
    <form onSubmit={handleSubmit} className={styles.formContainer}>
      <h2>Create Payment</h2>
      <input
        type="text"
        value={firstName}
        onChange={(e) => setFirstName(e.target.value)}
        placeholder="First Name"
        required
        className={styles.formInput}
      />
      <input
        type="text"
        value={lastName}
        onChange={(e) => setLastName(e.target.value)}
        placeholder="Last Name"
        required
        className={styles.formInput}
      />
      <input
        type="text"
        value={zipCode}
        onChange={(e) => setZipCode(e.target.value)}
        placeholder="Zip Code"
        required
        className={styles.formInput}
      />
      <input
        type="text"
        value={cardNumber}
        onChange={(e) => setCardNumber(e.target.value)}
        placeholder="Card Number"
        required
        className={styles.formInput}
      />
      <button type="submit" className={styles.formButton}>
        Create Payment
      </button>
    </form>
  );
};

export default PaymentForm;
