<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="/WEB-INF/struts-tiles.tld" prefix="tiles"%>
<link href="/alumni/css/style.css" rel="stylesheet" type="text/css" />

<tiles:insert page="layout.jsp" flush="true">
	<tiles:put name="title" value="Alumni Portal" />
	<tiles:put name="header" value="header.jsp" />
	<tiles:put name="menu" value="menu.jsp" />
	<tiles:put name="body" value="body_socialmedia.jsp" />
	<tiles:put name="footer" value="footer.jsp" />
</tiles:insert>