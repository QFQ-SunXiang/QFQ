
$(function(){
    $('.order-table').find('table').show();
    $('.order-table-title:first').css('margin-top','0');
	$('.order-right').on('click',function(){
		
		//var orderId = $(this).attr("data-order-id");
		//var orderTable=$(".event-table-" + orderId);
		var orderTable=$(this).parent().parent().find('table tr').not('tr:first').not('tr:eq(0)');
		if(orderTable.css('display')==('none')){
			orderTable.css('display','table-row');
			$(this).find('s').html('收起');
			$(this).find('i').css('background-position','-114px -30px');
		}else{
			orderTable.css('display','none');
			$(this).find('s').html('展开');
			$(this).find('i').css('background-position','-102px -30px');
		}
		

	})
});

