![GitHub language count](https://img.shields.io/github/languages/count/souzafcharles/Java-Spring-Thymeleaf-Triathlete-Sponsorship)
![GitHub top language](https://img.shields.io/github/languages/top/souzafcharles/Java-Spring-Thymeleaf-Triathlete-Sponsorship)
![GitHub](https://img.shields.io/github/license/souzafcharles/Java-Spring-Thymeleaf-Triathlete-Sponsorship)
![GitHub last commit](https://img.shields.io/github/last-commit/souzafcharles/Java-Spring-Thymeleaf-Triathlete-Sponsorship)

# 🏊🚴🏃 Triathlete Sponsorship Management API

## System Overview:

<p align="justify">
The Triathlete Sponsorship Management API is designed to manage the sponsorship relationships between triathletes and sponsors. Each Triathlete can have multiple Sponsors, and each Sponsor can support multiple Triathletes, forming a <code>Many-to-Many</code> (M:N) relationship.
</p>

<p align="justify">
To efficiently manage this relationship, an intermediate table (<code>tb_triathlete_sponsor</code>) is created, ensuring a structured connection between Triathletes and Sponsors.  This <code>Many-to-Many</code> relationship is a core aspect of the system's design. 
</p>

<p align="justify">
The system aims to provide a user-friendly and efficient platform for managing these interactions, streamlining the sponsorship process for both triathletes and sponsors.  The development of this system leverages the capabilities of the <code>Java Spring</code> framework, incorporating key technologies such as <code>Spring Boot</code>, <code>Spring Data JPA</code>, and <code>PostgreSQL</code>.
</p>

<p align="justify">
The user interface is built using <code>Thymeleaf</code> templates, incorporating <code>Bootstrap 5.1.3</code> for responsive design and styling, and <code>jQuery 3.6.0</code> for enhanced client-side interactions.
</p>

***
## Project Stack:

| Technology       | Version  | Description                                              |
|------------------|----------|----------------------------------------------------------|
| 📐 IntelliJ IDEA | `2024.3` | Integrated Development Environment (IDE)                 |
| ☕ Java          | `21`     | Backend programming language                             |
| 🌱 Spring Boot   | `3.4.3`  | Framework for creating Spring applications               |
| 🍃 Thymeleaf     | `3.1.3`  | Modern server-side Java template engine                  |
| 🐦 Maven         | `3.9.9`  | Build automation and dependency management tool          |
| 🐘 PostgreSQL    | `17`     | Relational database management system                    |
| 👩‍🚀 Postman       | `11.19`  | API testing and development tool                         |
| 🎨 Bootstrap	   |`5.1.3`   |	Front-end framework for responsive web design            |
| 💠 jQuery	       | `3.6.0`  | JavaScript library for simplifying HTML DOM manipulation |

***

## Dependencies:

| Dependency              | Category         | Description                                                                                                               |
|-------------------------|------------------|---------------------------------------------------------------------------------------------------------------------------|
| 🌐 Spring Web           | Web              | Constructs web applications, including RESTful APIs, utilising Spring MVC. Employs Apache Tomcat as the default container |
| 💾 Spring Data JPA      | SQL              | Facilitates database access using JPA with Spring Data and Hibernate                                                      |
| 🐘 PostgreSQL Driver    | SQL              | JDBC and R2DBC driver enabling Java applications to interact with PostgreSQL databases                                    |
| ✔️ Validation           | Validation (I/O) | Enables Java Bean Validation employing Hibernate Validator                                                                |
| 🔄 Spring Boot DevTools | Developer Tools  | Provides fast application restarts, LiveReload, and configurations for an enhanced development experience                 |
| 🍃 Thymeleaf            | Template Engines | Allows HTML to be correctly displayed in browsers and as static prototypes                                                |
| 🗝️ dotenv-java          | Configuration    | Loads environment variables from a `.env` file into the application, aiding in secure configuration management            |

***
