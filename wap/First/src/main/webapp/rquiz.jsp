<%--
  Created by IntelliJ IDEA.
  User: Xiangkui
  Date: 9/18/19
  Time: 21:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>

<html>
<head>
    <title>Quiz</title>
</head>
<body>

<H1>The Number Quiz</H1>
<div>Your current score is <span name="score">${score}</span> </div>
<div>Guess the next number in the sequence!</div>
<div>${question}</div>
<form action="rquiz" method="post">
    <div>Your answer: <input type="number" name="answer"></div>
    <input type="submit" value="Submit">
</form>

</body>
</html>
