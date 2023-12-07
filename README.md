# Automated Web Testing for Userinyerface.com

This repository hosts automated tests for "https://userinyerface.com/" using Java and Selenium, with the `aquality-selenium` framework for enhanced testing capabilities.

## Programming Language & Framework

- **Java**: Our choice for strong typing and a robust ecosystem.
- **Selenium**: The core framework enabling browser automation.
- **aquality-selenium**: A corporate web automation framework that extends Selenium's functionalities and facilitates the Page Object Model implementation.

## Task Type

- **Test Automation**: Scripts for verifying web application functionalities.
- **Web**: Interactions with the web application through a browser interface.

## Required Skills

- **Communication**: Documented code and clear instructions.
- **OOP (Object-Oriented Programming)**: Encapsulation, abstraction, inheritance, and polymorphism are employed throughout the codebase.

## Requirements

- **Assertions**: All validations are executed with Asserts for precision in testing.
- **Page Object Pattern**: This design pattern is used to describe pages and elements, improving test maintenance and readability.
- **Framework Usage**: The `aquality-selenium` framework is integrated for adherence to corporate web automation standards.

## Test Cases

### Test Case 1: Functional Flow Validation

- **Homepage Access**: Confirm the welcome page load (`Expected: Welcome page is open`).
- **Page Navigation**: Navigate using the provided link (`Expected: The '1' card is open`).
- **Data Entry and Terms Acceptance**: Input valid data and accept terms (`Expected: The '2' card is open`).
- **Interest Selection and File Upload**: Choose interests and upload an image (`Expected: The '3' card is open`).

### Test Case 2: UI Element Interaction

- **Homepage Verification**: Ensure the homepage is displayed properly (`Expected: Welcome page is open`).
- **Help Form Manipulation**: Test the toggle functionality of the help form (`Expected: Form content is hidden`).

### Test Case 3: Cookie Acceptance

- **Homepage Confirmation**: Verify the welcome page presence (`Expected: Welcome page is open`).
- **Cookie Consent**: Check the cookie acceptance feature (`Expected: Form is closed`).

### Test Case 4: Timer Accuracy

- **Homepage Load**: Confirm the welcome page loads accurately (`Expected: Validate that timer starts from "00:00"`).

---
