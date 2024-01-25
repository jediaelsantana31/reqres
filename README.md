# Reqres Automated Tests

## Prerequisites

Make sure you have the following tools installed before running the tests:

- [Java -JDK8](https://www.oracle.com/br/java/technologies/javase/javase8-archive-downloads.html) or higher
- [Maven](https://maven.apache.org/download.cgi)
- [Git](https://git-scm.com/book/en/v2/Getting-Started-Installing-Git)
- [Allure Report](https://allurereport.org/docs/gettingstarted-installation/)

## Setup
 **Clone the project:**
  ```
   git clone https://github.com/jediaelsantana31/reqres.git
  ```

## Running Tests
Execute the Selenium tests using the following Maven command:
 ```
   mvn clean test
  ```

## Generate Report
 	allure serve

## Project Structure

        reqres-rest
		├── .github
		│   └── workflows
		│       └── rest-test.yaml
		├── src
		│   ├── main
		│   │   ├── java
		│   │   │   └── com
		│   │   │       └── reqres
		│   │   │           ├── pojo
		│   │   │           ├── service
		│   │   │           ├── utils
		│   │   │           └── validation
		│   │   └── resources
		│   │       └── schemas
		└── pom.xml

  # Test Cases
  
  **Scenarios:**
```
 Feature: User Creation

  Scenario Outline: Given a valid user, when creating a user, then the user is registered
    Given a valid user
    When creating the user
    Then the user is registered successfully

	Examples:
	    | simulate error in the contract |
            | true                           |
            | false			     |

  Scenario: Given a valid user, when creating a user with an invalid endpoint, then should return 404 status code
    Given a valid user
    When creating the user with an invalid endpoint
    Then should return a 404 status code


  Scenario: Given a valid user, when creating a user with an invalid body, then should return 400 status code
    Given a valid user
    When creating the user with an invalid body
    Then should return a 400 status code
```

# Test Results

| Test Case                                                 | Status  |
|-----------------------------------------------------------|---------|
| Given a valid user, when creating a user, then the user is registered - true | Passed  |
| Given a valid user, when creating a user, then the user is registered - false | Failed  |
| Given a valid user, when creating a user with an invalid endpoint, then should return 404 status code | Passed  |
| Given a valid user, when creating a user with an invalid body, then should return 400 status code | Failed  |

## Overall Test Results

- Passed: 2
- Failed: 2
- Total Executed: 4
