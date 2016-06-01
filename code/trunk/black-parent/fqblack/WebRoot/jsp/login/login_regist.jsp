<%@ page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
	<%@include file="../common/head.jsp"%>
	<title>分期信用黑名单-注册</title>
	<script type="text/javascript">
		$(function(){
			getValidCodeImg("validCodeImg");
			$("#validCodeStatus").val("1");
		});
		function regist(){
			if(validate()){
				$.post("<%=basePath%>login/login!userRegist.do", {
					"userQuery.userName" : $.trim($("#userName").val()),
					"userQuery.password" : $.md5($.trim($("#password").val())),
					"userQuery.companyName" : $.trim($("#companyName").val()),
					"userQuery.companyShortName" : $.trim($("#companyShortName").val()),
					"userQuery.companyLicNum" : $.trim($("#companyLicNum").val()),
					"timestamp" : new Date().getTime()
				}, function(data) {
					if (data.result == "FAILURE") {
						showMsg(data.message);
					} else {
						window.location.href = "<%=basePath%>index/index.html";
					}
				}, "json");
			}
		}
		function validate(){
				
			// 验证用户名
			var b = checkUserName();
			if(b){
				var registStatus = $.trim($("#registStatus").val());
				if(registStatus == 1){
					showMsg("手机号码已经注册过，请更换手机号再进行注册!");
					b = false;
				} else {
					b = true;
				}
			}
			// 验证密码
			if(b){
				b = checkPassword();
			}
			// 验证确认密码
			if(b){
				b = checkConfirmPass();
			}
			// 验证公司名称
			if(b){
				b = checkCompanyName();
			}
			// 验证公司简称
			if(b){
				b = checkCompanyShortName();
			}
			// 验证公司简称
			if(b){
				b = checkCompanyLicNum();
			}
			// 验证图片验证码
			if(b){
				b = checkImgCode();
				if(b){
					var validCodeStatus = $.trim($("#validCodeStatus").val());
					if(validCodeStatus == 1){
						showMsg("输入图片验证码验证不通过!");
						b = false;
					} else {
						b = true;
					}
				}
			}
			return b;
		}
		
		// 公司名称
		function checkCompanyName(){
			var companyName = $.trim($("#companyName").val());
			if(companyName.length == 0){
				showMsg("公司名称不能为空!");
				return false;
			}
			hideMsg();
			return true;
		}
		
		// 公司简称
		function checkCompanyShortName(){
			var companyShortName = $.trim($("#companyShortName").val());
			if(companyShortName.length == 0){
				showMsg("公司简称不能为空!");
				return false;
			}
			hideMsg();
			return true;
		}
		
		// 公司简称
		function checkCompanyLicNum(){
			var companyLicNum = $.trim($("#companyLicNum").val());
			if(companyLicNum.length == 0){
				showMsg("营业执照号不能为空!");
				return false;
			}
			hideMsg();
			return true;
		}
		
		
		
		//校验手机号是否已经注册
		function checkMobileRegist(){
			var userName = $.trim($("#userName").val());
			if(checkUserName()){
				$.post("<%=basePath%>login/login!checkMobileRegist.do", {
					"userQuery.userName" : userName,
					"timestamp" : new Date().getTime()
				}, function(data) {
					if (data.result == "FAILURE") {
						showMsg("手机号码已经注册过，请更换手机号再进行注册!");
					} else {
						hideMsg();
						$("#registStatus").val(2);
					}
				}, "json");
			}
		}
		
		
		function checkUserName(){
			var userName = $.trim($("#userName").val());
			if(userName.length == 0){
				showMsg("手机号不能为空!");
				return false;
			}
			if(userName.length > 11 || userName.length < 11){
				showMsg("手机号码位数不正确!");
				return false;
			}
			if(isNaN(userName)){
				showMsg("手机号码必须为数字!");
				return false;
			}
			if(!userName.match(/^((1[3,5,8][0-9])|(14[5,7])|(17[0,6,7,8]))\d{8}$/)){
				showMsg("手机号码不合法!");
				return false;
			}
			return true;
		}
		
		function checkImgCode(){
			var validCode = $.trim($("#validCode").val());
			if(validCode.length == 0){
				showMsg("输入图片验证码不能为空!");
				return;
			}
			if(validCode.length < 4 || validCode.length > 4){
				showMsg("输入图片验证码位数不正确!");
				return false;
			}
			return true;
		}
		
		//验证输入的图片验证码是否正确
		function checkValidateCode(){
			var validCode = $.trim($("#validCode").val());
			if(checkImgCode()){
				$.post("<%=basePath%>login/login!checkValidateCode.do", {
					"userQuery.validateCode" : validCode,
					"timestamp" : new Date().getTime()
				}, function(data) {
					if(data.code == "-1"){
						showMsg("输入图片验证码为空!");
						return;
					} else if (data.code == "-2") {
						showMsg("输入验证码输入不正确!");
						return;
					} else {
						hideMsg();
						$("#validCodeStatus").val("2");
					}
				}, "json");
			}
		}
		// 验证密码
		function checkPassword(){
			var password = $.trim($("#password").val());
			if(password.length == 0){
				showMsg("密码不能为空!");
				return false;
			}
			if(password.length < 8){
				showMsg("密码长度不能小于8位!");
				return false;
			}
			if(isNaN(password) == false){
				showMsg("密码必须包含字母与数字!");
				return false;
			}
			hideMsg();
			return true;
		}
		
		// 验证确认密码
		function checkConfirmPass(){
			var password = $.trim($("#password").val());
			var confirmPass = $.trim($("#confirmPass").val());
			if(confirmPass.length == 0){
				showMsg("确认密码不能为空!");
				return false;
			}
			if(confirmPass.length < 8){
				showMsg("密码长度不能小于8位!");
				return false;
			}
			if(password != confirmPass){
				showMsg("两次密码输入不一致!");
				return false;
			}
			hideMsg();
			return true;
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
		
	</script>
</head>
<body>
<!--top -->
	<%@include file="../common/top.jsp"%>
	<div class="clearfix"></div>
	<div class="leftlogo container">
		<a href="/">
			<img src="../fqblack/images/logo.png" width="487" height="97" />
		</a>
	</div>

<!--conent -->
	<div class="container ">
  		<div class="row">
    		<div class="leftnav col-md-4">
    			<a class="signlogin" href="login/login.html">登录</a>
    			<a class="signlogin active" href="login/regist.html">注册</a>
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
	        		<input id="userName" class="ruse_name" type="text" name="userQuery.username" label="手机号" placeholder="请输入正确的手机号"  onblur="checkMobileRegist()"/>
	        		<input id="registStatus" name="registStatus" value="1" type="hidden" />
	        		<a class="color_3" target="_parent" href="login/login.html">&nbsp;我已经注册，现在就登录</a>
	        		<div class="clear"></div>
	      		</div>
	      		<div class="login_title col-md-8">
	        		<p class="rleftword">密码：</p>
	        		<input id="password" class="denglu_shuruk" type="password" name="userQuery.password" placeholder="请输入密码，（6-20）位数字与字母"  onblur="checkPassword()" />
	        		<a class="color_3" target="_parent" href="login/findpwd.html">&nbsp;忘记密码？</a>
	        		<div class="clear"> </div>
	      		</div>
	      		<div class="login_title col-md-8">
	        		<p class="rleftword">确认密码：</p>
	        		<input id="confirmPass" class="denglu_shuruk" type="password" name="userQuery.confirmPass" placeholder="请再次输入密码" onblur="checkConfirmPass()"/>
	        		<div class="clear"></div>
	      		</div>
	      		<div class="login_title col-md-8">
	        		<p class="rleftword">公司名称：</p>
	        		<input id="companyName" class="denglu_shuruk" type="text" name="userQuery.companyName" placeholder="请填写正确的公司名称" onblur="checkCompanyName()"/>
	        		<div class="clear"> </div>
	      		</div>
	      		<div class="login_title col-md-8">
	        		<p class="rleftword">公司简称：</p>
	        		<input id="companyShortName" class="denglu_shuruk" type="text" name="userQuery.companyShortName" placeholder="请填写公司简称" onblur="checkCompanyShortName()" />
	        		<div class="clear"></div>
	      		</div>
	      		<div class="login_title col-md-8">
	        		<p class="rleftword">营业执照号：</p>
	        		<input id="companyLicNum" class="denglu_shuruk" type="text" name="userQuery.companyLicNum"  placeholder="请填写正确的营业执照号"  onblur="checkCompanyLicNum()"/>
	        		<div class="clear"></div>
	      		</div>
	      		<div class="login_title col-md-8">
	        		<p class="rleftword">验证码：</p>
	        		<input id="validCode" class="denglu_shuruk" type="text" name="userQuery.validCode" placeholder="输入图片验证码" style="width: 100px;" onblur="checkValidateCode()"/>
	        		<input id="validCodeStatus" name="validCodeStatus" value="1" type="hidden" />
	        		<a id="imageCode" href="javascript:;" onclick="getValidCodeImg('validCodeImg')">
        				<img id="validCodeImg" style="margin-top: -5px; margin-left: 10px;" width="100" height="35" alt="验证码" />
        			</a>
	        		<a id="imageCode" href="javascript:;" onclick="getValidCodeImg('validCodeImg')">
	        			看不清楚，刷新一下
                   	</a>
	        		<div class="clear"></div>
	      		</div>
		      	<div class="loginbtn">
		        	<input onclick="regist()" class="register_button" type="button"  value="立即注册" name="sign" />
		      	</div>
			</div>
    	<!--right end--> 
  		</div>
	</div>
	<!--footer -->
	<%@include file="../common/foot.jsp"%>
</body>
</html>