<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
	<p><h3>ALUMNI REGISTRATION FORM:</h3></p><img src='mipgslogosmall.jpg' width='16' height='16' alt='*' /> Required field</img>
	<br />
	<table>
		<tr>
			<td>First Name:</td>
			<td><input type="text" id="firstname" /><img src='mipgslogosmall.jpg' width='16' height='16' alt='*' /> </td>
		</tr>
		<tr>
			<td>Last Name:</td>
			<td><input type="text" id="lastname" /><img src='mipgslogosmall.jpg' width='16' height='16' alt='*' /> </td>
		</tr>
		<tr>
			<td>Email_id:</td>
			<td><input type="text" id="email_id" /><img src='mipgslogosmall.jpg' width='16' height='16' alt='*' /> </td>
		</tr>
		<tr>
			<td>Mobile Number:</td>
			<td><input type="text" id="mobile_number" /><img src='mipgslogosmall.jpg' width='16' height='16' alt='*' /></td>
		</tr>
		<tr>
			<td>Telephone Number:</td>
			<td><input type="text" id="telephone_number" /></td>
		</tr>
		<tr>
			<td>User Nane:</td>
			<td><input type="text" id="userid" /><img src='mipgslogosmall.jpg' width='16' height='16' alt='*' /></td>
		</tr>
	<tr>
		<td>Password</td>
		<td class="fieldCell" id="cbfv_51"><input type="password"
			name="password" id="password" value="" mosReq="1" mosLabel="Password"
			autocomplete="off" size="25" maxlength="50"
			class="{minlength:6} required inputbox"
			title="Password: Please enter a valid password.  No spaces, at least 6 characters and contain lower and upper-case letters, numbers and special signs" />
			<span class='cbFieldIcons'> <img src='mipgslogosmall.jpg'
				width='16' height='16' alt='*' title='This Field is required' />
		</span>
		</td>
	</tr>
	<tr class="sectiontableentry1 cbft_password" id="cbfr_51__verify">

	</tr>
	<tr class="sectiontableentry1 cbft_password" id="cbfr_51__verify">
		<td class="titleCell"><label for="password__verify"
			id="cblabpassword__verify"
			title="Verify Password:Please enter a valid password.  No spaces, at least 6 characters and contain lower and upper-case letters, numbers and special signs">Verify
				Password:</label>
		</td>
		<td class="fieldCell" id="cbfv_51__verify"><input type="password"
			name="password__verify" id="password__verify" value="" mosReq="1"
			mosLabel="Verify Password" autocomplete="off" size="25"
			maxlength="50"
			class="{minlength:6,equalTo:'#password'} required inputbox"
			title="Verify Password: Please enter a valid password.  No spaces, at least 6 characters and contain lower and upper-case letters, numbers and special signs" /><span
			class='cbFieldIcons'> <img src='mipgslogosmall.jpg' width='16'
				height='16' alt='*' title='This Field is required' />
		</span>
		</td>
	</tr>
	<tr>
			<td>Address Line1:</td>
			<td><input type="text" id="addressline1" /></td>
		</tr>
		<tr>
			<td>Address Line2:</td>
			<td><input type="text" id="addressline2" /></td>
		</tr>
		<tr>
			<td>City:</td>
			<td><input type="text" id="city" /></td>
		</tr>
		<tr>
			<td>State:</td>
			<td><input type="text" id="state" /></td>
		</tr>
		<tr>
			<td>Country:</td>
			<td><input type="text" id="country" /></td>
		</tr>
		<tr>
			<td>Pincode:</td>
			<td><input type="text" id="pincode" /></td>
		</tr>
			<tr >

		<td ><label >Graduation:</label></td>
					
		<td><select>
	<option value=""> </option>
	
				<option value="UG">UG</option>
			
	<option value="PG">PG</option>

			</select> <img src='mipgslogosmall.jpg' width='16' height='16' alt='*' title='This Field is required' />		</td>
			
	</tr>
			
	<tr>
		
		<td><label>Course:</label></td>

		<td>
<select>
	<option value=""></option>
	
				<option value="MSc">MSc</option>
	
				<option value="MCA">MCA</option>
	
				<option value="MBA">MBA</option>
</select><img src='mipgslogosmall.jpg' width='16' height='16' alt='*' title='This Field is required' /></td>
	
	</tr>

	
	
<tr>
		
		<td><label>Birthday:</label></td>

		<td><input type="text"id="cb_birthday" value="" /> <img src='mipgslogosmall.jpg' width='16' height='16' alt='*' title='This Field is required' /></td>

	</tr>
	<tr>
		
		<td><label>Year of passing:</label></td>

		<td><input type="text"id="cb_passedoutyear" value="" /> <img src='mipgslogosmall.jpg' width='16' height='16' alt='*' title='This Field is required' /></td>

	</tr>
	<tr>
		
		<td><label>Nature of Employment</label></td>

		<td><input type="text"id="cb_emplnature" value="" /></td>

	</tr>
	<tr>
		
		<td><label>Name of Organization:</label></td>

		<td><input type="text"id="cb_orgname" value="" /></td>

	</tr>
	<tr>
		
		<td><label>Working Platform:</label></td>

		<td><input type="text"id="cb_platform" value="" /></td>

	</tr>
	<tr>
		
		<td><label>Designation:</label></td>

		<td><input type="text"id="cb_designation" value="" /> </td>

	</tr>
	<tr>
		
		<td><label>City:</label></td>

		<td><input type="text"id="cb_emplcity" value="" /> </td>

	</tr>
	<tr>
		
		<td><label>Country:</label></td>

		<td><input type="text"id="cb_workcountry" value="" /> </td>

	</tr>


		
	</table><br /><br />

<input type="submit" value="Register" class="button" />