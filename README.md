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

- Create and update tasks.
- View a list of tasks.
- Task status tracking.
- Simple and intuitive user interface.
- Admin panel template, where you can see list of users (WIP)

## Getting Started

### Prerequisites

Make sure you have the following installed:

- [Java Development Kit (JDK)](https://www.oracle.com/java/technologies/javase-downloads.html)
- [XAMPP](https://www.apachefriends.org/ru/index.html)
- [IntelliJ IDEA](https://www.jetbrains.com/idea/)

### Installation

   1. Clone the repository:
   ```
   git clone https://github.com/MihhailKakourov/Task-Management-Application.git
   ```
   2. Chose the project directory in your IDE.
   3. Run Apache and MySQL servers in XAMPP.
   4. Run the project through main class (src/main/java/TodolistApplication.java).
### Usage
   1. Run the application.
   2. Open your browser and go to:
   ```
   http://localhost:3000/
   ```
## Technologies Used
   - Java

   - Spring Boot

   - Hibernate

   - Thymeleaf
     
   - Spring Security 

## Functional requirements
- Guest
    ```
    Login
    Signup
    Navigate through pages
    ```
- User
    ```
    Creating tasks
    View the list of tasks
    Editing a task
    Mark a task as completed
    ```
- Administrator
    ```
    All user capabilities
    User management (see list of users, delete user, add new user)
    ```

## Participants
   - @TomatoJami - Eduard Toomemets

   - @MihhailKakourov - Mihhail Kakourov

   - @IvanAntipov777 - Ivan Antipov
## ERD
![ERD](https://github.com/MihhailKakourov/Task-Management-Application/blob/master/ERD.PNG)
