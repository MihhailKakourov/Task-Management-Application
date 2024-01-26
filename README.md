# Task Management Application

A simple web application for managing tasks (to-do list) using Java, Spring Boot, and Hibernate.

## Table of Contents
- [Introduction](#introduction)
- [Features](#features)
- [Getting Started](#getting-started)
  - [Prerequisites](#prerequisites)
  - [Installation](#installation)
- [Usage](#usage)
- [Technologies Used](#technologies-used)
- [Functional requirements](#Functional-requirements)
- [Participants](#Participants)
- [ERD](#ERD)

## Introduction

This project is a basic task management application that allows users to create, view, update, and delete tasks.

## Features

- Create, update, and delete tasks.
- View a list of tasks.
- Task status tracking (completed or pending).
- Simple and intuitive user interface.

## Getting Started

### Prerequisites

Make sure you have the following installed:

- [Java Development Kit (JDK)](https://www.oracle.com/java/technologies/javase-downloads.html)
- [Maven](https://maven.apache.org/download.cgi)
- Your preferred IDE

### Installation

   1. Clone the repository:
   ```
   git clone https://github.com/MihhailKakourov/Task-Management-Application.git
   ```
   2. Navigate to the project directory:
   ```
   cd task-management-system
   ```
   3. Build the project:
   ```
    mvn clean install
   ```
### Usage
   1. Run the application:
   ```
   mvn spring-boot:run
   ```
   2. Open your browser and go to:
   ```
   http://localhost:8080
   ```
## Technologies Used
   - Java

   - Spring Boot

   - Hibernate

   - Thymeleaf

## Functional requirements
- Guest
    ```
    View tasks
    Filtering tasks
    ```
- User
    ```
    Creating tasks
    View the list of tasks
    Editing a task
    Deleting a task
    Mark a task as completed
    Filtering tasks
    ```
- Administrator
    ```
    All user capabilities
    Task management (edit and delete tasks created by any user. Ability to view a list of  all tasks)
    ```

## Participants
   - @TomatoJami - Eduard Toomemets

   - @MihhailKakourov - Mihhail Kakourov

   - @IvanAntipov777 - Ivan Antipov
## ERD
![ERD](https://github.com/MihhailKakourov/Task-Management-Application/blob/master/ERD.png)
