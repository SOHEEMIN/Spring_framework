<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2022-05-18
  Time: 오후 4:00
  To change this template use File | Settings | File Templates.
--%>
    <%@ page contentType="text/html;charset=UTF-8" language="java" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <!-- CSS only -->
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="/resources/css/bootstrap.min.css">
    <style>
        .container {
            max-width: 500px;
        }
    </style>
</head>
<body>
<div class="container">
    <table class="table">
        <tr>
            <th>m_id</th>
            <th>memberId</th>
            <th>memberPassword</th>
            <th>memberName</th>
            <th>memberAge</th>
            <th>memberPhone</th>
            <th>조회</th>
            <th>삭제</th>
        </tr>
        <tr>
            <c:forEach items="${memberList}" var="member">
        <tr>
            <td>${member.m_id}</td>
            <td>${member.memberId}</td>
            <td>${member.memberPassword}</td>
            <td>${member.memberName}</td>
            <td>${member.memberAge}</td>
            <td>${member.memberPhone}</td>
            <td><a href="/detail?m_id=${member.m_id}">조회</a></td>
            <td><a href="/delete?memberId=${member.memberId}">삭제</a></td>

                <%-- 클릭한 회원의 정보를 DB에서 가져와서 detail.jsp에 출력 --%>
        </tr>
        </c:forEach>
        </tr>

    </table>
</div>
</body>
</html>
