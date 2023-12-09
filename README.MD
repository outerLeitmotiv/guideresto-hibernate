# GuideResto - Hibernate Integration Demo

## Overview
GuideResto is a demonstration project that illustrates the integration of **Hibernate ORM** with an existing database schema. This project focuses on showcasing how Hibernate can be used for database operations in a Java application, particularly in the context of a restaurant evaluation system.

## Features
- **Entity Mapping:** Showcases mapping Java classes to database tables using Hibernate annotations.
- **CRUD Operations:** Implements basic Create, Read, Update, Delete operations via Hibernate's APIs.
- **Relationship Management:** Demonstrates handling one-to-many and many-to-one relationships.
- **Lazy Loading/Eager Fetching:** Explores Hibernate's strategies for loading data.
- **Inheritance Mapping:** Presents handling inheritance hierarchies in Hibernate.

## Project Structure
- `src/main/java/ch/hearc/ig/guideresto/business`: Domain model classes.
- `src/main/java/ch/hearc/ig/guideresto/persistence`: DAO classes for database operations.
- `src/main/java/ch/hearc/ig/guideresto/presentation`: CLI class for user interactions.
- `src/main/java/ch/hearc/ig/guideresto/persistence/HibernateUtil.java`: Configuration class for Hibernate's SessionFactory.
- `src/main/resources/hibernate.properties`: Property file for Hibernate configuration.

## Setup and Running
To run this project:
1. Ensure a **Java Development Kit (JDK)** is installed.
2. Set up a database corresponding to the expected schema by the application.
3. Update `hibernate.properties` in `src/main/resources` with the appropriate database connection settings.
4. Build and run the application to interact with the database via the command line interface.

## Note
This project serves as an educational tool to demonstrate the use of Hibernate with an existing database schema and is not intended for production use.
