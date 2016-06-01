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
	</script>
</head>

<body>
	<%@include file="../common/top.jsp"%>
	<div class="clearfix"></div>
	<%@include file="black_search.jsp"%>
	<div class="clearfix"></div>
	
	<div class="container statemar26"> 
  		<!-- table top -->
  		<div class="infortop">
	    	<div class="inleft">
	    		<span><s:property value="blackQuery.trueName"/></span>&nbsp &nbsp
	    		<span>身份证号码:</span> 
	    		<span><s:property value="blackQuery.idCard"/></span> 
	    	</div>
	    	<div class="rdate">
	    		<span>发布日期：</span>
	    		<span><s:date name="blackQuery.publishTime" format="yyyy-MM-dd"/></span> 
	    	</div>
	  	</div>
	  	<div class="row detailsbox" style="margin-top:0px;"> 
	    	<!-- table left -->
	    	<div class="col-md-3 inforleft">
	      		<div><img src="<s:property value="blackQuery.photo"/>" width="220" height="300"></div>
		      	<div>
			      	<p> 
			      		<span class="inforbtit inforlw">姓名：</span> 
			      		<span class="inforword"><s:property value="blackQuery.trueName"/></span>
			     	</p>
			    	<div class="clearfix"></div>
			    	<p> 
			      		<span class="inforbtit inforlw">性别：</span> 
			      		<span class="inforword">
			      			<s:if test="blackQuery.sex == 1">男</s:if>
							<s:if test="blackQuery.sex == 2">女</s:if>
							<s:if test="blackQuery.sex == 3">未知</s:if>
			      		</span>
			     	</p>
			    	<div class="clearfix"></div>
			    	<p> 
			      		<span class="inforbtit inforlw">电话：</span> 
			      		<span class="inforword"><s:property value="blackQuery.mobile.substring(0,3)"/>****<s:property value="blackQuery.mobile.substring(7,11)"/></span>
			     	</p>
			    	<div class="clearfix"></div>
			    	<p> 
			      		<span class="inforbtit inforlw">身份证号：</span> 
			      		<span class="inforword"><s:property value="blackQuery.idCard"/></span>
			     	</p>
			    	<div class="clearfix"></div>
			    </div>
			</div>
	    	<!-- table right -->
	    	<div class="col-md-9  rightcont martop ">
	        	<!-- basic -->
	      		<p class="infortitbg" style="margin-top:0px;">基本信息</p>
	      		<p> 
	       			<span class="inforbtit">邮箱：</span> 
	       			<span class="inforword"><s:property value="blackQuery.email"/></span> 
	       			<span class="inforbtit">QQ:</span> 
	       			<span class="inforword"><s:property value="blackQuery.qq"/></span> 
	     		</p>
	     		<div class="clearfix"></div>
	     		<p> 
	      			<span class="inforbtit">微信：</span> 
	      			<span class="inforword"><s:property value="blackQuery.idCardAddress"/></span>
	    		</p>
	     		<div class="clearfix"></div>
	     		<p> 
	      			<span class="inforbtit">身份证地址：</span> 
	      			<span class="inforword"><s:property value="blackQuery.idCardAddress"/></span>
	    		</p>
	    		<div class="clearfix"></div>
	    		<p> 
	      			<span class="inforbtit">学校（公司）地址：</span> 
	      			<span class="inforword"><s:property value="blackQuery.companyAddress"/></span>
	    		</p>
	    		<div class="clearfix"></div>
	    		<p> 
	      			<span class="inforbtit">学校（公司）名称：</span> 
	      			<span class="inforword"><s:property value="blackQuery.companyName"/></span>
	    		</p>
	    		<div class="clearfix"></div>
	    		<p> 
	      			<span class="inforbtit">学校（公司）职务：</span> 
	      			<span class="inforword"><s:property value="blackQuery.companyPosition"/></span>
	    		</p>
				<div class="clearfix"></div>
	        	<!-- situation -->
	      		<p class="infortitbg">欠款情况</p>
	      		<p> 
	       			<span class="inforbtit">欠款总金额：</span> 
	       			<span class="inforword">￥<s:property value="blackQuery.totalArrears"/></span> 
	     		</p>
	     		<div class="clearfix"></div>
	     		<p> 
	      			<span class="inforbtit">逾期罚款金额：</span> 
	      			<span class="inforword">￥<s:property value="blackQuery.totalPenalty"/></span>
	    		</p>
	    		<div class="clearfix"></div>
	    		<p> 
	      			<span class="inforbtit">逾期笔数：</span> 
	      			<span class="inforword"><s:property value="blackQuery.lateTimes"/>笔</span>
	    		</p>
	    		<div class="clearfix"></div>
	    		<p> 
	      			<span class="inforbtit">逾期天数：</span> 
	      			<span class="inforword"><s:property value="blackQuery.lateDays"/>天</span>
	    		</p>
	    		<div class="clearfix"></div>
	    		<p> 
	      			<span class="inforbtit">状态：</span> 
	      			<span class="inforword">
	      				<s:if test="blackQuery.status == 1">逾期</s:if>
						<s:if test="blackQuery.status == 2">已还清</s:if>
	      			</span>
	    		</p>
	    		<div class="clearfix"></div>
	    		<p class="infortitbg">其它信息</p>
	      		<p> 
	       			<span class="inforbtit">发起人所属平台：</span> 
	       			<span class="inforword"><s:property value="blackQuery.companyShortName"/></span> 
	     		</p>
	     		<div class="clearfix"></div>
	      		<p> 
	       			<span class="inforbtit">发起人留言：</span> 
	       			<span class="inforword  messagebox">
	       				<s:property value="blackQuery.publishOpinion"/>
	       			</span> 
	     		</p>
	     		<div class="clearfix"></div>
	     		<!--  
	      		<p> 
	       			<span class="inforbtit">欠款证据图片：</span>
	       			<p style="margin-top:10px;">
	       				<s:if test="evidences.size() > 0">
							<s:iterator value="evidences" id="evidence" status="L">
								<div class="maright20"><img src="<s:property value="#evidence" />" width="160"  height="160" /></div>
							</s:iterator>
						</s:if>
	       			</p>
	      		</p>
	   			<div class="clearfix"></div>
	   			-->
	   		</div>
		</div>
	</div>
	
	<!-- merchants start -->
	<%@include file="../common/link.jsp"%>
	<%@include file="../common/foot.jsp"%>
</body>
</html>
