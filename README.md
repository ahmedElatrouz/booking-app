# Project Overview

The project is a hotel booking application that allows users to search for and book rooms at hotels. The application has a REST API that provides CRUD functionality for the following entities:

- Hotel: Represents a hotel and includes fields such as id, name, location, rating, and amenities.
- Room: Represents a room in a hotel and includes fields such as id, hotel, roomType, numBeds,             price, and availability.
- User: Represents a user and includes fields such as id, name, email, and phone.
- Booking: Represents a booking made by a user and includes fields such as id, room, user, payment,            startDate, endDate, numGuests, and cost.
- Review: Represents a review left by a user for a hotel and includes fields such as id, hotel, user, rating, comments, and date.
- Payment: Represents a payment made by a user for a booking and includes fields such as id, booking, amount, paymentMethod, and paymentStatus.

# Outstanding Issues and Tasks

- The REST API needs to be thoroughly tested to ensure it is stable and reliable.
- features and functionality need to be implemented, such as search and filter functionality for hotels and rooms, and payment processing for bookings.
- The project needs to be deployed.
- Documentation and user guides need to be created.

# Setting Up the Project

To set up the project locally, you will need to have the following software installed on your machine:

- Java 11
- Maven
- MySQL (or not, because H2 is used by default)

Once you have these dependencies installed, follow these steps to set up the project:

- Clone the project repository to your local machine.
- Open the project in your preferred Java IDE.
- Build the project using Maven.
- Run the project as a Spring Boot application.

The application should start up and the REST API will be available at http://localhost:8080/booking-app. You can use a tool like Postman to test the API and perform CRUD operations on the entities.

# Author

Ahmed Elatrouz

# Acknowledgements

This Project was built using the Spring Initializr tool.
