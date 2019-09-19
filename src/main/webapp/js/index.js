$(document).on("click","#login",function () {
    var username = $("#username").val();
    var password = $("#password").val();
    $.ajax({
        url:"/login",
        type:"POST",
        data:{username:username, password:password},
        success:function (result) {
            if (result.code == 200) {
                alert("登录成功");
                to_Page(totalRecord);
            } else {
                if (undefined != result.extend.errorFields.email) {
                    show_validate_msg("#email_add_input", "error", result.extend.errorFields.email);
                }
                if (undefined != result.extend.errorFields.empName) {
                    show_validate_msg("#email_add_input", "error", result.extend.errorFields.empName);
                }
            }
        }
    })
});