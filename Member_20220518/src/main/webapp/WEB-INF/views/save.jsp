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
        <input type="text" name="memberId" placeholder="아이디">
        <input type="password" name="memberPassword" placeholder="비밀번호" >
        <input type="text" name="memberName" placeholder="이름">
        <input type="text" name="memberAge" placeholder="나이">
        <input type="text" name="memberPhone" placeholder="전화번호">
        <input type="submit" value="회원가입">
        <button>버튼tag가입</button>
        <input type="button" value="button타입">
    </form>
</body>
</html>
