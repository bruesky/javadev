<%--
  Created by IntelliJ IDEA.
  User: Xiangkui
  Date: 9/18/19
  Time: 23:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" import="java.util.*" %>
<%@ page import="java.util.ArrayList" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<!-- html comment -->
<%-- jsp comment --%>

<%
    List<String> list = new ArrayList();
    list.add("aaa");
    list.add("bbb");
    list.add("ccc");
    request.setAttribute("list",list);
    request.setAttribute("num",99);
%>
<c:forEach begin="1" end="10" var="i" step="1">
    ${i}<br />
</c:forEach>
${list}
<c:forEach items="${list}" var="str" varStatus="s">
    ${str}<br />
</c:forEach>

<c:if test="${1==0}">
    true
</c:if>

<c:choose>
    <c:when test="${num==1}">One</c:when>
    <c:when test="${num==2}">Two</c:when>
    <c:when test="${num==3}">Three</c:when>
    <c:when test="${num==4}">Four</c:when>
    <c:when test="${num==5}">Five</c:when>
    <c:when test="${num==6}">Six</c:when>
    <c:when test="${num==7}">Seven</c:when>
    <c:otherwise>Bug</c:otherwise>



</c:choose>

</body>
</html>
