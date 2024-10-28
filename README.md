# IoT Device Management Dashboard

This project is an IoT Device Management Dashboard developed with Java and Spring Boot. It provides a RESTful API to manage IoT devices and user reviews, including functionalities for adding, updating, deleting, and listing devices and users. The application is designed to showcase backend skills with Spring Boot, JPA, and basic CRUD operations.

## Project Structure

The project consists of the following main components:

- **Models**: The primary entities representing users, IoT devices, and reviews.
- **Repositories**: Interfaces extending JPA repositories for database interactions.
- **Services**: Business logic layer that handles the core functionalities of each entity.
- **Controllers**: RESTful APIs for interacting with the application.

## Technologies Used

- **Java 17**: The core programming language.
- **Spring Boot**: For building the application and structuring the project.
- **Spring Data JPA**: To interact with the database using JPA repositories.
- **Lombok**: To reduce boilerplate code.
- **JUnit & Mockito**: For testing the service layer.
- **H2 / PostgreSQL (Configurable)**: Database setup can be configured to work with either H2 for testing or PostgreSQL for production.

## Modules Overview

### 1. User

- **Model**: `User` - Represents a user with properties such as id, name, email, password, role, and status. Each user can have multiple reviews associated with them.
- **Repository**: `UserRepository` - Provides methods for CRUD operations and custom queries, such as `findByEmail`.
- **Service**: `UserService` - Handles business logic for user management, including methods to add, delete, update, and list users.
- **Controller**: `UserController` - REST API for user management, with endpoints for fetching users.

### 2. IoTDevice

- **Model**: `IoTDevice` - Represents an IoT device with properties such as id, type, status, and a relationship with a User.
- **Repository**: `IoTDeviceRepository` - Provides methods for CRUD operations and custom queries, such as `findByType` and `findByStatus`.
- **Service**: `IoTDeviceService` - Handles business logic for device management, including methods to add, delete, update, and list devices.
- **Controller**: (Optional) - REST API endpoints can be created to manage devices if needed.

### 3. Review

- **Model**: `Review` - Represents a review associated with a user, with properties like id, content, rating, and createdAt timestamp.
- **Relationship**: Linked with `User` as each review belongs to a single user.

## REST API Endpoints

### User Endpoints

- `GET /users`: Retrieve a list of all users.
- `POST /users`: Add a new user (currently handled in the service layer).
- `DELETE /users/{id}`: Delete a user by ID.
- `PUT /users/{id}`: Update a user by ID.

### IoT Device Endpoints

- `GET /devices`: Retrieve a list of all IoT devices.
- `POST /devices`: Add a new IoT device.
- `DELETE /devices/{id}`: Delete a device by ID.
- `PUT /devices/{id}`: Update a device by ID.

## Testing

Unit tests are implemented in the `IoTDeviceServiceTest` class using JUnit and Mockito. These tests verify the core functionality of the `IoTDeviceService` layer, including:

- `addDevice`: Ensures a device is correctly added.
- `deleteDevice`: Checks that a device can be deleted by ID.
- `updateDevice`: Validates updating an existing device or throwing an exception if the device is not found.
- `listDevices`: Confirms that the service returns all devices.

To run tests, execute:

```bash
mvn test
```
### Build and Run
```bash
mvn clean install
mvn spring-boot:run
```

# Future Improvements
- Implement a front-end UI for visualizing devices and user reviews.
- Integrate security features using Spring Security.
- Extend device functionalities to include IoT-specific features like telemetry data tracking.
