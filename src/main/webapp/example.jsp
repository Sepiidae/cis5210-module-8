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
    </body>
</html>
