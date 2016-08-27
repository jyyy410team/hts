<?php
include ("checkuser.php");
include ("../include/config.php");
include("../include/function.php");
$AdminUser=$_COOKIE["AdminUser"];
$sql="select * from admin where AdminUser='".$AdminUser."'";
$result=mysql_db_query($dbname,$sql);
$rs=mysql_fetch_array($result);
if($rs!=NULL)
{
    $yue=$rs["yue"];
	$ip=$rs["ip"];
	$data=$rs["data"];
}
?>
<HTML>
<HEAD><TITLE>后台管理中心</TITLE>
<META content="text/html; charset=utf-8" http-equiv=Content-Type>
<META content=IE=7 http-equiv=X-UA-Compatible>
<LINK rel=stylesheet type=text/css href="../images/reset.css">
<LINK rel=stylesheet type=text/css href="../images/zh-cn-system.css">
<SCRIPT language=javascript type=text/javascript src="../images/jquery.min.js"></SCRIPT>
<SCRIPT language=javascript type=text/javascript src="../images/styleswitch.js"></SCRIPT>
<SCRIPT type=text/javascript>
	window.focus();
	var pc_hash = 'oxB0Wa';
	</SCRIPT>
<SCRIPT language=javascript> 
<!-- 
window.onerror=function(){return true;} 
// --> 
</SCRIPT>

<META name=GENERATOR content="MSHTML 8.00.6001.19394">
</HEAD>
<BODY>
<STYLE type=text/css>HTML {
	_overflow-y: scroll
}
</STYLE>

<DIV style="_width: 98.9%; _margin-right: -12px" id=main_frameid 
class="pad-10 display">
<DIV class="col-2  col-auto">
<H6>我的个人信息</H6>
<DIV class=content>
<div width="120px" style="float:left;padding-top:3px;padding-bottom:5px;"><img src="<?php echo $rs["headpic"];?>" border="0" width="110" height="110"><br><a href="info.php">编辑资料</a> | <a href="info.php">修改头像</a></div><div width="830px" style="float:left;margin-left:10px"><?php echo $_COOKIE["AdminUser"];?>，欢迎您！<BR>所属角色：<?php
		switch($_COOKIE["fg"])
		{
		 case "1":
		 echo "超级用户";
		 break;
		 case "2":
		 echo "只允许添加";
		 break;
		 case "3":
		 echo "只允许查看";
		 break;
		}
		?> <BR>账号余额：<b style='color:#FF0000'><?php echo $rs["yue"];?></b>元 <a href="chongzhi.php"><img src="../images/chongzhi.gif" border="0" width="27" height="15"></a><BR>
<DIV class="bk20 hr">
<HR>
</DIV>上次登录时间：<?php echo $data;?><BR>上次登录IP：<?php echo $ip;?> <BR></div></DIV></DIV>
<DIV class="bk20 hr"></DIV>
<DIV style="WIDTH: 48%" class="col-2 lf mr10">
<H6>资讯中心</H6>
<DIV class=content>
<?php
$sqls="select * from news_info where class_id=28 order by ID asc limit 0,2";
//$results=mysql_db_query($dbname,$sqls);
$results=mysql_query($sqls);
	while($rss=mysql_fetch_array($results))
	{
?>
  <P style="BORDER-BOTTOM: #ccc 1px dotted; PADDING-BOTTOM: 5px; HEIGHT: 25px; CLEAR: both"><SPAN style="FLOAT: left">※ <A style="COLOR: #f00" href="newsinfo.php?id=<?php echo $rss["ID"];?>"><?php echo $newsOB->utfSubstr($rss["title"],0,80);?></A></SPAN> <EM style="FLOAT: right"><?php echo $rss["data"];?></EM></P>
<?php
	}?>
</DIV></DIV>
<DIV class="col-2 col-auto">
<H6>发稿帮助</H6>
<DIV class=content>
<?php
$sqls="select * from news_info where class_id=29 order by ID asc limit 0,2";
//$results=mysql_db_query($dbname,$sqls);
$results=mysql_query($sqls);
	while($rss=mysql_fetch_array($results))
	{
?>
  <P style="BORDER-BOTTOM: #ccc 1px dotted; PADDING-BOTTOM: 5px; HEIGHT: 25px; CLEAR: both"><SPAN style="FLOAT: left">※ <A style="COLOR: #f00" href="newsinfo.php?id=<?php echo $rss["ID"];?>"><?php echo $newsOB->utfSubstr($rss["title"],0,80);?></A></SPAN> <EM style="FLOAT: right"><?php echo $rss["data"];?></EM></P>
<?php
	}?>
</DIV>
</DIV>
</DIV>
</BODY>
</HTML>
