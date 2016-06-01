<%@ page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
	<script type="text/javascript">
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

	<div class="logo container">
		<a href="/">
			<img src="../fqblack/images/logo.png"  width="487" height="97" alt="黑名单logo">
		</a> 
	</div>

	<!-- search start -->
	<form id="searchForm" method="get" action="index/index.html">
		<div class="search_box  container">
	  		<div class="input-group">
		    		<input type="text" class="form-control" id="keyword" name="blackQuery.keyword" value="<s:property value='blackQuery.keyword'/>" />
		    		<input type="hidden" id="pageNo" name="blackQuery.pageNo" value="<s:property value='blackQuery.pageNo'/>"/>
					<input type="hidden" id="pageTotal" name="blackQuery.pageTotal" value="<s:property value='blackQuery.pageTotal'/>"/>
		    		<input type="hidden" id="mark" value="1" name="blackQuery.type"  />
		    		<div class="input-group-btn">
			      		<button type="button" class="name_btn btn btn-default dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false" id="type">姓名<span class="caret"></span></button>
			      		<ul class="dropdown-menu dropdown-menu-right" style="left:-3px;">
			        		<li><a href="javascript:chgeType('1', '姓名');">姓名</a></li>
			        		<li><a href="javascript:chgeType('2', '身份证');">身份证</a></li>
			        		<!--  
			        		<li><a href="javascript:chgeType('3', '平台');">平台</a></li>
			        		-->
			      		</ul>
			      		<button class="search_btn  btn btn-default" type="button" onclick="queryBlack(1)">搜索</button>
			    	</div>
		    	<!-- /btn-group --> 
	  		</div>
	  		<!-- /input-group --> 
		</div>
	</form>
	