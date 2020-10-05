<%-- 
    Document   : webservice
    Created on : Oct 4, 2020, 10:30:04 PM
    Author     : rhianresnick
--%>

<%@page import="edu.fit.module8.entity.Person"%>
<%@page import="edu.fit.module8.entity.AppController"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    AppController app = new AppController();

    if (request.getParameter("list") != null) {
        out.println(app.getPeople());
    }

    if (request.getParameter("get") != null) {
        int id = Integer.parseInt(request.getParameter("get"));

        out.println(app.getPerson(id));
    }
    
    if (request.getParameter("update") != null || request.getParameter("create") != null ) {
        Integer id = null; 
        if( request.getParameter("update") != null ) {
            id = Integer.parseInt(request.getParameter("id"));
        }
        
        String email = request.getParameter("email");
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String employeeNumber = request.getParameter("employeeNumber");
        out.println( "\n" + firstName + "<br>");
        Person person = null;
        if( id == null ) {
            person = app.createPerson(firstName, lastName, email, employeeNumber);
        } else {
            person = app.updatePerson(id, firstName, lastName, email, employeeNumber);
        }
        
        out.println(person);
    }
%>
