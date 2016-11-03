<?php
//���ù������·��
$root_path="../";
if(file_exists("$root_path/pay/alipayconfig.php")){	  
	require_once("$root_path/pay/alipayconfig.php");
}

//�޸�����
if(isset($_POST['mod']) && isset($_POST['submit'])){
	
	$content = '<?' ."php\n";
	$payok=$_POST['payok'];
	$partner=$_POST['partner'];
	$key=$_POST['key'];
	$seller_email=$_POST['seller_email'];	
	$content .= "\$payok   = \"$payok\";\n\n";
	if(!empty($partner)){
		 $content .= "\$partner   = \"$partner\";\n\n";
	}
	if(!empty($key)){
		 $content .= "\$key   = \"$key\";\n\n";
	} 
	if(!empty($seller_email)){
		 $content .= "\$seller_email   = \"$seller_email\";\n\n";
	} 	
    $content .= '?>';
	if(empty($payok) && empty($partner) && empty($seller_email) && empty($key)){
		echo "<script>alert('û������ȫ����Ϣ��');</script>";
	}else{
		$fp = @fopen('../pay/alipayconfig.php', 'wb+');
		if (!$fp)
		{
			echo "<script>alert('�ļ������ڣ�');</script>";
		}
		if (!@fwrite($fp, trim($content)))
		{
		  echo "<script>alert('�ļ�д��ʧ�ܣ������linuxϵͳ���� alipay/alipayconfig.php ��Ϊ777��');</script>";
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
<div class="title">֧�������� �������ſ���֧��,���id,�뵽֧������˾���̼ҷ��������뼴ʱ֧��</div>

</div>
<div class="list">
<form id="form1" name="form1" method="post"action="alipay.php">
<table class="tablelist" cellpadding=0 cellspacing=0 width=100% class="role_table" >
<tr>
	<td class="tRight" width="160" >֧�����Ƿ�����</td>
<td  class="tLeft" > <input name="payok" type="text" size="50" value="<?echo $payok?>"/>1Ϊ����0Ϊ�ر� </td>
</tr>
<tr>
	<td class="tRight" width="160">���������ID</td>
	<td  class="tLeft" > <input type="text" name="partner" size="50"  value="<?echo $partner?>"/> </td>
</tr>
<tr>
	<td class="tRight" width="160">��ȫ������</td>
	<td  class="tLeft" > <input name="key" type="text" size="50" value="<?echo $key?>"/> </td>
</tr>
<tr>
	<td class="tRight" width="160">ǩԼ֧�����˺Ż�֧�����ʻ�</td>
	<td  class="tLeft" > <input type="text" name="seller_email"  size="50"  value="<?echo $seller_email?>"/> </td>
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
