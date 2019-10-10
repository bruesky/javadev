<%--
  Created by IntelliJ IDEA.
  User: Xiangkui
  Date: 10/8/19
  Time: 18:55
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
    <spring:url value="/user/add" var="adduser"></spring:url>
    <form:form modelAttribute="user"  action="${adduser}" method="post">
        <fieldset>
            <label>User Name</label>
            <div>
                <form:input path="name"></form:input>
                <form:errors path="name"></form:errors>
            </div>

            <label>Email</label>
            <div>
                <form:input path="email"></form:input>
                <form:errors path="email"></form:errors>
            </div>

            <label>Age</label>
            <div>
                <form:input path="age"></form:input>
                <form:errors path="age"></form:errors>
            </div>

            <label>Birthday</label>
            <div>
                <form:input path="birthday"></form:input>
                <form:errors path="birthday"></form:errors>
            </div>

            <label>Role</label>
            <div>
                <form:select path="role">
                    <form:option value="" label="Select"></form:option>
                    <form:option value="Teacher" label="Teacher"></form:option>
                    <form:option value="Student" label="Student"></form:option>
                </form:select>
                <form:errors path="role"></form:errors>
            </div>


            <label>Address</label>
            <div>
                <label>Street</label>
                <div>
                    <form:input path="address.street"></form:input>
                    <form:errors path="address.street"></form:errors>
                </div>

                <label>State</label>
                <div>
                    <form:input path="address.state"></form:input>
                    <form:errors path="address.state"></form:errors>
                </div>

                <label>ZipCode</label>
                <div>
                    <form:input path="address.zipcode"></form:input>
                    <form:errors path="address.zipcode"></form:errors>
                </div>

            </div>


            <input type="submit" value="add">
        </fieldset>
    </form:form>


</body>
</html>
