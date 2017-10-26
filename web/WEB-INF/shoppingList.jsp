<%-- 
    Document   : shoppingList
    Created on : Oct 10, 2017, 2:22:51 PM
    Author     : 728918
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Shopping list</title>
    </head>
    <body>
        <h1>Shopping List</h1><br>
        Hello, ${username} <a href="ShoppingList?function=logout">logout</a>
        <br>
        <h1>List</h1><br>
        Add item <input type="textfield" name="additemtextfield"> <input type="submit" value="Add"><br>
        
        <table>
                <c:forEach items="${items}" var="item">
                    <tr>
                         <td><input type="radio" name="delet" value="${item.name}"></td>
                        <td>${item.name}</td>
                    </tr>
                </c:forEach>
            </table>
        
                    <input type="submit" name="deleteUserFN" value="Delete">
    </body>
</html>
