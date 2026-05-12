# Task Manager Project Specification

## Overview
A simple task management application built with Spring Boot, H2 database, and Maven.

## Architecture
The application follows a layered architecture:
- **Controller Layer**: Handles HTTP requests and responses, exposes REST endpoints
- **Service Layer**: Contains business logic, coordinates between controller and repository
- **Repository Layer**: Handles data persistence using Spring Data JPA
- **Entity Layer**: Represents the data model
- **DTO Layer**: Data Transfer Objects for request/response validation and decoupling

## Components

### Entity: Task
- id: Long (primary key)
- title: String
- completed: Boolean
- createdAt: LocalDateTime

### Repository: TaskRepository
- Extends JpaRepository<Task, Long>
- Provides CRUD operations for Task entities

### Service: TaskService
- Creates tasks: TaskResponseDTO createTask(TaskRequestDTO taskRequestDTO)
- Retrieves all tasks: List<TaskResponseDTO> getAllTasks()
- Marks task as complete: TaskResponseDTO completeTask(Long id)
- Deletes tasks: void deleteTask(Long id)

### Controller: TaskController
- Exposes REST endpoints for task management with validation:
  - POST /tasks: Create a new task (with @Valid validation)
  - GET /tasks: Retrieve all tasks
  - PUT /tasks/{id}/complete: Mark a task as complete
  - DELETE /tasks/{id}: Delete a task

### DTOs
- TaskRequestDTO: For incoming task creation requests
  - title: String (validated with @NotBlank and @Size)
- TaskResponseDTO: For outgoing task data
  - id: Long
  - title: String
  - completed: Boolean
  - createdAt: String

## Endpoints
- POST /tasks
  - Request Body: TaskRequestDTO (JSON)
  - Response: Created TaskResponseDTO (JSON) with HTTP 201
  - Validation: @NotBlank, @Size(max=100) on title
  - Description: Creates a new task

- GET /tasks
  - Response: List of all TaskResponseDTO objects (JSON) with HTTP 200
  - Description: Retrieves all tasks

- PUT /tasks/{id}/complete
  - Path Variable: id (Long)
  - Response: Updated TaskResponseDTO (JSON) with HTTP 200
  - Description: Marks the specified task as complete

- DELETE /tasks/{id}
  - Path Variable: id (Long)
  - Response: HTTP 204 No Content
  - Description: Deletes the specified task

## Technologies
- Java 17
- Spring Boot 3.x
- Spring Data JPA
- Spring Validation (Bean Validation)
- H2 Database
- Maven

## Setup and Execution
1. Clone the repository
2. Run `mvn spring-boot:run` or execute the main class
3. Access the H2 console at http://localhost:8080/h2-console
4. Test endpoints using curl or Postman

## Future Improvements
- Implement exception handling
- Add pagination for GET /tasks
- Add search/filter capabilities
- Implement security with Spring Security