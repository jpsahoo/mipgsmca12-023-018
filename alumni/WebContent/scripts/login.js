function openProfile(id) {
	var action = '/alumni/gotoProfile.do?method=gotoProfile&id=' + id;
	var profileForm = document.createElement("form");
	addToForm(profileForm, 'registration.id', id);
	profileForm.action = action;
	profileForm.submit();
}

function submitLoginForm(oForm) {
	var retvalue = validateLoginForm(oForm); 
	if (retvalue.length > 0) {
		evaluateErrors(retvalue);
		return;
	}
	oForm.submit();
}

function validateLoginForm(oForm) {
	var errors = new Array();
	var retValue = checkBlankField(oForm['login.userName'], 'User name');
	var index = 0;
	if (retValue) errors[index++] = retValue;
	retValue = checkBlankField(oForm['login.password'], 'Password');
	if (retValue) errors[index++] = retValue;
	return errors;
}

function submitRegisterForm() {
	var oForm = document.createElement("form");
	oForm.action = '/alumni/showRegistrationLinks.do';
	addToForm(oForm, 'method', 'showRegistrationLinks');
	oForm.submit();
}