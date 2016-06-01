<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Frameset//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-frameset.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<style type="text/css">
		.cnt_td {padding: 7px 3px; text-align: center; line-height: 20px; vertical-align: top;}
		.link_a{margin-right: 5px;}
		.font_b{font-weight: 800;}
	</style>
	<script type="text/javascript">
		$(function(){
			// 分页处理
			$("[pageDiv]").pagination({
				pageNo: <s:property value="userQuery.pageNo" />,
				total: <s:property value="userQuery.total" />,
				pageSize : <s:property value="userQuery.pageSize" />,
				callback: function(selectPage) {
					$("[name='userQuery.pageNo']").val(selectPage);
					queryUserList();
				}
			});
			//点击确定触发
			$("#queryUser").click(function(){
				queryUserList(1);
			});
		});
		
		// 关闭
		function close(){
			queryUserList();
			layer.closeAll();
		}
		
		// 删除用户
		function deleteUser(id, style){
			layer.confirm("确认是否删除用户!", function(){
				$.post("user/user!deleteUser.do", {
					"userQuery.userId" : id,
					"userQuery.userStyle" : style,
					"timestamp" : new Date().getTime() 
					}, function(data) {
						if (data.result == "FAILURE") {
							layer.alert("删除用户失败!");
						} else {
							layer.alert("删除用户成功!");
							close();
						}
					}, "json");
			});
		} 
		
		// 根据IP查询用户
		function queryUserByIp(id, ip){
			var id = "#" + id;
			$(id).val(ip);
			queryUserList(1);
		}
		
		// 审核通过
		function auditPass(id){
			layer.confirm("确认审核通过吗?", function(){
				$.post("user/user!auditPass.do", {
					"userQuery.userId" : id,
					"timestamp" : new Date().getTime() 
					}, function(data) {
						if (data.result == "FAILURE") {
							layer.alert("审核通过失败!");
						} else {
							close();
						}
					}, "json");
			});
		}
		
		// 审核不通过		
		function auditNoPass(id){
			layer.confirm("确认审核不通过吗?", function(){
				$.post("user/user!auditNoPass.do", {
					"userQuery.userId" : id,
					"timestamp" : new Date().getTime() 
					}, function(data) {
						if (data.result == "FAILURE") {
							layer.alert("审核不通过失败!");
						} else {
							close();
						}
					}, "json");
			});
		}
		
	</script>
</head>
<body>
	<!--main-->
		<div class="rhead">
			<div class="rpos">当前位置: 用户管理 - 全部用户</div>
			<div class="clear"></div>
		</div>
		<!--  -->
		<form id="userForm" method="post">		
			<div class="rhead">
				用户名：<input type="text" id="userName" name="userQuery.userName" value="<s:property value='userQuery.userName'/>" style="width:100px" />&nbsp;
				&nbsp;&nbsp;&nbsp;&nbsp;<input type="button" value="查询" id="queryUser"/>
				<input type="hidden" name="userQuery.pageNo"  value="<s:property value='userQuery.pageNo'/>"/>
				<input type="hidden" name="userQuery.pageTotal"  value="<s:property value='userQuery.pageTotal'/>"/>
				<div class="clear"></div>
			</div>
			<table class="pn-ltable" style="" width="100%" cellspacing="1" cellpadding="0" border="0" id="data_table">
				<thead class="pn-lthead">
					<tr>
						<th width="25">
							<input type="checkbox" />
						</th>
						<th>用户ID</th>
						<th>用户名</th>
						<th>公司名称</th>
						<th>公司简称</th>
						<th>营业执照号</th>
						<th>登录次数</th>
						<th>注册时间</th>
						<th>状态</th>
						<th>操作</th>
					</tr>
				</thead>
				<tbody class="pn-ltbody">
					<s:if test="userList.size() > 0">
						<s:iterator value="userList" id="user">
							<tr>
								<td class="cnt_td">
									<input type="checkbox" name="ids" value="5" />
								</td>
								<td class="cnt_td">
									<s:property value="#user.userId" />
								</td>
								<td class="cnt_td">
									<s:property value="#user.userName" />
								</td>
								<td class="cnt_td">
									<s:property value="#user.companyName" />
								</td>
								<td class="cnt_td">
									<s:property value="#user.companyShortName" />
								</td>
								<td class="cnt_td">
									<s:property value="#user.companyLicNum" />
								</td>
								<td class="cnt_td">
									<s:property value="#user.loginCount" />
								</td>
								<td class="cnt_td">
									<s:date name="#user.createTime" format="yyyy-MM-dd HH:mm:ss"/>
								</td>
								<td class="cnt_td">
									<s:if test="#user.auditStatus == 1">通过</s:if>
									<s:if test="#user.auditStatus == 2">不通过</s:if>
								</td>
								<td class="cnt_td">
									&nbsp;<input type="button" value="审核通过" onclick="auditPass('<s:property value="#user.userId"/>')" class="btn-top" />
									&nbsp;<input type="button" value="审核不通过" onclick="auditNoPass('<s:property value="#user.userId"/>')" class="btn-top" />
								</td>
							</tr>
						</s:iterator>
					</s:if>
				</tbody>
			</table>
			<div class="pagination list_content" style="text-align: center;">
				<div pageDiv class="msdn" style="float: left;"></div>
				<div class="pagin_go" style="margin-left: 1px;">共 <s:property value="userQuery.total" /> 条记录</div>
			</div>
		</form>
	<!--main end-->
	</body>
</html>





