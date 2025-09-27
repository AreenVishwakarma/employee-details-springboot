# Employee Details Spring Boot Application

This is a Spring Boot project that allows users to manage employee details and incentives. The application provides RESTful APIs or a web interface (depending on your implementation) for adding, viewing, and managing employees and their incentives. All data is persisted in a database.

## Features

- **Add Employee**: Users can add new employees with the following details:
  - Name
  - Designation
  - Email
  - Phone Number
  - Salary

- **View Employees**: Retrieve a list of all employees with their details.

- **Add Incentive**: Assign incentives to any employee that has been added to the system.

- **Database Integration**: All records are stored in a relational database (such as MySQL, PostgreSQL, H2, etc.).

## Technologies Used

- Java
- Spring Boot
- Spring Data JPA
- Hibernate
- Database (configure as per your setup: MySQL/PostgreSQL/H2)
- (Optional) Spring Web / Spring MVC (for REST APIs or web frontend)
- (Optional) Lombok

## Getting Started

### Prerequisites

- Java 8 or higher
- Maven or Gradle
- Database server (if not using embedded H2)

### Setup

1. **Clone the repository:**
   ```bash
   git clone https://github.com/AreenVishwakarma/employee-details-springboot.git
   cd employee-details-springboot
   ```

2. **Configure Database:**
   - Edit `src/main/resources/application.properties` to set your database connection properties.
   - Example for H2 (default for testing):
     ```
     spring.datasource.url=jdbc:h2:mem:testdb
     spring.datasource.driverClassName=org.h2.Driver
     spring.datasource.username=sa
     spring.datasource.password=
     spring.jpa.database-platform=org.hibernate.dialect.H2Dialect
     spring.h2.console.enabled=true
     ```
   - Example for MySQL:
     ```
     spring.datasource.url=jdbc:mysql://localhost:3306/employee_db
     spring.datasource.username=root
     spring.datasource.password=yourpassword
     spring.jpa.hibernate.ddl-auto=update
     ```

3. **Build and Run:**
   ```bash
   mvn clean install
   mvn spring-boot:run
   ```
   or with Gradle:
   ```bash
   ./gradlew bootRun
   ```

4. **Access the Application:**
   - If REST API: Open [http://localhost:8080](http://localhost:8080) and use an API client (like Postman) to interact.
   - If Web UI: Open [http://localhost:8080](http://localhost:8080) in your browser.

## API Endpoints (Example)

| Method | Endpoint                | Description               |
|--------|------------------------ |---------------------------|
| POST   | `/employees`            | Add a new employee        |
| GET    | `/employees`            | List all employees        |
| POST   | `/employees/{id}/incentive` | Add incentive to employee |

> **Note:** Adjust URLs as per your actual controller mappings.

### Sample JSON Payloads

**Add Employee**
```json
{
  "name": "John Doe",
  "designation": "Software Engineer",
  "email": "john.doe@example.com",
  "number": "1234567890",
  "salary": 65000
}
```

**Add Incentive**
```json
{
  "amount": 5000,
  "description": "Performance Bonus"
}
```

## Entity Relationships

- **Employee** (id, name, designation, email, number, salary)
- **Incentive** (id, amount, description, employee_id)

Each `Incentive` is associated with an `Employee`.

## License

This project is licensed under the MIT License.

## Author

[Areen Vishwakarma](https://github.com/AreenVishwakarma)
