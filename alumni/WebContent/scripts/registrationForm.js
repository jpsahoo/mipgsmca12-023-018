
function updateCourseOptions(value) {
	switch (value) {
	case "UG":
		updateUGOptions();
		break;
	case "PG":
		updatePGOptions();
		break;
	default:
		break;
	}
}

function updateUGOptions() {
	var ele = document.getElementById("registration.course.course");
	ele.options[0] = new Option("BSc", "BSc");
	ele.options[1] = new Option("BA", "BA");
	ele.options[2] = new Option("BCom", "BCom");
}

function updatePGOptions() {
	var ele = document.getElementById("registration.course.course");
	ele.options[0] = new Option("MSC", "MSc");
	ele.options[1] = new Option("MBA", "MBA");
	ele.options[2] = new Option("MCA", "MCA");
}

function submitForm(oForm) {
	var retvalue = validateRegistrationForm(oForm); 
	if (retvalue.length > 0) {
		evaluateErrors(retvalue, 'registrationErrorsDiv');
		return;
	}
	oForm.submit();
}

function validateRegistrationForm(oForm) {
	var errors = new Array();
	var index = 0;
	
	var regType = oForm['type'].value;
	
	var retValue = checkBlankField(oForm['registration.firstName'], 'First name');
	if (retValue) errors[index++] = retValue;
	retValue = checkBlankField(oForm['registration.lastName'], 'Last name');
	if (retValue) errors[index++] = retValue;
	retValue = checkBlankField(oForm['registration.emailId'], 'email_id');
	if (retValue) errors[index++] = retValue;
	retValue = checkBlankField(oForm['registration.mobileNumber'], 'mobile number');
	if (retValue) errors[index++] = retValue;
	retValue = checkBlankField(oForm['registration.userName'], 'user name');
	if (retValue) errors[index++] = retValue;
	retValue = checkBlankField(oForm['registration.password'], 'password');
	if (retValue) errors[index++] = retValue;
	retValue = checkBlankField(oForm['password__verify'], 'confirm password');
	if (retValue) errors[index++] = retValue;
	retValue = checkBlankField(oForm['registration.course.graduation'], 'Graduation');
	if (retValue) errors[index++] = retValue;
	retValue = checkBlankField(oForm['registration.course.course'], 'Course');
	if (retValue) errors[index++] = retValue;
	
	if (regType == 'alumni') {
		retValue = checkBlankField(oForm['registration.alumni.passOutYear'], 'Pass out year');
		if (retValue) errors[index++] = retValue;
		retValue = checkBlankField(oForm['registration.alumni.emplNature'], 'nature of employment');
		if (retValue) errors[index++] = retValue;
		retValue = checkBlankField(oForm['registration.alumni.platform'], 'working platform');
		if (retValue) errors[index++] = retValue;
		retValue = checkBlankField(oForm['registration.alumni.designation'], 'designation');
		if (retValue) errors[index++] = retValue;
		retValue = checkBlankField(oForm['registration.alumni.emplCity'], 'employ city');
		if (retValue) errors[index++] = retValue;
		retValue = checkBlankField(oForm['registration.alumni.workCountry'], 'working country');
		if (retValue) errors[index++] = retValue;
	}
	return errors;
}