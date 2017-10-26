<%-- 
    Document   : register
    Created on : Oct 10, 2017, 2:22:39 PM
    Author     : 728918
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Shopping List</title>
    </head>
    <body>
        <h1>Shopping List</h1><br>
        <form action="ShoppingList" method="post">
            <input type="hidden" name="action" value="register">
            Username: <input type="textfield" name="uname"> <input type="submit"  value="Register name">
        </form>
        ${message}
    </body>
</html>
