<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h1><%= "Hello World!" %>
</h1>
<br/>
<form action="hello-servlet" method="post">
    Entra nel magazzino
    <input type="submit" value="Invia">
</form>
</body>
</html>