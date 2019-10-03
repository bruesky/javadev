<%--
  Created by IntelliJ IDEA.
  User: Xiangkui
  Date: 10/2/19
  Time: 19:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<h2>Ask for advise about your favorite roast</h2>
<form action="advice" method="get">");
    <select name="roast">
       <option value="-">--Choose Roast--</option>
        <option value="dark">Dark</option>
        <option value="medium">Medium</option>
        <option value="light">Light</option>
    </select>
    <input type="submit" value="Submit"/>
</form>
</body>
</html>
