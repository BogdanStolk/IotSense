**Sensor Data Simulator**
**Overview**

This project is a simulation tool designed to generate and monitor sensor data, such as temperature and humidity, 
typically used in home interface devices. It uses Java with Spring Boot for the backend, 
Maven for dependency management, and PostgreSQL as the data persistence layer. The simulation logic takes into account 
daily and seasonal variations, as well as a noise factor to mimic real-world sensor imperfections.

**Project Structure**

The codebase is organized as follows:

com.sense package contains the main application and service layer for CRUD operations on sensor data.

com.sense.sensor includes sensor implementations that generate simulated data.

com.sense.repository handles data persistence.

com.sense.controller provides the REST API endpoints for interacting with sensor data.
com.sense.config contains the configuration for sensor beans.

com.sense.model defines the SensorData entity.

com.sense.scheduler schedules the regular generation of sensor data.
com.sense.database manages database interactions.

com.sense.generator contains the logic for generating lists of sensor data.

The project also includes a comprehensive suite of unit tests to validate the business logic.


**Prerequisites**

Java JDK 8 or higher
Maven
PostgreSQL

**Setting Up the Development Environment**

Clone the repository to your local machine.
Ensure PostgreSQL is installed and running.
Create a database named iotdata
Configure the application.properties file with the correct PostgreSQL connection details.

**Running the Application**

To run the application, navigate to the root directory of the project and execute:
mvn spring-boot:run

This will start the application on the default port 8080.

**Using the Application**

After starting the application, you can interact with the API using the following endpoints:

GET /api/sensor-data - Retrieve all sensor data records.

GET /api/sensor-data/{id} - Retrieve a specific sensor data record by ID.

POST /api/sensor-data - Create a new sensor data record.

PUT /api/sensor-data/{id} - Update an existing sensor data record.

DELETE /api/sensor-data/delete/{id} - Delete a sensor data record by ID.

**Running Tests**

To run the unit tests, execute:
mvn test

The tests cover a wide range of scenarios, including CRUD operations and sensor data generation logic.

**Contributing**

Pull requests are welcome. Please make sure to update tests as appropriate.

**Versioning**

Git for version control. You can view the commit history to see the changes that have been made 
and how the project has evolved over time.

**License**

MIT

