# SMS-Test
# SMS Dev App

This project is a Java-based application for managing SMS subscribers. It allows users to create and log in subscribers, and view remaining balance lists.

## Table of Contents

- [Getting Started](#getting-started)
- [Project Structure](#project-structure)
- [Usage](#usage)
- [Test Cases](#test-cases)
- [Automation Scripts](#automation-scripts)
- [Screenshots](#screenshots)
- [Contributing](#contributing)
- [License](#license)

## Getting Started

These instructions will help you set up the project on your local machine for development and testing purposes.

### Prerequisites

- Java Development Kit (JDK) 8 or higher
- Maven
- An IDE (e.g., IntelliJ IDEA, Eclipse)

### Installation

1. **Clone the repository:**

    ```bash
    git clone https://github.com/yourusername/sms-dev-app.git
    cd sms-dev-app
    ```

2. **Build the project using Maven:**

    ```bash
    mvn clean install
    ```

3. **Run the application:**

    ```bash
    mvn exec:java -Dexec.mainClass="org.example.Main"
    ```

## Project Structure

```plaintext
sms-dev-app
├── src
│   ├── main
│   │   └── java
│   │       └── org
│   │           └── example
│   │               ├── Main.java
│   │               └── aomClient.java
│   └── test
│       └── java
│           └── org
│               └── example
│                   └── AomClientTest.java
├── pom.xml
└── README.md

Usage
Start the application:

Run the Main class. You will see the following options:
Hello world!
Operator Web Selfcare
1. Create Subscriber
2. Show Remaining Balance List
3. Exit
Enter your choice: 

Create Subscriber:

Select option 1 and enter the required details when prompted.

Show Remaining Balance List:

Select option 2 to log in and view the remaining balance list. (Note: The implementation for showing the balance list needs to be completed.)

Exit:

Select option 3 to exit the application.

Test Cases
Test Case 1: Create Subscriber Successfully
Description: Verify that a new subscriber can be created successfully.
Expected Result: The message "Subscriber created successfully!" is displayed.
Test Case 2: Create Subscriber with Invalid Data
Description: Verify that the application handles invalid input data gracefully.
Expected Result: An error message is displayed and the subscriber is not created.
Test Case 3: Login Subscriber Successfully
Description: Verify that a subscriber can log in successfully.
Expected Result: The message "Logged in successfully!" is displayed and a token is returned.
Test Case 4: Login Subscriber with Invalid Credentials
Description: Verify that the application handles invalid login credentials appropriately.
Expected Result: An error message is displayed indicating invalid credentials.

Screenshots(WILL ADD LATER)
Home Screen

Create Subscriber Screen

Login Subscriber Screen
