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

using Spring JDBC's jdbcTemplate to execute a query(SELECT  ...) and retrieve a list of Player objects, with each row of the
result
set mapped to a Player object using the BeanPropertyRowMapper. The BeanPropertyRowMapper relies on the naming
conventions of the JavaBean properties to map the columns of the result set to the corresponding properties of the
Player class. IN playerDao I write more functions about for those queries SELECT UPDATE INSERT DELETE and DDL.
