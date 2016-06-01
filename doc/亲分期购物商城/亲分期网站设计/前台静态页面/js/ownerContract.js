function showPayDate(maxDateStr){
	var minDate = new Date();
	var maxDate = new Date();
	minDate.setDate(maxDate.getDate() + 7);
//	maxDate.setDate(maxDate.getDate() + 30);
	var minDateStr = minDate.getFullYear() + "-" + (minDate.getMonth()+1) + "-" + minDate.getDate();
//	var maxDateStr = maxDate.getFullYear() + "-" + (maxDate.getMonth()+1) + "-" + maxDate.getDate();
	WdatePicker({dateFmt:'yyyy-MM-dd',qsEnabled:true,minDate:minDateStr,maxDate:maxDateStr,onpicked:changeFirstPayDate});
}


function cancelCoupons(){
	$("#myCouponsCode").val("");
	$("#shuRuCouponsSpan").hide();
	$("#myCouponsSelect option[value='notUseCoupons']").attr("selected", true);
	$("#myCouponsSelect").show();
	$("#determineCoupons").show();
	$("#couponsOff").html("");
	$("#couponsOff").hide();
}
var wrap = $("#contractDocId");
function doAjax(){
	var paypre = $("#paypre"),
		stages = $("#stages"),
		orderId = $("#orderId");
	var promise = $.ajax({
		url: '/user/contract/getOwnerContractMonthlyPayments',
		type: 'POST',
		data: {
			paypre: paypre.val(),
			stages: stages.val(),
			orderId: orderId.val(),
			_csrf: $("#_csrf").val()
		}
	});
	promise.then(function(data){
		var data = JSON.parse(data);
		if(!data.success){
			wrap.parent().hide();
			return false;
		}
		var result = serialData(data.data) || {};
		if(result.perfer==1){
				$("#couponsDiv").show();
			}else{
				$("#couponsDiv").hide();
				$("#myCouponsCode").val("");
			}

		result.prepay = paypre.val();
		result.stages = stages.val();
		var source = "";
		if(result.tpl == 0){
			source = $("#first-tpl").html();
		}else if(result.tpl == 10){
			source = $("#25-tpl").html();
		}
		var template = Handlebars.compile(source);
		var html = template(result);
		wrap.html(html);
	});
}
function serialData(arr){
	var result = {
		downPay: arr[0],
		monthPay: arr[1],
		price: arr[2],
		tip: arr[3],
		perfer: arr[4],
		loan: arr[5],
		tpl: arr[6]		
	};
	return result;
}

$(function(){
	doAjax();
	

	
	$('#acceptContract').click(function(){
		if($(this).is(":checked")){
			$('#paymentBtn').removeClass('bg-disable').addClass('bg-fc');
		}else{
			$('#paymentBtn').removeClass('bg-fc').addClass('bg-disable');
		}
	})
	$('#paymentBtn').click(function(){
		if($(this).hasClass('bg-disable')){
			return ;
		}
		if($(this).hasClass('bg-fc')){
			showPaymentPasswordUI();
		}
	})
});
