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
        success:function(rs){  //rs 就是json串  {"flag":"false","message":"当前商品名称已被占用"}
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

//增加商品
function addServlet(url) {
    //以二进制数据格式收集数据
    var formData = new FormData($("#addForm")[0]);
    $.ajax({
        type:"post",
        url:url+"/items?code=add",
        data:formData,
        contentType:false,
        processData:false,
        success:function(rs){
            $(".main").html(rs);
        }
    });
}


//显示修改界面
function viewOne(url){
    $.ajax({
        type:"get",
        url:url,
        success:function (rs) {
            $(".main").html(rs);
        }
    });
}

//校验更新时的用户名是否存在
function validateUpdateName(url,oldName) {
    var newName = $("#name").val();

    if(oldName != newName){
        $.ajax({
            type:"get",
            url:url+"/items?code=validate&name="+newName,
            dataType:"json",   //若要解析json数据，必须由此项
            success:function(rs){  //rs 就是json串  {"flag":"false","message":"当前商品名称已被占用"}
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
    }else{
        $(".nameMsg").html("");
    }
}


//更新商品信息
function updateServlet(url) {
    var formData = new FormData($("#updateForm")[0]);
    $.ajax({
        type:"post",
        url:url+"/items?code=update",
        data:formData,
        contentType:false,
        processData:false,
        success:function(rs){
            $(".main").html(rs);
        }
    });
}


//删除
function deleteAll(url,str) {

    if(str=="all"){
        //多选删除   http://localhost:8899/items?code=delete&id=1&id=2
        var s = "";
        $(".single").each(function () {
            if($(this).prop("checked")){
                var id = $(this).parents(".data").find(".id").text();
                // &id=1&id=2
                s = s + "&id="+id;
                alert(s)
            }
        });
        url = url+"/items?code=delete"+s;  //&id=1&id=2&id=3
    }else{
        //单项删除  http://localhost:8899/items?code=delete&id=1
        url = url+"/items?code=delete&id="+str;
    }

    //发送请求
    $.ajax({
        type:"get",
        url:url,
        success:function (rs) {
            $(".main").html(rs);
        }
    });
}