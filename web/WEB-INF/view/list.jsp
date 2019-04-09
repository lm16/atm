<%--
  Created by IntelliJ IDEA.
  User: LM16
  Date: 2019/4/9
  Time: 19:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Title</title>

    <style>

    </style>
</head>
<body>

    <table>
        <tr>
            <td>id</td>
            <td>name</td>
        </tr>
        <c:forEach items="${list}" var="father" varStatus="st">
        <tr>
            <td>${father.id}</td>
            <td>${father.name}</td>
        </tr>
        </c:forEach>
    </table>

</body>
</html>
