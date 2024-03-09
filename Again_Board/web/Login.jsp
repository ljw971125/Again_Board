<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.*"%>
<%@ page import="java.text.SimpleDateFormat" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form id ="userinfoForm" action="http://localhost:8080/MemberLogin.auth" method="post">
    <table>
        <tr>
            <td>아이디: </td>
            <td><input type="text" name="id"></td>
        </tr>
        <tr>
            <td>비밀번호: </td>
            <td><input type="text" name="pw"></td>
        </tr>
        <tr>
            <td align="center">
                <a href="/Signup.auth">회원가입</a>
            </td>
            <td align="center">
                <input type="submit" value="로그인">
            </td>
        </tr>
    </table>
</form>
</body>
</html>
