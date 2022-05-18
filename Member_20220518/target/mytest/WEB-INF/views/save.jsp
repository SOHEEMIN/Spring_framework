<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2022-05-18
  Time: 오후 3:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h2>save.jsp</h2>
    <form action="/save" method="post">
        <input type="text" name="memberId" placeholder="memberId">
        <input type="password" name="memberPassword" placeholder="memberPassword" >
        <input type="text" name="memberName" placeholder="memberName">
        <input type="text" name="memberAge" placeholder="memberAge">
        <input type="text" name="memberPhone" placeholder="memberPhone">
        <input type="submit" value="전송">
    </form>
</body>
</html>
