# ezyCollect

This is a simple application to manage payments and webhooks.

## Project Structure

The project is divided into two main parts:

- **backend**: A Spring Boot application that handles the business logic, data storage, and API endpoints.
- **frontend**: A Next.js application that provides a user interface for interacting with the backend.

## Backend

### Description

The backend is a Spring Boot application responsible for handling payment processing and webhook management.  
For more information, check the [backend README](./backend/README.md).

> To be able to receive the notifications from the webhook, follow the instructions below:
>
> When testing locally **without Docker**, create the webhooks URL as `http://localhost:<port>`.
> When testing **with the containers running**, create the webhooks URL as `http://host.docker.internal:<port>`.

### Technologies Used

- Java 17
- Spring Boot
- Maven
- PostgreSQL
- Flyway (database migrations)

### Requirements

- Java Development Kit (JDK) 17 or higher
- Apache Maven

## Frontend

### Description

The frontend is a Next.js application that provides a user interface to interact with the EzyCollect backend services.  
For more information, check the [frontend README](./frontend/README.md).

### Technologies Used

- Next.js
- React
- TypeScript
- npm

### Requirements

- Node.js (LTS version recommended)
- npm

## Requirements

To run this application, ensure you have Docker installed on your system.

## Launch

1.  **Launch the application**:  
    Navigate to the root directory of the project (where `docker-compose.yaml` is located) and run:

    ```bash
    docker compose up -d
    ```

2.  **Access the application**:
    - **Frontend**: Once the services are up, you can access the frontend application in your browser at `http://localhost:3000`.
    - **Backend**: The backend API will be available at `http://localhost:8080`.

## Improvements to be made:

1.  **Validations to Value Objects**: Implement a better validation mechanisms within value objects to ensure data integrity at the core domain level.
2.  **Change Uniqueness at Tables Payments and Webhooks**: Modify the uniqueness constraints in the `payments` and `webhooks` tables to allow for single webhooks and single payers with the same card, ensuring proper handling of these entities.
3.  **Manage Better Errors and Status Codes and Messages**: Enhance error handling across the application, providing more descriptive error messages and appropriate HTTP status codes for better API communication and debugging.
4.  **Observability**: Implement comprehensive logging and tracing to have better monitoring and debugging.
5.  **Tests**: Improve tests coverage to 100% and creation of integration (databases, controllers) and e2e tests.
6.  **Front-end**: Basically refactor all the front-end, including README, which is currently too simple and does not have any test.
