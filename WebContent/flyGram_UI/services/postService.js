var d = JSON.parse(localStorage.getItem("app-token"));
$(document).ready(function() {

	$("#filePath").change(function(event) {
		event.preventDefault();
		postSubmit();
	});

});

$(document).ready(function() {

	$("#sharePost").click(function(event) {
		event.preventDefault();
		captionSubmit();
	});

}); 
function postSubmit() {

	var form = $('#fileUploadForm')[0];
	var data = new FormData(form);

	$.ajax({
		url : "http://localhost:9595/createPost1",
		type : 'POST',
		data : data,
		enctype : 'multipart/form-data',
		processData : false, // tell jQuery not to process the data
		contentType : false, // tell jQuery not to set contentType
		cache : false,
		timeout : 600000,
		beforeSend : function(xhr) {
			xhr.setRequestHeader("Authorization", "Bearer " + d.token);
		},
		success : function(data) {

		},
		error : function(e) {

		}
	});

}

function captionSubmit() {

	var search = {}
	search["caption"] = $("#postCaption").val();

	$
			.ajax({
				type : "POST",
				contentType : "application/json",
				url : "http://localhost:9595/createPost",
				data : JSON.stringify(search),
				dataType : 'json',
				cache : false,
				timeout : 600000,
				beforeSend : function(xhr) {
					xhr.setRequestHeader("Authorization", "Bearer " + d.token);
				},
				success : function(data) {
					var json = "<div class='alert alert-success'> <strong>Post successfully uploaded! </strong>"
							+ "Invalid credentials" + "</div>";
					$('#feedback').html(json);
				},
				error : function(e) {

					var json = "<div class='alert alert-danger'> <strong>Oops! </strong>"
							+ "Invalid credentials" + "</div>";
					$('#feedback').html(json);
				}
			});

}
