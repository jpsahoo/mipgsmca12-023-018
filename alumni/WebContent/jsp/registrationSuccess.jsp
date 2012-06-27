<%@page import="ac.mipgs.common.Constants"%>
<%@page import="ac.mipgs.vo.UserSession"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>

<div>
	<%
		UserSession userSession = (UserSession)session.getAttribute(Constants.LOGIN_INFO);
		String errorMessage = (String) request.getAttribute(Constants.ERROR_KEY);
		String fullName = null;
		if (userSession != null) {
			fullName = userSession.getFullName();
		}
	%>
	<%if (errorMessage != null) { %>
	<div style="color: red;">
		<%=errorMessage %>
	</div>
	<% } else if (fullName != null) { %>
	<div style="color: green;">
		<logic:equal value="registration_save" property="fromAction" name="registrationForm">
		Registration Successful!!! <br></br>&nbsp&nbsp&nbsp&nbsp&nbsp
		Welcome Mr/Mrs. <%=fullName %>
		</logic:equal>
		<logic:equal value="registration_update" property="fromAction" name="registrationForm">
		Mr/Mrs. <%=fullName %>, your profile successfully updated.
		</logic:equal>
	</div>
	<%}%>
</div>