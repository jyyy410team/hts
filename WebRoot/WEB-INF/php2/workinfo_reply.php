﻿<?php
include ("../include/config.php");
include ("checkuser.php");

$ID=$_REQUEST["ID"];
$sqlN="select * from ask_info where ID=".$ID."";
$resultN=mysql_db_query($dbname,$sqlN);
$rsN=mysql_fetch_array($resultN);
$order_id=$rsN["order_id"];
?>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=7" />
<title>后台管理中心</title>   </title> <LINK rel=stylesheet type=text/css href="../css/style2.css">    
<LINK rel=stylesheet type=text/css href="../css/select.css">
<SCRIPT language=javascript type=text/javascript src="../css/j_dialog.js"></SCRIPT>  
<SCRIPT language=javascript type=text/javascript src="../css/jquery.js"></SCRIPT> 

<link href="../images/reset.css" rel="stylesheet" type="text/css" />
<link href="../images/zh-cn-system.css" rel="stylesheet" type="text/css" />
<script language="javascript" type="text/javascript" src="../images/jquery.min.js"></script>
<script language="javascript" type="text/javascript" src="../images/styleswitch.js"></script>
<script type="text/javascript">
	window.focus();
	var pc_hash = 'oxB0Wa';
	</script>
<script charset="utf-8" src="../kindeditor/kindeditor.js"></script>
<script>
KE.show({
	id : 'recontent',
		afterCreate : function(id) {
			KE.event.ctrl(document, 13, function() {
				KE.util.setData(id);
				document.forms['example'].submit();
			});
			KE.event.ctrl(KE.g[id].iframeDoc, 13, function() {
				KE.util.setData(id);
				document.forms['example'].submit();
			});
	}
});
</script>
</head>
<body>
<style type="text/css">
	html{_overflow-y:scroll}
</style>
<div id="main_frameid" class="pad-10 display" style="_margin-right:-12px;_width:98.9%;">
<div class="col-2  col-auto" >
	<h6>提交工单</h6>
	<div class="content">
	  <form id="form1" name="form1" method="post" action="saveworkinfo.php?action=reply&ID=<?php echo $ID;?>" onsubmit="return check()">
	    <table class="tablelist" width="100%" cellpadding="0" cellspacing="1" bgcolor="#e2e2e2">
	      <tr>
	        <td width="12%" height="30" bgcolor="#FFFFFF" style="padding-left:10px;">
			  <INPUT id="userid" value="<?php echo $rsN["ID"];?>" type="hidden" name="userid">
			  <INPUT id="order_id" value="<?php echo $order_id;?>" type="hidden" name="order_id">
	          <div align="center">问题标题</div></td>
	        <td style="PADDING-BOTTOM: 10px; PADDING-LEFT: 10px; PADDING-RIGHT: 10px; PADDING-TOP: 10px" 
    bgColor=#ffffff width="88%" align=left><?php echo $rsN["title"];?></td>
          </tr>
	      <tr>
	        <td height="30" bgcolor="#FFFFFF" style="padding-left:10px;"><div align="center">问题详述</div></td>
	        <td style="PADDING-BOTTOM: 10px; PADDING-LEFT: 10px; PADDING-RIGHT: 10px; PADDING-TOP: 10px" 
    bgColor=#ffffff width="88%" align=left><?php echo $rsN["content"];?></td>
          </tr>
		  <TR>
			<TD bgColor=#ffffff height=30>
			  <DIV align=center>交互信息</DIV></TD>
			<TD style="PADDING-BOTTOM: 10px; PADDING-LEFT: 10px; PADDING-RIGHT: 10px; PADDING-TOP: 10px" 
			bgColor=#ffffff align=left>
			<table class="tablelist" cellSpacing=1 cellPadding=0 width="100%" >
			<?php
				$sqls="select * from ask_discuss where order_id=".$order_id."";
				$results=mysql_db_query($dbname,$sqls);
				if (mysql_num_rows($results)==NULL)
				 {
				   echo " ";
				 }
				 else
				 {
					while($rss=mysql_fetch_array($results))
					  {
						$VipUser=$rss["VipUser"];
						$sqlu="select * from user where VipUser='".$VipUser."'";
						$resultu=mysql_db_query($dbname,$sqlu);
						$rsu=mysql_fetch_array($resultu);
						if($rsu!=NULL)
						{
							$headpic=$rsu["headpic"];
							$uflag=1;
							$bcolor="#e3e8f3";
						}
						else{
							$sqla="select * from admin where AdminUser='".$VipUser."'";
							$resulta=mysql_db_query($dbname,$sqla);
							$rsa=mysql_fetch_array($resulta);
							if($rsa!=NULL)
							{
								$headpic=$rsa["headpic"];
								$uflag=0;
								$bcolor="#c9d3e9";
							}
							else{
								$headpic="../images/headpic.gif";
							}
						}
						
					?>
					<TR><TD bgColor=<?php echo $bcolor;?> width="110" height="110" rowspan="2"><DIV align=center><img src="<?php echo $headpic;?>" border="0" width="93" height="93"></DIV></TD><TD bgColor=<?php echo $bcolor;?> width="110" height="25" style="PADDING-LEFT: 10px; PADDING-RIGHT: 10px; PADDING-TOP: 8px"><div style="float:left; width:100%; height:26px"><?php echo $rss["VipUser"];?>在【<?php echo $rss["data"];?>】<?php if($uflag) {echo "反馈：";} else {echo "回复：";}?></div></TD></TR>
					<TR>
						<TD style="PADDING-BOTTOM: 10px; PADDING-LEFT: 10px; PADDING-RIGHT: 10px; PADDING-TOP: 8px" 
						bgColor=#ffffff align=left>
						<div style="float:left; width:100%; height:auto; padding-top:10px;"><?php echo $rss["recontent"];?></div></TD>
					</TR>
				<?php }
				 }
				?>
			</TABLE>
		  </TD></TR>
	      <tr>
	        <td height="30" bgcolor="#FFFFFF" style="padding-left:10px;"><div align="center">回复内容</div></td>
	        <td style="PADDING-BOTTOM: 10px; PADDING-LEFT: 10px; PADDING-RIGHT: 10px; PADDING-TOP: 10px" 
    bgColor=#ffffff width="88%" align=left>
			<textarea name="recontent"  style="width:100%;height:330px;visibility:hidden;"></textarea>
			</td>
          </tr>
		  <TR>
			 <td height="30" bgcolor="#FFFFFF"><div align="center">问题是否解决</div></td>
			 <td align="left" bgcolor="#FFFFFF" style="padding:10px;"><SELECT id="yn" name="yn"> <OPTION value=1 >已解决</OPTION> <OPTION value=0 <?php echo "selected";?>>未解决</OPTION></SELECT></td>
		  </TR>
	      <tr>
	        <td height="30" bgcolor="#FFFFFF">&nbsp;</td>
	        <td align="left" bgcolor="#FFFFFF" style="padding-left:10px;"><input type="submit" name="button" id="button"  value=" 提 交 "  style="width:60px; height:25px;"/></td>
          </tr>
	    
        </table>
      </form>
	</div>
</div>
	<div class="bk20 hr"></div>	
</div>
<iframe name="main" width="0" height="0" id="main"  frameborder="0"></iframe>
<script type="text/javascript">
 

function check()
    {
        var flg = true;
		var flg1= true;
        $("input[lang='require']").each(function(){
			$(this).css("border-color","#ffffff"); 
            if($(this).val() == "") {
                flg = false;   
				$(this).css("border-color","#FF0000");            
            }        
        })
		
		 $("select[lang='require']").each(function(){
			$(this).css("background-color","#ffffff"); 
            if($(this).val() == "0") {
                flg1 = false;   
				$(this).css("background-color","#FF0000");            
            }        
        })
		
		if(flg==false || flg1==false)
		{
	 	    alert('红色提示为关键信息,请填写完整,不能空!');
			return false;   
			
		}
		
        return true;
    }  

</script>
</body>
</html>
