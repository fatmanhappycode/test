$(document).on("click", "#login", function () {
    var username = $("#inputEmail").val();
    var password = $("#inputPassword").val();
    $.ajax({
        url: "/login",
        type: "POST",
        dataType: "json",
        async: true,
        contentType: "application/json;charset=utf-8",
        data: {"username": username, "password": password},
        success: function (result) {
            if (result.code == 200) {
                alert(result.msg);
            } else if (result.code == 401) {
                alert(result.msg);
            } else {
                // doSomething
            }
        }
    })
});