# customersService

The `customersService` is a Spring Boot microservice that manages customer data and provides functionalities for creating new customers, retrieving customer details, and handling customer-related operations

## Features

- Create a new customer profile.
- Retrieve details of a customer by UUID.
- Search for customers based on their name and surname.
- Update customer information securely.

### Prerequisites

Ensure you have the following installed:

- Java 17 or higher
- Maven 3.6+
- Docker (optional for running the service as a container)

### Installation

1. **Clone the repository**:
   ```bash
   git clone https://github.com/kaouther24/customersService.git
   cd customersService

2. **Build the project using Maven**:
   ```bash
   mvn clean install

3. **run the application**:
   ```bash
   mvn spring-boot:run

The service will be available at http://localhost:8080.

### Running with Docker

1. **Build with docker**:
   ```bash
   docker build -t customers-service:latest .

2. **Run the docker container**:
   ```bash
   docker run -p 8081:8080 customers-service

### API Endpoints
The customersService exposes the following API endpoints:
1. **Create a new customer**:
- Endpoint: POST /customer/new
- Request body:
  {
  "name": "string",
  "surname": "string",
  }
2. **Search a customer by name and surname**:
- Endpoint: GET /customer/byNameAndSurname/{name}/{surname}
3. **Get a customer by its UUID**:
- Endpoint: GET /customer/byId/{customerUuid}

### Technologies Used
- Spring Boot: Framework for building microservices.
- JUnit & Mockito: For unit and integration testing.
- Docker: To containerize the service.

### License
This project is licensed under the MIT License