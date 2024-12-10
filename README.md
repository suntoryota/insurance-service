# Insurance Data Integration Service

## Description
A service that asynchronously fetches insurance data from external API and stores it in a database. Built with Quarkus framework, implementing asynchronous processing and RESTful architecture.

## Technology Stack
- Quarkus 3.6.4
- Java 21
- H2 Database
- Lombok
- RESTEasy Reactive
- Maven

## Project Structure
```plaintext
src/
├── main/
│   ├── java/com/insurance/
│   │   ├── client/
│   │   │   └── ExternalInsuranceClient.java    # External API integration
│   │   ├── controller/
│   │   │   └── InsuranceController.java        # REST endpoints
│   │   ├── dto/
│   │   │   ├── BaseResponse.java               # Standard API response
│   │   │   └── InsuranceResponse.java          # Insurance data response
│   │   ├── entity/
│   │   │   └── Insurance.java                  # Database entity
│   │   ├── exception/
│   │   │   ├── ApiException.java               # Custom exceptions
│   │   │   ├── ErrorCode.java                  # Error codes
│   │   │   └── GlobalExceptionHandler.java     # Exception handling
│   │   ├── repository/
│   │   │   └── InsuranceRepository.java        # Database operations
│   │   └── service/
│   │       ├── InsuranceService.java           # Service interface
│   │       └── InsuranceServiceImpl.java       # Business logic
│   └── resources/
        └── application.properties              # Application configuration
```

## Prerequisites
- JDK 17+
- Maven 3.8+
- External Insurance API access

## Configuration
### application.properties
```properties
# Database Configuration
quarkus.datasource.db-kind=h2
quarkus.datasource.username=username
quarkus.datasource.password=password
quarkus.datasource.jdbc.url=jdbc:h2:mem:insurance;DB_CLOSE_DELAY=-1

# Hibernate Configuration
quarkus.hibernate-orm.database.generation=update
quarkus.hibernate-orm.log.sql=true

# External API Configuration
quarkus.rest-client.insurance-api.url=https://external-insurance-api.com
quarkus.rest-client.insurance-api.scope=javax.inject.Singleton
```

## Setup & Installation
1. Clone repository:
```bash
git clone [repository-url]
```

2. Navigate to project directory:
```bash
cd insurance-service
```

3. Build project:
```bash
./mvnw clean install
```

4. Run application:
```bash
./mvnw quarkus:dev
```

## API Documentation
### Get Insurance Data
- **Endpoint**: GET `/api/insurance/{policyNumber}`
- **Description**: Fetches insurance data from external API and stores in database
- **Path Parameters**:
    - policyNumber (String): Insurance policy number
- **Response Format**:
```json
{
    "success": true,
    "message": "Success",
    "data": {
        "id": 1,
        "policyNumber": "POL123",
        "customerName": "John Doe",
        "type": "Life Insurance",
        "premium": 1000.0,
        "startDate": "2024-01-01T00:00:00",
        "endDate": "2025-01-01T00:00:00"
    }
}
```

## Error Codes
| Code    | Description             |
|---------|-------------------------|
| INS-001 | Insurance not found     |
| INS-002 | External API error      |
| INS-003 | Database operation error|

## Testing
1. Start application in dev mode
2. Use Postman or similar tool:
    - Create GET request
    - URL: `http://localhost:8080/api/insurance/{policyNumber}`
    - Replace `{policyNumber}` with actual policy number
    - Send request
3. Expected successful response should match format above

## Features
- Asynchronous data processing
- External API integration
- Database persistence
- Error handling
- Standardized API responses

## Dependencies
```xml
<dependency>
    <groupId>io.quarkus</groupId>
    <artifactId>quarkus-resteasy-reactive</artifactId>
</dependency>
<dependency>
    <groupId>io.quarkus</groupId>
    <artifactId>quarkus-resteasy-reactive-jackson</artifactId>
</dependency>
<dependency>
    <groupId>io.quarkus</groupId>
    <artifactId>quarkus-hibernate-orm-panache</artifactId>
</dependency>
<dependency>
    <groupId>io.quarkus</groupId>
    <artifactId>quarkus-jdbc-h2</artifactId>
</dependency>
<dependency>
    <groupId>io.quarkus</groupId>
    <artifactId>quarkus-rest-client-reactive</artifactId>
</dependency>
<dependency>
    <groupId>org.projectlombok</groupId>
    <artifactId>lombok</artifactId>
    <version>1.18.30</version>
    <scope>provided</scope>
</dependency>
```
