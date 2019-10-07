<%--
  Created by IntelliJ IDEA.
  User: Xiangkui
  Date: 10/6/19
  Time: 17:41
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <style>
        .error{color:red}
    </style>
</head>
<body>
<form:form action="helloagain" modelAttribute="emp">
    Username: <form:input path="name"/>
    <form:errors path="name" cssClass="error"/><br><br>
    Password(*): <form:password path="pass"/>
    <form:errors path="pass" cssClass="error"/><br><br>
    Age: <form:input path="age"/>
    <form:errors path="age" cssClass="error"/><br><br>
    <input type="submit" value="submit">
</form:form>
</body>
</html>