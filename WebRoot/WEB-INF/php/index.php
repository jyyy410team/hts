<?php
require_once("rand.inc.php");
include ("include/config.php");
include("include/function.php");
$VipUser=$_COOKIE["VipUser"];
$AdminUser=$_COOKIE["AdminUser"];
if($VipUser<>""){
	$sql="select * from user where VipUser='".$VipUser."'";
	//$result=mysql_db_query($dbname,$sql);
	mysql_select_db($dbname);
	$result=mysql_query($sql);
	$rs=mysql_fetch_array($result);
	if($rs!=NULL)
	{
		$yue=$rs["yue"];
		$ip=$rs["ip"];
		$data=$rs["data"];
	}
	$ufalg=1;
	$username=$VipUser;
	$userpath="../user/";
	$fg=$_COOKIE["fg"];
	switch($_COOKIE["fg"])
	{
		case "1":
			$jiaose="核心代理";
			break;
		case "2":
			$jiaose="合作加盟供应商";
			break;
		case "3":
			$jiaose="企业用户";
			break;
	}
}
elseif($AdminUser<>""){
	$sql="select * from admin where AdminUser='".$AdminUser."'";
	//$result=mysql_db_query($dbname,$sql);
	mysql_select_db($dbname);
	$result=mysql_query($sql);
	$rs=mysql_fetch_array($result);
	if($rs!=NULL)
	{
		$yue=$rs["yue"];
		$ip=$rs["ip"];
		$data=$rs["data"];
	}
	$ufalg=1;
	$username=$AdminUser;
	$userpath="../admin/";
	$fg=$_COOKIE["fg"];
	switch($_COOKIE["fg"])
	{
		case "1":
			$jiaose="站长";
			break;
		case "2":
			$jiaose="副站长";
			break;
		case "3":
			$jiaose="检查员";
			break;
	}
}
else{
	$ufalg=0;
}
?>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3c.org/TR/1999/REC-html401-19991224/loose.dtd">
<HTML xmlns="http://www.w3.org/1999/xhtml">
<HEAD>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title><?php echo $title;?></title>
<meta name="keywords" content="<?php echo $keyword;?>" />
<meta name="description" content="<?php echo $descr;?>" />
<meta name=GENERATOR content="MSHTML 8.00.6001.19394">
<LINK rel=stylesheet type=text/css href="../images/index.css">
<LINK rel=stylesheet type=text/css href="../images/css.css">
<link href="../images/resets.css" rel="stylesheet" type="text/css">
<LINK rel=icon type=image/x-icon href="favicon.ico">
<SCRIPT type=text/javascript src="../images/jquery.min.js"></SCRIPT>
<SCRIPT type=text/javascript src="../images/iepng.js"></SCRIPT>
<script type="text/javascript" src="../images/jquery.js"></script>
<SCRIPT type=text/javascript>
EvPNG.fix('div, ul, img, li, input');
</SCRIPT>

<STYLE>.blk1 {
	CLEAR: both; OVERFLOW: hidden
}
.blk2 {
	CLEAR: both; OVERFLOW: hidden
}
.blk3 {
	CLEAR: both; OVERFLOW: hidden
}
.blk4 {
	CLEAR: both; OVERFLOW: hidden
}
.blk {
	CLEAR: both; OVERFLOW: hidden
}
.blk1 {
	HEIGHT: 5px
}
.blk2 {
	HEIGHT: 10px
}
.blk3 {
	HEIGHT: 15px
}
.blk4 {
	HEIGHT: 20px
}
.blk {
	HEIGHT: 65px
}
A.applink:hover {
	BORDER-BOTTOM: #dce6f4 2px dotted; BORDER-LEFT: #dce6f4 2px dotted; PADDING-BOTTOM: 2px; BACKGROUND-COLOR: #ffff00; PADDING-LEFT: 2px; PADDING-RIGHT: 2px; COLOR: green; BORDER-TOP: #dce6f4 2px dotted; BORDER-RIGHT: #dce6f4 2px dotted; TEXT-DECORATION: none; PADDING-TOP: 2px
}
A.applink {
	BORDER-BOTTOM: #dce6f4 2px dotted; BORDER-LEFT: #dce6f4 2px dotted; PADDING-BOTTOM: 2px; PADDING-LEFT: 2px; PADDING-RIGHT: 2px; BACKGROUND: none transparent scroll repeat 0% 0%; COLOR: #2f5bff; BORDER-TOP: #dce6f4 2px dotted; BORDER-RIGHT: #dce6f4 2px dotted; TEXT-DECORATION: none; PADDING-TOP: 2px
}
A.info {
	BACKGROUND: none transparent scroll repeat 0% 0%; COLOR: #2f5bff; TEXT-DECORATION: none
}
A.info:hover {
	BACKGROUND: none transparent scroll repeat 0% 0%; COLOR: green; TEXT-DECORATION: underline
}
.mainnav {
	WIDTH: 100%; BACKGROUND: #08a5e0; HEIGHT: 40px
}
.mainnav .nav {
	MARGIN: 0px auto; WIDTH: 980px
}
.mainnav .nav .current-post-ancestor {
	BACKGROUND: #40bbec
}
.mainnav .nav .current-menu-ancestor {
	BACKGROUND: #40bbec
}
.mainnav .nav .current-menu-parent {
	BACKGROUND: #40bbec
}
.mainnav .nav .current-menu-item {
	BACKGROUND: #40bbec
}
.mainnav .nav UL {
	Z-INDEX: 999; POSITION: relative; FLOAT: left; HEIGHT: 100%
}
.mainnav .nav LI {
	TEXT-ALIGN: center; WIDTH: 100px; DISPLAY: inline; FLOAT: left; HEIGHT: 40px; MARGIN-RIGHT: 1px; TEXT-DECORATION: none
}
.mainnav .nav LI A {
	PADDING-BOTTOM: 0px; LINE-HEIGHT: 40px; PADDING-LEFT: 15px; PADDING-RIGHT: 15px; DISPLAY: block; COLOR: #fff; FONT-SIZE: 16px; PADDING-TOP: 0px
}
.mainnav .nav LI A:link {
	PADDING-BOTTOM: 0px; LINE-HEIGHT: 40px; PADDING-LEFT: 15px; PADDING-RIGHT: 15px; DISPLAY: block; COLOR: #fff; FONT-SIZE: 16px; PADDING-TOP: 0px
}
.mainnav .nav LI A:visited {
	PADDING-BOTTOM: 0px; LINE-HEIGHT: 40px; PADDING-LEFT: 15px; PADDING-RIGHT: 15px; DISPLAY: block; COLOR: #fff; FONT-SIZE: 16px; PADDING-TOP: 0px
}
.mainnav .nav LI A:active {
	PADDING-BOTTOM: 0px; LINE-HEIGHT: 40px; PADDING-LEFT: 15px; PADDING-RIGHT: 15px; DISPLAY: block; COLOR: #fff; FONT-SIZE: 16px; PADDING-TOP: 0px
}
.mainnav .nav UL LI UL {
	Z-INDEX: 999; POSITION: absolute; FILTER: alpha(opacity=90); WIDTH: 158px; DISPLAY: none; BACKGROUND: #08a5e0; HEIGHT: auto; BORDER-TOP: #fff 1px solid; opacity: .9; -moz-opacity: .9
}
.mainnav .nav UL LI UL LI {
	BORDER-BOTTOM: #fff 1px solid; TEXT-ALIGN: left; PADDING-BOTTOM: 0px; PADDING-LEFT: 0px; WIDTH: 158px; PADDING-RIGHT: 0px; DISPLAY: block; BACKGROUND: none transparent scroll repeat 0% 0%; FLOAT: left; PADDING-TOP: 0px
}
.mainnav .nav UL LI UL LI A {
	LINE-HEIGHT: 24px; WIDTH: 128px; DISPLAY: block; FLOAT: none; FONT-SIZE: 12px
}
.mainnav .nav LI A:hover {
	BACKGROUND: #ffbf4b
}
.mainnav .nav UL LI UL LI A:hover {
	BACKGROUND: #ffbf4b
}
</STYLE>
<SCRIPT language=javascript>
var jQuery_1_8_2 = $.noConflict(true);
var code_hidden = '<?php echo $_SESSION['authnum'];?>';
function check(){
if(document.getElementById('VipUser').value==""){
document.getElementById('VipUser').focus();
alert("VIP帐号不能够为空!");
return false;
}
if(document.getElementById('VipPass').value==""){
document.getElementById('VipPass').focus();
alert("VIP密码不能够为空!");
return false;
}
if(code_hidden != form1.checkcode.value){
document.form1.checkcode.focus();
alert('验证码输入错误!');
return false;
}
   document.form1.action="checklogin.php";
   document.form1.submit();
   return true;
}
function refreshimg(){document.all.checkcode.src='checkcode.php?authnum=<?php echo $_SESSION['authnum']?>';} 
</SCRIPT>
</HEAD>
<BODY>
<DIV class=top>
<DIV class=head>
<H1><A href="/"></A></H1><IMG src="../images/chongzhi.png">
</DIV>
</DIV>
<?php
include("menu.php");
?>
<DIV class=blk2></DIV>
<DIV class=ban>
<DIV class=banner>
<form name="form1" id="form1" action="" method="post">
<DIV class=denglu>
<?php
if($ufalg<>1){ ?>
<UL>
  <LI style="TEXT-ALIGN: right; MARGIN-BOTTOM: 15px"></LI>
  <LI style="PADDING-BOTTOM: 10px; LINE-HEIGHT: 35px; PADDING-LEFT: 30px; PADDING-RIGHT: 0px; HEIGHT: 35px; COLOR: red; PADDING-TOP: 0px"></LI>
  <LI><DIV class=InputContent1>用 户： <INPUT style="LINE-HEIGHT: 22px; WIDTH: 200px; HEIGHT: 22px" name="VipUser" type="text" id="VipUser"></div></LI>
  <LI><DIV class=InputContent2>密 码： <INPUT style="LINE-HEIGHT: 22px; WIDTH: 200px; HEIGHT: 22px" name="VipPass" type="password" id="VipPass"></div></LI>
  <LI><DIV class=InputContent3><table style="margin-left:8px"><tr><td>验 证：</td><td><DIV style="float:left;padding-left:6px;margin-top:10px"><INPUT style="LINE-HEIGHT: 26px; TEXT-TRANSFORM: uppercase; IME-MODE: disabled; WIDTH: 104px; HEIGHT: 22px" maxLength=5 type=text name="checkcode" id="checkcode"></div> <div class="checkcodeimg" style="float:right; padding-left:0px; padding-top:0px; margin-left:10px"><?php echo $_SESSION['authnum'];?></div></td></tr></table></DIV></LI>
  <LI style="POSITION: relative" class=m_t_10><INPUT onclick="javascript:check()" src="../images/denglu.png" type=image> <A title="注册" href="../reg.php"><IMG alt="注册" src="../images/zhuce1.png" width=120 height=44></A> </LI>
</UL>
<?php }
else{ ?>
<UL style="PADDING-TOP: 73px;font-size:12px">
  <div><div width="120px" style="float:left;padding-top:3px;padding-bottom:5px;line-height:25px;"><img src="<?php echo $rs["headpic"];?>" border="0" width="110" height="120"><br><a href="<?php echo $userpath;?>">返回后台</a> | <a href="logouts.php">注销登录</a></div><div width="253px" style="float:left;margin-left:10px;text-align:left;line-height:25px;"><?php echo $username;?>，欢迎您！<BR>所属角色：<?php echo $jiaose;?> <BR>账号余额：<b style='color:#FF0000'><?php echo $rs["yue"];?></b> 元<BR>
<DIV class="bk20 hr">
<HR>
</DIV>上次登录时间：<?php echo substr($data,0,10);?><BR>登录IP：<?php echo $ip;?> <BR></div></div>
</UL>
<?php } ?>
</DIV><INPUT value=1 type="hidden" name="commit"> 
</FORM></DIV></DIV>
<DIV class=blk2></DIV>
<DIV class=main>
<DIV class=main_l>
<DIV class="m_l_div m_l_one small">
<H2>平台功能</H2>
<P><SPAN style="FONT-SIZE: 14px">好推手是国内最大的软文稿件发布平台，目前已经和国内1000多家大型门户网站合作，同时媒体资源还在不断增加中，是您选择软文推广的最佳服务商。专业的软文发布，软文写作公司，老品牌、大影响、高效率、发遍全网络！</SPAN></P></DIV>
<DIV class="m_l_div m_l_two small">
<H2>发稿说明</H2>
<P><SPAN 
style="FONT-SIZE: 14px">好推手为您提供了一站式的软文发布系统，您可以将您的文章提交到已收录的媒体网站上，待您成功提交后我们客服会将您的稿件提交到编辑部门审核，文章发布成功后会返回文章链接在您的后台。</SPAN></P></DIV>
<DIV class="m_l_div m_l_three small">
<H2>费用结算</H2>
<P><SPAN 
style="FONT-SIZE: 14px">好推手为您提供在线支付功能，您可以选择支付宝、财付通，网银转账等方式进行自动充值，可开发票。充值成功后就可以开始提交稿件了，系统后台会为您做详细的财务流水账单，包括每一笔发稿的费用和代写的费用，无最低充值限制，可随时申请余额提现。</SPAN></P></DIV>
<DIV class="m_l_div m_l_four small">
<H2>售后保障</H2>
<P><SPAN 
style="FONT-SIZE: 14px">您在好推手发稿中心软文发布成功后，还将享受好推手提供给您的服务保障，包括文章百度未收录的我们会为您发外链，已发布成功的文章是长期保持在互联网上的，如果遇到被删除，或者内容被修改，我们会为您去争取恢复。</SPAN></P></DIV></DIV>
<DIV class=main_r>
<DIV class=wd-section>
<DIV class=wd-section-title>
<H3><span style="FLOAT: left">资讯中心</span><EM style="FLOAT: right"><a href="../news/news.php">更多>></a></EM></H3></DIV>
<UL id=news>
<?php
$sqls="select * from news_info order by data desc limit 0,5";
//$results=mysql_db_query($dbname,$sqls);
mysql_select_db($dbname);
$results=mysql_query($sqls);
	while($rss=mysql_fetch_array($results))
	{
?>
<li><span style="FLOAT: left">·<A href="../news/newsinfo.php?ID=<?php echo $rss["ID"];?>" target="_blank" title="<?php echo $rss["title"];?>"><?php echo $newsOB->utfSubstr($rss["title"],0,22);?></A></SPAN> <EM style="FLOAT: right"><?php echo $rss["data"];?></EM></li>
<?php
	}?>
</UL></DIV>
<DIV class="wd-section wd-section2">
<DIV class="wd-section-title wd-section-title2">
<H3>合作客户</H3></DIV>
<UL class=wd-link>
  <LI class="wd-border imgborder"><A><IMG border=2 src="../images/sina.jpg" 
  width=128></A> <A><IMG border=2 src="../images/sohu.jpg" width=128></A></LI>
  <LI class="wd-border imgborder"><A><IMG border=2 src="../images/163.jpg" 
  width=128></A> <A><IMG border=2 src="../images/qq.jpg" width=128></A></LI>
  <LI class="wd-border imgborder"><A><IMG border=2 src="../images/cctv.jpg" 
  width=128></A> <A><IMG border=2 src="../images/people.jpg" 
  width=128></A></LI>
  <LI class="wd-border imgborder"><A><IMG border=2 src="../images/14050.jpg" 
  width=128></A> <A><IMG border=2 src="../images/14052.jpg" 
width=128></A></LI>
  <LI class="wd-border imgborder"><A><IMG border=2 src="../images/14054.jpg" 
  width=128></A> <A><IMG border=2 src="../images/14053.jpg" width=128></A></LI>
</UL>
</DIV>
</DIV>
</DIV>
<DIV class="footer">
<DIV id=link>友情链接：<?php
	$sql="select * from piclink_class where BigClass<>'" . "' order by paixu asc";
	//$result=mysql_db_query($dbname,$sql);
	mysql_select_db($dbname);
	$result=mysql_query($sql);
	while($rs=mysql_fetch_array($result))
		{
			$link=$rs["linkurl"];
		?>
	<A href="<?php echo $link;?>" target="_blank"><?php echo $rs["BigClass"];?></A>
	<?php
		}
	?>
</DIV>
</DIV>
<?php
include("footer.php");
?>
</BODY>
</HTML>
