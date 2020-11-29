$(document).ready(function () {

    $("#submitlogin").click(function (event) {

        //stop submit the form, we will post it manually.
        event.preventDefault();

        loginsubmission();

    });

});

function loginsubmission() {

    var s = "mytest";
    $('#feedback').html(s);
   /* var search = {}
    search["username"] = $("#username_id").val();
    search["password"] = $("#password_id").val();*/
    $.ajax({
       
        alert(s);
        
       /* type: "POST",
        contentType: "application/json",
        url: "http://localhost:9595/authenticate",
        data: JSON.stringify(search),
        dataType: 'json',
        cache: false,
        timeout: 600000,
        success: function (data) {
            localStorage.setItem("app-token",data);
            alert(data);
            var json = "<div class='alert alert-success'> <strong>Login success!</div>";
            $('#feedback').html(json);
        },
        error: function (e) {
            var json = "<div class='alert alert-danger'> <strong>Error!"
                + e.responseText + "</div>";
            $('#feedback').html(json);
        }*/

    });

}