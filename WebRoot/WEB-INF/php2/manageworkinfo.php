<?php
include ("../include/config.php");
include ("checkuser.php");
include ("../include/function.php");
?>

<?php
$titleID=$_REQUEST["titleID"];


/*-----------------接收相关数据值---------------------*/
$Page=@$_REQUEST["Page"];
$skey=@$_REQUEST["skey"];
$key=@$_REQUEST["key"];
/*-----------------设置每页显示数目-------------------*/
$List_Num=10;
/*-----------------计算共有记录数--------------------*/
if($key=="")
{
$sqlN="select Count(*) from ".$titleID."_info";
}
else
{
$sqlN="select Count(*) from ".$titleID."_info where ".$skey." like '%".$key."%'";
}
//$resultN=mysql_db_query($dbname,$sqlN);
mysql_select_db($dbname);
$resultN=mysql_query($sqlN);
$rsN=mysql_fetch_array($resultN);
$Num=$rsN[0];

/*------------------计算共有页数--------------------*/
$CountPage=ceil($Num/$List_Num);
/*-------------------设置当道页--------------------*/
$Cpage=$Page+1;
/*--------------------------------------------------*/

if($key=="")
{
$sql="select * from ".$titleID."_info order by ID desc limit ".($List_Num*$Page).",".$List_Num."";
}
else
{
$sql="select * from ".$titleID."_info where ".$skey." like '%".$key."%' order by ID desc limit ".($List_Num*$Page).",".$List_Num."";
}
//$result=mysql_db_query($dbname,$sql);
mysql_select_db($dbname);
$result=mysql_query($sql);
?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" >
<head runat="server">
<title>后台管理</title>   </title> <LINK rel=stylesheet type=text/css href="../css/style2.css">    
<LINK rel=stylesheet type=text/css href="../css/select.css">
<SCRIPT language=javascript type=text/javascript src="../css/j_dialog.js"></SCRIPT>  
<SCRIPT language=javascript type=text/javascript src="../css/jquery.js"></SCRIPT> 

<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link rel="stylesheet" href="skin/css/base.css" type="text/css" />
</head>
<body>
<table class="tablelist" width="98%" border="0" align="center" cellpadding="4" cellspacing="1" bgcolor="#CBD8AC">
  <tr>
    <td height="28" align="center" background="skin/images/frame/wbg.gif" class='title'>&nbsp;&nbsp;<strong>信息管理</strong></td>
  </tr>
  <tr>
    <td height="49" bgcolor="#FFFFFF"><form id="myform" name="myform" method="post" action="saveworkinfo.php?action=del&amp;titleID=<?php echo $titleID;?>">
      <table class="tablelist" width="100%" height="49" border="0" cellpadding="0" cellspacing="1">
        <tr>
          <td height="47" valign="top" bgcolor="#FFFFFF"><?php
		 if (mysql_num_rows($result)==NULL)
		 {
		   echo "<br><table class="tablelist" width=750 border=0 align=center cellpadding=0 cellspacing=0><tr>
                 <td align=center><span class=rd rd>还没有添加数据！</span></td></tr></table>";
		 }
       
		 else
		 {
		?>
                <table class="tablelist" class="tableBorder" width="100%" border="0" align="center" cellpadding="1" cellspacing="1" bgcolor="#FFFFFF">
                  <tr align="center" bgcolor="#F8F8F8" >
                    <td width="5%" bgcolor="#FFFFFF">序号</td>
					<td width="13%" bgcolor="#FFFFFF">订单号</td>
                    <td bgcolor="#FFFFFF">信息标题</td>
					<td width="35%" bgcolor="#FFFFFF">问题内容</td>
                    <td width="13%" bgcolor="#FFFFFF">提交时间</td>
                    <td width="5%" bgcolor="#FFFFFF">编辑</td>
                    <td width="7%" bgcolor="#FFFFFF">选择</td>
                  </tr>
                  <?php
				$i=1;
			  while($rs=mysql_fetch_array($result))
			  {
			  ?>
                  <tr>
                    <td height="30" align="center" bgcolor="#FFFFFF"><?php echo $Cpage;?>-<?php echo $i;?></td>
					<td align="center" bgcolor="#FFFFFF"><?php echo $rs["order_id"];?></td>
                    <td bgcolor="#FFFFFF" style="padding-left:15px"><?php echo $newsOB->utfSubstr($rs["title"],0,93);?></td>
					<td align="center"><?php echo $newsOB->utfSubstr($rs["content"],0,93);?></td>
                    <td align="center">[<?php echo $rs["data"];?>]</td>
                    <td align="center" bgcolor="#FFFFFF"><a href="editworkinfo.php?ID=<?php echo $rs["ID"];?>&amp;class_id=<?php echo $rs["class_id"];?>&amp;titleID=<?php echo $titleID;?>">回复</a></td>
                    <td align="center" bgcolor="#FFFFFF"><input name="ID[]" type="checkbox" id="ID[]" value="<?php echo $rs["ID"]?>" /></td>
                  </tr>
                  <?php
				$i=$i+1;
			  }
			  ?>
                  <tr align="center" >
                    <td colspan="7" align="right" bgcolor="#FFFFFF"><table class="tablelist" width="100%" border="0" cellspacing="0" cellpadding="2">
                        <tr>
                          <td width="87%" height="35" align="right"><?php
					  if($Page!=0)
					  {
					  $Prv=$Page-1;
					  echo "<a href=manageworkinfo.php?skey=".$skey."&key=".$key."&titleID=".$titleID.">首页&nbsp;&nbsp;</a>";
					  echo "<a href=manageworkinfo.php?Page=".$Prv."&skey=".$skey."&key=".$key."&titleID=".$titleID.">上一页&nbsp;</a>";
					  }
					  else
					  {
					   echo "首页&nbsp;&nbsp;";
					   echo "上一页&nbsp;";
					  }
					  if($Page!=$CountPage-1)
					  {
					  $NtPage=$Page+1;
					  $EdPage=$CountPage-1;
					  echo "<a href=manageworkinfo.php?Page=".$NtPage."&skey=".$skey."&key=".$key."&titleID=".$titleID.">下一页</a>&nbsp;&nbsp;";
					  echo "<a href=manageworkinfo.php?Page=".$EdPage."&skey=".$skey."&key=".$key."&titleID=".$titleID.">尾页&nbsp;</a>";
					  }
					  else
					  {
					   echo "下一页&nbsp;&nbsp;";
					   echo "尾页&nbsp;";
					  }
					  echo "当前为".$Cpage."/".$CountPage."页 每页显示".$List_Num."条记录 共有记录数".$Num."条记录";
					  ?>                          </td>
                          <td width="13%" align="right"><a href="#" onclick="mm();">全选</a>
                              <input type="checkbox" name="checkbox" value="Check All" onclick="mm();" />
                              <input type="submit" name="Submit" value="删 除" onclick="return test();" /></td>
                        </tr>
                    </table></td>
                  </tr>
                </table>
            <?php
			}
			?>
          </td>
        </tr>
      </table>
    </form></td>
  </tr>
</table>
<br />
<table class="tablelist" width="98%" border="0" align="center" cellpadding="4" cellspacing="1" bgcolor="#CBD8AC">
  <tr>
    <td height="28" align="center" background="skin/images/frame/wbg.gif" class='title'>&nbsp;<strong>信息搜索</strong></td>
  </tr>
  <tr>
    <td height="49" bgcolor="#FFFFFF"><form id="myform2" name="myform1" method="post" action="manageworkinfo.php?titleID=<?php echo $titleID;?>" onsubmit="return checkSo();">
      <table class="tablelist" class="tableBorder" width="100%" border="0" align="center" cellpadding="1" cellspacing="1" bgcolor="#FFFFFF">
        <tr align="center" >
          <td width="100%" bgcolor="#FFFFFF"><table class="tablelist" width="598" border='0' cellpadding='0' cellspacing='0'>
            <tr>
              <td width='89' align='center'>搜索条件：</td>
              <td width='143'><select name='skey' id="skey" style='width:150'>
                <option value='0'>选择类型...</option>
                <option value="title">信息标题</option>
                <option value="content">内容信息</option>
              </select>
              </td>
              <td width='90'> 搜索关键字： </td>
              <td width='210'><input name='key' type='text' id="key" style='width:150px' value='' />
              </td>
              <td width='66' align="left"><input type="submit" name="Submit2" value="查询"/></td>
            </tr>
          </table></td>
        </tr>
        <tr align="center" >
          <td bgcolor="#FFFFFF"><span class="red">*搜索相关数据时，如果搜索条件未选择，将搜索所有的数据!</span></td>
        </tr>
      </table>
    </form></td>
  </tr>
</table>
<br />
<?php
include ("footx.php");
?>
</body>
</html>
<script language="javascript" src="comm_js/javascriptTxt.js"></script>
<script language="javascript">
	function CheckForm()
	{
		if(!checkLength("BigClass1" , "新闻类别" , 2 , 15 , "~!@#$%^&*+=\\\'\"\<\>"))
			return false;
		if(!checkLength("classidorder1" , "新闻类别序号" , 1 , 15 , "&<>\'"))
			return false;
	}
	function CheckForm1()
	{
		if(!checkLength("BigClass" , "新闻类别" , 2 , 15 , "~!@#$%^&*+=\\\'\"\<\>"))
			return false;
		if(!checkLength("classidorder" , "新闻类别序号" , 1 , 15 , "&<>\'"))
			return false;
	}
</script>
<SCRIPT language=JScript>
function check(){
if(document.myform.ID[].value==""){
document.myform.ID[].focus();
alert("请选择!");
return false;
}
</SCRIPT>
