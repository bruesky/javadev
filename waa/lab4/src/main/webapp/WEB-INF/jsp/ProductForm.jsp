<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE HTML>
<html>
<head>
<title>Add Product Form</title>
<style type="text/css">@import url(css/main.css);</style>
</head>
<body>
<spring:url var="addpro" value="/product" />
<div id="global">
    <form:form modelAttribute="product" action="${addpro}" method="post">
        <fieldset>
            <legend>Add a product</legend>
            <p>
                <label for="category">
                </label>
                <form:select id="category" path="category" items="${categories}"
                             itemLabel="name" itemValue="id" />
            </p>

            <p>
                <label for="name">Product Name: </label>
                <form:input id="name" path="name" />
            </p>
            <p>
                <label for="description">Description: </label>
                <form:input id="description" path="description" />
            </p>
            <p>
                <label for="price">Price: </label>
                <form:input id="price" path="price" />
            </p>
            <p id="buttons">
                <input id="reset" type="reset" tabindex="4">
                <input id="submit" type="submit" tabindex="5"
                       value="Add Product">
            </p>
        </fieldset>
    </form:form>
</div>

</body>
</html>
