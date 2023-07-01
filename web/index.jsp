<%--
  Created by IntelliJ IDEA.
  User: 10929
  Date: 2023/6/30
  Time: 12:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<link rel="stylesheet" href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="http://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.min.js"></script>
<script src="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <nav class="navbar navbar-inverse" role="navigation"><!-- 顶部的菜单栏 -->
    <div class="container-fluid">
      <div class="navbar-header">
        <a class="navbar-brand" href="TouristHome">动漫二次元键盘政治爱好者论坛</a>
      </div>
      <ul class="nav navbar-nav navbar-right">
        <li><a href="zhuce.jsp"><span class="glyphicon glyphicon-user"></span> 注册</a></li>
        <li><a href="login.jsp"><span class="glyphicon glyphicon-log-in"></span> 登录</a></li>
      </ul>
    </div>
  </nav>

  <div  class="container">
    <div id="myCarousel" class="carousel slide" data-ride="carousel" data-interval="4000">
      <!-- 轮播(Carousel)指标 -->
      <ol class="carousel-indicators">
        <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
        <li data-target="#myCarousel" data-slide-to="1"></li>
        <li data-target="#myCarousel" data-slide-to="2"></li>
      </ol>
      <!-- 轮播(Carousel)项目 -->
      <div class="carousel-inner" >
        <div class="item active">
          <img src="https://th.bing.com/th/id/OIP.oSTmdNyXwQRhVVjjDYPNMQAAAA?pid=ImgDet&rs=1" alt="First slide" style="width:900px;height:200px;">
        </div>
        <div class="item">
          <img src="https://th.bing.com/th/id/OIP.zw9j_cmOy5iuYpQ72yQYYAAAAA?pid=ImgDet&rs=1" alt="Second slide" style="width:900px;height:200px;">
        </div>
        <div class="item">
          <img src="https://th.bing.com/th/id/OIP.rZsb3Gbk54qAyMQ6qI1kgAAAAA?pid=ImgDet&rs=1" alt="Third slide" style="width:900px;height:200px;">
        </div>
      </div>
      <!-- 轮播(Carousel)导航 -->
      <a class="carousel-control left" href="#myCarousel"
         data-slide="prev">&lsaquo;</a>
      <a class="carousel-control right" href="#myCarousel"
         data-slide="next">&rsaquo;</a>






      <div class="panel panel-default">
        <div class="panel-body">
          <table class="table table-hover">

            <thead>
            <tr>
              <th>标题</th>
              <th>时间</th>
              <th>发帖人</th>
            </tr>
            </thead>
            <%

            %>
            <tbody>
            <tr>

              <td><a href="TouristFindReply?fid=1"> 测试 </a></td>
              <td>今天</td>
              <td><img src="https://th.bing.com/th/id/R.5c80aa95fbd3954894716d1ec12f004c?rik=flmfJ2KO%2fcItUw&riu=http%3a%2f%2fpic.ntimg.cn%2ffile%2f20180425%2f25124298_172519481324_2.jpg&ehk=lCAbTESr6UfvpTHME8gHYXlarjxwHjs8Ny4ODFRWuT4%3d&risl=&pid=ImgRaw&r=0" class="img-circle" style="width: 20px;height: 20px;">
                <a href="TouristFindUserById?uid=1"> 宋宇然</a></td>
            </tr>

            </tbody>
          </table>
        </div>
      </div>


      <div id="footer" >
        <nav class="navbar navbar-inverse navbar-staic-bottom" style="border-radius: 4px;padding-top:30px;margin-bottom:0px;height:100px;">
          <div class="navbar-inner navbar-content-center">
            <p style="color:#ffffff;"align=center>by: 前端宋宇然</p >
            <p style="color:#ffffff;"align=center>Contact information: <a href=" ">北京信息科技大学 宋宇然刘子贺田少杰小组作品</a></p >
          </div>
        </nav>
      </div>


    </div>
  </div>
  </body>
</html>
