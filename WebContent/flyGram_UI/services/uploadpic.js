var d = JSON.parse(localStorage.getItem("app-token"));
$(document).ready(function () {
    $("#btn").click(function (event) {
        event.preventDefault();
        uploadPicture();
    });
});

function uploadPicture() {
    var path = "http://localhost:9595/upload"
    var form = $('#fileUploadForm')[0];
    var data1 = new FormData(form);
    $.ajax({
        url:  path,
        type: 'POST',
        data: data1,
        enctype: 'multipart/form-data',
        processData: false, 
        contentType: false,
        cache: false,
        beforeSend: function (xhr) {
            xhr.setRequestHeader("Authorization", "Bearer " + d.token);
        },
        success: function (data) {
            localStorage.setItem("app-acc", JSON.stringify(data));
            var json = "<div class='alert alert-success alert-dismissable'><a class='panel-close close' data-dismiss='alert'>×</a> <i class='fa fa-coffee'></i> <strong>Success! </strong>Profile has been upadated SUCCESSFULLY</div>";
            $("#feed1").append(json);
            $('#p_image2').attr('src', 'data:image/png;base64,'+data.profilePic);
        },
        error: function (e) {
            var json = "<div class='alert alert-danger alert-dismissable'><a class='panel-close close' data-dismiss='alert'>×</a> <i class='fa fa-coffee'></i> <strong>Oops! </strong>"
            + e.textResponse + "</div>";
            $("#feed1").append(json);
            //alert(error.textResponse);
        }
    });
}

