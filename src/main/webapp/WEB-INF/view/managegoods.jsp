<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: cjr
  Date: 2018/11/2 0002
  Time: 19:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"  isELIgnored="false" %>
<html>
<head>
    <link rel="shortcut icon" type="/image/x-icon" href="../../favicon.ico" media="screen" />
    <link type="text/css" rel="stylesheet" href="/css/bootstrap.css"/>
    <link rel="stylesheet" href="/css/font-awesome.css">
    <link rel="stylesheet" href="/css/style.css">
    <script type="text/javascript" language="JavaScript" src="/js/jquery-3.3.1.min.js"></script>
    <script type="text/javascript" src="/js/popper.min.js"></script>
    <script type="text/javascript" src="/js/bootstrap.js"></script>

    <title>管理员管理商品</title>
</head>
<body>
    <div class="search-style" style="display: flex;margin: 5px;">
        <form action="searchgoods">
            <input type="text" name="search" placeholder="search"><i class="fa fa-search"></i>
            <input type="submit" value="提交">
        </form>
        <button type="button" class="btn btn-success" onclick=window.open("addgoods")>上架商品</button>
    </div>

    <table class="table back">
        <thead>
        <tr style="font-family: 方正舒体;font-size: 20px;">
            <th>商品序号</th>
            <th>商品名</th>
            <th>商品价格</th>
            <th>商品存量</th>
            <th>商品销售量</th>
            <th>商品规格</th>
            <th>商品照片</th>
            <th>商品说明</th>
            <th>商品类型</th>
            <th>操作</th>
        </tr>
        </thead>
        <tbody id="data-content">

        </tbody>
    </table>
    <input type="hidden" name="current">
    <input type="hidden" name="pageNum">
    <p style="text-align: right;position: fixed;bottom: 50px;right: 0px">
        <button type="button" class="btn btn-success" onclick="pre()">上一页</button>&nbsp&nbsp&nbsp&nbsp
        <button type="button" class="btn btn-success" onclick="next()">下一页</button>
    </p>
    <script>
        $(function () {
            fun(1)
        })
        function pre() {
            var n = $("input[name='current']").val();
            if(n == 1){
                fun(1)
            }else{
                fun(n-1)
            }
        }
        function next() {
            var n = $("input[name='current']").val();
            var pagenum = $("input[name='pageNum']").val();
            if(n == pagenum){
                fun(n);
            }else{
                fun(parseInt(n)+1)
            }
        }
        function fun(n){
            $.ajax({
                url:"goodsmanage",
                data:{"n":n},
                dataType:"json",
                success:function (result) {
                    var str = "";
                    $(result.content).each(function () {
                        str += "<tr>\n" +
                            "            <td>"+this.gid+"</td>\n" +
                            "            <td>"+this.gname+"</td>\n" +
                            "            <td>"+this.gprice+"</td>\n" +
                            "            <td>"+this.grepertory+"</td>\n" +
                            "            <td>"+this.gsalevolume+"</td>\n" +
                            "            <td>"+this.gstandard+"</td>\n" +
                            "            <td><img src='onload/"+this.gphoto+"' style=\"width:80px;height: 50px\"/></td>\n" +
                            "            <td>"+this.gremarks+"</td>\n" +
                            "            <td>"+this.tname+"</td>\n" +
                            "            <td>\n" +
                            "                <div class=\"dropdown\">\n" +
                            "                    <button type=\"button\" class=\"btn btn-success dropdown-toggle\" data-toggle=\"dropdown\">\n" +
                            "                        <i class=\"fa fa-cogs\"></i>\n" +
                            "                    </button>\n" +
                            "                    <div class=\"dropdown-menu\">\n" +
                            "                        <a class=\"dropdown-item\" href=\""+"deletegoods?gid="+this.gid+"\">下架商品</a>\n" +
                            "                        <a class=\"dropdown-item\" href=\""+"updategoods?gid="+this.gid+"\">修改商品信息</a>\n" +
                            "                    </div>\n" +
                            "                </div>\n" +
                            "            </td>\n" +
                            "        </tr>"
                    })
                    $("#data-content").html(str);
                    $("input[name='current']").val(result.currentPage)
                    $("input[name='pageNum']").val(result.pageNum)
                }
            })
        }
    </script>
</body>
</html>
