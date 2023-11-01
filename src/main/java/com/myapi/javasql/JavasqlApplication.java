package com.myapi.javasql;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JavasqlApplication {

	// For this example, you need not modify the AccessingDataMysqlApplication class.
	//
	//@SpringBootApplication is a convenience annotation that adds all of the following:
	//
	//@Configuration: Tags the class as a source of bean definitions for the application context.
	//
	//@EnableAutoConfiguration: Tells Spring Boot to start adding beans based on classpath settings, other beans, and various property settings. For example, if spring-webmvc is on the classpath, this annotation flags the application as a web application and activates key behaviors, such as setting up a DispatcherServlet.
	//
	//@ComponentScan: Tells Spring to look for other components, configurations, and services in the com/example package, letting it find the controllers

	public static void main(String[] args) {
		SpringApplication.run(JavasqlApplication.class, args);
	}

	//Make Some Security Changes
	//When you are on a production environment, you may be exposed to SQL injection attacks. A hacker may inject DROP TABLE or any other destructive SQL commands. So, as a security practice, you should make some changes to your database before you expose the application to your users.
	//
	//The following command revokes all the privileges from the user associated with the Spring application:

	//mysql> revoke all on db_example.* from 'springuser'@'%';

	//Now the Spring application cannot do anything in the database.
	//
	//The application must have some privileges, so use the following command to grant the minimum privileges the application needs:

	//mysql> grant select, insert, delete, update on db_example.* to 'springuser'@'%';

	//Removing all privileges and granting some privileges gives your Spring application the privileges necessary to make changes to only the data of the database and not the structure (schema).

	//When you want to make changes to the database:
	//
	//Regrant permissions.
	//
	//Change the spring.jpa.hibernate.ddl-auto to update.
	//
	//Re-run your applications.
	//
	//Then repeat the two commands shown here to make your application safe for production use again. Better still, use a dedicated migration tool, such as Flyway or Liquibase.

}
