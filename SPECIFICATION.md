# Specification for creating Task entity in Spring Boot

## Step 1: Create Spring Boot project
- Use Spring Initializr to generate a project with:
    - Group: com.example
    - Artifact: task-manager
    - Name: task-manager
    - Description: Task manager application
    - Package name: com.example.taskmanager
    - Packaging: Jar
    - Java version: 17 (or latest LTS)
    - Dependencies: Spring Web, Spring Data JPA, Lombok, H2 Database

## Step 2: Create the Task entity
- Create a class `Task` in the package `com.example.taskmanager.entity`
- Fields:
    - id (Long) with @Id and @GeneratedValue
    - title (String)
    - completed (Boolean)
    - createdAt (LocalDateTime) with @CreationTimestamp (if using Hibernate) or set manually in @PrePersist
- Use Lombok annotations: @Data, @NoArgsConstructor, @AllArgsConstructor, @Builder (optional)
- Use JPA annotations: @Entity, @Table(name = "tasks")

## Step 3: Verify the entity is correctly mapped
- We can write a simple test or run the application and check the logs for table creation.

## Step 4: Create the TaskRepository interface
- Create an interface `TaskRepository` in the package `com.example.taskmanager.repository`
- Extend `JpaRepository<Task, Long>`
- This interface will provide CRUD operations for the Task entity without needing to write any implementation.
- The repository layer is responsible for data access, abstracting the persistence layer and providing a clean interface for the service layer to interact with the data store.

## Step 5: Create the TaskService class
- Create a class `TaskService` in the package `com.example.taskmanager.service`
- Use constructor-based dependency injection to receive TaskRepository
- Annotate with @Service
- Implement business logic methods:
    - createTask(Task task): saves a new task
    - getAllTasks(): returns all tasks
    - completeTask(Long id): finds task by id, sets completed to true, and saves
    - deleteTask(Long id): deletes task by id
- The service layer contains business logic, orchestrates repository operations, handles transactions (if needed), and keeps the controller layer free of business rules.

## Step 6: Fix pom.xml for H2 database
- Changed spring-boot-starter-webmvc to spring-boot-starter-web (standard for REST applications)
- Added H2 dependency with runtime scope for embedded database configuration
- Consolidated test dependencies into spring-boot-starter-test (includes necessary testing libraries)
- This ensures Spring Boot can auto-configure an embedded H2 database when no other DataSource is defined.

## Step 7: Create the TaskController class
- Create a class `TaskController` in the package `com.example.taskmanager.controller`
- Use constructor-based dependency injection to receive TaskService
- Annotate with @RestController and @RequestMapping("/tasks")
- Implement REST endpoints:
    - POST /: create a new task
    - GET /: get all tasks
    - PUT /{id}/complete: mark a task as completed
    - DELETE /{id}: delete a task
- The controller layer handles HTTP requests, delegates business logic to the service layer, and returns appropriate HTTP responses.
- Keep controllers free of business logic - they should only handle request/response mapping and delegate to services.