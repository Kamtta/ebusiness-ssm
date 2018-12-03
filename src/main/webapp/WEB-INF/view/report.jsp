<%--
  Created by IntelliJ IDEA.
  User: cjr
  Date: 2018/11/21 0021
  Time: 20:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Report</title>
    <link rel="shortcut icon" type="/image/x-icon" href="../../favicon.ico" media="screen" />
    <link type="text/css" rel="stylesheet" href="/css/bootstrap.css"/>
    <link rel="stylesheet" href="/css/font-awesome.css">
    <link rel="stylesheet" href="/css/style.css">
    <script type="text/javascript" language="JavaScript" src="/js/jquery-3.3.1.min.js"></script>
    <script type="text/javascript" src="/js/bootstrap.js"></script>
    <script type="text/javascript" src="/js/echarts.js"></script>
</head>
<body>
<div id="echart" style="height: 300px;width: 400px;float: left;margin-right: 100px;margin-top: 100px"></div>
<div id="grepertory" style="height: 300px;width: 400px;margin-top: 100px;float: left"></div>
<script type="text/javascript">
    // 基于准备好的dom，初始化echarts实例
    var myChart = echarts.init(document.getElementById('echart'));
    var myChart2 = echarts.init(document.getElementById('grepertory'));
    // 指定图表的配置项和数据
    var option = {
        backgroundColor: '#2c343c',

        title: {
            text: '销售量',
            left: 'center',
            top: 20,
            textStyle: {
                color: '#ccc'
            }
        },

        tooltip : {
            trigger: 'item',
            formatter: "{a} <br/>{b} : {c} ({d}%)"
        },

        visualMap: {
            show: false,
            min: 80,
            max: 600,
            inRange: {
                colorLightness: [0, 1]
            }
        },
        series : [
            {
                name:'商品名',
                type:'pie',
                radius : '55%',
                center: ['50%', '50%'],
                data:[].sort(function (a, b) { return a.value - b.value; }),
                roseType: 'radius',
                label: {
                    normal: {
                        textStyle: {
                            color: 'rgba(255, 255, 255, 0.3)'
                        }
                    }
                },
                labelLine: {
                    normal: {
                        lineStyle: {
                            color: 'rgba(255, 255, 255, 0.3)'
                        },
                        smooth: 0.2,
                        length: 10,
                        length2: 20
                    }
                },

                itemStyle: {
                    normal: {
                        color: '#8B0000',
                        shadowBlur: 200,
                        shadowColor: 'rgba(0, 0, 0, 0.5)'
                    }
                },
                animationType: 'scale',
                animationEasing: 'elasticOut',
                animationDelay: function (idx) {
                    return Math.random() * 200;
                }
            }
        ]
    };

    var option2 = {
        title: {
            text: '货存'
        },
        tooltip: {},
        legend: {
            data:['存量']
        },
        xAxis: {
            data: []
        },
        yAxis: {},
        series: [{
            name: '存量',
            type: 'bar',
            data: []
        }]
    };

    // 使用刚指定的配置项和数据显示图表。
    myChart.setOption(option);
    myChart2.setOption(option2);
    var gname = [];
    var grepertory = [];
    var mapper = [];
    $.ajax({
        url:"listshow",
        dataType:"json",
        success:function (result) {
            $(result).each(function () {
                gname.push(this.gname)
                grepertory.push(this.grepertory)
                mapper.push({
                    value:this.gsalevolume,
                    name:this.gname
                });
            })
            myChart.setOption({
                series : [
                    {
                        data: mapper.sort(function (a, b) {
                            return a.value - b.value;
                        }),

                    }
                ]
            });
            myChart2.setOption({
                xAxis: {
                    data: gname
                },
                series: [{
                    // 根据名字对应到相应的系列
                    data: grepertory
                }]
            });
        }
    })

</script>
</body>
</html>
