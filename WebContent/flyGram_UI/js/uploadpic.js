var d = JSON.parse(localStorage.getItem("app-token"));
$(document).ready(function () {
    $("#checkdoc").click(function (event) {
        var path = "http://localhost:9595/upload"
        var input = document.getElementById("btn");
        file = input.files[0];
        $.ajax({
            url: path,
            type: "POST",
            data: file,
            contentType: "application/json",
            beforeSend: function (xhr) {
                xhr.setRequestHeader("Authorization", "Bearer " + d.token);
            },
            success: function (data) {
                localStorage.setItem("app-acc", JSON.stringify(data));
                $("#feedback").append(data);
            },
            error: function (error) {
                alert(error.textResponse);
            }
        });
    });
});