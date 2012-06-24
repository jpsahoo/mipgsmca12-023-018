<%@page import="ac.mipgs.common.Constants"%>
<%@page import="ac.mipgs.vo.UserSession"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>

<script type="text/javascript">
<!--

function openProfile(id) {
	var action = '/alumni/gotoProfile.do?method=gotoProfile&id=' + id;
	var profileForm = document.createElement("form");
	//profileForm.method = 'post';
	profileForm.action = action;
	profileForm.submit();
}
//-->
</script>

<%

UserSession userSession = (UserSession)session.getAttribute(Constants.LOGIN_INFO);
if(userSession == null) {
%>
<table id="leftPan">
	<tr>
		<td align="left">
		<html:form action="login" method="post">
			<html:hidden property="method" value="login"/>
			<h2>members login</h2>
			<label>Log In:</label> 
			<html:text property="login.userName" name="loginForm"></html:text>
			<label>Password:</label> 
			<html:password property="login.password" name="loginForm"></html:password> 
			<input name="" type="submit" class="button" value="Login" />
			<div id="register">
				<a href="/alumni/showRegistrationLinks.do?method=showRegistrationLinks">Register now</a>
			</div>
		</html:form>
		</td>
	</tr>
</table>
<%
} else {
	String fullName = userSession.getFullName();
	String id = userSession.getId();
%>
<table id="leftPan" width="100%">
	<tr>
		<td align="left">
			<html:form action="gotoProfile" method="post" styleId="profileForm">
				<html:hidden property="method" value="gotoProfile"/>
				<html:hidden property="registration.id" value="<%=id%>"/>
				<div style="width: 100%; height: 30%; vertical-align: middle;" align="center">
					<table width="100%" height="100%" align="center" style="padding-left: 5px; padding-right: 5px;">
						<tr>
							<td align="left"><%=fullName %></td>
							<td align="right">
								<a href="/alumni/logout.do?method=logout">Logout</a>
							</td>
						</tr>
					</table>
				</div>
				<div align="center" style="width: 100%; height: 70%; vertical-align: middle;">
					<img style="width: 100px; height: 100px;" alt="" src='/alumni/getPhoto.do?method=getPhoto&id=<%=id %>' onclick='document.getElementById("profileForm").submit();'> 
				</div>
			</html:form>
		</td>
	</tr>
</table>
<%}%>