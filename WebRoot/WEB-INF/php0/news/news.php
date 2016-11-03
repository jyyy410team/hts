<?php
include("../include/config.php");
include("../include/function.php");
$BigID=@$_REQUEST["BigID"];
if($BigID==""){
	$BigClass="最新资讯";
}
else{
	$sqls="select * from news_class where ID=".$BigID."";
	$results=mysql_db_query($dbname,$sqls);
	$rss=mysql_fetch_array($results);
	$BigClass=$rss["BigClass"];
}
?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<TITLE>资讯中心_<?php echo $webname;?></TITLE>
<META content="text/html; charset=UTF-8" http-equiv=Content-Type>
<link href="../images/index.css" rel="stylesheet" type="text/css">
<link href="../images/reset.css" rel="stylesheet" type="text/css">
<link href="../images/ruanwen.css" rel="stylesheet" type="text/css">
<META name=GENERATOR content="MSHTML 8.00.6001.19394">
</head>
<body class="articleview">
<div class="header clearfix">
  <div class="top">
    <div class="head">
      <h1><a href="/"></a></h1>
    </div>
  </div>
<?php
include("menu.php");
?>
</div>
<div id="wrapmain">
  <div class="maincont clearfix">
    <div class="adct corner5px mb15 clearfix" id="adt"><img src="../images/banner.jpg" width="980" height="279"></div>
    <div class="wrapindex clearfix">
      <div class="homeleft corner5px mb15">
        <div class="position">当前位置：<a href="/">网站主页</a> &gt; <a href="../news/news.php">资讯中心</a></div>
        <div class="b2"></div>
        <div class="clearfix" id="content">
			<DIV id=main_left>
			<DIV class=l_top>分类导航</DIV>
				<DIV class=l_list>
				<UL>
					<?php
					$sql1="select * from news_class order by ID asc";
					$result1=mysql_db_query($dbname,$sql1);
						while($rs1=mysql_fetch_array($result1))
						{
						if($BigID==$rs1["ID"]){
					?>
					<li><a href="../news/news.php?BigID=<?php echo $rs1["ID"];?>" class=sideba><?php echo $rs1["BigClass"];?></a></li>
					<?php
						 }else{ ?>
					<li><a href="../news/news.php?BigID=<?php echo $rs1["ID"];?>"><?php echo $rs1["BigClass"];?></a></li>
					<?php
						 }
						}?>
				</UL>
				</DIV>
				<DIV class=l_bottom></DIV>
			</DIV>
			<DIV id=con_right>
			<DIV class=r_top>
			<DIV class=r_top1><?php echo $BigClass;?></DIV></DIV>
			<DIV class=newslist>
			<UL>
			<?php
			/*-----------------接收相关数据值---------------------*/
			$BigID=@$_REQUEST["BigID"];
			$Page=@$_REQUEST["Page"];
			/*-----------------设置每页显示数目-------------------*/
			$List_Num=10;
			/*-----------------计算共有记录数--------------------*/
			if($BigID=="")
			{
			$sqlN="select Count(*) from news_info";
			}
			else
			{
			$sqlN="select Count(*) from news_info where class_id=".$BigID."";
			}
			$resultN=mysql_db_query($dbname,$sqlN);
			$rsN=mysql_fetch_array($resultN);
			$Num=$rsN[0];

			/*------------------计算共有页数--------------------*/
			$CountPage=ceil($Num/$List_Num);
			/*-------------------设置当道页--------------------*/
			$Cpage=$Page+1;
			/*--------------------------------------------------*/

			if($BigID=="")
			{
			$sql="select * from news_info order by ID desc limit ".($List_Num*$Page).",".$List_Num."";
			}
			else
			{
			$sql="select * from news_info where class_id=".$BigID." order by ID desc limit ".($List_Num*$Page).",".$List_Num."";
			}
			$result=mysql_db_query($dbname,$sql);
					 if (mysql_num_rows($result)==NULL)
					 {
					 $fy="no";
							  echo "<br><table width=95% border=0 align=center cellpadding=0 cellspacing=0><tr>
							 <td align=center><span class=rd rd>还没有添加数据！</span></td></tr></table>";
					 }
					 else
					 {
					 $fy="yes";
					
						  while($rs=mysql_fetch_array($result))
						  {
			?>
			  <LI><SPAN><?php echo $rs["data"];?></SPAN><A 
			  href="../news/newsinfo.php?ID=<?php echo $rs["ID"];?>"><?php echo $newsOB->utfSubstr($rs["title"],0,100);?></A></LI>
			<?php
					}
				 }?>
			</UL>
			<DIV class=pagelist>
			<?php
				 if ($fy=="yes")
				 {
								  echo "当前为".$Cpage."/".$CountPage."页  共".$Num."条记录&nbsp;&nbsp;";
								  
								  if($Page!=0)
								  {
								  $Prv=$Page-1;
								  echo "<a href='../news/news.php"."'>首页</a>&nbsp;&nbsp;";
								  echo "<a href='../news/news.php?Page=".$Prv.""."'>上一页</a>&nbsp;&nbsp;";
								  }
								  else
								  {
								   echo "首页&nbsp;&nbsp;";
								   echo "上一页&nbsp;&nbsp;";
								  }
								  if($Page!=$CountPage-1)
								  {
								  $NtPage=$Page+1;
								  $EdPage=$CountPage-1;
								  echo "<a href='../news/news.php?Page=".$NtPage."'>下一页</a>&nbsp;&nbsp;";
								  echo "<a href='../news/news.php?Page=".$EdPage."'>尾页</a>&nbsp;&nbsp;";
								  }
								  else
								  {
								   echo "下一页&nbsp;&nbsp;";
								   echo "尾页&nbsp;&nbsp;";
								  }
				 }
				 ?>
			</DIV></DIV></DIV>
        </div>
      </div>
    </div>
  </div>
</div>
</div>
<?php
include("footer.php");
?>
</body>
</html>