<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="/WEB-INF/struts-tiles.tld" prefix="tiles"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><tiles:getAsString name="title" ignore="true" /></title>
<link href="/alumni/css/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="/alumni/scripts/jquery-1.3.2.min.js"></script>
</head>
<body>
	<table cellpadding="10" width="100%">
		<tr height="10%">
			<td width="100%" colspan="3" nowrap="nowrap" style="background:url(/alumni/images/mainbg.gif) 0 0 repeat-x #F6F4E4; color:#6B6854; font:14px/18px "Trebuchet MS", Arial, Helvetica, sans-serif;"><tiles:insert attribute="header" ignore="true" /></td>
		</tr>
		<tr height="80%">
			<td width="20%" align="center" style="vertical-align: top;">
				<table width="100%">	
					<tr height="50%">
						<td width="100%"><tiles:insert attribute="links" /></td>
					</tr>
					<tr height="50%">
						<td width="100%"><tiles:insert attribute="login" /></td>
					</tr>
				</table>
			</td>
			<td width="70%" style="vertical-align: top;"><tiles:insert attribute="body" /></td>
			<td width="20%" style="vertical-align: top;"><tiles:insert attribute="right" /></td>
		</tr>
		<tr height="10%">
			<td width="100%" colspan="3"><tiles:insert attribute="footer" /></td>
		</tr>
	</table>
</body>
</html>