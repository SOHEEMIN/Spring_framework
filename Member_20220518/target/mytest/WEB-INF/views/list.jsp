<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="/resources/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
    <style>
        .container {
            max-width: 1000px;
        }
    </style>
</head>
<body>
<h2>list.jsp</h2>
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
            <th>ajax 조회</th>
        </tr>
        <c:forEach items="${memberList}" var="member">
            <tr>
                <td>${member.m_id}</td>
                <td>${member.memberId}</td>
                <td>${member.memberPassword}</td>
                <td>${member.memberName}</td>
                <td>${member.memberAge}</td>
                <td>${member.memberPhone}</td>
                <td href="/detail?m_id=${member.m_id}">조회</td>
                <td><a href="/delete?m_id=${member.m_id}">삭제</a></td>
                <td><button class="btn btn-outline-info" onclick="detailByAjax('${member.m_id}')">조회</button></td>
                    <%-- 클릭한 회원의 정보를 DB에서 가져와서 detail.jsp에 출력 --%>
            </tr>
        </c:forEach>
    </table>

    <div id="detail">

    </div>
</div>
</body>
<script>
    //자바스크립트는 변수이름만있으면 됨. 타입x
                        //매개변수 id
    const detailByAjax = (m_id) => {
        console.log(m_id);
        const detail = document.getElementById("detail");
        $.ajax({
            type: "get", // http request method
            url: "detail-ajax", // 요청주소(컨트롤러 주소값)
            data: {"m_id": m_id}, // 전송하는 파라미터
            dataType: "json", // 리턴받을 데이터 형식 (ajax로 주고 받을 땐 보통 json타입으로 지정. json으로 변환해주는건 pon.xml 130번쯤에 있음)
            success: function (result) {
                let output = "<table class='table'>";
                output += "<tr>" +
                    "<th>m_id</th> <th>memberId</th> <th>memberPassword</th> <th>memberName</th>" +
                    "<th>memberAge</th> <th>memberPhone</th> " +
                    "</tr>";
                output += "<tr>";
                output += "<td>" + result.m_id                + "</td>";
                output += "<td>" + result.memberId            + "</td>";
                output += "<td>" + result.memberPassword      + "</td>";
                output += "<td>" + result.memberName          + "</td>";
                output += "<td>" + result.memberAge           + "</td>";
                output += "<td>" + result.memberPhone         + "</td>";
                output += "</tr>";
                output += "</table>";

                detail.innerHTML = output;
            },
            error: function () {
                alert("오타체크");
            }
        });

    }
</script>
</html>