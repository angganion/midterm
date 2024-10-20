# Spring Boot Project

This project is a Spring Boot application designed to EXAM.

## Prerequisites

- **JDK 21**: Ensure you have JDK 21 installed and configured in your environment.
- **Gradle**: The project uses the Gradle Wrapper (`gradlew`), so you don't need to install Gradle separately.
- **Docker**: Docker needs to be installed and running on your system.
- **Docker Compose**: Required for building and running the application in a containerized environment.

## Building the Project

### 1. Build the JAR

To build the Spring Boot project and create a JAR file, run the following command in the root directory of the project:

```bash
./gradlew clean build
```

This command will clean the previous builds and compile the project, packaging it into a JAR file located in the `build/libs` directory.

### 2. Run the database server

Berfore running your application, you need to run the database server using docker compose.

   ```bash
   docker compose up db
   ```

Note: credentials for database can be found in file `app.env`. The credential also stored in your `application.yml` file.


### 3. Run the Application

You can run the Spring Boot application using the Gradle `bootRun` task:

```bash
./gradlew bootRun
```

This command will start the application on the default port specified in your `application.yml` file (port 8080).


### 4. Populate Database for Testing

You can use INSERT statements in file `sample.sql` to pre-populate tables for testing.


## Cleaning Up

To clean the project and remove all the generated files, run:

```bash
./gradlew clean
```

To stop and remove the Docker containers started by Docker Compose, use:

```bash
docker compose down
```

## Troubleshooting

If you encounter issues, consider the following steps:

- **Ensure Docker is Running**: Docker services must be running for Docker and Docker Compose commands to work.
- **Check Dependencies**: Make sure all dependencies are correctly specified in your `build.gradle` file.
- **Clear Cache**: Sometimes, clearing the Gradle cache can help resolve build issues. Use `./gradlew clean` to do so.
