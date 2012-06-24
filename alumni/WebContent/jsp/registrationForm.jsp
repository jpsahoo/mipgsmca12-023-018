<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>

<script type="text/javascript" src="/alumni/scripts/registrationForm.js">
<!--

//-->
</script>

<p>
<h3>
<logic:equal value="student" name="registrationForm" property="type">
STUDENT REGISTRATION FORM
</logic:equal>
<logic:equal value="alumni" name="registrationForm" property="type">
ALUMNI REGISTRATION FORM
</logic:equal>
</h3>
</p>
<img src='mipgslogosmall.jpg' width='16' height='16' alt='*' />
Required field
</img>

<html:form action="register" method="post" enctype="multipart/form-data">
<html:hidden property="method" value="register"/>
<html:hidden property="type" name="registrationForm"/>
<table>
	<tr>
		<td>First Name:</td>
		<td><html:text property="registration.firstName" title="First Name: Please enter your real first name."></html:text> *</td>
	</tr>
	<tr>
		<td>Last Name:</td>
		<td><html:text property="registration.lastName" title="Last Name: Please enter your real last name." ></html:text> *</td>
	</tr>
	<tr>
		<td>Gender:</td>
		<td>
			<html:radio property="registration.gender" value="Male">Male</html:radio>&nbsp;&nbsp;&nbsp;
			<html:radio property="registration.gender" value="Female">Female</html:radio>
		*</td>
	</tr>
	<tr>
		<td>Email_id:</td>
		<td><html:text property="registration.emailId" title="Email:Please enter a valid e-mail address."></html:text> *</td>
	</tr>
	<tr>
		<td>Mobile Number:</td>
		<td><html:text property="registration.mobileNumber" title='This Field is required'></html:text> *</td>
	</tr>
	<tr>
		<td>Telephone Number:</td>
		<td><html:text property="registration.telephoneNumber" title="please enter telephone number along with STD code"></html:text></td>
	</tr>
	<tr>
		<td>User Nane:</td>
		<td><html:text property="registration.userName"></html:text> *</td>
	</tr>
	<tr>
		<td>Password</td>
		<td><html:password property="registration.password"></html:password> *</td>
	</tr>
	<tr class="sectiontableentry1 cbft_password" id="cbfr_51__verify">

	</tr>
	<tr class="sectiontableentry1 cbft_password" id="cbfr_51__verify">
		<td>Confirm Password:</td>
		<td><input type="password" name="password__verify" id="password__verify"/> *</td>
	</tr>

	<tr>
		<td>Address Line1:</td>
		<td><html:text property="registration.address.addrLine1"></html:text></td>
	</tr>
	<tr>
		<td>Address Line2:</td>
		<td><html:text property="registration.address.addrLine2"></html:text></td>
	</tr>
	<tr>
		<td>City:</td>
		<td><html:text property="registration.address.city"></html:text></td>
	</tr>
	<tr>
		<td>State:</td>
		<td><html:text property="registration.address.state"></html:text></td>
	</tr>
	<tr>
		<td>Country:</td>
		<td><html:text property="registration.address.country"></html:text></td>
	</tr>
	<tr>
		<td>Pincode:</td>
		<td><html:text property="registration.address.pincode"></html:text></td>
	</tr>
	<tr>

		<td><label>Graduation:</label>
		</td>
		
		<td>
			<html:select property="registration.course.graduation" onchange="updateCourseOptions(this.value)">
				<html:option value=""></html:option>
				<html:option value="UG">Under Graduation</html:option>
				<html:option value="PG">Post Graduation</html:option>
			</html:select>*
		</td>

	</tr>

	<tr>

		<td><label>Course:</label>
		</td>

		<td>
			<html:select property="registration.course.course" styleId="registration.course.course" />*
		</td>

	</tr>

	<logic:equal value="student" name="registrationForm" property="type">
	<tr>
		<td><label>Year:</label>
		</td>

		<td>
			<html:select property="registration.course.year">
				<html:option value="1">1st Year</html:option>
				<html:option value="2">2nd Year</html:option>
				<html:option value="3">3rd Year</html:option>
			</html:select>*
		</td>
	</tr>
	</logic:equal>

	<tr>
		<td><label>Birthday:</label></td>
		<td><html:text property="registration.dob"></html:text></td>
	</tr>
	
	<logic:equal value="alumni" name="registrationForm" property="type">
	<tr>
		<td><label>Year of passing:</label></td>
		<td><html:text property="registration.alumni.passOutYear"></html:text> *</td>
	</tr>
	<tr>
		<td><label>Nature of Employment</label></td>
		<td>
			<html:select property="registration.alumni.emplNature">
				<html:option value="1">[select...]</html:option>
				<html:option value="2">Self Employment</html:option>
				<html:option value="3">Professional</html:option>
			</html:select>*
		</td>
	</tr>
	<tr>
		<td><label>Name of Organization:</label></td>
		<td><html:text property="registration.alumni.orgName"></html:text> </td>
	</tr>
	<tr>
		<td><label>Working Platform:</label></td>
		<td><html:text property="registration.alumni.platform"></html:text>* </td>
	</tr>
	<tr>
		<td><label>Designation:</label></td>
		<td><html:text property="registration.alumni.designation"></html:text>* </td>
	</tr>
	<tr>
		<td><label>City:</label></td>
		<td><html:text property="registration.alumni.emplCity"></html:text> *</td>
	</tr>
	<tr>
		<td><label>Country:</label></td>
		<td><html:text property="registration.alumni.workCountry"></html:text> *</td>
	</tr>
	</logic:equal>
	
	<tr>
		<td><label>Photo:</label></td>
		<td><html:file property="photo"></html:file> </td>
	</tr>

	<tr>
		<td colspan="2">
			<html:submit value="Register" onclick="this.form.submit()"></html:submit>
		</td>
	</tr>

</table>
</html:form>
