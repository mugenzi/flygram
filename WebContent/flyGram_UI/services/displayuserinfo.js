$(document).ready(function () {
    var dd = JSON.parse(localStorage.getItem("app-acc"));
     $("#p_names").html(dd.user.fullName+"<br/><br/>User Name: "+dd.user.userName);
     $("#fullname_id").html(dd.user.fullName);
     $("#username_id").html(dd.user.userName);
     $('#p_image').attr('src', 'data:image/png;base64,'+dd.profilePic);
     $('#p_image2').attr('src', 'data:image/png;base64,'+dd.profilePic);
});