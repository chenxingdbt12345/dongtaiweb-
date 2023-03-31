<%@ page import="java.util.Date" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<%--  include指令，引入其他页面，在编译时，
指令会先将当前JSP和被包含的文件融合到一起形成一个Servlet再进行编译执行 --%>
<%--  <%@include file="show.jsp"%>--%>
HelloWorld!
<%--脚本元素，支持大部分java代码--%>
<%
    Date date=new Date();
    out.print(date.toLocaleString());
%>
jsp脚本输入当前时间
<%--  JSP表达式 等同于out.print--%>
<%=(new java.util.Date().toLocaleString())
%>
<%--  jsp声明，可以声明一个变量，也可以声明方法
注意与普通脚本声明变量的区别--%>
<%!int num=9; %>
<%
    for(int i=0;i<10;i++){
        out.print(i);
    }
%>
<%--  <jsp:include page="show.jsp"  flush="true">--%>
<%--      <jsp:param name="username" value="tom"/>--%>
<%--  </jsp:include>--%>
<%--forward可以实现一个页面跳转，注意不要和include同时使用--%>
<jsp:forward page="show.jsp">
    <jsp:param name="username" value="zhangsan"/>
</jsp:forward>



</body>
</html>