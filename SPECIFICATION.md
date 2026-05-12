# Task Manager Project Specification

## Overview
A simple task management application built with Spring Boot, H2 database, and Maven.

## Architecture
The application follows a layered architecture:
- **Controller Layer**: Handles HTTP requests and responses, exposes REST endpoints
- **Service Layer**: Contains business logic, coordinates between controller and repository
- **Repository Layer**: Handles data persistence using Spring Data JPA
- **Entity Layer**: Represents the data model

## Components

### Entity: Task
- id: Long (primary key)
- title: String
- description: String
- completed: Boolean

### Repository: TaskRepository
- Extends JpaRepository<Task, Long>
- Provides CRUD operations for Task entities

### Service: TaskService
- Creates tasks: Task createTask(Task task)
- Retrieves all tasks: List<Task> getAllTasks()
- Marks task as complete: Task completeTask(Long id)
- Deletes tasks: void deleteTask(Long id)

### Controller: TaskController
- Exposes REST endpoints for task management:
  - POST /tasks: Create a new task
  - GET /tasks: Retrieve all tasks
  - PUT /tasks/{id}/complete: Mark a task as complete
  - DELETE /tasks/{id}: Delete a task

## Endpoints
- POST /tasks
  - Request Body: Task object (JSON)
  - Response: Created Task object (JSON) with HTTP 201
  - Description: Creates a new task

- GET /tasks
  - Response: List of all Task objects (JSON) with HTTP 200
  - Description: Retrieves all tasks

- PUT /tasks/{id}/complete
  - Path Variable: id (Long)
  - Response: Updated Task object (JSON) with HTTP 200
  - Description: Marks the specified task as complete

- DELETE /tasks/{id}
  - Path Variable: id (Long)
  - Response: HTTP 204 No Content
  - Description: Deletes the specified task

## Technologies
- Java 17
- Spring Boot 3.x
- Spring Data JPA
- H2 Database
- Maven

## Setup and Execution
1. Clone the repository
2. Run `mvn spring-boot:run` or execute the main class
3. Access the H2 console at http://localhost:8080/h2-console
4. Test endpoints using curl or Postman

## Future Improvements
- Add DTOs for request/response validation
- Implement exception handling
- Add pagination for GET /tasks
- Add search/filter capabilities
- Implement security with Spring Security