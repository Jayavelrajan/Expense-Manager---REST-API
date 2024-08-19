# Expense-Manager---REST-API
Expense Tracker API! This REST API, built with Spring Boot, provides endpoints for managing expenses and users. It allows you to create, read, update, and delete expenses and users, as well as filter expenses by category, keyword, and date.

## Getting Started

To get a local copy of the project up and running, follow these steps:

1. **Clone the repository:**

   ```bash
   git clone https://github.com/your-username/expense-tracker-api.git

2. **Navigate to the project directory:**

   ```bash
   cd expense-tracker-rest-api

3. **Install dependencies:**

   ```bash
      mvn install

4. **Set up the database:**

- Ensure you have MySQL installed and running.
- Create a new database for the project.
- Import the schema from the provided schema.sql file into your MySQL database.

5. Configure the database connection:
- Update the src/main/resources/application.properties file with your MySQL database credentials:
   ```bash
   spring.datasource.url=jdbc:mysql://localhost:3306/your-database-name
   spring.datasource.username=your-username
   spring.datasource.password=your-password
   spring.jpa.hibernate.ddl-auto=update

6. **Run the application:**
    ```bash
    mvn spring-boot:ru
