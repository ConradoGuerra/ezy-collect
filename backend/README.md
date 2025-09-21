# EzyCollect Backend Service

This project provides a backend service for managing payments and webhooks.

## How to Run

This is a Maven project. You can run the application using the following command:

```bash
./mvn spring-boot:run
```

The application will start on port `8080`.

## OpenAPI Specification

The API endpoints are documented below. The base URL for the API is `http://localhost:8080`. You can access the Swagger UI at `http://localhost:8080/swagger-ui`.

### Payment Endpoints

**Create Payment**

- `POST /api/payments`
  - **Description:** Creates a new payment. After creating a payment, all registered webhooks will be notified.
  - **Request Body Example (PaymentRequest):**
    ```json
    {
      "firstName": "John",
      "lastName": "Doe",
      "cardNumber": "1234-5678-9012-3456",
      "zipCode": "2000"
    }
    ```
  - **Response Body Example (PaymentResponse):**
    ```json
    {
      "message": "Payment created"
    }
    ```

### Webhook Endpoints

**Create Webhook**

- `POST /api/webhooks`
  - **Description:** Registers a new webhook to receive payment notifications.
  - **Request Body Example (WebhookRequest):**
    ```json
    {
      "url": "https://example.com/webhook-listener"
    }
    ```
  - **Response Body Example (WebhookResponse):**
    ```json
    {
      "message": "Webhook created"
    }
    ```

