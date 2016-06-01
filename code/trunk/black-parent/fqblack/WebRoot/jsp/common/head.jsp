<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>

	<base href="<%=basePath%>">
	<basePath value="<%=basePath%>" id="basePath"></basePath>
	<link rel="shortcut icon" href="favicon.ico" type="image/x-icon" />
	<meta name="keywords" content=""></meta>
	<meta name="description" content=""></meta>
	<meta http-equiv="Pragma" CONTENT="no-cache" />
	<meta http-equiv="Cache-Control" CONTENT="no-store, no-cache, must-revalidate" />
	<meta http-equiv="Expires" CONTENT="-1" />
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<link href="<%=basePath %>css/bootstrap.min.css" rel="stylesheet" type="text/css" />
	<link href="<%=basePath %>css/common.css" rel="stylesheet" type="text/css" />
	<link href="<%=basePath %>css/black.css" rel="stylesheet" type="text/css" />
	<script type="text/javascript" src="<%=basePath%>js/jquery-1.11.3.min.js"></script>
	<script type="text/javascript" src="<%=basePath%>js/bootstrap.min.js"></script>
	<script type="text/javascript" src="<%=basePath%>js/jquery.md5.js"></script>
	<script type="text/javascript" src="<%=basePath%>js/jquery.pagination.js"></script>
	<script type="text/javascript" src="<%=basePath%>js/layer/layer.js"></script>	
	<script type="text/javascript" src="<%=basePath%>js/jquery.timers-1.2.js" ></script>

	<script type="text/javascript">
			// 验证码
		function getValidCodeImg(id){
			var eId = "#" + id;
			var url = "<%=basePath%>login/login!getValidCodeImg.do?rand=" + new Date().getTime();
			$(eId).attr("src", url);
			//document.getElementById(id).src="<%=basePath%>login/login!getValidCodeImg.do?rand=" + new Date().getTime();
		}
		// 退出
		function logout(){
			$.post("<%=basePath%>login/login!logout.do", 
				function(data) {
					if (data.result == "SUCCESS") {
						window.location.href = "<%=basePath%>";	
					}
				}, 
			"json");
		}
		// 更换查询类型		
		function chgeType(mark, name){
			$("#type").html(name + "<span class='caret'></span>");
			$("#mark").val(mark);
		}
	</script>
