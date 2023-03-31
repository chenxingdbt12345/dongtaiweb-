<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2023/3/29
  Time: 10:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
我是页面show.jsp
接收index.jsp传递过来的变量
<%=request.getParameter("username")%>
<jsp:useBean id="student" class="com.candy.bean.Student">
    <jsp:setProperty name="student" property="stu_no" value="0201"></jsp:setProperty>
    <jsp:setProperty name="student" property="stu_name" param="username"></jsp:setProperty>
</jsp:useBean>
<%=student.toString()%>
获取student对象的stuname属性的值:
<jsp:getProperty name="student" property="stu_name"/>

</body>
</html>
