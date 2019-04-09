<%--
  Created by IntelliJ IDEA.
  User: LM16
  Date: 2019/3/29
  Time: 22:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <p>${sessionScope.card.cardId}的交易记录</p>
    <table border="1">
        <tr>
            <th>时间</th>
            <th>类型</th>
            <th>交易额</th>
            <th>交易余额</th>
        </tr>
        <c:forEach items="${list}" var="bill">
        <tr>
            <td>${bill.time}</td>
            <c:choose>
                <c:when test="${bill.type==0}">
                    <td>存款</td>
                </c:when>
                <c:when test="${bill.type==1}">
                    <td>取款</td>
                </c:when>
                <c:when test="${bill.type==10}">
                    <td>转出</td>
                </c:when >
                <c:when test="${bill.type==11}">
                    <td>转入</td>
                </c:when>
                <c:otherwise>
                    <td>failed</td>
                </c:otherwise>
            </c:choose>
            <td>${bill.changee}</td>
            <td>${bill.balanceChange}</td>
        </tr>
        </c:forEach>
    </table>
</body>
</html>
