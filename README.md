﻿# Simple Project on Java

## Overview

This project is a simple MCQ quiz system implemented in Java, where an admin can add multiple-choice questions to a quiz bank, and students can take the quiz. The system uses a `userList.json` file for login credentials and a `questionList.json` file to store the quiz questions and answers.

## Features

- **Admin Functionality:**
    - Login with admin credentials.
    - Add new questions to the quiz bank.
    - Save questions to `questionList.json`.

- **Student Functionality:**
    - Login with student credentials.
    - Take a quiz with 10 random questions from the quiz bank.
    - Receive a score and performance feedback.
 
## Video


https://github.com/user-attachments/assets/410de899-77fc-4cef-89ca-6ca557697ee2


## Project Structure

- `userList.json`: Stores the user credentials and roles.
- `questionList.json`: Stores the quiz questions, options, and answer keys.
- `src`: Contains the Java source code files.

## Running the Project


1. Ensure you have Java and Gradle installed on your system.
2. Place the `users.json` and `quiz.json` files in the `data` directory.
3. Navigate to the project directory and run:
