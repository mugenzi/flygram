$(document).ready(function () {

    $("#submitlogin").click(function (event) {
        event.preventDefault();
        loginsubmission();
    });

});

function loginsubmission() {

    //alert("Yeahp")
    var search = {}
    search["username"] = $("#username_id").val();
    search["password"] = $("#password_id").val();
    $.ajax({
        type: "POST",
        contentType: "application/json",
        url: "http://localhost:9595/authenticate",
        data: JSON.stringify(search),
        dataType: 'json',
        cache: false,
        timeout: 600000,
        success: function (data) {
            localStorage.setItem('app-token', JSON.stringify(data));
            localStorage.setItem("app-acc", JSON.stringify(data.acc));
            window.location.href = "../flyGram_UI/newsfeed.html"
            var dd = JSON.parse(localStorage.getItem("app-acc"));
            //var valid = "<div class='alert alert-success'> <strong>Success!</strong>Token:"+ localStorage.getItem('app-token') +"</div>";
            // var valid = "<div class='alert alert-success'> <strong>Success!</strong>"+ data.acc.user.fullName +"</div>";
            //  $('#feedback').html(valid);
            // $('#feedback').html(dd.user.fullName);
        },
        error: function (e) {

            var json = "<div class='alert alert-danger alert-dismissable'><a class='panel-close close' data-dismiss='alert'>×</a> <i class='fa fa-coffee'></i> <strong>Oops! </strong>"
                + "Invalid credentials" + "</div>";
            $('#feedback').html(json);
        }

    });

}