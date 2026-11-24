<%@ page language="java" import="java.util.Date" %>
<html>
<head>
<title>Scriplet JSP</title>
</head>
<body>
<p>Current Date : </p>
<% out.println(new Date()); %> <!-- <%= new Date() %> -->
<p>Server address : </p>  
<% out.println (request.getRemoteHost()); %> <!-- <%=request.getRemoteHost() %> -->
</body>
</html>