# EzyCollect Project

This repository contains both the backend and frontend components of the EzyCollect application.

## Project Structure

- `backend/`: Contains the Spring Boot backend application.
- `frontend/`: Contains the Next.js frontend application.

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
