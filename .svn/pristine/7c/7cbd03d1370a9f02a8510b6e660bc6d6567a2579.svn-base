<%@ page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
	<title>分期信用黑名单-详情页面</title>
	<script type="text/javascript">
		function queryBlackList(index){
			//点击查询时,将页码置为1
			if(index == 1){
				$("#pageNo").val(1);
			}
			$("#searchForm").attr("action", "index/index.html").submit();
		}
	</script>
</head>

<body>
	<div class="container">
  		<div class="leftlogo" style="float:left;">
  			<a href="/">
  				<img src="../fqblack/images/logo.png"  width="487" height="97" alt="分期信用黑名单logo" />
  			</a>
  		</div>
	  <!-- search start -->
		<form id="searchForm" method="get">
			<div class="search_box searchf" >
				<div class="input-group">
			      	<input type="text" class="form-control" id="keyword" name="blackQuery.keyword" value="<s:property value='blackQuery.keyword'/>" />
			      	<input type="hidden" id="pageNo" name="blackQuery.pageNo" value="<s:property value='blackQuery.pageNo'/>"/>
					<input type="hidden" id="pageTotal" name="blackQuery.pageTotal" value="<s:property value='blackQuery.pageTotal'/>"/>
		    		<input type="hidden" id="mark" value="1" name="blackQuery.type"  />
					<input type="hidden" id="userId" name="blackQuery.platform" value="<s:property value="getCurrentUser().userId" />"/>
					<input type="hidden" id="status" name="blackQuery.auditStatus" value="0"/>
					<input type="hidden" id="isAll" name="blackQuery.isAll" value="2"/>
			      	<div class="input-group-btn">
			        	<button type="button" class="name_btn btn btn-default dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false" id="type">姓名<span class="caret"></span></button>
			       		<ul class="dropdown-menu dropdown-menu-right" style="left:-3px;">
			        			<li><a href="javascript:chgeType('1', '姓名');">姓名</a></li>
			        		<li><a href="javascript:chgeType('2', '身份证');">身份证</a></li>
			        		<!--  
			        			<li><a href="javascript:chgeType('3', '平台');">平台</a></li>
			        		-->
			       		</ul>
						<button class="search_btn  btn btn-default" type="button" onclick="queryBlackList(1)">搜索</button>
			      	</div>
			      <!-- /btn-group --> 
			    </div>
		    	<!-- /input-group --> 
		  	</div>
		</form>
	</div>
	