<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>

<script type="text/javascript">
<!--
function showSearchForm(radioObj) {
	
	var searchByNameId = document.getElementById("searchByNameId");
	var searchByPlatformId = document.getElementById("searchByPlatformId");
	var searchByPassOutYearId = document.getElementById("searchByPassOutYearId");
	
	if(radioObj.checked && radioObj.value=='byName') {
		searchByNameId.style.display = 'block';
		searchByPlatformId.style.display = 'none';
		searchByPassOutYearId.style.display = 'none';
	} else if(radioObj.checked && radioObj.value=='byPlatform') {
		searchByNameId.style.display = 'none';
		searchByPlatformId.style.display = 'block';
		searchByPassOutYearId.style.display = 'none';
	} else if(radioObj.checked && radioObj.value=='byPassOutYear') {
		searchByNameId.style.display = 'none';
		searchByPlatformId.style.display = 'none';
		searchByPassOutYearId.style.display = 'block';
	}
}
//-->
</script>

<div>
	<table>
		<th> Find Alumni</th>
		<tr><td><hr/></td></tr>
		<tr>
			<td><input type="radio" name="searchOption" value="byName" onchange="showSearchForm(this)"/> Search By Name</td>
		</tr>
		<tr>
			<td><input type="radio" name="searchOption" value="byPlatform" onchange="showSearchForm(this)"/> Search By Platform</td>
		</tr>
		<tr>
			<td><input type="radio" name="searchOption" value="byPassOutYear" onchange="showSearchForm(this)"/> Search By Passed Out year</td>
		</tr>
		<tr><td><hr/></td></tr>
		<tr>
			<td id="searchFormId">
				<div id="searchByNameId" style="display:none;">
					<html:form action="searchAlumni">
					<html:hidden property="alumniFinder.searchType" value="byName"/>
					<html:hidden property="method" value="searchAlumni"/>
					<table>
						<tr>
							<td>Name</td>
							<td><html:text property="alumniFinder.name" name="searchForm"/></td>
						</tr>
						<tr>
							<td>Course</td>
							<td>
								<html:select property="alumniFinder.course">
									<html:option value="BSc">BSc</html:option>
									<html:option value="BA">BA</html:option>
									<html:option value="BCom">BCom</html:option>
									<html:option value="MSC">MSC</html:option>
									<html:option value="MBA">MBA</html:option>
									<html:option value="MCA">MCA</html:option>
								</html:select>
							</td>
						</tr>
						<tr>
							<td colspan="2"><html:submit value="Search" onclick="this.form.submit()"/> </td>
						</tr>
					</table>
					</html:form>
				</div>
				<div id="searchByPlatformId" style="display:none;">
					<logic:notEmpty property="userSession" name="searchForm">
					<html:form action="searchAlumni">
					<html:hidden property="alumniFinder.searchType" value="byPlatform"/>
					<html:hidden property="method" value="searchAlumni"/>
					<table>
						<tr>
							<td>Platform</td>
							<td><html:text property="alumniFinder.platform" name="searchForm"/></td>
						</tr>
						<tr>
							<td colspan="2"><html:submit value="Search" onclick="this.form.submit()"/> </td>
						</tr>
					</table>
					</html:form>
					</logic:notEmpty>
					<logic:empty property="userSession" name="searchForm">
						Please login!!!
					</logic:empty>
				</div>
				<div id="searchByPassOutYearId" style="display:none;">
					<logic:notEmpty property="userSession" name="searchForm">
					<html:form action="searchAlumni">
					<html:hidden property="alumniFinder.searchType" value="byPassoutYear"/>
					<html:hidden property="method" value="searchAlumni"/>
					<table>
						<tr>
							<td>Passed Out Year</td>
							<td><html:text property="alumniFinder.passoutYear" name="searchForm"/></td>
						</tr>
						<tr>
							<td>Course</td>
							<td>
								<html:select property="alumniFinder.course">
									<html:option value="BSc">BSc</html:option>
									<html:option value="BA">BA</html:option>
									<html:option value="BCom">BCom</html:option>
									<html:option value="MSC">MSC</html:option>
									<html:option value="MBA">MBA</html:option>
									<html:option value="MCA">MCA</html:option>
								</html:select>
							</td>
						</tr>
						<tr>
							<td colspan="2"><html:submit value="Search" onclick="this.form.submit()"/> </td>
						</tr>
					</table>
					</html:form>
					</logic:notEmpty>
					<logic:empty property="userSession" name="searchForm">
						Please login!!!
					</logic:empty>
				</div>
			</td>
		</tr>
	</table>
</div>