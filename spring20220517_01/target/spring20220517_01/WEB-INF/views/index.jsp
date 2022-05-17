<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2022-05-17
  Time: 오전 9:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h2>index.jsp</h2>
    <!-- server에게 /welcome주소를 get방식으로 요청-->
    <a href="welcome">welcome 페이지로 이동</a> <!--직접 링크를 넣지 않고, 컨트롤러에 요청해서 컨트롤러가 해당화면을 띄울 수 있게 함.-->
   <%-- 아래 링크 클릭하면 form-ex.jsp 출력 --%>
    </br>
    <a href="form-ex">form-ex 페이지로 이동</a>
</body>
</html>
