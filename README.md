# Task Tracker API

## Overview

Task Tracker API is a Spring Boot RESTful application for managing Projects, Users, and Tasks.

### Features

* CRUD operations for Projects, Users, and Tasks
* Project → Task one-to-many relationship
* User → Task many-to-one relationship
* Bean Validation
* Global Exception Handling
* H2 In-Memory Database
* Pagination and Sorting
* Swagger/OpenAPI Documentation
* Unit Testing with JUnit 5 and Mockito
* Integration Testing using MockMvc
* Docker Support

---

## Technologies Used

* Java 17
* Spring Boot 3.x
* Spring Data JPA
* Hibernate
* H2 Database
* Maven
* Lombok
* JUnit 5
* Mockito
* Swagger OpenAPI (springdoc-openapi)
* Docker

---

## Project Structure

src/main/java

* controller
* service
* repository
* entity
* dto
* exception
* config

---

## Prerequisites

Install the following:

* Java 17+
* Maven 3.9+
* Git
* Docker (Optional)

Verify installation:

```bash
java -version
mvn -version
docker --version
```

---

## Clone Repository

```bash
git clone https://github.com/Thilak1999/TaskTrackerAPI.git
cd TaskTracker
```

---

## Build Application

```bash
mvn clean package
```

Generated JAR:

```text
target/TaskTracker-0.0.1-SNAPSHOT.jar
```

---

## Run Application

Using Maven:

```bash
mvn spring-boot:run
```

OR

Using JAR:

```bash
java -jar target/TaskTracker-0.0.1-SNAPSHOT.jar
```

Application starts on:

```text
http://localhost:8080
```

---

## H2 Database

Open:

```text
http://localhost:8080/h2-console
```

Connection Details:

```text
JDBC URL : jdbc:h2:mem:testdb
Username : sa
Password :
```

---

## Swagger UI

Open:

```text
http://localhost:8080/swagger-ui/index.html
```

OpenAPI Specification:

```text
http://localhost:8080/v3/api-docs.yaml
```


## Configuration

application.properties

```properties
app.name=Task Tracker API
app.version=1.0.0

task.default-priority=MEDIUM

pagination.default-page-size=10
```


# Sample CURL Requests

## Create Project

```bash
curl -X POST http://localhost:8080/api/projects \
-H "Content-Type: application/json" \
-d '{
"name":"Backend Project",
"description":"Spring Boot Task Tracker"
}'
```

## Get All Projects

```bash
curl http://localhost:8080/api/projects
```



## Get Project By Id

```bash
curl http://localhost:8080/api/projects/1
```


## Update Project

```bash
curl -X PUT http://localhost:8080/api/projects/1 \
-H "Content-Type: application/json" \
-d '{
"name":"Updated Project",
"description":"Updated Description"
}'
```

## Delete Project

```bash
curl -X DELETE http://localhost:8080/api/projects/1
```

## Create User

```bash
curl -X POST http://localhost:8080/api/users \
-H "Content-Type: application/json" \
-d '{
"name":"Thilak",
"email":"thilak@gmail.com",
"role":"DEVELOPER"
}'
```


## Get All Users

```bash
curl http://localhost:8080/api/users
```


## Create Task

```bash
curl -X POST http://localhost:8080/api/tasks \
-H "Content-Type: application/json" \
-d '{
"title":"Implement CRUD APIs",
"status":"TODO",
"priority":"HIGH",
"projectId":1,
"assigneeId":1,
"dueDate":"2026-06-15"
}'
```

---

## Get All Tasks

```bash
curl http://localhost:8080/api/tasks
```

---

## Filter Tasks By Status

```bash
curl http://localhost:8080/api/tasks?status=TODO
```

---

## Filter Tasks By Project

```bash
curl http://localhost:8080/api/tasks?projectId=1
```

---

## Get Tasks For Project

```bash
curl http://localhost:8080/api/projects/1/tasks
```

---

## Run Tests

```bash
mvn test
```

---

Docker Support

Build Docker Image

```bash
docker build -t tasktracker .
```

### Run Docker Container

```bash
docker run -p 8080:8080 tasktracker
```

## Verify


http://localhost:8080/swagger-ui/index.html

---

## Author

Thilak K S
Software Engineer (Java)
