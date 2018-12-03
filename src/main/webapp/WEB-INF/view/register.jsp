<%--
  Created by IntelliJ IDEA.
  User: cjr
  Date: 2018/11/3 0003
  Time: 16:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="shortcut icon" type="/image/x-icon" href="../../favicon.ico" media="screen" />
    <link type="text/css" rel="stylesheet" href="/css/bootstrap.css"/>
    <link rel="stylesheet" href="/css/font-awesome.css">
    <link rel="stylesheet" href="/css/style.css">
    <script type="text/javascript" language="JavaScript" src="/js/jquery-3.3.1.min.js"></script>
    <script type="text/javascript" src="/js/bootstrap.js"></script>
    <title>注册</title>
</head>
<body class="body-style">
    <img src="/img/logo.jpg" alt="logo" style="width: 100px;height: 100px;position: fixed;top: 0;left: 0;border-radius: 50%;box-shadow: 2px 4px 4px;z-index: 4">
    <div id="op"></div>
    <div class="register-stytle">
        <form action="register" method="post" onsubmit="return checkInformation()">
            <div class="form-group">
                <label for="uname">用户名:</label>
                <input type="text" class="form-control" id="uname" name="uname">
            </div>
            <div class="form-group">
                <label for="upwd">密码:</label>
                <input type="password" class="form-control" id="upwd" name="upwd">
            </div>
            <div class="form-group">
                <label for="upwd">确认密码:</label>
                <input type="password" class="form-control" id="Sureupwd" name="Sureupwd">
            </div>
            <div class="radio">
                <label><input type="radio" value="1" name="usex">男</label>
                <label><input type="radio" value="0" name="usex">女</label>
            </div>
            <div class="form-group">
                <label for="ubirthday">生日:</label>
                <input type="date" class="form-control" id="ubirthday" name="ubirthday">
            </div>
            <div class="form-group">
                <label for="receiver">收货人:</label>
                <input type="text" class="form-control" id="receiver" name="receiver">
            </div>
            <div class="form-group">
                <label for="raddress">地址:</label>
                <input type="text" class="form-control" id="raddress" name="raddress">
            </div>
            <div class="form-group">
                <label for="rtelephone">收货人电话:</label>
                <input type="text" class="form-control" id="rtelephone" name="rtelephone">
            </div>
            <button type="submit" class="btn btn-success">提交</button>
        </form>
    </div>
    <script>
        <%--对注册的用户输入的信息进行健壮性的判断--%>
        function checkInformation() {
            if("" == $("input[id='uname']").val()){
                alert("请输入账号")
                document.getElementById("uname").focus()
                return false
            }
            if("" == $("input[id='upwd']").val()){
                alert("请输入密码")
                document.getElementById("upwd").focus()
                return false
            }
            if("" == $("input[id='Sureupwd']").val()){
                alert("请确认密码")
                document.getElementById("Sureupwd").focus();
                return false
            }
            if(!($("input[id='upwd']").val() == $("input[id='Sureupwd']").val())){
                alert("请重新确认密码")
                document.getElementById("Sureupwd").focus()
                return false
            }
            if($("input[id='ubirthday']").val() == null || $("input[id='ubirthday']").val() == ""){
                alert("请输入出生日期")
                document.getElementById("ubirthday").focus();
                return false
            }
            else{
                return true;
            }
        }

    </script>
</body>
</html>
