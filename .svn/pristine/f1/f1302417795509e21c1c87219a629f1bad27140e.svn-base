<%@ page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
	<%@include file="../common/head.jsp"%>
	<title>分期信用黑名单-注册</title>
	<script type="text/javascript">
		$(document).ready(function(){
			$("#userName").focus();
		});
		
		/** 登录验证 */
		function validLogin() {
			var userName = $.trim($("#userName").val());
			var password = $.trim($("#password").val());
			if(userName.length == 0){
				showMsg("手机号不能为空!");
				userName.focus();
				return false;
			}
			if(password.length == 0){
				showMsg("密码不能为空!");
				password.focus();
				return false;
			}
			return true;
		}
		
		function login(){
			hideMsg();
			if(validLogin()){
				$.post("<%=basePath%>login/login!userLogin.do", {
					"userQuery.userName" : $.trim($("#userName").val()),
					"userQuery.password" : $.md5($.trim($("#password").val()))
				}, function(data) {
					if (data.result == "FAILURE") {
						$("#errInfo").html(data.message).show(); 
					} else {
						window.location.href = "<%=basePath%>black/manage.html";
					}
				}, "json");
			}
		}
		
		// 隐藏错误信息
		function hideMsg(){
			$("#msg").html("");
			$("#error_msg").hide();
		}
		
		// 显示错误信息
		function showMsg(msg){
			$("#msg").html(msg);
			$("#error_msg").show();
		}
		
		/** Enter键提交 */
		$(document).keyup(function(event){
			var currKey = 0, e = e || event;
			if (e.keyCode == 13) {
				login();
			}
		});
	</script>
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
    			<a class="signlogin active" href="login/login.html">登录</a>
    			<a class="signlogin" href="login/regist.html">注册</a>
    			<!--  
    			<a class="signlogin" href="login/findpwd.html">找回密码</a> 
    			-->
    		</div>
    		<!--right start-->
    		<div class="rightcont col-md-8">
    			<div class="login_title col-md-8" id="error_msg" style=" display: none; padding-bottom: 0px;">
	        		<p class="rleftword">&nbsp;</p><div id="msg" style="color: red;"></div>
	      		</div>
      			<div class="login_title col-md-8">
        			<p class="rleftword">手机号：</p>
        			<input id="userName" class="denglu_shuruk" type="text" name="userQuery.userName" placeholder="请输入注册使用的手机号" />
        			<a class="color_3" target="_parent" href="login/regist.html">&nbsp;还不是会员？免费注册</a>
        			<div class="clear"> </div>
      			</div>
      			<div class="login_title col-md-8">
        			<p class="rleftword">密码：</p>
        			<input id="password" class="denglu_shuruk" type="password" name="txt_usname" placeholder="请输入密码" />
        			<a class="color_3" target="_parent" href="login/findpwd.html">&nbsp;忘记密码？</a>
        			<div class="clear"> </div>
      			</div>	
      			<div class="loginbtn">
        			<input id="userlogin" class="luse_button" type="button" onclick="login()" value="登录" name="userlogin" />
      			</div>
    		</div>
    	<!--right end--> 
  		</div>
	</div>
	<!--footer -->
	<%@include file="../common/foot.jsp"%>
</body>
</html>