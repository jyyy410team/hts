
function alertMsg(msg){
	var $dialog = $(
			"<div class='tip' style='display: none'>"+
			
					"<div class='tiptop'>"+
					"<span>提示信息</span><a></a>"+
				    "</div>"+


			
							"<div class='tipinfo'>"+
							"<span><img src='images/ticon.png' />"+
							"</span>"+
							"<div class='tipright'>"+
							"<br />"+	
								"<p>"+msg+"</p>"+
				
							"</div>"+
						     "</div>"+
			
			
			
			
				    
						    
						   "<div class='tipbtn'>" +
					       "<input name='' type='button' class='sure' value='确定' />&nbsp;"+
					       
					       "<input name='' type='button' class='cancel' value='取消' />"+
				           "</div>"+
				

		   "</div>"
	);

	$("body").append($dialog);
	 $(".tip").fadeIn(200);


		$(".sure").click(function(){
			  $(".tip").fadeOut(100);
			});
		  $(".tiptop a").click(function(){
			  $(".tip").fadeOut(200);
			});

			  $(".cancel").click(function(){
			  $(".tip").fadeOut(100);
				});

	
}



$(function(){
	
	
}  
)