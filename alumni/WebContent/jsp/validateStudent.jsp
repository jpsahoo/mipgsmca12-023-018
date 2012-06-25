<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>

<%
String errorMessage = (String)request.getAttribute("VALIDATE_ERROR");
if (errorMessage != null) {
%>
<div style="color: red;">
<%=errorMessage %>
</div>
<%} %>
<html:form action="validateStudent">
<html:hidden property="method" value="validateStudent"/>
<html:hidden property="type" name="studentValidatorForm"/>
<table>
	<tr>
		<td>Name</td>
		<td><html:text property="validator.name" name="studentValidatorForm"></html:text> </td>
	</tr>
	<tr>
		<td>Roll Number</td>
		<td><html:text property="validator.rollNumber" name="studentValidatorForm"></html:text> </td>
	</tr>
	<tr>
		<td colspan="2"><html:submit value="Register" onclick="this.form.submit();"></html:submit></td>
	</tr>
</table>
</html:form>