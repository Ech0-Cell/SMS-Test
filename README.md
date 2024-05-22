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

1. Clone the repository:

    ```bash
    git clone https://github.com/yourusername/sms-dev-app.git
    cd sms-dev-app
    ```

2. Build the project using Maven:

    ```bash
    mvn clean install
    ```

3. Run the application:

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
Here are the implemented test cases along with their single-line descriptions:

1. TC_001: Create Subscriber
   - Tests the functionality to create a new subscriber by providing necessary information.

2. TC_002: Show Remaining Balance List
   - Verifies the capability to retrieve and display the remaining balance list after logging in.

3. TC_003: User Login Authentication
   - Validates the authentication process for user login.

4. TC_004: User Registration Validation
   - Checks the validation process for user registration.

5. TC_005: User Logout Functionality
   - Tests the functionality to log out a user after completing tasks.

6. TC_006: Send SMS Message
   - Validates the capability to send an SMS message after logging in.

7. TC_007: View SMS Inbox
   - Verifies the ability to view the SMS inbox after logging in.
