# Training Center Management System

A Spring Boot application for managing training centers with MongoDB backend. This system allows you to create, read, update, and delete training center information with proper validation and data consistency.

## Features

-   MongoDB document-based storage
-   Field validations for all training center properties
-   Unique center code enforcement
-   Automatic creation timestamp

-   RESTful API endpoints
-   Error handling for duplicate entries

## Prerequisites

-   Java 21 or higher
-   MongoDB 6.0 or higher
-   Gradle 8.x
-   Spring Boot 3.4.3

## Project Structure

```
src/
├── main/
│   ├── java/
│   │   └── com/
│   │       └── train8/
│   │           └── train8mvp/
│   │               ├── Controller/
│   │               ├── Model/
│   │               ├── Repository/
│   │               ├── Service/
│   │               ├── Exception/
│   │               └── config/
│   └── resources/
│       └── application.properties
```

## Setup Instructions

1. **Install MongoDB**

    ```bash
    For Windows:
    Download and install from https://www.mongodb.com/try/download/community

    For Ubuntu:
    sudo apt update
    sudo apt install mongodb
    ```

2. **Clone the Repository**

    ```bash
    git clone https://github.com/05shourya/train8mvp_assignment
    cd train8mvp
    ```

3. **Configure MongoDB**

    - The application is configured to connect to MongoDB at:
        - Host: localhost
        - Port: 27017
        - Database: train8db
    - To modify these settings, update `src/main/resources/application.properties`

4. **Build the Project**

    ```bash
    ./gradlew.bat clean build
    ```

5. **Run the Application**
    ```bash
    ./gradlew.bat bootRun
    ```

## API Endpoints

```
POST    /api/training-centers      - Create a new training center
GET     /api/training-centers      - List all training centers
GET     /api/training-centers/{id} - Get a specific training center
```

### Sample Request Body

```json
{
    "centerName": "Tech Learning Hub",
    "centerCode": "TCHLRN123458",
    "address": {
        "detailedAddress": "123 Main Street",
        "city": "Bangalore",
        "state": "Karnataka",
        "pinCode": "560001"
    },
    "studentCapacity": 200,
    "coursesOffered": ["Java", "Spring Boot", "React", "MongoDB"],
    "contactEmail": "contact@xyz.com",
    "contactPhone": "+911234567890"
}
```

## Error Handling

The application includes comprehensive error handling for:

-   Duplicate center codes
-   Invalid field values
-   Validation failures
-   Resource not found
