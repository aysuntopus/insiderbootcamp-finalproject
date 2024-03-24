# insiderbootcamp-final-project



The repository contains tests based on Page Object Model, Selenium, TestNG using Java for insider bootcamp final project.

## Short Test Framework Description

-   This test framework is being built with Page Object Pattern, Page Objects include whole pages' elements and actions.
-   Abstract components includes common element for pages (like footer, header etc.) and common methods are used from test cases.
-   Mongodb was used to keep the test results.
-   TestNG Listeners were used to retrieve test results and write them to the database.

## Prerequisites
Before you can run this project, you must have the following software installed on your computer:
-   Java Development Kit (JDK) version 21
-   Apache Maven
-   Google Chrome and Firefox web browsers

## Dependencies
This project uses the following dependencies:
-   Selenium Java version 3.141.59
-   TestNG version 7.1.0

## Run

-   Navigate to the project directory using command line.
    
-   Run the following command to run test cases for both browser
    
    ```
      mvn test  
    
    ```
    
-   or you can run test cases for selected browser. Replace "browserName" with the name of the browser.    
    ```
      mvn test -P {browserName}
    
    ```
## CI ScreenShot
- Added screenshot from Jenkins Test Results included test duration, fail and pass info, also you can find them under Test-screenshot File.
![Test Result](https://i.postimg.cc/Yq4T4Zpq/Jenkinstestoutput.png)

![Test Result](https://i.postimg.cc/3wrswRNz/Jenkinstestoutput2.png)

## Test Result Visualization 

- You can see Test Result Dashboard from Grafana Link: 