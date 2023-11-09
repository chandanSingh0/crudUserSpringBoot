# crudUserSpringBoot

# Spring Boot CRUD with Many-to-Many and One-to-One Relationships

This project is a Spring Boot application that demonstrates a simple CRUD (Create, Read, Update, Delete) functionality with Many-to-Many and One-to-One relationships.

## Table of Contents

- [Technologies Used](#technologies-used)
- [Setup](#setup)
- [Database Configuration](#database-configuration)
- [Endpoints](#endpoints)
- [Usage](#usage)
- [Contributing](#contributing)
- [License](#license)

## Technologies Used

- Spring Boot
- Spring Data JPA
- H2 Database (for demo purposes, you can replace it with your preferred database)
- Maven

## Setup

1. Clone the repository:

```bash
git clone https://github.com/your-username/your-repository.git

# Database Configuration
spring.datasource.url=jdbc:h2:mem:testdb
spring.datasource.driverClassName=org.h2.Driver
spring.datasource.username=sa
spring.datasource.password=password
spring.jpa.database-platform=org.hibernate.dialect.H2Dialect

