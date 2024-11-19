<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.util.ArrayList" %>
<%@page import="pack1.ProductBean" %>
<%@page import="pack1.AdminBean" %>
<%@page import="java.util.Iterator" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body><center><h1>
<%
AdminBean abean= (AdminBean)session.getAttribute("abean");
ArrayList<ProductBean> al = (ArrayList<ProductBean>)session.getAttribute("ProductList");
out.println("Mr. "+abean.getFirstname()+" here are your Products details !!!<br><br>");

if(al.size()==0){
	out.println("No products Are Available!!!<br><br>");
}
else{
	Iterator<ProductBean> i = al.iterator();
	while(i.hasNext()){
		ProductBean pb = i.next();
		out.println(pb.getPid()+" "+pb.getPname()+" "+pb.getPcompany()+" "+pb.getPprice()+"  "+pb.getPqty()+"<a href='edit?pid="+pb.getPid()+"'>Edit</a>"+" <a href='delete?pid="+pb.getPid()+"'>Delete</a>"+"<br><br>");
		//URL rewritting 
		
		
		
	}
}
%>
<a href ="AddProduct.html">Add Product</a><br><br>
<a href="logout">Logout</a>
</body>
</html>