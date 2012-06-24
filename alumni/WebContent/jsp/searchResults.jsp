<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>

<link href="style.css" rel="stylesheet" type="text/css" />

<div>Search Results:</div>
<div>
	<logic:equal value="byName" property="alumniFinder.searchType" name="searchForm">
		<table>
			<tr>
				<th class="searchHeader">Name</th>
				<th class="searchHeader">Course</th>
				<th class="searchHeader">Passout Year</th>
			</tr>
			<logic:iterate id="result" property="searchResult" name="searchForm" indexId="ctx">
			<tr>
				<td class="<%= (ctx%2==0)? "rowEven":"rowOdd" %>"><bean:write name="result" property="name"/> </td>
				<td class="<%= (ctx%2==0)? "rowEven":"rowOdd" %>"><bean:write name="result" property="course"/> </td>
				<td class="<%= (ctx%2==0)? "rowEven":"rowOdd" %>"><bean:write name="result" property="passoutYear"/> </td>
			</tr>
			</logic:iterate>
		</table>
	</logic:equal>
	<logic:equal value="byPlatform" property="alumniFinder.searchType" name="searchForm">
		<table>
			<tr>
				<th class="searchHeader">Name</th>
				<th class="searchHeader">E-mail ID</th>
				<th class="searchHeader">Organization Name</th>
				<th class="searchHeader">Course</th>
				<th class="searchHeader">Passout Year</th>
				<th class="searchHeader">Platform</th>
			</tr>
			<logic:iterate id="result" property="searchResult" name="searchForm" indexId="ctx">
			<tr>
				<td class="<%= (ctx%2==0)? "rowEven":"rowOdd" %>"><bean:write name="result" property="name"/> </td>
				<td class="<%= (ctx%2==0)? "rowEven":"rowOdd" %>"><bean:write name="result" property="emailId"/> </td>
				<td class="<%= (ctx%2==0)? "rowEven":"rowOdd" %>"><bean:write name="result" property="orgName"/> </td>
				<td class="<%= (ctx%2==0)? "rowEven":"rowOdd" %>"><bean:write name="result" property="course"/> </td>
				<td class="<%= (ctx%2==0)? "rowEven":"rowOdd" %>"><bean:write name="result" property="passoutYear"/> </td>
				<td class="<%= (ctx%2==0)? "rowEven":"rowOdd" %>"><bean:write name="result" property="platform"/> </td>
			</tr>
			</logic:iterate>
		</table>
	</logic:equal>
		<logic:equal value="byPassoutYear" property="alumniFinder.searchType" name="searchForm">
		<table>
			<tr>
				<th class="searchHeader">Name</th>
				<th class="searchHeader">E-mail ID</th>
				<th class="searchHeader">Organization Name</th>
				<th class="searchHeader">Course</th>
				<th class="searchHeader">Passout Year</th>
				<th class="searchHeader">Platform</th>
			</tr>
			<logic:iterate id="result" property="searchResult" name="searchForm" indexId="ctx">
			<tr>
				<td class="<%= (ctx%2==0)? "rowEven":"rowOdd" %>"><bean:write name="result" property="name"/> </td>
				<td class="<%= (ctx%2==0)? "rowEven":"rowOdd" %>"><bean:write name="result" property="emailId"/> </td>
				<td class="<%= (ctx%2==0)? "rowEven":"rowOdd" %>"><bean:write name="result" property="orgName"/> </td>
				<td class="<%= (ctx%2==0)? "rowEven":"rowOdd" %>"><bean:write name="result" property="course"/> </td>
				<td class="<%= (ctx%2==0)? "rowEven":"rowOdd" %>"><bean:write name="result" property="passoutYear"/> </td>
				<td class="<%= (ctx%2==0)? "rowEven":"rowOdd" %>"><bean:write name="result" property="platform"/> </td>
			</tr>
			</logic:iterate>
		</table>
	</logic:equal>
</div>
<div><a href="/alumni/showAlumniSearchForm.do?method=showAlumniSearchForm">&lt;&lt; Back</a></div>