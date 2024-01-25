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
