$(document).ready(function() {


	
});

function go(url) {
	window.location = url;
}

function newContact() {
	window.location = "saveContact.do";
}

function deleteGrade(url) {
	var isOK = confirm("Are you sure to delete Grade?");
	if (isOK) {
		go(url);
	}
}



function showStudentsByGrade(gradeId){
	alert("aaa "+ gradeId);
}