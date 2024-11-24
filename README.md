# Playwright Task Automation Project

This project automates scenarios on [Demoblaze](https://www.demoblaze.com/) using **Playwright** and **TestNG** with the **Page Object Model (POM)** design pattern.

## Project Structure

### Dependencies
The project relies on the following key dependencies, defined in the `pom.xml`:

1. **Playwright Java**: Core library for browser automation.
2. **TestNG**: Test framework for defining and executing test cases.
3. **Maven Surefire Plugin**: For executing TestNG tests via Maven.

### Architecture
The project follows the **Page Object Model (POM)** design pattern to ensure maintainable and reusable code.

- **Pages**:  
  Each webpage has a corresponding `Page` class containing locators and methods to interact with elements.  
  Example classes:
    - `HomePage.java`
    - `SignUpPage.java`
    - `LoginPage.java`
    - `CartPage.java`

- **Tests**:  
  Test classes are organized per functionality and interact with `Page` classes to execute scenarios.  
  TestNG annotations (e.g., `@Test`, `@BeforeClass`) are used for test lifecycle management.

- **TestNG and Reports**:
    - A `testng.xml` configuration file defines the test execution flow.
    - Reports are generated in the `test-output` directory for execution results.

### Benefits of the Architecture:
- Easy scalability for adding new tests.
- Separation of concerns for better code maintenance.
- Re-usability of common actions across tests.

## Scenarios Automated

1. **User Registration**: Register a new user with unique data.
2. **User Login**: Login with valid credentials.
3. **User Logout**: Log out successfully.
4. **Place an Order**: Add "Apple Monitor 24" to the cart and complete the purchase.

## Prerequisites
1. **Java JDK 8+** installed (`java -version`).
2. **Maven** installed (`mvn -version`).
3. Install Playwright browsers:
   ```bash
   mvn exec:java -Dexec.mainClass="com.microsoft.playwright.CLI" -Dexec.args="install"

## How To Run
mvn test