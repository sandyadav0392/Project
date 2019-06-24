<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <TITLE> Hungry Hyderabad.com</TITLE>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
  
   <tr bgcolor="#a4c2c2">	
	<td height="36" colspan="6" class="navText style1" id="navigation">	

	
<%--	<% String role=(String)session.getAttribute("role"); --%>
<%--	if(role!=null){--%>
<%--	if(role.equalsIgnoreCase("ADMINISTRATOR")){--%>
<%--	 %>--%>
<%--	<jsp:include page="AdminOptions.html"/>--%>
<%--	--%>
<%--	<%}else if(role.equalsIgnoreCase("customer")){ %>--%>
<%--	--%>
<%--	<jsp:include page="CustomerOptions.jsp"/>--%>
<%--		--%>
<%--	<%}else { %>--%>
<%--	--%>
<%--	<jsp:include page="GeneralOptions.jsp"/>		--%>
<%--	<%} }else{--%>
<%--					response.sendRedirect("LoginForm.jsp?status=session expired login again...." );--%>
<%--			}	--%>
<%--	 %>--%>
<%--	 --%>
	 	</td>	
	</tr>
    <form action="./QuestionAction" name="addquestion" onSubmit="return validate()">
     <tr><td><center>  <% if(request.getParameter("status")!=null)
					  {%>
                           <strong><font color=red><%=request.getParameter("status")%></font></strong>
                      <%}%></center></td></tr> 
   <tr> <td>Question Description</td><td><input type="text" name="qbase"></td></tr>
    <input type="submit" name="submit" value="Add"/>
    
    </form>
    <script>
var frmvalidator  = new Validator("addquestion");  
  frmvalidator.addValidation("qbase","req","Please Enter Question Base");    
  
</script>
  </body>
</html>
