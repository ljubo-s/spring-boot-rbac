#   Use JPA + Hibernate + PostgreSQL in Spring Boot for Role-Based Access Control (RBAC) database model

##  Usage
-	Run the application and go on http://localhost:8080/
-	Use the index page to choose: 
    -	HTML web forms  
        -   Users
        -   Role
        -   Permisions
        -   Permission & Users
        -   Permision & Role
        -   Users & Role
    -	Bootstrap lists
        -   Users List
        -   Role List
        -   Permission List
        -   PermisionUsers List
        -   PermisionRole List
        -   UsersRole List
##  Build and run
### Configurations
Open the `application.properties` file and set your own configurations for the database connection.
###    Create database
Open `db.sql file` and use code for creating database.
### Prerequisites
-	Java 
-	Gradle
-	PostgreSQL
###    From Eclipse (Spring Tool Suite)
Import as Existing Gradle Project and run it as Spring Boot App.
###    Web server
Export to war, deploy on Tomcat server
### Junit Tests
- Inregration tests for Service and Repository
    -   UsersTest
    -   RoleTest
    -   PermisionsTest
    -   PermissionUsersTest
    -   PermisionRoleTest
    -   UsersRoleTest
