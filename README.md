# README - Whisky Production Management System (Desktop Application)

## 📌 General Information
- **Institution**: Polytechnic Institute of Viana do Castelo (IPVC)  
- **Course**: Computer Engineering  
- **Subject**: Project II  
- **Academic Year**: 2023/2024  
- **Authors**:    
  - Pedro Poças (№28976)
  - Tiago Baptista (№28998)
- **Project Title**: Whisky Production Management System  

## 📊 Project Overview
This project is a continuation of **Project I**, focusing on the development of a **desktop application** for managing whisky production. The system is designed to streamline operations related to order management, production control, and supplier interactions. The application is built using **Java**, **Hibernate** for database access, and **PostgreSQL** as the database management system.

The system is tailored for three main user roles:
- **Receptionist**: Manages supplier registration, order reception, and order registration.
- **Order Manager**: Handles order placement, order tracking, and supplier management.
- **Production Manager**: Oversees production initiation, production tracking, and monitoring of production phases.

## 🛠️ Technologies Used
- **Java**: Primary programming language for application development.
- **Hibernate**: ORM (Object-Relational Mapping) tool for database access.
- **PostgreSQL**: Relational database management system for storing production data.
- **Maven**: Dependency management and project build tool.
- **JavaFX**: For creating the graphical user interface (GUI).

## 📂 Project Structure
### 1️⃣ Use Case Model
The system is designed around three main user roles:
- **Receptionist**: Registers suppliers, receives orders, and logs them into the system.
- **Order Manager**: Places orders, tracks order status, and manages suppliers.
- **Production Manager**: Initiates production, tracks production phases, and monitors bottling processes.

### 2️⃣ Database Model
The database model was carefully designed to store all necessary information for the whisky production process. The final database schema includes tables for suppliers, orders, production phases, and more.

### 3️⃣ Database Access
- **Hibernate**: Used for seamless interaction with the PostgreSQL database.
- **Persistence.xml**: Configuration file for database connection and entity management.
- **Entity Package**: Contains auto-generated entities from the database schema.
- **BIL Package**: Includes methods for CRUD operations (Create, Read, Update, Delete) on the database entities.

### 4️⃣ Application Development
- **Low-Fidelity Prototypes**: Initial sketches and wireframes were created to visualize the application's layout and functionality.

### 5️⃣ Graphical User Interface (GUI)
The final GUI was designed to be both functional and aesthetically pleasing, ensuring a smooth user experience. Key features include:
- **Login Page**: Secure authentication for users.
- **Receptionist Interface**: Allows the receptionist to manage received lots, orders, and suppliers.
- **Order Manager Interface**: Enables the order manager to place orders, track order status, and manage suppliers.
- **Production Manager Interface**: Provides tools for initiating production, tracking production phases, and monitoring bottling processes.





