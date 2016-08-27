
<#macro page total_count current_page action total_page page_size>

<div class="pagin" >

    	<div class="message">每页显示<i class="blue"> ${page_size} </i>条记录,共 <i class="blue"> ${total_count} </i>条记录，当前显示第<i class="blue"> ${current_page} </i>页</div>
        <ul class="paginList">
				    <li class="paginItem"><a href="${action}?current_page=1">首页</a></li>
				    <li class="paginItem"><a href="${action}?current_page=${current_page?number-1}">上页</a></li>
	               	<li class="paginItem"><a href=""><span class="pagepre"></span></a></li>
       
				         <#list 1..total_page?number as i>
				             <li class="paginItem"><a href="${action}?current_page=${i}">${i}</a></li>
				         </#list>
        
			        <li class="paginItem"><a href="javascript:;"><span class="pagenxt"></span></a></li>
			        <li class="paginItem"><a href="${action}?current_page=${current_page?number+1}">下页</a></li>
			        <li class="paginItem"><a href="${action}?current_page=${total_page}">尾页</a></li>
			        
        
        </ul>
    </div>
</#macro>
