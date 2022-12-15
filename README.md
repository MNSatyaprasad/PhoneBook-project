# PhoneBook-project
============
Mini Projects
============

Technologies : Spring Boot, REST API, Data JPA, Swagger, PostMan & Angular


==== For every mini project we have to follow below steps ====

1) Read the FDD and understand the requirement

2) Note down the questions on requirment (Query Log)

3) Design Database Tables

4) Design Classes & Method Signature

5) Backend Coding

6) Backend Testing

7) Backend Deployment using docker & k8s

=================================================

-> First you guys need to analyze the requirement & design db  & design classes

-> I will do my analysis in class and i will show my design then compare your design and my design
	 (you will understand your mistakes)

-> I will do live coding in the class and you guys should complete that coding on your own after the class is completed

-> you need to submit your code for these mini projects as git repo urls

====================================
Main intension of developing Mini Projects
====================================

1) Your analysis skills should improve

2) Your coding skills should improve

3) To understand Realtime Best Practises as a developer

4) To learn how to develop and deploy the real world projects

5) Practise all the tools in the projects



=============
01-Mini Project
=============

1)  Contact.java  ( Entity & Binding ) (C)
		
			Integer contactId;
			String contactName;
			String contactEmail;
			Long contactNum;

2) ContactRepository.java  ( extends from JpaRepository ) (I)

3) ContactService.java (I)

			public String saveContact ( Contact contact ) ;

			public List<Contact> getAllContacts ( ) ;

			public Contact getContactById ( Integer contactId );

			public String updateContact ( Contact contact );
	
			public String deleteContactById ( Integer contactId );

			


===============================
Steps to develop First Mini Project
===============================

1) Create Spring Boot Application with below dependencies

		a) web-starter
		b) data-jpa-starter
		c) lombok
		d) devtools
		e) h2

2) Create Entity class & repository interface

3) Create Service interface with implementation

4) Create Rest Controller with required methods

5) Configure Data source properties in application.yml file

spring.datasource.url=jdbc:h2:mem:testdb
spring.datasource.username=sa
spring.datasource.password=sa
spring.datasource.driver-class-name=org.h2.Driver

6) Run the application and test it 

Note: We can access h2 database using below URL

		DB URL : http://localhost:8080/h2-console/


7) Download and install POSTMAN app to test Backend API

	URL : https://www.postman.com/downloads/

# Swagger implemebtion
========
Swagger
========

-> Swagger is a third party api

-> Swagger is used to generate documentation for our REST APIs


Q) What is REST API documentation ?

Ans) REST API documentation will provide all the information about API like below

			a) API Base URL
			b) Endpoints of API
			c) Request Data Format
			d) Response Data Format


-> API documentation will play major role in distributed applications development.


Note: If we want to access any API then we need documentation for that. Based on the documentation we can understand api and its structure.

===========
Use-Case
===========

-> IRCTC project developed by one company to book train tickets

-> MakeMyTrip applications developed by another company to book tickets.

-> MakeMyTrip wants to communicate with IRCTC to book train tickets.

-> To communicate with IRCTC, MakeMyTrip project developers should understand IRCTC API details.

				a) What is URL ?
				b) What are the Endpoints ?
				c) Request Data Structure
				d) Response Data Structure

-> If MakeyMyTrip developers knows above details then only they can write the logic to access IRCTC api.

Note: IRCTC team should provide API documentation to MakeMyTrip team.


-> Swagger-UI is used to test our REST APIs (We can use this as alternative to POSTMAN)


============================================
How to setup Swagger in Spring Boot Application ?
============================================

###############  1) Add Swagger & Swagger-UI dependencies in pom.xml file ###############


		<dependency>
			<groupId>io.springfox</groupId>
			<artifactId>springfox-swagger2</artifactId>
			<version>2.9.2</version>
		</dependency>

		<dependency>
			<groupId>io.springfox</groupId>
			<artifactId>springfox-swagger-ui</artifactId>
			<version>2.9.2</version>
		</dependency>



#################  2) Create Swagger Config class ######################

package in.ashokit.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
	
	@Bean
	public Docket apiDoc() {
		
		return new Docket(DocumentationType.SWAGGER_2)
				   .select()
				   .apis(RequestHandlerSelectors.basePackage("in.ashokit.rest"))
				   .paths(PathSelectors.any())
				   .build();
	}
}


################  3) Configure below property in application.properties file #################

spring.mvc.pathmatch.matching-strategy = ANT_PATH_MATCHER


###############  4) Run the spring boot application and access below URL ###################

	URL : http://localhost:8080/swagger-ui.html

=================================================================================




