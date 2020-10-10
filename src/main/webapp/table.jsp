<%-- 
    Document   : webservice
    Created on : Oct 4, 2020, 10:30:04 PM
    Author     : rhianresnick
--%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="edu.fit.module8.entity.Person"%>
<%@page import="edu.fit.module8.entity.AppController"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
            <% // The tag signals to the parsing engine (jsp) on the server that the 
            // code between the less then and greater then signs is JSP
            AppController app = new AppController();
            
            // Store all the people
            List<Person> people = app.getPeople();
            for( Person person : people ) {
            %>
            
                    <%= person.getId() %>,                 
                    <%= person.getFirstName() %>, 
                    <%= person.getLastName() %>,                               
                    <%= person.getEmail() %>, 
                    <%= person.getEmployeeNumber() %>
                       <br />
                           
            <% } %>
    </body>
</html>
