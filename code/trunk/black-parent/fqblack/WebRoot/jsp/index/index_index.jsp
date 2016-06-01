<%@ page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
	<%@include file="../common/head.jsp"%>
	<title>分期信用黑名单-首页</title>
	<script type="text/javascript">
		$(function (){
			// 分页处理
			$("[pageDiv]").pagination({
				pageNo: <s:property value="blackQuery.pageNo" />,
				total: <s:property value="blackQuery.total" />,
				pageSize : <s:property value="blackQuery.pageSize" />,
				callback: function(selectPage) {
					$("[name='blackQuery.pageNo']").val(selectPage);
					queryBlack();
				}
			});
		});
				
		function queryBlack(index){
			//点击查询时,将页码置为1
			if(index == 1){
				$("#pageNo").val(1);
			}
			$("#searchForm").submit();
		}
	</script>
</head>

<body>
	<%@include file="../common/top.jsp"%>
	<div class="clearfix"></div>
	<%@include file="index_search.jsp"%>
	<!-- 
	<div class="container">
  		<p class="Platclass"><b>平台分类:</b></p>
  		<p class="Platclass"> 
    		<a class="Platform" href="#">亲分期</a> 
    		<a class="Platform" href="#">趣分期</a> 
    		<a class="Platform" href="#">分期乐</a> 
    		<a class="Platform" href="#">优分期</a> 
    		<a class="Platform" href="#">仁仁分期</a> 
   		</p>
	</div>
	 -->
	<div class="clearfix"></div>
	<!-- statement start -->
	<div class="statementbox container">
	  	<p><b style="font-size:18px;">分期黑名单声明</b></p>
	  	<p class="statementword">
	  		1、如果您是信息主体人，请尽快还清欠款，然后联系发布者让其更正您的黑名单信息;<br />
	    	2、如果主体人发现信息有不属实之处，您也可以向本站"申诉"，本站在核实后会进行妥善处理，并追究提供虚假信息者的法律责任；<br />
	    	3、包括个人、非商业机构组织和商业机构组织在内的任何第三方非经本站单独授权均不得转载本站网贷信用黑名单内容，否则任何转载行为都将被视为侵权行为，转载者须对自己的行为承担一切法律责任。<br />
	  	</p>
	</div>
	<!-- table start -->

	<div class="container tablebox" id="index_data">
		<table width="100%" class="tablebg">
			<tr>
		    	<td width="130"  class="tableheader" >姓名</td>
		    	<td width="180"  class="tableheader">欠款总额</td>
		    	<td width="130"  class="tableheader" >总罚息</td>
		    	<td width="160"  class="tableheader">逾期笔数</td>
		    	<td width="110"  class="tableheader">状态</td>
		    	<td width="230" class="tableheader">身份证号</td>
		    	<td width="130" class="tableheader">平台</td>
		    	<td width="130" class="tableheader">详情</td>
			</tr>
			<s:if test="blackList.size() > 0">
				<s:iterator value="blackList" id="black">
				   <tr>
				    <td width="130"  class="tableconet" ><s:property value="#black.trueName"/></td>
				    <td width="180"  class="tableconet">￥<s:property value="%{formatDouble(#black.totalArrears)}"/></td>
				    <td width="130"  class="tableconet" >无 </td>
				    <td width="160"  class="tableconet"><s:property value="#black.lateTimes"/>笔</td>
				    <td width="110"  class="tableconet">
				    	<s:if test="#black.status == 1">逾期</s:if>
				    	<s:if test="#black.status == 2">已还清</s:if>
				    </td>
				    <td width="230" class="tableconet"><s:property value="#black.idCard"/></td>
				    <td width="130" class="tableconet"><s:property value="#black.companyShortName"/></td>
				    <td width="130" class="tableconet"><a href="detail/<s:property value="#black.blackId"/>.html">详情</a></td>
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
		<div class="pagination" pageDiv>
		</div>
	</div>
	
	<!-- merchants start -->
	<%@include file="../common/link.jsp"%>
	<%@include file="../common/foot.jsp"%>
</body>
</html>
