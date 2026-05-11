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