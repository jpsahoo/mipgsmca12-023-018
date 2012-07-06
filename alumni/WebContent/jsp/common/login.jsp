<%@page import="ac.mipgs.common.Constants"%>
<%@page import="ac.mipgs.vo.UserSession"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>

<script type="text/javascript" src="/alumni/scripts/validations.js"></script>
<script type="text/javascript" src="/alumni/scripts/login.js"></script>

<%

UserSession userSession = (UserSession)session.getAttribute(Constants.LOGIN_INFO);
if(userSession == null) {
%>
<html:form action="showRegistrationLinks" styleId="regForm">
<html:hidden property="method" value="showRegistrationLinks"/>
</html:form>
<html:form action="login" method="post">
<html:hidden property="method" value="login"/>
<table class="loginForm">
	<thead>
		<tr><td class="heading2" colspan="2">Login here</td></tr>
	</thead>
	<tbody class="loginBody">
		<tr><td colspan="2"><div id="errorDiv" class="errorMessage" style="display: none; line-height: 16px; padding-left: 20px"></div></td></tr>
		<tr><td class="labelText" colspan="2">User Name</td></tr>
		<tr>
		<td class="inputField" colspan="2"><html:text property="login.userName" name="loginForm" /></td>
		</tr>
		<tr><td class="labelText" colspan="2">Password</td></tr>
		<tr>
			<td class="inputField" colspan="2"><html:password property="login.password" name="loginForm" /></td>
		</tr>
		<tr>
			<td class="submitButton">
				<input type="button" class="button" value="Login" onclick="submitLoginForm(this.form);"/>
			</td>
			<td class="submitButton">
				<input type="button" class="button" value="Register now" onclick='document.getElementById("regForm").submit();'/>
			</td>
		</tr>
	</tbody>
</table>
</html:form>
<%-- 
<table id="leftPan">
	<tr>
		<td align="left">
		<html:form action="login" method="post">
			<html:hidden property="method" value="login"/>
			<h2>members login</h2>
			<label>User Name</label> 
			<html:text property="login.userName" name="loginForm"></html:text>
			<label>Password</label> 
			<html:password property="login.password" name="loginForm"></html:password> 
			<input name="" type="button" class="button" value="Login" onclick="submitLoginForm(this.form);"/>
			<div id="register">
				<a href="/alumni/showRegistrationLinks.do?method=showRegistrationLinks">Register now</a>
			</div>
		</html:form>
		</td>
	</tr>
</table>--%>
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
					<img title="Click to view and edit your profile" style="width: 100px; height: 100px;" alt="" src='/alumni/getPhoto.do?method=getPhoto&id=<%=id %>' onclick='document.getElementById("profileForm").submit();'> 
				</div>
			</html:form>
		</td>
	</tr>
</table>
<%}%>