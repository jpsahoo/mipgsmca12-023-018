
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