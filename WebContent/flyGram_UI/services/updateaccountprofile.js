$(document).ready(function () {

    $("#update_profile").click(function (event) {
        event.preventDefault();
        updateProfile();
    });

});
var d = JSON.parse(localStorage.getItem("app-token"));
var acc = JSON.parse(localStorage.getItem("app-acc"));
function updateProfile() {
    var search = {}
    search["website"] = $("#website_edit").val();
    search["gender"] = $("#gender_edit").val();
    search["biography"] = $("#biography_edit").val();
    $.ajax({
        type: "PUT",
        contentType: "application/json",
        url: "http://localhost:9595/updateAccountProfile/" + acc.accountId,
        data: JSON.stringify(search),
        dataType: 'json',
        cache: false,
        timeout: 600000,
        beforeSend: function (xhr) {
            xhr.setRequestHeader("Authorization", "Bearer " + d.token);
        },
        success: function (data) {
            localStorage.setItem("app-acc", JSON.stringify(data));
            var json = "<div class='alert alert-success alert-dismissable'><a class='panel-close close' data-dismiss='alert'>×</a> <i class='fa fa-coffee'></i> <strong>Success! </strong> Account  has been updated successfully</div>";
            $('#feedback').html(json);
            $('#p_image2').attr('src', 'data:image/png;base64,'+data.profilePic);
        },
        error: function (e) {
            var json = "<div class='alert alert-danger alert-dismissable'><a class='panel-close close' data-dismiss='alert'>×</a> <i class='fa fa-coffee'></i> <strong>Oops! </strong>"
                + e.textResponse + "</div>";
            $('#feedback').html(json);
        }
    });
}
