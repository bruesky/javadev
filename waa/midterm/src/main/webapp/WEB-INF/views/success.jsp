<%--
  Created by IntelliJ IDEA.
  User: Xiangkui
  Date: 10/8/19
  Time: 18:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div>
    Name: ${user.name}
    Email: ${user.email}
    Age: ${user.age}
    Birthday: ${user.birthday}
    Role: ${user.role}


    Street: ${user.address.street}
    State: ${user.address.state}
    Zip Code: ${user.address.zipcode}

</div>

</body>
</html>
