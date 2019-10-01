<%--
  Created by IntelliJ IDEA.
  User: Xiangkui
  Date: 9/30/19
  Time: 14:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"  %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="calc" method="get">
    <input type = "text" name = "add1" size = "2"  value = "${add1}" />+
    <input type = "text" name = "add2" value = "${add2}" size = "2"/>=<input type = "text" name = "sum" value = "${sum}"  size = "2" readonly/><br/>
    <input type = "text" name = "mult1" value = "${mult1}" size = "2"/>*
    <input type = "text" name = "mult2" value = "${mult2}"  size = "2"/>=<input type = "text" name = "product" value = "${product}"   size = "2" readonly/><br/>
    <input type = "submit" value = "Submit"/>
</form>
</body>
</html>
