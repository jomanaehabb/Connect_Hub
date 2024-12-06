# Connect Hub

**Connect Hub** is a social media-like platform built with Java and Swing, designed to provide an engaging space for users to manage their profiles, create content (posts and stories), interact with friends, and stay updated through a newsfeed. The backend leverages a file-based database with JSON to store user data, posts, profiles, and friendships.
![image](https://github.com/user-attachments/assets/f4383b2a-2198-4325-9719-46cff6b37139)
---

## Table of Contents
- [Overview](#overview)
- [Features](#features)
- [Architecture](#architecture)
  - [Backend Components](#backend-components)
  - [Frontend Components](#frontend-components)
  - [Database Structure](#database-structure)
- [Design Patterns](#design-patterns)
- [SOLID Principles](#solid-principles)
- [Setup](#setup)
  - [Prerequisites](#prerequisites)
  - [Installation](#installation)
  - [Running the Application](#running-the-application)
- [Usage](#usage)
  - [User Flow](#user-flow)
- [License](#license)

---

## Overview

Connect Hub is an interactive social platform where users can:
- **Create and manage their profile**: Add a bio, upload a profile picture, and update their personal information.
- **Post content**: Users can create posts or share stories.
- **Interact with friends**: Send friend requests, accept or reject them, and manage the friends list.
- **Stay updated**: View a personalized newsfeed with posts from friends.

The project uses **Java** and **Swing** for the frontend, and **JSON files** for backend data storage. It follows key **design patterns** and adheres to the **SOLID principles** to maintain clean, scalable, and maintainable code.

---

## Features

- **User Account Management**: 
  - Registration and login using email and password.
  - Password validation, with the password stored securely.
  - User authentication with session management.
  
- **Profile Management**:
  - Users can create, update, and view their profiles.
  - Profile customization (bio, profile photo).
  - Ability to manage privacy settings.

- **Content Creation**:
  - Users can create posts, share stories, and comment on other users' posts.
  - Posts can be viewed in a dynamic newsfeed that updates in real-time.
  
- **Friend Management**:
  - Send, accept, or decline friend requests.
  - View a list of friends and interact with their content.
  
- **Newsfeed**:
  - Display posts and stories from friends.
  - Includes options to like, comment, and share posts.

---

## Architecture

### Backend Components

- **User Account Management**:
  - Handles user registration, login, and session management.
  - Validates user credentials, stores hashed passwords, and authenticates users during login.
  
- **Profile Management**:
  - Responsible for storing and updating user profile data such as bio, profile picture, and contact details.
  - Users can view and edit their profiles through the frontend.

- **Content Management**:
  - Manages the creation and storage of posts and stories.
  - Responsible for associating posts with users and storing them in the database.

- **Friend Management**:
  - Handles the friend request process.
  - Allows users to send, accept, reject, or delete friend requests.

- **Newsfeed**:
  - Displays a personalized stream of content (posts and stories) from friends.
  - Dynamically updates as new content is posted.

### Frontend Components

- **Java Swing UI**:
  - The user interface is built using Java Swing, providing an intuitive and responsive layout for interacting with the platform.
  - Key UI components include:
    - Login and registration forms.
    - Profile page (editable bio, profile picture).
    - Newsfeed displaying posts and stories.
    - Friends list with options to send or accept friend requests.
  
### Database Structure

- The backend uses a **file-based database** for persistent data storage, implemented in **JSON** format.
- **User Data**:
  - Stores user credentials, profile information, and friend relationships.
  - Includes security features such as hashed passwords and session tokens.
  
- **Post Data**:
  - Stores content for posts and stories, including text, image paths, timestamps, and associated user data.
  
- **Friendship Data**:
  - Maintains records of friend requests, accepted/rejected statuses, and active friendships.

The data is stored in individual JSON files for users, posts, and friends. This approach simulates a database system while keeping the implementation simple and lightweight.

---

## Design Patterns

1. **Factory Pattern**:
   - Used to create `User` objects. The `UserFactory` allows different types of users (e.g., normal user, admin) to be instantiated based on specific criteria.

2. **Strategy Pattern**:
   - Applied to password validation. The system can switch between different hashing strategies (e.g., bcrypt, SHA-256) depending on security needs.

3. **Command Pattern**:
   - Used for handling profile update requests. Each update operation is encapsulated as a command, allowing for easier extension and maintenance.

4. **Singleton Pattern**:
   - Used for managing a single instance of the database connection. Ensures that only one instance of the database manager exists during the application lifecycle.

---

## SOLID Principles

This project adheres to the **SOLID principles** to ensure that the codebase is modular, scalable, and easy to maintain:

1. **Single Responsibility Principle (SRP)**:
   - Each class has a single responsibility. For example, the `UserAccountManager` class handles only user account-related tasks, while `ProfileManager` handles profile management.

2. **Open/Closed Principle (OCP)**:
   - The system is open for extension but closed for modification. New features (e.g., new user roles, additional validation methods) can be added without altering existing code.

3. **Liskov Substitution Principle (LSP)**:
   - Subtypes of classes can be substituted without altering the correctness of the program. For example, derived classes of `Manager` (like `UserManager` or `ProfileManager`) can replace the base class without introducing issues.

4. **Interface Segregation Principle (ISP)**:
   - Interfaces are tailored to specific functionalities. For example, `IUserManager` only defines user-specific operations like creating a user, while `IProfileManager` defines methods for profile management.

5. **Dependency Inversion Principle (DIP)**:
   - High-level modules (such as user and profile management) depend on abstractions (interfaces) rather than concrete classes. This allows for easier testing and modification.

---

## Setup

### Prerequisites

- Java 11 or higher.
- A suitable IDE (e.g., IntelliJ IDEA, Eclipse).
- Basic understanding of Java, Swing, and JSON handling.

### Installation

1. **Clone the repository**:
   ```bash
   git clone https://github.com/your-username/connect-hub.git
