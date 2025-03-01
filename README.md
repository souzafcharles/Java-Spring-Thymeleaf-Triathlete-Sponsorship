![GitHub language count](https://img.shields.io/github/languages/count/souzafcharles/Java-Spring-Thymeleaf-Triathlete-Sponsorship)
![GitHub top language](https://img.shields.io/github/languages/top/souzafcharles/Java-Spring-Thymeleaf-Triathlete-Sponsorship)
![GitHub](https://img.shields.io/github/license/souzafcharles/Java-Spring-Thymeleaf-Triathlete-Sponsorship)
![GitHub last commit](https://img.shields.io/github/last-commit/souzafcharles/Java-Spring-Thymeleaf-Triathlete-Sponsorship)

# 🏊🚴🏃 Triathlete Sponsorship Management Web

***
▶️ Project developed based on tutorials by **Gilberto
** - [4CatsDev](https://www.youtube.com/playlist?list=PLj8jbyWxdQ-n-WuVOeqqVTXZEhml3H_bH).
***

## System Overview:

<p align="justify">
The Triathlete Sponsorship Management Web is designed to manage the sponsorship relationships between triathletes and sponsors. Each Triathlete can have multiple Sponsors, and each Sponsor can support multiple Triathletes, forming a <code>Many-to-Many</code> (M:N) relationship.
</p>

<p align="justify">
To efficiently manage this relationship, an intermediate table (<code>tb_triathlete_sponsor</code>) is created, ensuring a structured connection between Triathletes and Sponsors. This <code>Many-to-Many</code> relationship is a core aspect of the system's design. 
</p>

<p align="justify">
The system aims to provide a user-friendly and efficient platform for managing these interactions, streamlining the sponsorship process for both triathletes and sponsors. The development of this system leverages the capabilities of the <code>Java Spring</code> framework, incorporating key technologies such as <code>Spring Boot</code>, <code>Spring Data JPA</code>, and <code>PostgreSQL</code>.
</p>

<p align="justify">
The user interface is built using <code>Thymeleaf</code> templates, incorporating <code>Bootstrap 5.1.3</code> for responsive design and styling, and <code>jQuery 3.6.1</code> for enhanced client-side interactions.
</p>

***

## Project Stack:

| Technology       | Version  | Description                                              |
|------------------|----------|----------------------------------------------------------|
| 📐 IntelliJ IDEA | `2024.3` | Integrated Development Environment (IDE)                 |
| ☕ Java           | `21`     | Backend programming language                             |
| 🌱 Spring Boot   | `3.4.3`  | Framework for creating Spring applications               |
| 🍃 Thymeleaf     | `3.1.3`  | Modern server-side Java template engine                  |
| 🐦 Maven         | `3.9.9`  | Build automation and dependency management tool          |
| 🐘 PostgreSQL    | `17`     | Relational database management system                    |
| 🎨 Bootstrap     | `5.1.3`  | Front-end framework for responsive web design            |
| 💠 jQuery	       | `3.6.1`  | JavaScript library for simplifying HTML DOM manipulation |

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
| 🗝️ dotenv-java         | Configuration    | Loads environment variables from a `.env` file into the application, aiding in secure configuration management            |

***

# Page Views:

## Viewing the List of Triathletes:

![List Triathletes](https://github.com/souzafcharles/Java-Spring-Thymeleaf-Triathlete-Sponsorship/blob/main/src/main/resources/static/images/list-triathletes.png)

## Viewing a Triathlete's Details:

![View Triathlete](https://github.com/souzafcharles/Java-Spring-Thymeleaf-Triathlete-Sponsorship/blob/main/src/main/resources/static/images/view-triathlete.png)

## Searching for a Triathlete:

![Search Triathlete](https://github.com/souzafcharles/Java-Spring-Thymeleaf-Triathlete-Sponsorship/blob/main/src/main/resources/static/images/search-triathlete.png)

## Adding a New Triathlete:

![New Triathlete](https://github.com/souzafcharles/Java-Spring-Thymeleaf-Triathlete-Sponsorship/blob/main/src/main/resources/static/images/new-triathlete.png)

## Editing a Triathlete Record:

![Edit Triathlete](https://github.com/souzafcharles/Java-Spring-Thymeleaf-Triathlete-Sponsorship/blob/main/src/main/resources/static/images/edit-triathlete.png)

## Adding a New Sponsor:

![New Sponsor](https://github.com/souzafcharles/Java-Spring-Thymeleaf-Triathlete-Sponsorship/blob/main/src/main/resources/static/images/new-sponsor.png)


***

# Project Requirements and Configurations:

## Entity Relationship Diagram - Triathlete and Sponsor:

![Triathlete-Sponsor Data Relationship Diagram](https://github.com/souzafcharles/Java-Spring-Thymeleaf-Triathlete-Sponsorship/blob/main/src/main/resources/static/images/triathlete-sponsor-entities.png)

## SQL Script for Populating Database Tables:

````sql
-- Drop tables if they exist with CASCADE
DROP TABLE IF EXISTS tb_triathlete_sponsor CASCADE;
DROP TABLE IF EXISTS tb_sponsor CASCADE;
DROP TABLE IF EXISTS tb_triathlete CASCADE;

-- Create tables
CREATE TABLE tb_triathlete (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    age INTEGER
);

CREATE TABLE tb_sponsor (
    id SERIAL PRIMARY KEY,
    title VARCHAR(255) NOT NULL
);

CREATE TABLE tb_triathlete_sponsor (
    triathlete_id INT REFERENCES tb_triathlete(id),
    sponsor_id INT REFERENCES tb_sponsor(id),
    PRIMARY KEY (triathlete_id, sponsor_id)
);

-- Insert triathletes
INSERT INTO tb_triathlete (name, age) VALUES
('Balthazar de Bigode', 35),
('Ophelia Birrenta', 34),
('Ludovico Crispim', 35),
('Abigail Sebastiana', 29),
('Belizario Epaminondas', 20),
('Belarmino Gumercindo', 21),
('Zuleica Serafina de Jesus', 27),
('Vitalino Simplicio', 18),
('Cassandra Valquiria', 23),
('Abilio Prudencio', 21),
('Alzira Filisbino', 19),
('Genivaldo Custodio', 36);

-- Insert sponsors
INSERT INTO tb_sponsor (title) VALUES
('Nike'),
('Specialized'),
('Garmin'),
('TYR'),
('Gatorade'),
('Brooks Running'),
('PowerBar'),
('Red Bull'),
('Oakley'),
('Zone3'),
('Hoka One One'),
('ROKA'),
('Clif Bar'),
('2XU'),
('Maurten'),
('Polar'),
('Zipp'),
('Compressport'),
('Science in Sport (SiS)'),
('Michelin');

-- Clean inconsistent data before inserting relationships
DELETE FROM tb_triathlete_sponsor
WHERE triathlete_id NOT IN (SELECT id FROM tb_triathlete);

-- Associate triathletes with sponsors
INSERT INTO tb_triathlete_sponsor (triathlete_id, sponsor_id) VALUES
(1, 1),  -- Balthazar de Bigode with Nike
(1, 2),  -- Balthazar de Bigode with Specialized
(1, 3),  -- Balthazar de Bigode with Garmin
(2, 4),  -- Ophelia Birrenta with TYR
(3, 5),  -- Ludovico Crispim with Gatorade
(4, 6),  -- Abigail Sebastiana with Brooks Running
(5, 7),  -- Belizario Epaminondas with PowerBar
(6, 8),  -- Belarmino Gumercindo with Red Bull
(7, 9),  -- Zuleica Serafina de Jesus with Oakley
(8, 10), -- Vitalino Simplicio with Zone3
(9, 11), -- Cassandra Valquiria with Hoka One One
(10, 12), -- Abilio Prudencio with ROKA
(11, 13), -- Alzira Filisbino with Clif Bar
(12, 14), -- Genivaldo Custodio with 2XU
(1, 15), -- Balthazar de Bigode with Maurten
(2, 16), -- Ophelia Birrenta with Polar
(3, 17), -- Ludovico Crispim with Zipp
(4, 18), -- Abigail Sebastiana with Compressport
(5, 19), -- Belizario Epaminondas with Science in Sport (SiS)
(6, 20); -- Belarmino Gumercindo with Michelin

````

***

## Setting up `application.properties` File with PostgreSQL Configurations:

```properties
# Application name
spring.application.name=triathlete-sponsorship-web
# PostgreSQL Connection
spring.datasource.url=${DATABASE_URL}
spring.datasource.username=${DATABASE_USERNAME}
spring.datasource.password=${DATABASE_PASSWORD}
# Hibernate settings
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

***

## Creation of the `.env` File:

- At the root of the project, create a file named `.env` to declare the environment variables required for the
  `PostgreSQL` database connection.

***

## Requirements for LoadEnvironment Class:

- **Class Purpose:**
    - Create the `LoadEnvironment` class to load environment variables from a `.env` file and set them as system
      properties.

- **Load Environment Method:**
    - **Method:** `loadEnv`
    - **Purpose:** Loads environment variables from a `.env` file and sets them as system properties.
    - **Implementation Details:**
        - Use the `Dotenv.configure().load()` method from the `io.github.cdimascio.dotenv` library to load the
          environment variables.
        - Iterate over the entries using
          `dotenv.entries().forEach(entry -> System.setProperty(entry.getKey(), entry.getValue()))` to set each
          environment variable as a system property.

- **External Library:**
    - **Library:** `io.github.cdimascio.dotenv`
    - **Purpose:** Used to load environment variables from a `.env` file. Ensure this library is included as a
      dependency in your project's build configuration.

- **Purpose:**
    - Ensure that environment variables defined in a `.env` file are loaded and accessible as system properties
      throughout the application.

***

## Entry Point Integration:

- Call the environment loader at the project's entry point to ensure environment variables are available at runtime:

```java

@SpringBootApplication
public class TriathleteSponsorshipWebApplication {

    public static void main(String[] args) {
        LoadEnvironment.loadEnv();
        SpringApplication.run(TriathleteSponsorshipWebApplication.class, args);
    }

}
```

***

# Backend Requirements Specification:

## Requirements for `Triathlete` Entity Class:

- **Entity Mapping:**
    - Define the `Triathlete` class as an entity to represent a database table;
    - Annotate the class with `@Entity` to designate it as a persistent entity;
    - Use `@Table(name = "tb_triathlete")` to map the entity to the database table named `tb_triathlete`.

- **Attributes and Annotations:**
    - Declare attributes `id`, `name`, `age`, and `sponsors` to represent the respective database columns;
    - Annotate the `id` field with `@Id` and `@GeneratedValue(strategy = GenerationType.IDENTITY)` to specify it as the
      primary key with an automatically generated value;
    - Use `@NotBlank` and `@Size(min = 2)` on `name` to enforce validation constraints;
    - Apply `@Min(value = 18)` on `age` to ensure a minimum valid age requirement;
    - Establish a many-to-many relationship between `Triathlete` and `Sponsor` using
      `@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)`;
    - Configure the relationship mapping with `@JoinTable`, specifying `joinColumns` and `inverseJoinColumns`.

- **Accessors and Mutators:**
    - Implement `getters` and `setters` for all attributes to facilitate data manipulation.

- **Serializable Interface:**
    - Ensure the entity implements the `Serializable` interface if object serialisation is required for transmission or
      storage.

- **Database Constraints and Relationships:**
    - Ensure that the `name` column is not blank and has a minimum length;
    - Ensure that the `age` column enforces a minimum valid value;
    - Define a structured association between `Triathlete` and `Sponsor` entities through a join table.

- **Equals and HashCode:**
    - Override the `equals()` method to compare instances based on the `id` attribute;
    - Override `hashCode()` to generate a consistent hash code using `Objects.hashCode(id)`.

***

## Requirements for `TriathleteRepository` Interface:

- **Repository Definition:**
    - Define `TriathleteRepository` as a repository interface to manage `Triathlete` entities;
    - Extend `JpaRepository<Triathlete, Long>` to inherit standard CRUD operations and pagination capabilities.

- **Custom Query Methods:**
    - Declare `List<Triathlete> findByNameContainingIgnoreCase(String name)` to enable case-insensitive search for
      `Triathlete` entities by name.

- **Spring Data JPA Integration:**
    - Leverage Spring Data JPA's query derivation mechanism to generate the query for
      `findByNameContainingIgnoreCase(String name)`, ensuring flexible searching.

- **Entity Association:**
    - Ensure that the repository is correctly associated with the `Triathlete` entity, maintaining consistency with the
      database schema.

- **Code Simplicity and Maintainability:**
    - Utilise the built-in capabilities of `JpaRepository` to reduce boilerplate code and enhance maintainability.

***

## Requirements for `TriathleteService` Class:

- **Service Definition:**
    - Define `TriathleteService` as a service class responsible for business logic related to `Triathlete` entities;
    - Annotate the class with `@Service` to designate it as a Spring-managed service component.

- **Dependency Injection:**
    - Inject `TriathleteRepository` using `@Autowired` to enable interaction with the database.

- **CRUD Operations:**
    - Implement `createTriathlete(Triathlete triathlete)`, which saves a new `Triathlete` entity to the database;
    - Implement `readAllTriathletes()`, which retrieves a list of all registered triathletes;
    - Implement `readTriathleteById(Long id)`, which fetches a `Triathlete` entity by its identifier, throwing
      `TriathleteNotFoundException` if not found;
    - Implement `editTriathlete(Triathlete triathlete)`, which updates an existing triathlete's details;
    - Implement `deleteTriathlete(Long id)`, which first clears the association with sponsors before deleting the
      entity.

- **Custom Query Methods:**
    - Implement `readAllTriathletesByName(String name)`, which retrieves triathletes based on a case-insensitive search
      of their name.

- **Exception Handling:**
    - Ensure `readTriathleteById(Long id)` throws `TriathleteNotFoundException` if the requested entity is not found;
    - Ensure `deleteTriathlete(Long id)` utilises `readTriathleteById(Long id)` to verify existence before proceeding
      with deletion.

- **Data Integrity:**
    - Clear sponsorship associations before deleting a `Triathlete` to maintain referential integrity;
    - Use `triathleteRepository.save(triathlete)` after clearing sponsors to persist the changes before deletion.

- **Business Logic Separation:**
    - Ensure that `TriathleteService` strictly contains business logic, while data access remains in
      `TriathleteRepository`.

- **Code Maintainability:**
    - Leverage `Optional<Triathlete>` to handle nullability and reduce boilerplate code in
      `readTriathleteById(Long id)`;
    - Maintain a clear and structured approach to ensure service methods align with business requirements.

***

## Requirements for `TriathleteController` Class:

- **Controller Definition:**
    - Define `TriathleteController` as a Spring MVC controller to manage HTTP requests related to `Triathlete` entities;
    - Annotate the class with `@Controller` to indicate its role in handling web requests;
    - Use `@CrossOrigin(origins = "*", maxAge = 3600)` to allow cross-origin requests with a maximum cache age of 3600
      seconds.

- **Dependency Injection:**
    - Inject `TriathleteService` to handle business logic related to triathletes;
    - Inject `SponsorService` to retrieve sponsor data when required.

- **Request Mapping and Methods:**
    - Implement `listTriathletes(Model model)`, mapped to `@GetMapping("/")`, to display all triathletes in a list;
    - Implement `searchTriathletes(Model model, @Param("name") String name)`, mapped to `@PostMapping("/search")`, to
      filter triathletes based on a case-insensitive search by name;
    - Implement `newTriathlete(Model model)`, mapped to `@GetMapping("/new")`, to present the form for creating a new
      triathlete;
    - Implement
      `saveTriathlete(Model model, @ModelAttribute("newTriathlete") @Valid Triathlete triathlete, BindingResult errors, RedirectAttributes attributes)`,
      mapped to `@PostMapping("/save")`, to validate and save a new triathlete;
    - Implement `deleteTriathlete(@PathVariable("id") long id, RedirectAttributes attributes)`, mapped to
      `@GetMapping("/delete/{id}")`, to delete a triathlete, handling `TriathleteNotFoundException` if the ID is
      invalid;
    - Implement `editForm(Model model, @PathVariable("id") long id, RedirectAttributes attributes)`, mapped to
      `@GetMapping("/edit/{id}")`, to display the edit form for an existing triathlete;
    - Implement
      `editTriathlete(Model model, @PathVariable("id") long id, @ModelAttribute("objectTriathlete") @Valid Triathlete triathlete, BindingResult errors)`,
      mapped to `@PostMapping("/edit/{id}")`, to validate and update an existing triathlete;
    - Implement `viewForm(Model model, @PathVariable("id") long id, RedirectAttributes attributes)`, mapped to
      `@GetMapping("/view/{id}")`, to display details of a specific triathlete.

- **Exception Handling:**
    - Catch `TriathleteNotFoundException` when attempting to retrieve or delete a non-existent triathlete, redirecting
      with an error message if necessary.

- **Data Integrity and Validation:**
    - Ensure all triathlete-related forms are validated using `@Valid` and `BindingResult` to handle validation errors
      gracefully;
    - Redirect to the relevant form page with validation errors displayed if any issues arise.

- **Thymeleaf Integration:**
    - Return appropriate template names (e.g., `/list-triathletes`, `/new-triathlete`, `/edit-triathlete`,
      `/view-triathlete`) to be rendered using Thymeleaf.

- **Code Maintainability:**
    - Maintain separation of concerns by keeping business logic within `TriathleteService`;
    - Use `RedirectAttributes` to provide user-friendly feedback messages upon successful operations or errors.

***

## Requirements for `TriathleteNotFoundException` Class:

- **Class Definition:**
    - Define `TriathleteNotFoundException` as a custom exception to handle cases where a requested triathlete is not
      found;
    - Extend `RuntimeException` to allow unchecked exception handling.

- **Constructor and Message Formatting:**
    - Implement a constructor that accepts an `Object id` parameter;
    - Construct an error message in the format: `"Triathlete with id: <id> does not exist"`, ensuring clear and
      informative error messages.

- **Exception Handling Purpose:**
    - Use this exception within the `TriathleteService` class when attempting to retrieve or delete a triathlete by ID;
    - Facilitate structured error handling by throwing this exception when an invalid or non-existent ID is provided.

- **Code Maintainability:**
    - Keep the exception lightweight and focused solely on triathlete-related errors;
    - Ensure consistency in error messages to improve debugging and logging.

***

## Requirements for `Sponsor` Entity Class:

- **Entity Mapping:**
    - Define the `Sponsor` class as an entity to represent a database table in the application;
    - Annotate the class with `@Entity` to establish it as a persistent entity;
    - Use `@Table(name = "tb_sponsor")` to map it to the database table named `tb_sponsor`.

- **Attributes and Annotations:**
    - Define attributes `id`, `title`, and `triathletes` to map to the respective database columns;
    - Annotate the `id` field with `@Id` and `@GeneratedValue(strategy = GenerationType.IDENTITY)` to enable automatic
      primary key generation;
    - Use `@NotBlank(message = TriathleteSponsorshipMessages.SPONSOR_TITLE_REQUIRED)` to enforce that `title` must not
      be blank;
    - Apply `@Size(min = 2, message = TriathleteSponsorshipMessages.SPONSOR_TITLE_MIN_LENGTH)` to define a minimum
      character length for `title`;
    - Establish a bidirectional many-to-many relationship with `Triathlete` using `@ManyToMany(mappedBy = "sponsors")`.

- **Accessors and Mutators:**
    - Implement `getters` and `setters` for all attributes to facilitate data manipulation.

- **Entity Relationships:**
    - The `triathletes` attribute represents a list of `Triathlete` entities that are associated with a given sponsor;
    - The `mappedBy` attribute in `@ManyToMany` ensures that the relationship is controlled by the `sponsors` attribute
      in the `Triathlete` class.

- **Data Validation:**
    - Ensure `title` is non-null and meets the required length constraints to maintain data integrity.

- **Code Maintainability:**
    - Keep the class structure simple and aligned with best practices in JPA entity design;
    - Ensure consistency with application-wide validation messages stored in `TriathleteSponsorshipMessages`.

***

## Requirements for `SponsorRepository` Interface:

- **Repository Definition:**
    - Define the `SponsorRepository` interface to handle data access operations for the `Sponsor` entity;
    - Extend `JpaRepository<Sponsor, Long>` to inherit CRUD operations and pagination support.

- **Custom Query Methods:**
    - Declare `Optional<Sponsor> findByTitleIgnoreCase(String title);` to retrieve a `Sponsor` entity by its `title`,
      ignoring case sensitivity.

- **Spring Data JPA Integration:**
    - Leverage Spring Data JPA to automatically implement common database operations without requiring explicit query
      definitions;
    - Allow dependency injection of `SponsorRepository` into service classes to manage sponsor-related transactions.

- **Code Maintainability:**
    - Ensure that method names follow Spring Data JPA naming conventions to generate queries dynamically;
    - Use `Optional<Sponsor>` to handle potential null values safely when searching for a sponsor by `title`.

***

## Requirements for `SponsorService` Class:

- **Service Definition:**
    - Define the `SponsorService` class as a Spring-managed service using the `@Service` annotation;
    - Inject `SponsorRepository` using `@Autowired` to handle sponsor-related database operations.

- **Sponsor Creation:**
    - Implement the `createSponsor(Sponsor sponsor)` method to add new sponsors to the system;
    - Check if a sponsor with the same title already exists using `findByTitleIgnoreCase(String title)`;
    - Throw a `SponsorAlreadyExistsException` if a duplicate sponsor title is found;
    - Save and return the new sponsor entity if it does not exist.

- **Sponsor Retrieval:**
    - Implement the `readAllSponsors()` method to retrieve all sponsors from the database;
    - Use `findAll()` from `JpaRepository` to return a list of all sponsor entities.

- **Exception Handling:**
    - Ensure the application prevents duplicate sponsor entries by validating the sponsor's title before saving;
    - Utilise a custom exception (`SponsorAlreadyExistsException`) to notify when a sponsor with the same title already
      exists.

- **Best Practices:**
    - Follow the Dependency Injection principle to improve testability and maintainability;
    - Use `Optional<Sponsor>` to safely handle the presence or absence of a sponsor in the database.

***

## Requirements for `SponsorController` Class:

- **Controller Definition:**
    - Define the `SponsorController` class as a Spring MVC controller using the `@Controller` annotation;
    - Apply `@RequestMapping("/sponsor")` to group all endpoints under the `/sponsor` path;
    - Enable Cross-Origin Resource Sharing (CORS) with `@CrossOrigin(origins = "*", maxAge = 3600)`.

- **Sponsor Creation Form:**
    - Implement the `newSponsor(Model model)` method with `@GetMapping("/new")`;
    - Create a new `Sponsor` object and add it to the model with the attribute `"newSponsor"`;
    - Return the view `/new-sponsor` to render the sponsor registration form.

- **Sponsor Saving Process:**
    - Implement the `saveSponsor(Sponsor sponsor, BindingResult errors, RedirectAttributes attributes, Model model)`
      method with `@PostMapping("/save")`;
    - Use `@ModelAttribute("newSponsor")` to bind the submitted form data to a `Sponsor` object;
    - Validate the sponsor input using `@Valid` and `BindingResult` to handle validation errors;
    - If validation errors exist, return to `/new-sponsor` without saving the sponsor;
    - Call `sponsorService.createSponsor(sponsor)` to save the sponsor if no errors occur;
    - Handle `SponsorAlreadyExistsException` by adding an error message to the model and returning `/new-sponsor`;
    - If successful, add a success message using `RedirectAttributes` and redirect to `/sponsor/new`.

- **Exception Handling:**
    - Catch `SponsorAlreadyExistsException` when attempting to create a sponsor with a duplicate title;
    - Display an error message on the form without breaking the user experience.

- **Best Practices:**
    - Use `@RequestMapping("/sponsor")` for better route organisation;
    - Follow Spring MVC conventions by separating concerns between the controller, service, and repository layers;
    - Ensure form validation and proper error handling to improve user experience.

***

## Requirements for `SponsorAlreadyExistsException` Class:

- **Exception Definition:**
    - Define the `SponsorAlreadyExistsException` class to handle cases where a sponsor with the same title already
      exists;
    - Extend the `RuntimeException` class to create an unchecked exception.

- **Constructor Implementation:**
    - Implement a constructor that takes a `String title` as a parameter;
    - Call the superclass (`RuntimeException`) constructor with a meaningful error message:  
      `"Sponsor with title: " + title + " already exists"`.

- **Usage in Application:**
    - Throw this exception in the `SponsorService` class when attempting to save a sponsor with a duplicate title;
    - Handle this exception in the `SponsorController` class by displaying an error message to the user.

- **Best Practices:**
    - Ensure that meaningful exception messages are provided to improve debugging and user feedback;
    - Use unchecked exceptions (`RuntimeException`) for business logic validation to avoid excessive boilerplate code.

***

## Requirements for `TriathleteSponsorshipMessages` Utility Class:

- **Purpose and Structure:**
    - The `TriathleteSponsorshipMessages` class is a utility class designed to store constant message strings related to
      triathletes and sponsors;
    - Declare the class as `final` to prevent it from being subclassed;
    - Include a private constructor to prevent instantiation, with an exception being thrown (`IllegalStateException`)
      if the constructor is called, ensuring the class adheres to its utility role.

- **Triathlete Messages Constants:**
    - Define constants such as `TRIATHLETE_NAME_REQUIRED`, `TRIATHLETE_NAME_MIN_LENGTH`, `TRIATHLETE_AGE_MIN`, and
      `TRIATHLETE_SAVED_SUCCESSFULLY` to store messages related to triathletes;
    - Ensure each message is meaningful and aligns with the application's user feedback requirements.

- **Sponsor Messages Constants:**
    - Define constants such as `SPONSOR_TITLE_REQUIRED`, `SPONSOR_TITLE_MIN_LENGTH`, and `SPONSOR_SAVED_SUCCESSFULLY` to
      store messages related to sponsors;
    - Ensure these constants are self-explanatory and provide actionable information to the users.

- **Code Organisation:**
    - Group related constants logically under comments (e.g., `// Triathlete Messages` and `// Sponsor Messages`) to
      enhance readability and maintainability;
    - Use consistent naming conventions (`UPPERCASE_SNAKE_CASE`) for all constants, as per Java standards.

- **Immutability:**
    - Declare all constants as `public static final` to ensure they are immutable and can be accessed without
      instantiating the class.

- **Error Handling:**
    - Include a meaningful error message within the private constructor when the class is instantiated improperly to
      guide developers in adhering to its intended usage.

***

# Frontend Requirements Specification:

## Requirements for `list-triathletes.html` Page:

- **General Structure:**
    - The page is designed to display and manage a list of triathletes in a table format using Thymeleaf for dynamic
      content rendering;
    - Ensure the page structure adheres to standard HTML5 guidelines and utilises Bootstrap classes for responsive
      design.

- **Navigation and Actions:**
    - Provide buttons for creating new triathletes and sponsors, linking to the appropriate pages (`@{/new}` and
      `@{/sponsor/new}`);
    - Include a search form allowing users to search for triathletes by name. Add a "Cancel" button to reset the search
      and return to the main page (`@{/}`).

- **Table Design:**
    - Use a `table` element with Bootstrap's `table-striped` class for enhanced readability;
    - Display columns for `Id`, `Name`, `Age`, and action columns for `Delete`, `Edit`, and `View`;
    - Highlight column headers with a distinct background colour and centralised text for clarity.

- **Action Icons:**
    - Include icons for `Delete`, `Edit`, and `View` actions:
        - Use `fa-regular fa-trash-can` for the delete functionality, with a confirmation prompt implemented using
          `th:data-confirm-delete`;
        - Use `fa-regular fa-pen-to-square` for edit links;
        - Use `fa fa-eye` for viewing details.

- **Dynamic Content Rendering:**
    - Populate the table rows dynamically using Thymeleaf's `th:each` directive, iterating through the `listTriathletes`
      object;
    - Display a fallback message in the table (`"No Triathletes found."`) if `listTriathletes` is empty.

- **Error Messages:**
    - Display server-side error messages using a Bootstrap alert component (`alert-danger`);
    - Render the message dynamically using Thymeleaf's `th:if` and `th:text` directives.

- **Styling and Layout:**
    - Use inline styles within the `<style>` block to customise the table, including shadow effects and rounded corners
      for aesthetic appeal;
    - Style table headers and cells for improved readability:
        - Headers (`<th>`) use a blue background (`#007bff`) with white text;
        - Data cells (`<td>`) are centred and formatted for clarity, except `Name`, which is aligned to the left.

- **Scripts and Resources:**
    - Include necessary external resources:
        - Bootstrap CSS and JS for styling and functionality;
        - jQuery for any interactive elements;
        - Font Awesome for action icons;
    - Use Thymeleaf's `th:href` and `th:src` for resource management.

- **Responsive Design:**
    - Leverage Bootstrap's grid system (`row` and `col-sm-5`) to create a responsive layout, ensuring compatibility
      across various screen sizes.

- **Confirmation Handling:**
    - Implement a confirmation dialog for the delete functionality to prevent accidental deletions (`th:onclick` with
      `confirm`).

- **Accessibility and Usability:**
    - Provide meaningful icons and tooltips for all actionable links to enhance user experience;
    - Ensure buttons and links have intuitive colour schemes for hover and active states.

***

## Requirements for `view-triathlete.html` Page:

- **General Structure:**
    - The page is intended to display detailed information about a triathlete;
    - Use Thymeleaf templating to dynamically populate the content with data from the `objectTriathlete`.

- **Navigation:**
    - Include a `Back` button styled as `btn-back`, linking to the home page (`th:href="@{/}"`);
    - Provide hover effects for the `Back` button to enhance user interactivity.

- **Content Cards:**
    - Divide information into multiple Bootstrap `card` components:
        - **Name Card**: Displays the name of the triathlete;
        - **Age Card**: Displays the age of the triathlete;
        - **Sponsors Card**: Lists the sponsors of the triathlete.

- **Sponsor Table:**
    - Use a Bootstrap-styled `table` inside the "Sponsors" card for a clean and consistent layout;
    - Check if the `objectTriathlete.sponsors` list is empty using Thymeleaf's `th:if` directive, and display a fallback
      message (`"No Sponsors found."`) if no sponsors are present;
    - Dynamically populate the sponsor list using `th:each` for iteration.

- **Styling:**
    - Use custom CSS styles:
        - Style `.btn-back` with rounded corners, padding, and hover effects;
        - Style `.card` with a shadow effect, rounded corners, and a clean white background;
        - Apply a distinct header colour (`#007bff`) and text colour (white) to `.card-header` and `table th` for visual
          consistency.
    - Ensure that table cells (`table td`) have readable

***

## Requirements for `new-triathlete.html` Page:

- **General Structure:**
    - The page facilitates the registration of new triathletes;
    - Use Thymeleaf for dynamic data binding and rendering, ensuring compatibility with server-side logic.

- **Navigation:**
    - Include a `Back` button (`btn-back`) styled with rounded corners and hover effects, linking to the home page (
      `th:href="@{/}"`);
    - Provide an intuitive design for easy navigation back to the main interface.

- **Registration Form:**
    - Implement a form with `POST` method, binding it to the `newTriathlete` object using Thymeleaf (`th:object`);
    - Include fields for `Name`, `Age`, and a list of `Sponsors`:
        - Use the `th:field` attribute to bind inputs dynamically to the form object;
        - Validate fields using Thymeleaf's `th:errors` and display validation messages conditionally with `th:if`.

- **Field Components:**
    - **Name Field:** Input of type `text` with inline validation error messages for empty or invalid names;
    - **Age Field:** Input of type `number` with validation error messages for invalid ages;
    - **Sponsors Field:** Checkboxes dynamically generated using `th:each`, enabling users to select multiple sponsors
      from the `listSponsors`.

- **Success Alerts:**
    - Display a success message using a dismissible Bootstrap alert component if `message` is set (`th:if` and
      `th:text`).

- **Buttons:**
    - Include a `Save` button (`btn-save`) styled with consistent dimensions and visual emphasis to submit the form;
    - Use `aria-label` attributes for better screen reader accessibility on buttons.

- **Styling and Layout:**
    - Use a `card` container with a shadow and rounded corners for clean visual design;
    - Style the `card-header` with a distinct blue background (`#007bff`) and white text for header differentiation;
    - Organise sponsor checkboxes in a grid layout with three columns for a tidy and structured view.

- **Scripts and Resources:**
    - Include external resources dynamically using Thymeleaf:
        - Bootstrap for styling and layout (`@{/bootstrap-5.1.3-dist/css/bootstrap.min.css}`);
        - jQuery and Bootstrap JS for interactivity;
        - Font Awesome for any icons, ensuring cross-origin policies are respected;
        - A favicon for branding consistency (`triathlete-icon.svg`).

- **Responsive Design:**
    - Ensure the layout adapts gracefully across devices using Bootstrap's grid system (`row`, `col-sm-2`, `col-sm-10`,
      etc.);
    - Test for usability on both mobile and desktop interfaces.

- **Accessibility:**
    - Include `aria-label` attributes for form elements and buttons to ensure compatibility with screen readers;
    - Ensure error messages and validations are clearly visible to users.

- **Error Handling:**
    - Handle form validation errors effectively:
        - Highlight invalid fields and display context-aware error messages (`th:errors`);
        - Ensure the page gracefully handles any server-side validation issues.

***

## Requirements for `edit-triathlete.html` Page:

- **General Structure:**
    - The page should be a Thymeleaf-based HTML document for editing triathlete records;
    - Ensure the page follows a clean and structured design using Bootstrap for responsiveness and styling;
    - Include proper metadata, such as `viewport` settings, to ensure cross-device compatibility.

- **Styling and Layout:**
    - Use a custom `.card` component for the form and include rounded corners and shadow for visual appeal;
    - Style the `.card-header` with bold text and a distinct background colour (`#007bff`) for differentiation;
    - Create a `.sponsor-checkbox-container` with a grid layout (three columns) to display sponsors neatly.

- **Form Implementation:**
    - The form should use Thymeleaf syntax to bind the `objectTriathlete` and send `POST` data to the server;
    - Include input fields for `Name`, `Age`, and a checkbox list for `Sponsors` dynamically populated using Thymeleaf's
      `th:each`;
    - Ensure form fields are validated on the server side, with error messages displayed conditionally using `th:if`.

- **Button and Navigation Functionality:**
    - Include a `Back` button with proper styles to navigate to the home page (`th:href="@{/}"`);
    - Add a `Save` button styled with Bootstrap classes for submitting the form.

- **Script and Resource Management:**
    - Link to necessary external resources, including:
        - Bootstrap (CSS and JS);
        - jQuery;
        - Font Awesome for icons;
    - Ensure all resources use Thymeleaf's `th:href` and `th:src` syntax for dynamic URLs.

- **Accessibility and Usability:**
    - Use `aria-label` attributes for buttons and links for better screen reader support;
    - Include focus outlines and hover effects on buttons to improve user experience.

- **Error Handling:**
    - Display error messages for fields with validation errors (`name` and `age`) using `th:errors` and `span.message`
      for styling;
    - Add conditional rendering (`th:if`) for server messages within a dismissible Bootstrap alert.

- **Optimised Styling:**
    - Use inline styles in a `<style>` tag within the `<head>` to ensure unique, page-specific styling;
    - Ensure class-based styles (e.g., `.btn-back`, `.btn-save`) are used consistently for predictable behaviour.

- **Icons and Branding:**
    - Link a favicon (`triathlete-icon.svg`) using `th:href` for better branding;
    - Use Font Awesome icons where necessary to enhance visual clarity.

- **Grid Responsiveness:**
    - Implement Bootstrap's grid system (`row`, `col-sm`, `col-md`) to ensure the layout adapts gracefully across all
      screen sizes.

- **Validation and Error Feedback:**
    - Include inline feedback next to the fields for validation errors, enhancing form usability;
    - Render appropriate error messages for missing or invalid inputs (e.g., `Name` and `Age` fields).

***

## Requirements for `new-sponsor.html` Page:

- **General Structure:**
    - The page facilitates the registration of new sponsors within the system;
    - Employ Thymeleaf syntax for dynamic data binding and rendering, ensuring integration with the server-side logic.

- **Navigation:**
    - Include a `Back` button (`btn-back`) styled with rounded corners and hover effects, linking back to the home
      page (`th:href="@{/}"`);
    - Ensure the button includes an `aria-label` for accessibility.

- **Sponsor Registration Form:**
    - Implement a form using the `POST` method, bound to the `newSponsor` object through Thymeleaf (`th:object`);
    - Include a field for the `Title` of the sponsor:
        - Use `th:field` for data binding;
        - Validate the input and display error messages conditionally using `th:if` and `th:errors`.

- **Alerts and Messages:**
    - Display a success message using a Bootstrap alert component (`alert-success`), with a close button for dismissing
      it (`btn-close`);
    - Display an error message using a `alert-danger` if an error occurs during sponsor creation.

- **Buttons:**
    - Include a `Save` button (`btn-save`) styled for prominence to submit the form;
    - Add `aria-label` attributes to enhance accessibility for screen readers.

- **Styling and Layout:**
    - Use a `card` container to organise the form with a shadow effect, rounded corners, and a visually appealing white
      background;
    - Style the `card-header` with a distinct blue background (`#007bff`) and white text for header clarity;
    - Ensure the form elements (`input` fields) are styled for consistency using Bootstrap's `form-control` class.

- **Scripts and Resources:**
    - Include external resources dynamically through Thymeleaf for consistency:
        - Bootstrap CSS and JS for styling and layout (`@{/bootstrap-5.1.3-dist/css/bootstrap.min.css}`);
        - jQuery for interactive components;
        - Font Awesome for potential iconography;
        - A favicon for branding (`triathlete-icon.svg`).
    - Maintain the integrity and cross-origin attributes for external resources to ensure proper functioning.

- **Responsive Design:**
    - Use Bootstrap's grid system (`row`, `col-md-12`) to ensure the layout is adaptable to various screen sizes;
    - Test the page for usability across mobile and desktop devices.

- **Error Handling:**
    - Implement comprehensive field validation:
        - Highlight errors in the `Title` field using a red message displayed conditionally (`th:if`);
        - Ensure server-side validation errors are gracefully handled and displayed to the user.

- **Accessibility:**
    - Provide clear error messages and success feedback for better user experience;
    - Ensure all form elements and buttons are accessible to assistive technologies through proper attributes and visual
      indicators.

---