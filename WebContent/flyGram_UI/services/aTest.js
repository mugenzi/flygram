$(document).ready(function() {

	$("#submitPost").click(function(event) {

		// stop submit the form, we will post it manually.
		event.preventDefault();

		postSubmission();

	});

});

function postSubmission() {

	var d = JSON.parse(localStorage.getItem("app-token"));
	$.ajax({
		type : "GET",
		contentType : "application/json",
		url : "http://localhost:9595/testing",
		headers:{
		'Authorization':"Bearer "+d.token,
		'Content-Type':'application/json'
		},
		dataType : 'json',
		cache : false,
		timeout : 600000,
		 success: function (data) {
	            $('#feedback').html(data);
	        },
	        error: function (e) {
	            $('#feedback').html(json);
	        }
	});

}


$.ajax({ type: "POST", url: url, data: data, success: success, dataType:
dataType });
