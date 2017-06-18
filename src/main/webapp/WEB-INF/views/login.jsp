<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html xmlns:th="http://www.thymeleaf.org" xmlns:tiles="http://www.thymeleaf.org">
  <head>
    <title tiles:fragment="title">Messages : Create</title>

    <meta name="viewport" content="width=device-width, initial-scale=1">

    <link rel="shortcut icon" href="resources/img/favicon-96x96.png" />
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap-theme.min.css">
    <link rel="stylesheet" href="resources/css/style.css">
    <script src="https://code.jquery.com/jquery-2.1.4.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.5/angular.min.js"></script>
  </head> 
  <body class="container-fluid">
    <div tiles:fragment="content">
        <form name="f" th:action="@{/login}" method="post">               
            <fieldset>
                <legend>Please Login</legend>
                <div th:if="${param.error}" class="alert alert-error">     
                    Invalid username and password.
                </div>
                <div th:if="${param.logout}" class="alert alert-success"> 
                    You have been logged out.
                </div>
                <label for="username">Username</label>
                <input type="text" id="username" name="username"/>        
                <label for="password">Password</label>
                <input type="password" id="password" name="password"/>
                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>    
                <div class="form-actions">
                    <button type="submit" class="btn  btn-default">Log in</button>
                </div>
            </fieldset>
        </form>
    </div>
  </body>
</html>