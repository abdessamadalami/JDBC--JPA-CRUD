# JDBC-Starter-Project

#### **_What is JDBC:_**

JDBC (Java Database Connectivity) is a Java API that provides a standard way for Java applications to interact with
relational databases. It offers a set of classes and interfaces that allow developers to establish database connections,
execute SQL queries, and retrieve results.

Spring provides a template class called **JdbcTemplate** to interact with databases which offers a wide array of methods
to
perform storage and retrieval of data. The JdbcTemplate class hides all the boilerplate code for connection management
and error handling whereby the developer can focus on the SQL query.
JDBC starter project, connect to the H2 database, create a table, and add data to the table.

#### **_H2 Database:_**

H2 is an open-source, lightweight, and fast in-memory relational database management system written in Java. It is
designed to be embedded within Java applications, providing a simple and efficient solution for storing and retrieving
data.

One of the key advantages of H2 is its speed and performance. Being an in-memory database, H2 stores data in memory
rather than on disk, allowing for lightning-fast data access and query execution. It is optimized for high performance,
making it an excellent choice for applications that require rapid data processing and real-time analytics.

H2 supports a wide range of SQL syntax and features, ensuring compatibility with standard SQL queries and operations. It
offers support for various data types, indexes, and constraints, allowing developers to build robust and reliable
database applications.

H2 can still be used effectively for smaller data sets or as a temporary storage solution during development and testing
phases. It offers a lightweight and easy-to-use option for these scenarios. It is always important to consider the
specific requirements of your application and the scalability needs when choosing a database solution for storing big
data.

#### **_ResultSet_**:

In Java, a ResultSet is an interface provided by the JDBC API. It represents the result of executing a
database query and encapsulates the data returned from the database. The ResultSet allows you to navigate through the
rows of the result set, retrieve data from each row, and perform operations such as moving the cursor to the next row or
accessing column values. It provides methods to access and manipulate data based on column indices or column names. The
ResultSet is a fundamental component in JDBC for working with query results.

#### **DAO** (Data Access Object)

The DAO pattern is a design pattern commonly used in Java applications to provide an
abstraction layer between the application code and the underlying database. The purpose of a DAO class is to encapsulate
the logic for accessing and manipulating data, hiding the details of the database implementation from the rest of the
application. It provides methods to perform CRUD (Create, Read, Update, Delete) operations on data entities. The DAO
class typically contains methods for retrieving data from the database, updating or inserting data, and deleting data.
It allows for separation of concerns and promotes modularity by providing a clean and consistent interface for database
interactions.

    public List<Player> getAllPlayers() {
        String sql = "SELECT * FROM PLAYER";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<Player> (Player.class));
    }

using Spring JDBC's jdbcTemplate to execute a query(SELECT ...) and retrieve a list of Player objects, with each row of
the
result
set mapped to a Player object using the BeanPropertyRowMapper. The BeanPropertyRowMapper relies on the naming
conventions of the JavaBean properties to map the columns of the result set to the corresponding properties of the
Player class. IN playerDao I write more functions about for those queries SELECT UPDATE INSERT DELETE and DDL.

### **_JDBC & JPA:_**

JDBC is a lower-level API that requires manual SQL coding and provides more control, while JPA is a higher-level API
that offers abstraction and simplifies database interactions by mapping Java objects to database tables. JPA reduces the
amount of boilerplate code required for database operations and offers enhanced portability across different database
systems.

### **_JPA_**

Using JPA, we can map a Java class or bean to a table. The members of the class map columns in the table. When this
mapping is defined, JPA can write queries on its own. It takes the responsibility of creating and executing queries for
CRUD operations. This is due to the fact that the operations performed on a database are identical and can be
generalized. The types of objects change based on the database schema but the operations remain the same.

![](/nfs/homes/ael-oual/Downloads/tennis-player/imgs/JPA.png)

#### **_Defining an Entity_**

To use JPA in your Java project, you need to include the JPA dependency in your project's build configuration. This
dependency typically comes from a JPA implementation such as Hibernate or EclipseLink.

@Entity:
The @Entity annotation is used to mark a Java class as an entity, indicating that it corresponds to a database table.
Each instance of the entity class represents a row in the table.

@Table:
The @Table annotation is used to specify the details of the corresponding database table for an entity class. It allows
you to define the table name, schema, and other properties related to the table.

@Id and @GeneratedValue:
The @Id annotation is used to mark a field in an entity class as the primary key of the corresponding database table. It
indicates that the field uniquely identifies each row in the table.

The @GeneratedValue annotation is used in combination with @Id to specify the strategy for generating the primary key
values. It allows you to define how the primary key values should be generated, such as using an auto-incrementing
column or a sequence.

@Column:
The @Column annotation is used to specify the mapping of an entity class field to a column in the corresponding database
table. It allows you to define the column name, data type, constraints, and other properties related to the column.

## **_Creating a Repository_**

In JPA terms, a repository is a class that manages the entities.

* more about data transactions
* orm

### **_CRUD Operations_**

CRUD is shorthand referring to the most common types of queries: create, insert, update, and delete.

      // INSERT
    public Player insertPlayer(Player player)
    {
        return entityManager.merge(player);
    }
    //UPDATE
    public Player updatePlayer(Player player)
    {
        return entityManager.merge(player);
    }
    //FIND
    public Player getPlayerById(int id) {
        return entityManager.find(Player.class, id);
    }

    // delete
    public void deleteById(int id){
        Player player = entityManager.find(Player.class, id);
        entityManager.remove(player);
    }

### **_JPQL Named Query_**

@NamedQuery
To create a named query, we will use the @NamedQuery annotation on the Player class. This annotation requires two
parameters: the name of the query and the query itself. When using JPA, we will write the query in JPQL instead of SQL.
JPQL uses entities in place of tables. Since we want to return a list of Player objects, the query will be "SELECT p
FROM Player p".

    @Entity
    @NamedQuery(name="get_all_players", query="select p from Player p")

### **_Spring DATA_**

We have written methods to perform CRUD operations on the Player entity. If we add more entities to the project like
Coach and Tournament, we will have to write the same code for CRUD operations and plug a different entity type.

The methods that we implemented as part of the CRUD operations are all generic methods. The logic of the methods remains
the same, and only the entity changes.

Spring Data identified this duplication of code when writing repositories and created some predefined repositories. The
developer provides the entity type and its primary key and Spring Data comes up with the CRUD methods for the entity.
Spring Data JPA adds a layer of abstraction over the JPA provider (Hibernate in our case).

### **_Connecting to Other Databases_**
An in-memory H2 database is easy to set up and use. Now it’s time to learn how to switch to another database. In
real-life applications, we might want to connect to Oracle, MySql, or SQL server databases. Using Spring Boot, switching
databases is very straightforward. We just need to add some dependencies and change some property values.

For any database, we need to configure its URL, username, and password. These values are specified in the
application.properties file.

spring.jpa.hibernate.ddl-auto=none
spring.datasource.url = jdbc:mysql://localhost:3306/movie_example
spring.datasource.username = demo
spring.datasource.password = demo