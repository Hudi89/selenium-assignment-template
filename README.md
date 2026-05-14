# Selenium 2 Testing Assignment - The Internet Heroku App

## 📌 Overview
This project is a Selenium-based test automation framework written in Java using JUnit and the Page Object Model (POM) design pattern.

The were are executed on the following website:
https://the-internet.herokuapp.com/

## 📌 Technologies Used
- Java
- Selenium WebDriver
- JUnit
- Gradle
- Page Object Model (POM)

## 📌 Project Structure
- pages/ → Page Object classes
- tests/ → Test classes
- utils/ → WebDriver factory

## 📌 Test Scenarios

### 1. Login Test
- Opens login page
- Performs login with valid credentials
- Verifies successful login message

### 2. Checkbox Test
- Navigates to checkbox page
- Toggles checkbox state
- Verifies checkbox selection

## 📌 Design Pattern
This project uses the Page Object Model (POM):
- Each page has its own class
- Common Selenium actions are centralized in BasePage
- Tests are structured and readable

## 📌 How to Run

```bash
gradle clean test