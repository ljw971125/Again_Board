<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="net.board.db.*" %>
<%@ page import="java.util.*" %>
<!DOCTYPE html>
<html>
<head>
  <title>게시판</title>
</head>
<body>
<%
  BoardDAO boardDAO = new BoardDAO();
  List boardList = boardDAO.getBoardList(1, 10);
%>
<table border="1">
  <tr>
    <th>번호</th>
    <th>이름</th>
    <th>제목</th>
    <th>내용</th>
    <th>날짜</th>
  </tr>
  <%
    for (Object obj : boardList) {
      BoardBean board = (BoardBean) obj;
  %>
  <tr>
    <td><%= board.getBOARD_NUM() %></td>
    <td><%= board.getBOARD_NAME() %></td>
    <td><%= board.getBOARD_SUBJECT() %></td>
    <td><%= board.getBOARD_CONTENT() %></td>
    <td><%= board.getBOARD_DATE() %></td>
  </tr>
  <%
    }
  %>
</table>
</body>
</html>
