<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%
  String path = request.getContextPath();
  String basePath = request.getScheme() + "://"+ request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<!DOCTYPE html>
<html>
<head>

  <title>Login</title>

  <!-- 最新版本的 Bootstrap 核心 CSS 文件 -->
  <link rel="stylesheet" href="https://cdn.bootcdn.net/ajax/libs/twitter-bootstrap/3.4.1/css/bootstrap.min.css" integrity="sha384-HSMxcRTRxnN+Bdg0JdbxYKrThecOKuH5zCYotlSAcp1+c8xmyTe9GYg1l9a69psu" crossorigin="anonymous">

  <!-- 可选的 Bootstrap 主题文件（一般不用引入） -->
  <link rel="stylesheet" href="https://cdn.bootcdn.net/ajax/libs/twitter-bootstrap/3.4.1/css/bootstrap-theme.min.css" integrity="sha384-6pzBo3FDv/PJ8r2KRkGHifhEocL+1X2rVCTTkUfGk7/0pbek5mMa1upzvWbrUbOZ" crossorigin="anonymous">

  <!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
  <script src="https://cdn.bootcdn.net/ajax/libs/twitter-bootstrap/3.4.1/js/bootstrap.min.js" integrity="sha384-aJ21OjlMXNL5UyIl/XNwTMqvzeRMZH2w8c5cRVpzpU8Y5bApTppSuUkhZXN0VxHd" crossorigin="anonymous"></script>

  <style>
    .bk {

      background-repeat: no-repeat;
      background-size: cover;
    }
    .box {

      background-color: rgba(240, 240, 240, 0.7);
      border-radius: 10px;
    }
  </style>
</head>
<body class="bk">





<div class="container" style="margin-top: 200px;">
  <div class="box">
    <form action="login" method="post" class="form-horizontal">
      <filedset>
        <legend><lable> <span class="glyphicon glyphicon-user"></span> User login </lable></legend>

        <div class="row">
          <!--栅格系统，每row行共12列，分个3div，每1,3个div占3列，第2个div则占5列，即3列+5列+4列=12列-->
          <div class="col-sm-3"><span class="glyphicon glyphicon-user"></span> 你的账号名： </div>
          <div class="col-sm-5"><input type="text" name="ID" placeholder="输入你的用户名" class="form-control" required placeholder="请输入账号">  </div>
          <div class="col-sm-4"></div>
        </div>
        <div class="row">
          <div class="col-sm-3"><span class="glyphicon glyphicon-lock"></span> 密码： </div>
          <div class="col-sm-5"><input type="password" name="PWD" placeholder="输入你的密码" class="form-control" required placeholder="请输入密码"> </div>
          <div class="col-sm-4" ></div>
        </div>

        <div class="row">
          <div class="col-sm-5 col-sm-offset-3">
            <input type="submit" value="登录" class="btn btn-xs btn-primary">
            <input type="reset" value="重置" class="btn btn-xs btn-warning">
            <a href="register.jsp" class="btn btn-xs btn-default">点我注册</a>
          </div>
        </div>

      </filedset>
    </form>
  </div>




</div>
</body>
</html>