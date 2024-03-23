# Selenium Tests - Online Shopping

The repository contains tests based on Page Object Model, Selenium, TestNG using Java on AutomationExercise website which is full-fledged practice for Automation Engineers and it provides: 
- Ability to user account creation,
- Login, logout and delete account operations,
- Add to cart from recommended items,
- View category products,
- Add products to cart and finish the order

```App links : https://automationexercise.com/```

## Short Test Framework Description

- This test framework is being built with Page Object Pattern, Page Objects include whole pages' elements and actions.
- Abstract components includes common element for pages (like footer, header etc.) and common methods are used from test cases.
- Extentreports library is used for graphical reporting.
- TestNG Listeners is used to take a screenshot of the browser window when a test case fails.

## Prerequisites
Before you can run this project, you must have the following software installed on your computer:
- Java Development Kit (JDK) version 21
- Apache Maven
- Google Chrome web browser
  
 ## Dependencies
This project uses the following dependencies:
- Selenium Java version 3.141.59
- TestNG version 7.1.0
  
## Installation
- Clone with Git using command line and this command:
```sh
git clone https://github.com/aysuntopus/selenium_test
```
## Run
- Navigate to the project directory using command line.
- Run the following command but replace "TestClass" with the name of the test case.
  
        mvn test -Dtest=TestClass (mvn test -Dtest=RegisterUser)  
- or you can run all test cases with test suite via given command:
  
        mvn clean test -DxmlFilePath=testng
## Test Cases Covered (so far)
- Register user
- Login user with correct email and password
- Login user with incorrect email and password
- Logout user
- Delete user account
- Verify all products and product detail page
- View category products
- View brand products
- Search product
- Add products in cart
- Add to cart from recommended items
- Verify product quantity in cart
- Remove products from cart
- Verify all links are working 
- Place order: Register while checkout
- Place order: Login before checkout
