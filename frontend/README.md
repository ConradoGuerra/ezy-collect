# EzyCollect Frontend Application

This document provides an overview of the EzyCollect Frontend application.

## Prerequisites

- Node.js (LTS version recommended)
- npm (usually comes with Node.js)

## Installation

1.  Install the dependencies:
    ```bash
    npm install
    ```

## Running the Application

To start the development server:

```bash
npm run dev
```

The application will be accessible at `http://localhost:3000`.

## Key Features and Components

The frontend application provides the following main functionalities:

- **Payment Form (`src/forms/PaymentForm/PaymentForm.tsx`)**:
  This component allows users to submit payment requests. It captures necessary payment details and interacts with the backend API to process payments.

- **Webhook Form (`src/forms/WebhookForm/WebhookForm.tsx`)**:
  This component enables users to register webhook URLs. It sends the provided URL to the backend, which then configures the system to send notifications to that endpoint upon certain events.

