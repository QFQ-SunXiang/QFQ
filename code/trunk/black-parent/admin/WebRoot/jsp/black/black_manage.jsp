<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Frameset//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-frameset.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<style type="text/css">
		.cnt_td {padding: 7px 3px; text-align: center; line-height: 20px; vertical-align: middle;}
		.link_a{margin-right: 5px;}
		.font_b{font-weight: 800;}
	</style>
	<script type="text/javascript">
		$(function(){
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
			//点击确定触发
			$("#queryBlack").click(function(){
				queryBlackList(1);
			});
		});
		
		// 审核
		function auditPage(id){
			layer.open({
			    type: 2,
			    title: "审核黑名单",
			    shadeClose: false,
			    shade: 0.3,
			    area: ["650px", "800px"],
			    content: "black/black!auditPage.do?blackQuery.blackId=" + id
			});
		}
		
		// 关闭
		function close(){
			queryBlackList();
			layer.closeAll();
		}
		
	</script>
</head>
<body>
	<!--main-->
		<div class="rhead">
			<div class="rpos">当前位置: 黑名单管理 - 全部黑名单</div>
			<div class="clear"></div>
		</div>
		<!--  -->
		<form id="blackForm" method="post">		
			<div class="rhead">
				姓名：<input type="text" id="trueName" name="blackQuery.trueName" value="<s:property value='blackQuery.trueName'/>" style="width:100px" />&nbsp;
				&nbsp;&nbsp;&nbsp;&nbsp;<input type="button" value="查询" id="queryBlack"/>
				<input type="hidden" id="status" name="blackQuery.status"  value="<s:property value='blackQuery.status'/>"/>
				<input type="hidden" name="blackQuery.pageNo"  value="<s:property value='blackQuery.pageNo'/>"/>
				<input type="hidden" name="blackQuery.pageTotal"  value="<s:property value='blackQuery.pageTotal'/>"/>
				<div class="clear"></div>
			</div>
			<table class="pn-ltable" style="" width="100%" cellspacing="1" cellpadding="0" border="0" id="data_table">
				<thead class="pn-lthead">
					<tr>
						<th width="25">
							<input type="checkbox" />
						</th>
						<th>黑名单ID</th>
						<th>姓名</th>
						<th>性别</th>
						<th>手机号</th>
						<th>身份证号</th>
						<th>QQ号</th>
						<th>微信号</th>
						<th>公司（学校）名称</th>
						<th>欠款总金额</th>
						<th>总罚息</th>
						<th>逾期笔数</th>
						<th>逾期天数</th>
						<th>状态</th>
						<th>操作</th>
					</tr>
				</thead>
				<tbody class="pn-ltbody">
					<s:if test="blackList.size() > 0">
						<s:iterator value="blackList" id="black">
							<tr>
								<td class="cnt_td">
									<input type="checkbox" />
								</td>
								<td class="cnt_td">
									<s:property value="#black.blackId" />
								</td>
								<td class="cnt_td">
									<s:property value="#black.trueName" />
								</td>
								<td class="cnt_td">
									<s:if test="#black.sex == 1">男</s:if>
									<s:if test="#black.sex == 2">女</s:if>
									<s:if test="#black.sex == 3">未知</s:if>
								</td>
								<td class="cnt_td">
									<s:property value="#black.mobile" />
								</td>
								<td class="cnt_td">
									<s:property value="#black.idCard" />
								</td>
								<td class="cnt_td">
									<s:property value="#black.qq" />
								</td>
								<td class="cnt_td">
									<s:property value="#black.wechat" />
								</td>
								<td class="cnt_td">
									<s:property value="#black.companyName" />
								</td>
								<td class="cnt_td">
									<s:property value="#black.totalArrears" />
								</td>
								<td class="cnt_td">
									<s:property value="#black.totalPenalty" />
								</td>
								<td class="cnt_td">
									<s:property value="#black.lateTimes" />
								</td>
								<td class="cnt_td">
									<s:property value="#black.lateDays" />
								</td>
								<td class="cnt_td">
									<s:if test="#black.auditStatus == 1">未通过</s:if>
									<s:if test="#black.auditStatus == 2">通过</s:if>
								</td>
								<td class="cnt_td">
									<input type="button" value="审核" class="btn-top" onclick="auditPage(<s:property value="#black.blackId" />)"/>
								</td>
							</tr>
						</s:iterator>
					</s:if>
				</tbody>
			</table>
			<div class="pagination list_content" style="text-align: center;">
				<div pageDiv class="msdn" style="float: left;"></div>
				<div class="pagin_go" style="margin-left: 1px;">共 <s:property value="blackQuery.total" /> 条记录</div>
			</div>
		</form>
	<!--main end-->
	</body>
</html>





