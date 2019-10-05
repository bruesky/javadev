<%--
  Created by IntelliJ IDEA.
  User: Xiangkui
  Date: 10/4/19
  Time: 18:03
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<form:form modelAttribute="newCheckin" action="checkin" method="post">
    <p>Name <form:input path="name"></form:input> </p>
    <p>Gender <form:input path="gender"></form:input> </p>
    <input type="submit" value="Submit">
</form:form>

</body>
</html>
