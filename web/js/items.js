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


//查询所有商品信息
function viewAll(url) {
    var query = $("#searchName").val();
    if(query == undefined){
        query = "";
    }
    $.ajax({
        type:"get",
        url:url+"/items?code=viewAll&query="+query,
        success:function (rs) {
            $(".main").html(rs);
        }
    });
}

//分页
//首页
function first(url) {
    //获取查询条件
    var query = $("#searchName").val();
    //获取当前页
    var pageNow = $("#pageNow").val();
    pageNow = 1;

    $.ajax({
        type:"get",
        url:url+"/items?code=viewAll&query="+query+"&pageNow="+pageNow,
        success:function (rs) {
            $(".main").html(rs);
        }
    });
}

//末页
function last(url,myPages) {
    //获取查询条件
    var query = $("#searchName").val();
    //获取当前页
    var pageNow = $("#pageNow").val();
    pageNow = myPages;

    $.ajax({
        type:"get",
        url:url+"/items?code=viewAll&query="+query+"&pageNow="+pageNow,
        success:function (rs) {
            $(".main").html(rs);
        }
    });
}

//上一页
function pre(url) {
    //获取查询条件
    var query = $("#searchName").val();
    //获取当前页
    var pageNow = $("#pageNow").val();
    if(pageNow<=1){
        alert("已至首页");
    }else{
        pageNow = pageNow - 1;
    }

    $.ajax({
        type:"get",
        url:url+"/items?code=viewAll&query="+query+"&pageNow="+pageNow,
        success:function (rs) {
            $(".main").html(rs);
        }
    });
}


//下一页
function next(url,myPages) {
    //获取查询条件
    var query = $("#searchName").val();
    //获取当前页
    var pageNow = $("#pageNow").val();
    if(pageNow>=myPages){
        alert("已至末页");
    }else{
        pageNow = pageNow - (-1);
    }

    $.ajax({
        type:"get",
        url:url+"/items?code=viewAll&query="+query+"&pageNow="+pageNow,
        success:function (rs) {
            $(".main").html(rs);
        }
    });
}


//跳转
function skip(url,myPages) {
    //获取查询条件
    var query = $("#searchName").val();
    //获取当前页
    var pageNow = $("#pageNow").val();
    if(pageNow<1 || pageNow>myPages){
        alert("超出范围");
        pageNow = 1;
    }

    $.ajax({
        type:"get",
        url:url+"/items?code=viewAll&query="+query+"&pageNow="+pageNow,
        success:function (rs) {
            $(".main").html(rs);
        }
    });
}

//显示add界面
function add() {
    $.ajax({
        type:"get",
        url:"addItem.jsp",
        success:function(rs){
            $(".main").html(rs);
        }
    });
}

//校验商品名称是否存在
function validateName(url) {
    var name = $("#name").val();
    $.ajax({
        type:"get",
        url:url+"/items?code=validate&name="+name,
        dataType:"json",   //若要解析json数据，必须由此项
        success:function(rs){
            var flag = rs.flag;
            var message = rs.message;
            alert(flag +"\n"+message);
            if(flag=='true'){
                $(".nameMsg").html("<font style='color: #3c763d'>"+message+"</font>");
            }else if(flag=='false'){
                $(".nameMsg").html("<font style='color: darkred'>"+message+"</font>");
            }
        }
    });
}