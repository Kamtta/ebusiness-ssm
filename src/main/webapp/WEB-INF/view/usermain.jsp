<%@ page import="com.dreamTimes.beans.User" %>
<%@ page import="java.util.Date" %><%--
  Created by IntelliJ IDEA.
  User: cjr
  Date: 2018/11/4 0004
  Time: 17:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户主界面</title>
    <link rel="shortcut icon" type="/image/x-icon" href="../../favicon.ico" media="screen" />
    <link type="text/css" rel="stylesheet" href="/css/bootstrap.css"/>
    <link rel="stylesheet" href="/css/font-awesome.css">
    <link rel="stylesheet" href="/css/style.css">
    <script type="text/javascript" language="JavaScript" src="/js/jquery-3.3.1.min.js"></script>
    <script type="text/javascript" language="JavaScript" src="/js/popper.min.js"></script>
    <script type="text/javascript" src="/js/bootstrap.js"></script>
</head>
<body>

        <%--<div class="col-2" style="background-color: green;height: 100%;">
            <div style="padding: 10px">
                <img src="/img/user.jpg" style="width: 80px;height: 80px;border-radius: 50%;box-shadow: 2px 4px 4px;">
                <p style="color: white;font-family: 方正舒体;font-size: 20px;margin-top: 10px">欢迎用户：<%= request.getAttribute("uname").toString()%></p>
                <p style="color: white;font-family: 方正舒体;font-size: 20px;margin-top: 10px">登录时间：<%= new Date(System.currentTimeMillis())%></p>
            </div>
            <div class="container" style="margin-top: 50px">
                <ul class="list-group">
                    <li class="list-group-item">
                        <a href="goods" target="data-content" style="font-family: 方正舒体;font-size: 25px;color: darkgreen;text-decoration: none;margin: auto auto">菜市场</a>
                    </li>
                    <li class="list-group-item">
                        <a href="shoppingcart" target="data-content" style="font-family: 方正舒体;font-size: 25px;color: darkgreen;text-decoration: none;margin: auto auto">菜篮</a>
                    </li>
                    <li class="list-group-item">
                        <a href="order" target="data-content" style="font-family: 方正舒体;font-size: 25px;color: darkgreen;text-decoration: none;margin: auto auto">订单管理</a>
                    </li>
                    <li class="list-group-item">
                        <a href="update?uname=<%= ((User)request.getSession().getAttribute("user")).getUname()%>" target="data-content" style="font-family: 方正舒体;font-size: 25px;color: darkgreen;text-decoration: none;margin: auto auto">修改个人信息</a>
                    </li>
                </ul>
            </div>
        </div>
        <div class="store-style col-10">
            <div style="height: 100px;text-align: center;line-height: 100px;border: 1px solid green;">
                <h1 style="color: darkgreen;font-family: 方正舒体;font-size: 50px">WELCOME TO 绿蔬人 </h1>
            </div>
            <iframe src="welcomeuser" frameborder="0" name="data-content" id="framework"></iframe>
        </div>
        <div class="foot">
            <p>@CopyRight; CJR制作，公司：东软
                电话：15822869305</p>
        </div>--%>
        <div style="height: 100px;background-color: #ffffff;border-bottom: solid 2px green;position: fixed;top: 0;width: 100%;left: 0;z-index: 5">
            <img src="/img/logo.jpg" alt="logo" style="width: 80px;height: 80px;position: fixed;top: 10px;left: 150px;border-radius: 50%;box-shadow: 2px 4px 4px;z-index: 2">
            <a href="/logout" style="text-decoration: none;color: green;position: fixed;top: 0px;right: 25px;z-index: 2"><div style="position:absolute;right: 0px;top:10px;width: 50px;"><i class="fa fa-times"></i>退出</div></a>
            <div style="height: 100px;text-align: center;line-height: 100px;position: fixed;top: 20px;left: 250px;display: flex">
                <h1 style="color: darkgreen;font-family: 方正舒体;font-size: 40px">WELCOME TO 绿蔬人 </h1>
            </div>
            <form action="">
                <div class="input-group mb-3" style="position: fixed;top: 30px;right: 400px;width: 300px">
                    <input type="search" class="form-control" placeholder="search">
                </div>
            </form>
        </div>
        <div style="height: 800px;display: flex;position: relative;top: 100px;background-color: #f0f0f4">
            <div style="width: 100%;height: 40px;background-color: #f9f9f9;padding: 0px;margin: 0;box-shadow:1px 2px 2px;display: flex;justify-content: space-around">
                <a class="nav-link disabled" href="goods" target="data-content" style="font-family:楷体;font-size: 20px;color: #222;">菜市场</a>
                <a class="nav-link disabled" href="shoppingcart" target="data-content" style="font-family:楷体;font-size: 20px;color: #222;">菜篮</a>
                <a class="nav-link disabled" href="order" target="data-content" style="font-family: 楷体;font-size: 20px;color: #222;">订单管理</a>
                <a class="nav-link disabled" href="update?uname=<%= ((User)request.getSession().getAttribute("user")).getUname()%>" target="data-content" style="font-family: 楷体;font-size: 20px;color: #222;">修改个人信息</a>
            </div>
            <iframe src="welcomeuser" frameborder="0" name="data-content" id="framework" style="width: 1000px;height:750px;position: absolute;left: 250px;top: 42px;background-color: #f0f0f4"></iframe>
        </div>
        <div style="height: 80px;width:100%;background-color: green;position: absolute;top:900px">
                <p style="color: white;margin: 0 auto;position: absolute;left: 620px;top: 15px">@CopyRight; STEVEN-KAM</p>
            <p style="color: white;margin: 0 auto;position: absolute;left: 580px;top: 40px">公司：DreamTimes&nbsp;&nbsp;&nbsp;&nbsp;
                    电话：15822869305</p>
        </div>
</body>
</html>
