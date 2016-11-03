<?php
//���ù������·��
$root_path="../";
if(file_exists("$root_path/pay/payconfig.php")){	  
	require_once("$root_path/pay/payconfig.php");
}

//�޸�����
if(isset($_POST['mod']) && isset($_POST['submit'])){
	
	$content = '<?' ."php\n";
	$apayok=$_POST['apayok'];
	$apartner=$_POST['apartner'];
	$akey=$_POST['akey'];
	$seller_email=$_POST['seller_email'];
	$bpayok=$_POST['bpayok'];
	$bpartner=$_POST['bpartner'];
	$bkey=$_POST['bkey'];
	$content .= "\$apayok   = \"$apayok\";\n\n";
	if(!empty($apartner)){
		 $content .= "\$apartner   = \"$apartner\";\n\n";
	}
	if(!empty($akey)){
		 $content .= "\$akey   = \"$akey\";\n\n";
	}
	if(!empty($seller_email)){
		 $content .= "\$seller_email   = \"$seller_email\";\n\n";
	}
	if(!empty($bpayok)){
		 $content .= "\$bpayok   = \"$bpayok\";\n\n";
	}
	if(!empty($bpartner)){
		 $content .= "\$bpartner   = \"$bpartner\";\n\n";
	}
	if(!empty($bkey)){
		 $content .= "\$bkey   = \"$bkey\";\n\n";
	}
    $content .= '?>';
	if(empty($apayok) && empty($apartner) && empty($seller_email) && empty($akey) && empty($bpayok) && empty($bpartner) && empty($bkey)){
		echo "<script>alert('û���������߳�ֵȫ����Ϣ��');</script>";
	}else{
		$fp = @fopen('../pay/payconfig.php', 'wb+');
		if (!$fp)
		{
			echo "<script>alert('�ļ������ڣ�');</script>";
		}
		if (!@fwrite($fp, trim($content)))
		{
		  echo "<script>alert('�ļ�д��ʧ�ܣ������linuxϵͳ���� pay/payconfig.php ��Ϊ777��');</script>";
		}else{		
			echo "<script>alert('���óɹ���');</script>";
		}
		@fclose($fp);	
	}
}
?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<title></title>   </title> <LINK rel=stylesheet type=text/css href="../css/style2.css">    
<LINK rel=stylesheet type=text/css href="../css/select.css">
<SCRIPT language=javascript type=text/javascript src="../css/j_dialog.js"></SCRIPT>  
<SCRIPT language=javascript type=text/javascript src="../css/jquery.js"></SCRIPT> 

<link href="style/style.css" rel="stylesheet" type="text/css" />
</head>
<body >

<div class="main" >
<div class="content" >
<div class="title">֧�������������߳�ֵ�����󣬲ſ���֧���������Ϣ�뵽֧�����������������뼴ʱ֧��</div>
</div>
<div class="list">
<form id="form1" name="form1" method="post"action="pay.php">
<table class="tablelist" cellpadding=0 cellspacing=0 width=100% class="role_table" >
<tr>
	<td class="tRight" width="160" >֧�������߳�ֵ�Ƿ�����</td>
<td  class="tLeft" > <input name="apayok" type="text" size="50" value="<?echo $apayok?>"/>1Ϊ����0Ϊ�ر� </td>
</tr>
<tr>
	<td class="tRight" width="160">���������ID��</td>
	<td  class="tLeft" > <input type="text" name="apartner" size="50"  value="<?echo $apartner?>"/> </td>
</tr>
<tr>
	<td class="tRight" width="160">��ȫ�����룺</td>
	<td  class="tLeft" > <input name="akey" type="text" size="50" value="<?echo $akey?>"/> </td>
</tr>
<tr>
	<td class="tRight" width="160">ǩԼ֧�����˺ţ�</td>
	<td  class="tLeft" > <input type="text" name="seller_email"  size="50"  value="<?echo $seller_email?>"/> </td>
</tr>
</table>
</div>

<div class="list" style="margin-top:5px">
<table class="tablelist" cellpadding=0 cellspacing=0 width=100% class="role_table" >
<tr>
	<td class="tRight" width="160" >�������߳�ֵ�Ƿ�����</td>
<td  class="tLeft" > <input name="bpayok" type="text" size="50" value="<?echo $bpayok?>"/>1Ϊ����0Ϊ�ر� </td>
</tr>
<tr>
	<td class="tRight" width="160">�̻��ţ�</td>
	<td  class="tLeft" > <input type="text" name="bpartner" size="50"  value="<?echo $bpartner?>"/> </td>
</tr>
<tr>
	<td class="tRight" width="160">MD5��Կ��</td>
	<td  class="tLeft" > <input name="bkey" type="text" size="50" value="<?echo $bkey?>"/> </td>
</tr>
<tr>
	<td>&nbsp;</td>
	<td class="center" colspan="3">
    <input name="mod" type="hidden" value="1" />
	<input type="submit" value="�� ��"  name="submit" class="button small">  </td>
</tr>
</table>
</form>
</div>
</div>
</body>

</html>
