<%@page import="edu.fit.module8.entity.Person"%>
<%@page import="java.util.List"%>
<%@page import="edu.fit.module8.entity.AppController"%>

<%-- 
    Document   : example
    Created on : Oct 8, 2020, 9:05:16 PM
    Author     : rhianresnick
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Sample Header!</h1>
        <div>
            <form action="webservice.jsp" method="post">
                <fieldset>
                    <legend>Sample WebForm</legend>

                    <h2>Type of action (check one)</h2>
                    <p>
                        <input type="checkbox" name="create" value="1" /> Create <br />
                        <input type="checkbox" name="update" value="1" /> Update <br />
                    </p>

                    <p>
                        <label for="id">ID</label>
                        <input type="text" name="id" id="id" />                    

                    </p>
                    <p>
                        <label for="firstName">First Name</label>
                        <input type="text" name="firstName" id="firstname" />                    
                    </p>
                    <p>
                        <label for="lastName">Last Name</label>
                        <input type="text" name="lastName" id="lastName" />                    
                    </p>

                    <p>
                        <label for="emailAddress">Email Address</label>
                        <input type="text" name="emailAddress" id="emailAddress" />                    
                    </p>

                    <input type="submit" value="Submit" />
                </fieldset>

            </form>


        </div>
        
        <div>
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
        </div>
    </body>
</html>
