<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2022-05-18
  Time: 오후 5:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>


<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="/resources/css/bootstrap.min.css">
</head>
<body>
    <h2>main.jsp</h2>
    <h1>회원만 접근할 수 있는 페이지입니다.</h1>
    로그인 회원 정보: ${loginMember}<br>
    <!--세션에 담은 값 꺼낼 땐 sessionScope사용 -->
    세션에 담은 memberId: ${sessionScope.loginMemberId}<br>
    세션에 담은 m_id:${sessionScope.loginId}<br>
    <a href="/">index로 이동</a><br>
    <!-- 밑 두 코드 다 update-form으로 주소 이동-->
    <button class="btn btn-primary" onclick="location.href='/update-form'">수정</button><br>
    <button class="btn btn-danger" onclick="updateForm()">수정(함수호출)</button><br>
    <!-- 관리자가 로그인 했을 때만 회원 목록 링크를 볼 수 있게-->
    <c: if test = "${sessionScope.loginMemberId eq 'admin'}">
        <a href="/findAll">회원목록(관리자전용)</a>
    </c:>
</body>
<script>
    //function updateForm(){} 과 const updateForm = () => {} 은 같은 함수정의임
    const updateForm = () => {
        location.href = "/update-form";
    }
</script>
</html>
