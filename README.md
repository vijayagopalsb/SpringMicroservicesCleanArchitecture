<!-- README.md -->
<p align="center">
  <a href="https://www.oracle.com/java/">
    <img src="https://img.shields.io/badge/Java-17-blue?logo=java" />
  </a>
  <a href="https://spring.io/projects/spring-boot">
    <img src="https://img.shields.io/badge/Spring%20Boot-2.7.18-brightgreen?logo=spring-boot" />
  </a>
  <a href="https://www.docker.com/">
  	<img src="https://img.shields.io/badge/Docker-Built-blue?logo=docker" alt="Docker">
  </a>
  <a href="https://github.com/vijayagopalsb/SpringMicroservicesCleanArchitecture/blob/main/LICENSE">
    <img src="https://img.shields.io/github/license/vijayagopalsb/SpringMicroservicesCleanArchitecture" alt="License">
  </a>
  
</p>


# Spring Boot Microservices with Clean Architecture

A production-ready Java project that demonstrates how to build scalable **microservices** using **Spring Boot**, **Spring Cloud**, and **Clean Architecture** principles with **modular service separation** and **Eureka discovery** support.

## Project Modules

This project follows a multi-module Maven structure and includes three core microservices. Each module is independently developed, tested, and deployable, and follows Clean Architecture principles.

### 1. `eureka-server`

<!-- Role of Eureka Server -->

- Acts as the **Service Discovery Server** using Netflix Eureka.
- Enables dynamic registration and discovery of microservices in the ecosystem.
- Accessible at: `http://localhost:8761`

**Key Features:**

- Registers all services (user-service, order-service) automatically on startup.
- Provides a central registry for inter-service communication without hardcoding URLs.

---

### 2. `user-service`

<!-- Role of User Service -->

- Manages **user-related operations** such as creation, retrieval, and listing of users.
- Built with **Spring Boot**, uses **H2 database**, and follows **Clean Architecture** with clearly separated layers:
  - `api`: Controllers & request handling
  - `application`: Business logic (use cases)
  - `domain`: Core entity models
  - `infrastructure`: Spring JPA repository
  - `exception`: Custom error handling

**Key Features:**

- RESTful CRUD endpoints at `/api/users`
- Registered with Eureka
- Uses Spring Data JPA + H2

---

### 3. `order-service`

<!-- Role of Order Service (assumed, update as needed) -->

- Handles **order management** for the application.
- Follows the same clean-layered structure as user-service.
- Integrates with Eureka for service discovery.
- Currently a placeholder — logic can be extended for real-world order workflows.

**Key Features:**

- Placeholder service for order domain
- Ready for database, REST API, and further integration



