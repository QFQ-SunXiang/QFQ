<%@ page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
	<%@include file="../common/head.jsp"%>
	<title>分期信用黑名单-注册</title>
</head>
<body>
<!--top -->
	<%@include file="../common/top.jsp"%>
	<div class="clearfix"></div>
	<div class="leftlogo container">
		<a href="/">
			<img src="../fqblack/images/logo.png"  width="487" height="97" />
		</a>
	</div>

<!--conent -->
	<div class="container ">
  		<div class="row">
    		<div class="leftnav col-md-4">
    			<a class="signlogin" href="login/login.html">登录</a>
    			<a class="signlogin" href="login/regist.html">注册</a>
    			<!--  
    			<a class="signlogin active" href="login/findpwd.html">找回密码</a> 
    			-->
    		</div>
    		<!--right start-->
    		<div class="rightcont col-md-8">
      			<div class="login_title col-md-8">
        			<p class="rleftword">手机号：</p>
        			<input id="txt_usname" class="ruse_name" type="text" name="txt_usname" placeholder="注册账号时填写的手机号" />
        			<div class="clear"> </div>
      			</div>
      			<div class="login_title col-md-8">
	        		<p class="rleftword">图片验证码：</p>
	        		<input id="txt_usname" class="denglu_shuruk" type="text" name="txt_usname" />
	        		<img />
	        		<div class="clear"> </div>
	      		</div>
	      		<div class="login_title col-md-8">
	        		<p class="rleftword">短信验证码：</p>
	        		<input id="txt_usname" class="denglu_shuruk" type="text" name="txt_usname" />
	        		<div class="clear"> </div>
	      		</div>
	      		<div class="login_title col-md-8">
	        		<p class="rleftword">新密码：</p>
	        		<input id="txt_usname" class="denglu_shuruk" type="text" name="txt_usname" placeholder="请输入新密码" />
	        		<div class="clear"> </div>
	      		</div>
	      		<div class="login_title col-md-8">
	        		<p class="rleftword">确认密码：</p>
	        		<input id="txt_usname" class="denglu_shuruk" type="text" name="txt_usname" placeholder="请再次输入密码" />
	        		<div class="clear"> </div>
	      		</div>
	      		<div class="loginbtn">
	        		<input id="sign" class="password_button" type="button"  value="提交保存" name="sign" />
	      		</div>
	    	</div>
    		<!--right end--> 
  		</div>
	</div>
	<!--footer -->
	<%@include file="../common/foot.jsp"%>
</body>
</html>