<%@ page import="java.io.*,java.util.*, javax.servlet.*" %>
<html>
<body>
<center>
<h1>Teste 01</h1>
</center>
<%
   Date date = new Date();
   out.print( "<h2 align=\"center\">" +date.toString()+"</h2>");
%>
</body>
</html>
