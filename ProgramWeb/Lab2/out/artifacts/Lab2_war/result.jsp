<%@ page import="java.util.List" %>
<%@ page import="beans.Point" %><%--
  Created by IntelliJ IDEA.
  User: 2398768715qq.com
  Date: 2023/2/25
  Time: 04:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="pointsBean" class="beans.PointsList" scope="session"/>
<html>
<head>
    <title>Results</title>
    <link rel="stylesheet" href="css/resultStyle.css">
</head>
<body>
    <div>
        <table border="1">
            <tr>
                <th> No. </th> <th> x </th> <th> y </th> <th> r </th> <th> result </th> <th> time </th>
            </tr>
            <%
                int no = 0;
                List<Point> list = pointsBean.getPointList();
                for (Point p : list) {
            %>
            <tr>
                <td><%=++no%></td>
                <td><%=p.getX()%></td>
                <td><%=p.getY()%></td>
                <td><%=p.getR()%></td>
                <td><%=p.getRes()? "True" : "False"%></td>
                <td><%=p.getTimeUsage() + "ms"%></td>
            </tr>
            <%}%>
        </table>
    </div>
</body>
</html>
