<%@ page language="java" contentType="text/html; charset=windows-1256"
	pageEncoding="windows-1256"%>
<%@ page import="com.FCI.SWE.Controller.PagePostController"%>
<%@ page import ="java.util.ArrayList" %>
<%@ taglib prefix="c" 
		uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>page list</title>
</head>
<body>
Choose a page to write post

 
<form action="/social/createPostPage" method="get">
		<table Border="3" BorderColor="black" width="300" cellSpacing="1"
			CellPadding="3">

			<TR>
				<th ColSpan="3"><font size="5"><color="white"><b>Your Pages</b></font>
			</TR>

			<%
				for (int i = 0; i < PagePostController.pageName.size(); i++) {
			%>
			<tr Align="Center">
				<TD BGColor="white"><Font size="4"><I>
				 <input
							type="radio"  name="Email"
							value="<%= PagePostController.pageName.get(i)  %>"
				 >

					</I></Font></td>

				<td BGColor="white"><Font-size="4"><I> <%
 	out.println(PagePostController.pageName.get(i));
 %>

					</I></Font></TD>
			</tr>
			<%
				}
			%>

		</table>
		 <br/><br/>
				<input type="submit" value="Creat Post" class="button">
	</form>
</body>
</html>