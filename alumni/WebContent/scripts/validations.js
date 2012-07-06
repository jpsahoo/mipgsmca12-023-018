
function showError(message, element) {
	element.style.display = '';
	element.innerHTML = message;
}

function showErrorElement(ele, element) {
	var oEle = (arguments.length == 1) ? document.getElementById("errorDiv") : document.getElementById(element);
	oEle.style.display = '';
	oEle.appendChild(ele);
}

function showMessage() {
	var oEle = (arguments.length == 1) ? document.getElementById("messageDiv") : document.getElementById(element);
	oEle.style.display = '';
	oEle.innerHTML = message;
}

function clearAllMessages() {
	var errorDiv = document.getElementById("errorDiv");
	if (errorDiv) efforDiv.style.display = 'none';
	var messageDiv = document.getElementById("messageDiv");
	if (messageDiv) messageDiv.style.display = 'none';
} 

function checkBlankField(element, label) {
	if (element.value == null || element.value== "") {
		return label + " is Required";
	}
	return null;
}

function evaluateErrors(array, ele) {
	var errorDiv = null;
	if (ele == null) {
		errorDiv = document.getElementById("errorDiv");
	} else
		errorDiv = document.getElementById(ele);
	str = "<ul type='circle'>";
	for(var i=0; i<array.length; i++) {
		str += "<li>" + array[i] + ".</li>";
	}
	str += "</ul>";
	showError(str, errorDiv);
}

function addToForm(oForm, ele, value) {
	var el = document.createElement("input");
	el.type = "hidden";
	el.name = ele;
	el.value = value;
	oForm.appendChild(el);
} 