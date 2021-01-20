//显示登陆界面
function login() {
    $.ajax({
        type:"get",
        url:"login.jsp",
        success:function(rs){
            $(".main").html(rs);
        }
    });
}

//实现登陆功能
function loginServlet(url) {
    //收集表单数据
    var data = $(".loginForm").serialize();
    $.ajax({
        type:"post",
        url:url+"/userLogin?code=login",
        data:data,
        success:function(content){
            $(".main").html(content);
        }
    });
}

//实现登出
function logout(url) {
    $.ajax({
        type:"get",
        url:url+"/userLogin?code=logout",
        success:function (rs) {
            $(".main").html(rs);
        }
    });
}