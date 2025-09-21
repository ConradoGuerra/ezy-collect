# ezyCollect

This is a simple application to manage payments and webhooks.

## Project Structure

The project is divided into two main parts:

- **backend**: A Spring Boot application that handles the business logic, data storage, and API endpoints.
- **frontend**: A Next.js application that provides a user interface for interacting with the backend.

## Getting Started with Docker Compose

To run this application using Docker Compose, ensure you have Docker installed on your system.

1.  **Prerequisites**:
    - Docker Desktop (or Docker Engine) installed and running.

2.  **Launch the application**:
    Navigate to the root directory of the project (where `docker-compose.yaml` is located) and run:

    ```bash
    docker compose up -d
    ```

3.  **Access the application**:
    - **Frontend**: Once the services are up, you can access the frontend application in your browser at `http://localhost:3000`.
    - **Backend**: The backend API will be available at `http://localhost:8080`.

## Backend

### Description

The backend is a Spring Boot application responsible for handling payment processing and webhook management.

### Technologies Used

- Java 17
- Spring Boot
- Maven
- PostgreSQL
- Flyway (database migrations)

### How to Launch

1.  Navigate to the `backend/` directory: `cd backend`
2.  Build the project: `mvn clean install`
3.  Run the application: `mvn spring-boot:run`

### Requirements

- Java Development Kit (JDK) 17 or higher
- Apache Maven

## Frontend

### Description

The frontend is a Next.js application that provides a user interface to interact with the EzyCollect backend services.

### Technologies Used

- Next.js
- React
- TypeScript
- npm

### How to Launch

1.  Navigate to the `frontend/` directory: `cd frontend`
2.  Install dependencies: `npm install`
3.  Build the project: `npm run build`
4.  Start the application: `npm start`

### Requirements

- Node.js (LTS version recommended)
- npm

## Overall Project Launch

To run the complete EzyCollect application, you need to launch both the backend and frontend services separately as described above. Ensure the backend is running before accessing the frontend, as the frontend will communicate with the backend API.
