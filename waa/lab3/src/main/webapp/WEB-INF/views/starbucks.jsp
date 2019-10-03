<%--
  Created by IntelliJ IDEA.
  User: Xiangkui
  Date: 9/30/19
  Time: 16:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<h2>Ask for advice about your favorite roast:</h2>
<p />
<form action = "advice" method="get">
    <select name="roast" disabled="disabled" >
        <option value="-">--Choose Roast--</option>
        <option value="dark">Dark</option>
        <option value="medium">Medium</option>
        <option value="light">Light</option>
    </select>
    <br/><br/>
    <input type="submit" value = "Submit" disabled = "disabled" />
</form>
<div id='advice'>

</div>
<p />
Login:
<form action = "login" method = "post">
    Name: <input type = "text" name = "name" size = "9" /><br/>
    Password: <input type = "password" name = "password" size = "9" /><br/>
    <br/>
    <input type="submit" value = "Log In"/>
</form>

</body>
</html>
