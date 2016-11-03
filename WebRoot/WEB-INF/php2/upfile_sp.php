<?php
$uptypes=array('image/jpg',   //�ϴ��ļ������б�
'image/jpeg',
'image/png',
'image/pjpeg',
'image/gif',
'image/bmp',
'video/avi',
'video/x-ms-wmv',
'application/vnd.rn-realmedia',
'application/octet-stream',
'application/x-shockwave-flash',
'image/x-png'); 

$max_file_size=5000000;    //�ϴ��ļ���С����, ��λBYTE
$dizhi_r=$_REQUEST["dizhi_r"];
$destination_folder="../Uppic/".$dizhi_r."/"; //�ϴ��ļ�·��
$watermark=0;    //�Ƿ񸽼�ˮӡ(1Ϊ��ˮӡ,����Ϊ����ˮӡ);
$watertype=1;    //ˮӡ����(1Ϊ����,2ΪͼƬ)
$waterposition=1;    //ˮӡλ��(1Ϊ���½�,2Ϊ���½�,3Ϊ���Ͻ�,4Ϊ���Ͻ�,5Ϊ����);
$waterstring="newphp.site.cz"; //ˮӡ�ַ�
$waterimg="xplore.gif";   //ˮӡͼƬ
$imgpreview=1;    //�Ƿ����Ԥ��ͼ(1Ϊ���,����Ϊ�����);
$imgpreviewsize=1/2;   //����ͼ����
?>
<html>
<head>
<title>M4U BLOG - fywyj.cn</title>   </title> <LINK rel=stylesheet type=text/css href="../css/style2.css">    
<LINK rel=stylesheet type=text/css href="../css/select.css">
<SCRIPT language=javascript type=text/javascript src="../css/j_dialog.js"></SCRIPT>  
<SCRIPT language=javascript type=text/javascript src="../css/jquery.js"></SCRIPT> 

<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<style type="text/css">body,td{font-family:tahoma,verdana,arial;font-size:11px;line-height:15px;background-color:white;color:#666666;margin-left:20px;} 
strong{font-size:12px;}
a:link{color:#0066CC;}
a:hover{color:#FF6600;}
a:visited{color:#003366;}
a:active{color:#9DCC00;}
table.itable{}
td.irows{height:20px;background:url("index.php?i=dots") repeat-x bottom}</style>
</head>
<body>
<center><form enctype="multipart/form-data" method="post" name="upform">
�ϴ��ļ�: <br><br><br>
<?php
if ($_SERVER['REQUEST_METHOD'] == 'POST')
{
if (!is_uploaded_file($_FILES["upfile"][tmp_name]))
//�Ƿ�����ļ�
{ 
echo "<font color='red'>�ļ������ڣ�</font>";
exit;
}

$file = $_FILES["upfile"];
if($max_file_size < $file["size"])
//����ļ���С
{
echo "<font color='red'>�ļ�̫��</font>";
exit;
   }

if(!in_array($file["type"], $uptypes))
//����ļ�����
{
echo "<font color='red'>ֻ���ϴ�ͼ���ļ���Flash��</font>";
exit; 
}

if(!file_exists($destination_folder))
mkdir($destination_folder);

$filename=$file["tmp_name"];
$image_size = getimagesize($filename); 
$pinfo=pathinfo($file["name"]);
$ftype=$pinfo[extension];
$destination = $destination_folder.time().".".$ftype;
if (file_exists($destination) && $overwrite != true) 
{
      echo "<font color='red'>ͬ���ļ��Ѿ������ˣ�</a>";
      exit;
   }

if(!move_uploaded_file ($filename, $destination))
{
    echo "<font color='red'>�ƶ��ļ����?</a>";
      exit;
   }

$pinfo=pathinfo($destination);
$fname=$pinfo[basename];
echo " <font color=red>�Ѿ��ɹ��ϴ�</font><br>�ļ���: <font color=blue>".$destination_folder.$fname."</font><br>";
echo " ���:".$image_size[0];
echo " ����:".$image_size[1];
if($watermark==1)
{
$iinfo=getimagesize($destination,$iinfo);
$nimage=imagecreatetruecolor($image_size[0],$image_size[1]);
$white=imagecolorallocate($nimage,255,255,255);
$black=imagecolorallocate($nimage,0,0,0);
$red=imagecolorallocate($nimage,255,0,0);
imagefill($nimage,0,0,$white); 
switch ($iinfo[2])
{
case 1:
$simage =imagecreatefromgif($destination);
break;
case 2:
$simage =imagecreatefromjpeg($destination);
break;
case 3:
$simage =imagecreatefrompng($destination);
break;
case 6:
$simage =imagecreatefromwbmp($destination);
break;
default:
die("<font color='red'>�����ϴ��������ļ���</a>");
exit;
}

imagecopy($nimage,$simage,0,0,0,0,$image_size[0],$image_size[1]);
imagefilledrectangle($nimage,1,$image_size[1]-15,80,$image_size[1],$white);

switch($watertype)
{
case 1:   //��ˮӡ�ַ�
imagestring($nimage,2,3,$image_size[1]-15,$waterstring,$black);
break;
case 2:   //��ˮӡͼƬ
$simage1 =imagecreatefromgif("xplore.gif");
imagecopy($nimage,$simage1,0,0,0,0,85,15);
imagedestroy($simage1);
break;
} 

switch ($iinfo[2])
{
case 1:
//imagegif($nimage, $destination); 


imagejpeg($nimage, $destination);
break;
case 2:
imagejpeg($nimage, $destination);
break;
case 3:
imagepng($nimage, $destination);
break;
case 6:
imagewbmp($nimage, $destination);
//imagejpeg($nimage, $destination);
break;
}

//����ԭ�ϴ��ļ�
imagedestroy($nimage);
imagedestroy($simage);
}

if($imgpreview==1)
{
echo "<br>ͼƬԤ��:<br>";
echo "<a href=\"".$destination."\" target='_blank'><img src=\"".$destination."\" width=".($image_size[0]*$imgpreviewsize)." height=".($image_size[1]*$imgpreviewsize);
echo " alt=\"ͼƬԤ��:\r�ļ���:".$destination."\r�ϴ�ʱ��:\" border='0'></a>";
echo "<script>window.opener.document.form1.video.value='".$destination."'</script>";
echo "<script>alert('�ϴ��ɹ�');window.close();</script>";

}
}
?>
 <input name="upfile" type="file"   style="width:200;border:1 solid #9a9999; font-size:9pt; background-color:#ffffff" size="17">
<input type="submit" value="�ϴ�" style="width:30;border:1 solid #9a9999; font-size:9pt; background-color:#ffffff" size="17"><br>
</form> 

</center>
</body>
</html> 
