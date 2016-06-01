<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<div class="topbox">
	<div class="container">
		<div class="contactway">
			<span class="phone">010-56226133</span> <span class="online">2997544439</span>
		</div>
		<div class="divlogin">
			<s:if test="getCurrentUser() == null">
				<a class="login" href="login/login.html">登录</a> 
				<a class="login" href="login/regist.html">注册</a> 
			</s:if>
			<s:elseif test="getCurrentUser() != null">
				您好！<s:property value="getCurrentUser().userName" />
				<a href="javascript: logout();" >退出</a>
				<a href="black/manage.html" >管理黑名单</a>
			</s:elseif>
		</div>
	</div>
</div>