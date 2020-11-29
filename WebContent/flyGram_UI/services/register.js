$(document).ready(function () {

    $("#submituser").click(function (event) {

        //stop submit the form, we will post it manually.
        event.preventDefault();

        fire_ajax_submit();

    });

});

function fire_ajax_submit() {

    var search = {}
    search["username"] = $("#username_id").val();
    search["password"] = $("#password_id").val();
    search["fullName"] = $("#fullname_id").val();
    search["email"] = $("#email_id").val();
    search["phone"] = $("#phone_id").val();

    $.ajax({
        type: "POST",
        contentType: "application/json",
        url: "http://localhost:9595/register",
        data: JSON.stringify(search),
        dataType: 'json',
        cache: false,
        timeout: 600000,
        success: function (data) {
            var json = "<div class='alert alert-success alert-dismissable'><a class='panel-close close' data-dismiss='alert'>×</a> <i class='fa fa-coffee'></i> <strong>Success! </strong>" + JSON.stringify(data.fullName, null, 4) + " Account Created</div>";
            $('#feedback').html(json);
        },
        error: function (e) {
            var json ="<div class='alert alert-danger alert-dismissable'><a class='panel-close close' data-dismiss='alert'>×</a> <i class='fa fa-coffee'></i> <strong>Oops! </strong>"
            + e.textResponse + "</div>";
            $('#feedback').html(json);
        }
    });

}