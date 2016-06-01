<%@ page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
	<%@include file="../common/head.jsp"%>
	<title>分期信用黑名单-详情页面</title>
	<script type="text/javascript">
		$(function (){
			// 分页处理
			$("[pageDiv]").pagination({
				pageNo: <s:property value="blackQuery.pageNo" />,
				total: <s:property value="blackQuery.total" />,
				pageSize : <s:property value="blackQuery.pageSize" />,
				callback: function(selectPage) {
					$("[name='blackQuery.pageNo']").val(selectPage);
					queryBlackList();
				}
			});
			init();
			initStatus();
			
		});
		function initStatus(){
			var s = '<s:property value="blackQuery.auditStatus"/>';
			$("[nav]").each(function(){
				if($(this).attr("status") == s){
					$(this).addClass("active");
				} else {
					$(this).removeClass("active");
				}
			});
		}
		
		function init(){
			var c = '<s:property value="countStr"/>';
			var a = c.split(",");
			var all = 0;
			for(var i = 0; i < a.length; i++){
				var r = a[i].split("-");
				var id = "#status_" + r[0];
				$(id).html("（" + r[1] + "）");
				all += parseInt(r[1]);
			}
			$("#status_all").html("（" + all + "）");
		}
		
		// 根据状态查询黑名单
		function query(index, status){
			if(index == 1){
				$("#pageNo").val(1);
			}
			if(status != null && status > 0){
				$("#status").val(status);
			}
			$("#searchForm").attr("action", "black/manage.html").submit();
		}
		
		// 删除黑名单
		function deleteBlack(id){
			layer.confirm("确认删除黑名单吗?", function(){
				$.post("black/black!deleteBlack.do", {
					"blackQuery.blackId" : id,
					"timestamp" : new Date().getTime() 
					}, function(data) {
						if (data.result == "FAILURE") {
							layer.alert("删除黑名单失败!");
						} else {
							query();
						}
					}, "json");
			});
		}
		
		// 关闭黑名单
		function closeBlack(id){
			layer.confirm("确认关闭黑名单吗?", function(){
				$.post("black/black!closeBlack.do", {
					"blackQuery.blackId" : id,
					"timestamp" : new Date().getTime() 
					}, function(data) {
						if (data.result == "FAILURE") {
							layer.alert("关闭黑名单失败!");
						} else {
							query();
						}
					}, "json");
			});
		}
		
		// 发布黑名单
		function publishBlack(id){
			layer.confirm("确认发布黑名单吗?", function(){
				$.post("black/black!publishBlack.do", {
					"blackQuery.blackId" : id,
					"timestamp" : new Date().getTime() 
					}, function(data) {
						if (data.result == "FAILURE") {
							layer.alert("发布黑名单失败!");
						} else {
							query();
						}
					}, "json");
			});
		}
	</script>
</head>

<body>
	<%@include file="../common/top.jsp"%>
	<div class="clearfix"></div>
	<%@include file="black_search.jsp"%>
	<div class="clearfix"></div>
	<!-- handle line start -->
	<div class="container handlebox">
		<div style="float:left">
			<a nav href="javascript:query('1', '0')" status="0">全部<span id="status_all" style="color: red;">(0)</span></a> |
			<a nav href="javascript:query('1', '1')" status="1">已发布<span id="status_1" style="color: red;">(0)</span></a> |
			<a nav href="javascript:query('1', '2')" status="2">已关闭<span id="status_2" style="color: red;">(0)</span></a> | 
			<a nav href="javascript:query('1', '3')" status="3">待审核<span id="status_3" style="color: red;">(0)</span></a> |
			<a nav href="javascript:query('1', '4')" status="4">审核未通过<span id="status_4" style="color: red;">(0)</span></a>
		</div>
		<div class="redbtnbox">
			<s:if test="getCurrentUser().auditStatus == 2">
			<a style="color:#ef3936;" href="black/savePage.html">发布黑名单</a>
			</s:if>
		</div>
	</div> 
<!-- table start -->
	<div class=" container" id="index_data">
	  	<table width="100%">
		    <tr>
		    	<td width="130" class="tableheader tablefcol">姓名</td>
		      	<td width="230" class="tableheader tablefcol">身份证号</td>
		      	<td width="100" class="tableheader tablefcol">欠款总额</td>
		      	<td width="110" class="tableheader tablefcol">逾期笔数</td>
		      	<td width="110" class="tableheader tablefcol">状态</td>
		      	<td width="140" class="tableheader tablefcol">发布时间</td>
		      	<td width="140" class="tableheader tablefcol">更新时间</td>
		      	<td width="240" class="tableheader tablefcol">操作</td>
		    </tr>
		    <s:if test="blackList.size() > 0">
				<s:iterator value="blackList" id="black">
				    <tr>
				      	<td width="130" style="background:#fff;" class="tableconet"><s:property value="#black.trueName"/></td>
				      	<td width="230" style="background:#fff;" class="tableconet"><s:property value="#black.idCard"/></td>
				      	<td width="100" style="background:#fff;" class="tableconet">￥<s:property value="%{formatDouble(#black.totalArrears)}"/></td>
				      	<td width="110" style="background:#fff;" class="tableconet"><s:property value="#black.lateTimes"/>笔</td>
				      	<td width="110" style="background:#fff;" class="tableconet">
				      		<s:if test="#black.auditStatus == 1">已发布</s:if>
				      		<s:if test="#black.auditStatus == 2">已关闭</s:if>
				      		<s:if test="#black.auditStatus == 3">待审核</s:if>
				      		<s:if test="#black.auditStatus == 4">审核未通过</s:if>
				      	</td>
				      	<td width="140" style="background:#fff;" class="tableconet"><s:date name="#black.publishTime" format="yyyy-MM-dd"/></td>
				      	<td width="140" style="background:#fff;" class="tableconet"><s:date name="#black.modifyTime" format="yyyy-MM-dd"/></td>
				      	<td width="240" style="background:#fff;" class="tableconet">
				      		<a href="detail/<s:property value="#black.blackId"/>.html" target="_blank">查看</a>
				      		<s:if test="#black.auditStatus == 2">
					      		<a href="javascript:publishBlack(<s:property value="#black.blackId"/>)">发布</a> 
				      			<a href="black/savePage.html?blackQuery.blackId=<s:property value="#black.blackId"/>">修改</a>
				      			<a href="javascript: deleteBlack(<s:property value="#black.blackId"/>)">删除</a>
				      		</s:if>
				      		<s:if test="#black.auditStatus == 1">
					      		<a href="javascript:closeBlack(<s:property value="#black.blackId"/>)">关闭</a>
				      		</s:if>
				      	</td>
				    </tr>
			   </s:iterator>
		   	</s:if>
			 <s:else>
			  	<tr>
			 		<td colspan="8">&nbsp;&nbsp;查询无结果!</td>
			 	</tr>
			 </s:else>
		</table>
		<!-- page start -->
		<div class="pagination" pageDiv></div>
	</div>
	<%@include file="../common/foot.jsp"%>
</body>
</html>
