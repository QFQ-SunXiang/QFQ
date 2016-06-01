<%@ page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
	<%@include file="../common/head.jsp"%>
	<title>分期信用黑名单-详情页面</title>
	<script type="text/javascript">
		function queryBlackList(index){
			//点击查询时,将页码置为1
			if(index == 1){
				$("#pageNo").val(1);
			}
			$("#searchForm").submit();
		}
		
		// 保存用户
		function saveBlack(){
			if(validate()){
				$("#uploadForm").submit();
			}
		}
		function validate(){
			var trueName = $("#trueName");
			if(!checkNull(trueName)){
				return;
			}
			return true;
		}
		// 判断是否为空
		function checkNull(o){
			var label = o.attr("label");
			var value = o.val();
			if(value == ''){
				layer.alert(label + "不能为空!");
				o.focus();
				return;
			} else {
				return true;
			}
		}
	</script>
</head>

<body>
	<%@include file="../common/top.jsp"%>
	<div class="clearfix"></div>
	<%@include file="black_search.jsp"%>
	<div class="clearfix"></div>
	<!-- handle line start -->
	<!--conent -->
	<form id="uploadForm" method="post" enctype="multipart/form-data" action="black/saveBlack.html">
		<div class="container listable">
	 		<div class="listbox">
	  			<p class="leftside">姓   名：</p>
	  			<input class="rframe" id="trueName" type="text" name="blackQuery.trueName" label="姓名" value="<s:property value="blackQuery.trueName"/>"/>
	  			<input type="hidden" name="blackQuery.blackId" value="<s:property value="blackQuery.blackId"/>" />
	 			<div class="clearfix"></div>
	 		</div>
	 		<div class="listbox">
	  			<p class="leftside">身份证号码：</p>
	  			<input class="rframe" type="text" name="blackQuery.idCard" label="身份证号码" value="<s:property value="blackQuery.idCard"/>" />
	 			<div class="clearfix"></div>
	 		</div>
	 		<div class="listbox">
	  			<p class="leftside">性   别：</p>
	   			<p style="float:left; width:100px; text-align:left; line-height:36px; height:36px;">
	   				<label><input id="male" type="radio" name="blackQuery.sex" value="1" <s:if test="blackQuery.sex == 1"> checked="checked" </s:if>/>&nbsp;男</label>&nbsp;
	   				<label><input id="female" type="radio"  name="blackQuery.sex" value="2" <s:if test="blackQuery.sex == 2"> checked="checked" </s:if>/>&nbsp;女</label>
	   			</p>
	 			<div class="clearfix"></div>
	 		</div>
	 		<div class="listbox">
	  			<p class="leftside">电话号码：</p>
	  			<input class="rframe" type="text" name="blackQuery.mobile" label="电话号码" value="<s:property value="blackQuery.mobile"/>"/>
	 			<div class="clearfix"></div>
	 		</div>
	 		<div class="listbox">
	  			<p class="leftside">邮   箱：</p>
	  			<input class="rframe" type="text" name="blackQuery.email" label="邮箱" value="<s:property value="blackQuery.email"/>"/>
	 			<div class="clearfix"></div>
	 		</div>
	 		<div class="listbox">
	  			<p class="leftside">QQ：</p>
	  			<input class="rframe" type="text" name="blackQuery.qq" label="QQ" value="<s:property value="blackQuery.qq"/>"/>
	 			<div class="clearfix"></div>
	 		</div>
	 		<div class="listbox">
	  			<p class="leftside">身份证地址：</p>
	  			<input class="rframe" type="text" name="blackQuery.idCardAddress" label="身份证地址" value="<s:property value="blackQuery.idCardAddress"/>"/>
	 			<div class="clearfix"></div>
	 		</div>
	 		<div class="listbox">
	  			<p class="leftside">学校（公司）地址：</p>
	  			<input class="rframe" type="text" name="blackQuery.companyAddress" label="学校（公司）地址" value="<s:property value="blackQuery.companyAddress"/>"/>
	 			<div class="clearfix"></div>
	 		</div>
	 		<div class="listbox">
	  			<p class="leftside">学校（公司）名称：</p>
	  			<input class="rframe" type="text" name="blackQuery.companyName" label="学校（公司）名称" value="<s:property value="blackQuery.companyName"/>"/>
	 			<div class="clearfix"></div>
	 		</div>
	 		<div class="listbox">
	  			<p class="leftside">欠款人公司（学校）职务：</p>
	  			<input class="rframe" type="text" name="blackQuery.companyPosition" label="学校（公司）职务" value="<s:property value="blackQuery.companyPosition"/>"/>
	 			<div class="clearfix"></div>
	 		</div>
	 		<div class="listbox">
	  			<p class="leftside">欠款总金额：</p>
	  			<input class="srframe" type="text" name="blackQuery.totalArrears" label="欠款总金额" value="<s:property value="blackQuery.totalArrears"/>"/>
	  			<p class="eunit">元</p>
	 			<div class="clearfix"></div>
	 		</div>
	 		<div class="listbox">
	  			<p class="leftside">逾期罚款金额：</p>
	  			<input class="srframe" type="text" name="blackQuery.totalPenalty" label="逾期罚款金额" value="<s:property value="blackQuery.totalPenalty"/>"/>
	  			<p class="eunit">元</p>
	 			<div class="clearfix"></div>
	 		</div>
	 		<div class="listbox">
	  			<p class="leftside">逾期笔数：</p>
	  			<input class="srframe" type="text" name="blackQuery.lateTimes" label="逾期笔数" value="<s:property value="blackQuery.lateTimes"/>"/>
	  			<p class="eunit">笔</p>
	 			<div class="clearfix"></div>
	 		</div>
	 		<div class="listbox">
	  			<p class="leftside">逾期天数：</p>
	  			<input class="srframe" type="text" name="blackQuery.lateDays" label="逾期天数" value="<s:property value="blackQuery.lateDays"/>"/>
	   			<p class="eunit">天</p>
	 			<div class="clearfix"></div>
	 		</div>
	 		<div class="listbox">
	  			<p class="leftside">当前状态：</p>
	  			<select id="status" name="blackQuery.status" class="srframe">
	  				<option value="0">请选择</option>
	  				<option value="1" <s:if test="blackQuery.status == 1"> selected="selected"</s:if>>逾期</option>
	  				<option value="2" <s:if test="blackQuery.status == 2"> selected="selected"</s:if>>已还清</option>
	  			</select>
	 			<div class="clearfix"></div>
	 		</div>
	 		<div class="listbox">
	  			<p class="leftside">欠款人照片：</p>
	  			<input class="rframe" type="file" name="upload" label="欠款人照片" />
			 	<div class="clearfix"></div>
		 	</div>
		 	<!-- 
		 	<div class="listbox">
	  			<p class="leftside">发起人留言：</p>
	  			<textarea class="rframe" type="text" name="blackQuery.publishOpinion" style="height: 90px;" label="发起人留言"></textarea>
	 			<div class="clearfix"></div>
	 		</div>
	 		<div class="listbox">
	  			<p class="leftside">欠款人证据图片：</p>
	  			<input class="rframe" type="file" name="upload" label="欠款人证据图片"/>
	  			<input class="rframe" type="file" name="upload" label="欠款人证据图片"/>
	  			<input class="rframe" type="file" name="upload" label="欠款人证据图片"/>
	  			<input class="rframe" type="file" name="upload" label="欠款人证据图片"/>
	 			<div class="clearfix"></div>
	 		</div>
	 		-->
	 		<div class="signbtn">
	 			<input class="rframe" type="hidden" name="blackQuery.platform" value="<s:property value="getCurrentUser().userId" />"/>
	        	<input id="submit_btn" class="submit_button" type="button"  value="提交" onclick="saveBlack()"/>
			</div>
		</div>
	</form>
	<%@include file="../common/foot.jsp"%>
</body>
</html>
