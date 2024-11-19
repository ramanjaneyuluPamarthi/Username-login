<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="pack1.AdminBean" %>
    <%@page import="pack1.ProductBean" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body><center><h1>
<%
AdminBean abean = (AdminBean)session.getAttribute("abean");
ProductBean pb= (ProductBean)request.getAttribute("pbean");
 out.println( "*******Please Edit******** <br><br>");
%>
<form action = "update" method="post">
Product Name<input type=text name=pname value="<%=pb.getPname()%>"><br><br>
Product Company<input type=text name=pcompany value="<%=pb.getPcompany()%>"><br><br>
Product Price<input type=number name=pprice value="<%=pb.getPprice()%>"><br><br>
Product Quantity<input type=number name=pqty value="<%=pb.getPname()%>"><br><br>
<input type="hidden" name="pid" value="<%=pb.getPid() %>">
<input type="submit" value="Update product details">
</form>
</body>
</html>