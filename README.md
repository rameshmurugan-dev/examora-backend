# EXAMORA — Online Quiz & Mock Test Platform
![Status](https://img.shields.io/badge/Project-Active-success)
![Language](https://img.shields.io/badge/Java-21-blue)
![Backend](https://img.shields.io/badge/Spring%20Boot-3.x-green)
![Database](https://img.shields.io/badge/PostgreSQL-Active-blue)


Examora is a full-stack web application where students can take mock tests,
attempt quizzes, and view their performance results.

## 🎯 Project Goals
- Build a real-world full-stack portfolio project
- Practice Spring Boot + React + PostgreSQL
- Learn clean architecture & backend design

## 📌 About Examora

Examora is an online quiz and mock-test platform where students can:
- Take mock exams
- Practice section-wise tests
- View scores & performance history

Admins can:
- Create quizzes & questions
- Manage subjects & sections
- Monitor test attempts

## 🛠 Tech Stack
Backend: Spring Boot (Java, Spring Data JPA, Spring Security)
Database: PostgreSQL
Frontend: React (later)
Version Control: Git + GitHub

## 🏗️ System Architecture

Examora follows a layered full-stack architecture:

Backend — Spring Boot (REST APIs)
Database — PostgreSQL (JPA / Hibernate)
Frontend — React (will be added later)

Data Flow:
User → React UI → REST API → Service Layer → PostgreSQL

## 🚀 How to run backend locally

### Prerequisites
- Java 21+
- Maven
- PostgreSQL

### Steps

1. Clone the project
   git clone https://github.com/<your-username>/examora-backend.git

2. Configure database in `application.yml`

3. Run backend
   ./mvnw spring-boot:run

Backend will start at:
http://localhost:8080


## 📦 Current Development Status
✔ Project initialized  
✔ PostgreSQL connected  
✔ Backend setup in progress
