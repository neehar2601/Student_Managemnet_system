# Student Information System

This project is a Java-based Student Information System that connects to an MS SQL database using JDBC.

## File Structure
StudentInformationSystem/ │ ├── src/ │ └── com_241047020/ │ ├── Student.java │ ├── StudentDAO.java │ ├── StudentDAOImpl.java │ ├── StudentNotFoundException.java │ └── StudentManagementApp.java │ ├── db.properties ├── lib/ │ └── mssql-jdbc-<version>.jar ├── schema.sql └── README.md



## Prerequisites

- **Java Development Kit (JDK)**: Version 11 or later.
- **MS SQL Server**: Running on host `172.16.51.64` with database `241047020`.
- **JDBC Driver**: Place the Microsoft JDBC driver in the `lib/` directory.
- **Database Table**: Use the `schema.sql` file to create the `Students` table in the database.

## Setup Instructions

1. Clone the repository or copy the project files.
2. Configure the database by running the `schema.sql` file in your MS SQL Server.
3. Place the `db.properties` file in the project's root directory and update it with your database credentials:
   ```properties
   db.url=jdbc:sqlserver://172.16.51.64:1433;databaseName=241047020
   db.username=neehara
   db.password=Nee@20


javac -d bin -cp lib/mssql-jdbc-<version>.jar src/com_241047020/*.java
java -cp bin:lib/mssql-jdbc-<version>.jar com_241047020.StudentManagementApp


Usage
Run the Application: Follow the interactive menu options to:
## Usage
1. Add a student.
2. View all students.
3. Search for a student by roll number.
4. Exit 
