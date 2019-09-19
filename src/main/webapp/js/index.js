$(document).on("click", "#login", function () {
    var username = $("#inputEmail").val();
    var password = $("#inputPassword").val();
    var saveData={"username":username,"password":password};
    $.ajax({
        url: "/login",
        type: "POST",
        dataType: "json",
        contentType: "application/json;charset=utf-8",
        data: JSON.stringify(saveData),
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