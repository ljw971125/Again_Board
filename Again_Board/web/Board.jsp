<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.*"%>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="net.board.db.*" %>
<%
    BoardDAO boardDAO = new BoardDAO();
    List boardList = boardDAO.getBoardList(1, 10);
%>
<html>
<head>
    <title>게시판</title>
</head>
<body>
<table width=50% border="0" cellpadding="0" cellspacing="0">
    <tr align="center" valign="middle">
        <td colspan="4">MVC 게시판</td>
        <td align="right">
            <font size="2">글 개수 : ${listcount }</font>
        </td>
    </tr>
    <tr valign="middle" bordercolor="#333333">
        <td style="font-size: 8pt"; width="8%" height="26" >
            <div>번호</div>
        </td>
        <td style="font-size: 8pt"; width="50%" >
            <div>제목</div>
        </td>
        <td style="font-size: 8pt"; width="14%" >
            <div>작성자</div>
        </td>
        <td style="font-size: 8pt"; width="17%" >
            <div>날짜</div>
        </td>
    </tr>
    <%
        for(int i=0;i<boardList.size();i++){
            BoardBean board = (BoardBean)boardList.get(i);
    %>
    <tr>
        <td><%= board.getBOARD_NUM() %></td>
        <td><%= board.getBOARD_NAME() %></td>
        <td><%= board.getBOARD_SUBJECT() %></td>
        <td><%= board.getBOARD_DATE() %></td>
    </tr>
    <%}%>
</table>

</body>
</html>
