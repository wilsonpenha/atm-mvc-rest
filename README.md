ING ATM Locator - Spring MVC/RESTfull API for searching ING ATMs

This ATM Locator is a simple web UI integrated with RESTfull service and retrieve all locations of Dutch ATM belonging to ING bank:

RESTfull web service API for accessing ATM locations

Simple web UI interface for searching and retrieve ATM for a given Netherlands city
 
How to compile  and deploy the application

First you need to install maven4 :

People normally using linux would do as follow

$ mvn install 

The command should build war atm-mvc-rest.war in target folder

With Eclipse NEON or higher, you can just import the atm-mvc-rest.war into your project, or you can install git plugin and download into eclipse,

If you the app don't start due missing .jar, you will need to run mvn again to load the missing jars.

Deployment

In Tomcat env. it is enough to copy the atm-mvc-rest.war to your Tomcat/webapps folder. When startup Tomcat, the war file will be automatically deployed with context root atm-mvc-rest

Technology used in this project

JDK 1.8
Spring 4.3.0
Spring Security 4.2.2
Servlet 3.0
JQuery 2.1.4
AngularJS 1.4.5
Maven 4.0

Test cases

Use case	RESTfull API	Expected result	Description

1. Get all ATM location JSON format	http://localhost:8080/atm-mvc-rest/list	response: [{"address": {"street": "Heerenweg","housenumber": "199","postalcode": "1851 KP","city": "HEILOO","geoLocation": {"lat": "52.60022","lng": "4.703054"}},"distance": 0,"type": "ING"}]	The RESTfull API dispatches a request to https://www.ing.nl/api/locator/atms/ and response the result in the same format as it was retrieve

2. Search ATM by city	http://localhost:8080/atm-mvc-rest/search/city/Amsterdam	response: [{type: "ING",address: {street: "Beethovenstraat",housenumber: "8",postalcode: "1077 JG",city: "Amsterdam",geoLocation: {lat: "52.350159",lng: "4.878119"}}}},	The RESTfull API dispatches a request to https://www.ing.nl/api/locator/atms/ and the response will be filtered by city and send to requester in the same JSON format.

Secutity

There are two groups of users: ADMIN and USER

ADMIN:
user: admin
password: admin

USER:
user: wilson
password: wilson

Both groups has rights to perform any requests, permission can be change at SecurityConfiguration.java class and compile again, this is not how it was meant to work, but is fine for this demo.

Usage

After deploy the application successfully at Tomcat, try http://localhost:8080/atm-mvc-rest/ and get the login page enter your user and password: (admin, admin)

Then your will be able to use the Simple WEB UI and/or the RESTfull urls to retrieve the data as you wish.
