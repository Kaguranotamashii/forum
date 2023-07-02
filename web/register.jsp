<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <link rel='stylesheet' type='text/css' href='css/code.css' />
  <link rel="stylesheet" href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="http://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.min.js"></script>
  <script src="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  <title>注册</title>
  <style type="text/css">

    .bk {
      background-image: url(http://mpic.tiankong.com/561/5d6/5615d6afeeaf9e8f4bef8367f0984a39/4251r-2786.jpg);
      background-repeat: no-repeat;
      background-size: 140% 140%;
    }
  </style>

  <script>
    var code;
    function createCode(){
      code="";
      var codeLength=5;
      var checkCode=document.getElementById("checkCode");
      var codeChars=new Array(0, 1, 2, 3, 4, 5, 6, 7, 8, 9,
              'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z',
              'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z');
      for(var i=0;i<codeLength;i++)
      {
        var charNum=Math.floor(Math.random()*62);
        code+=codeChars[charNum];
      }
      if(checkCode){
        checkCode.className="code";
        checkCode.innerHTML=code;
      }
    }


    function showHead(ico){
      document.images['head'].src="images/face/user/"+ico;
    }

    function isUserId(str){
      var userid=/^([0-9])+/;
      return userid.test(str);
    }

    function isEmail(str){
      var email=/^([a-zA-Z0-9_-])+@([a-zA-Z0-9_-]{2,3})+\.([a-zA-Z0-9_-]{2,3})+/;
      return email.test(str);
    }

    function isPhone(str){
      var phone=/^([0-9])+/;
      return phone.test(str);
    }

    function check_login(form1){
      var user_id=document.getElementById("userid").value
      var user_name=document.getElementById("username").value;
      var user_password=document.getElementById("userpassword").value;
      var confirmPwd=document.getElementById("confirmPwd").value;


      //var user_password=document.forms.form1.user_password.value;
      //var confirmPwd=document.forms.form1.confirmPwd.value;
      var inputCode=document.forms.form1.inputCode.value;

      //if(document.forms.form1.user_id.value==""){
      //	alert("学号不能为空!");
      //	document.forms.form1.user_id.focus();
      //	return false;
      //}



      if(user_name==""){
        alert("请输入用户名!");
        document.getElementById("username").focus();
        return false;
      }

      if(user_password==""){
        alert("请输入密码!");
        document.forms.form1.user_password.focus();
        return false;
      }

      if(confirmPwd==""){
        alert("请确认密码!");
        document.forms.form1.confirmPwd.focus();
        return false;
      }

      if(user_password!=confirmPwd){
        alert("两次密码不一致!请重新输入!");
        return false;
      }



      if(!isEmail(document.getElementById("email").value)){
        alert("邮箱格式不正确!");
        document.getElementById("email").focus();
        return false;
      }



      if(inputCode==""){
        alert("请输入验证码!");
        document.forms.form1.inputCode.focus();
        return false;
      }

      if(inputCode.toUpperCase()!=code.toUpperCase()){
        alert("验证码有误!");
        createCode();
        document.forms.form1.inputCode.focus();
        return false;
      }else{
        return true;
      }

    }

  </script>

</head>

<body onload="createCode()" class="bk">

<div class="container">
  <nav class="navbar " role="navigation">
    <h3>用户注册</h3>
    <form class="form-horizontal" name="form1" method="post" action="reg" onsubmit="return check_login()">


      <div class="form-group">
        <label class="col-sm-2 control-label">用户名:</label>
        <div class="col-sm-4">
          <input class="form-control"  name="user_name" id="username" type="text"  placeholder="请输入用户名...">
        </div>
      </div>

      <div class="form-group">
        <label class="col-sm-2 control-label">密 码:</label>
        <div class="col-sm-4">
          <input  name="user_password" type="password" id="userpassword" class="form-control"  placeholder="请输入密码">
        </div>
      </div>

      <div class="form-group">
        <label class="col-sm-2 control-label">确认密 码:</label>
        <div class="col-sm-4">
          <input  name="confirmPwd" type="password" id="confirmPwd" class="form-control"  placeholder="请确认密码">
          <input type="hidden" name="pwd">
        </div>
      </div>



      <div class="form-group">
        <label class="col-sm-2 control-label">电子邮箱:</label>
        <div class="col-sm-4">
          <input id="email" name="user_email" class="form-control" type="text" maxlength=20 placeholder="请输入邮箱...">
        </div>
      </div>



      <div class="form-group">
        <label class="col-sm-2  control-label">输入验证码:</label>
        <div class="col-sm-4">
          <input type="text" id="inputCode" class="form-control">
        </div>
      </div>

      <table class="table">
        <tr>
          <td>
            <div class="form-group">
              <label class="col-sm-2 control-label"></label>
              <div class="col-sm-5">
                <div class="code" id="checkCode" onclick="createCode()"></div>
                <a href="#" onclick="createCode()">看不清换一张</a>

              </div>
            </div></td></tr>
      </table>




      <div class="form-group">
        <label class="col-sm-2 control-label"></label>
        <div class="col-sm-4">
          <button type="submit" class="btn btn-primary" >注册</button>
          <button type="reset" class="btn btn-primary">重置</button>
          <button type="button" class="btn btn-primary" onclick="location.href='TouristHome'">返回</button>
        </div>
      </div>

    </form></nav></div>

</body>
<script type="text/javascript" src="js/md5.js"></script>
</html>