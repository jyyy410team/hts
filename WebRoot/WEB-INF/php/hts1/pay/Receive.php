<!--  
 * ====================================================================
 *
 *                 Receive.php ���������߼���֧���ṩ
 *
 *     ��ҳ��Ϊ֧����ɺ��ȡ���صĲ���������......
 *
 *
 * ====================================================================
-->
<?
//��������
require_once("../pay/payconfig.php");
//****************************************	//MD5��ԿҪ�������ύҳ��ͬ����Send.asp��� key = "test" ,�޸�""���� test Ϊ������Կ
											//�������û������MD5��Կ���½����Ϊ���ṩ�̻���̨����ַ��https://merchant3.chinabank.com.cn/
	$key=$bkey;							//��½��������ĵ�����������ҵ���B2C�����ڶ������������С�MD5��Կ���á�
											//����������һ��16λ���ϵ���Կ����ߣ���Կ���64λ��������16λ�Ѿ��㹻��
//****************************************
	
$v_oid     =trim($_POST['v_oid']);       // �̻����͵�v_oid�������   
$v_pmode   =trim($_POST['v_pmode']);    // ֧����ʽ���ַ�����   
$v_pstatus =trim($_POST['v_pstatus']);   //  ֧��״̬ ��20��֧���ɹ�����30��֧��ʧ�ܣ�
$v_pstring =trim($_POST['v_pstring']);   // ֧�������Ϣ �� ֧����ɣ���v_pstatus=20ʱ����ʧ��ԭ�򣨵�v_pstatus=30ʱ,�ַ������� 
$v_amount  =trim($_POST['v_amount']);     // ����ʵ��֧�����
$v_moneytype  =trim($_POST['v_moneytype']); //����ʵ��֧������    
$remark1   =trim($_POST['remark1' ]);      //��ע�ֶ�1
$remark2   =trim($_POST['remark2' ]);     //��ע�ֶ�2
$v_md5str  =trim($_POST['v_md5str' ]);   //ƴ�պ��MD5У��ֵ  

/**
 * ���¼���md5��ֵ
 */
                           
$md5string=strtoupper(md5($v_oid.$v_pstatus.$v_amount.$v_moneytype.$key));

/**
 * �жϷ�����Ϣ�����֧���ɹ�������֧��������ţ�������һ���Ĵ���
 */


if ($v_md5str==$md5string)
{
	if($v_pstatus=="20")
	{
		//֧���ɹ����ɽ����߼�����
		//�̻�ϵͳ���߼����������жϽ��ж�֧��״̬�����¶���״̬�ȵȣ�......
		//���涩����Ϣ���Լ������ʽ���
		//�������ݿ�����
		include ("../include/config.php");
		include ("../include/function.php");
		$VipUser=$_COOKIE["VipUser"];
		$flag=1;
		$data=date("Y-m-d h:i:s");
		$sqls="select * from user where VipUser='".$VipUser."'";
		$results=mysql_db_query($dbname,$sqls);
		$rss=mysql_fetch_array($results);
		if($rss!=NULL)
		{
			$sql="insert into caiwu (order_id,VipUser,operator,leixing,jine,flag,data) values ('".$v_oid."','".$VipUser."','".$VipUser."','".$remark1."',".$v_amount.",".$flag.",'".$data."')";
			mysql_db_query($dbname,$sql);

			$yue=$rss["yue"]+$v_amount;
			$sqlu="update user set yue=".$yue." where VipUser='".$VipUser."'";
			mysql_db_query($dbname,$sqlu);
			echo "<script>alert('��ֵ�ɹ���');location.href='../user/right.php';</script>";
		}
		else{
			echo "<script>alert('��ֵ�쳣������վ����ϵ��');location.href='../user/right.php';</script>";
		}

	}else{
		echo "֧��ʧ��";
	}
	?>
	<html>
	<body>
	<TABLE width=500 border=0 align="center" cellPadding=0 cellSpacing=0>
		  <TBODY>
			<TR> 
			  <TD vAlign=top align=middle> <div align="left"><B><FONT style="FONT-SIZE:14px">MD5У����:<? echo $v_md5str?></FONT></B></div></TD>
			</TR>
			<TR> 
			  <TD vAlign=top align=middle> <div align="left"><B><FONT style="FONT-SIZE: 14px">������:<? echo $v_oid?></FONT></B></div></TD>
			</TR>
			<TR> 
			  <TD vAlign=top align=middle> <div align="left"><B><FONT style="FONT-SIZE: 14px">֧������:<? echo $v_pmode?></FONT></B></div></TD>
			</TR>
			<TR> 
			  <TD vAlign=top align=middle> <div align="left"><B><FONT style="FONT-SIZE: 14px">֧�����:<? echo $v_pstring?></FONT></B></div></TD>
			</TR>
			<TR> 
			  <TD vAlign=top align=middle> <div align="left"><B><FONT style="FONT-SIZE: 14px">֧�����:<? echo $v_amount?></FONT></B></div></TD>
			</TR>
			<TR> 
			  <TD vAlign=top align=middle> <div align="left"><B><FONT style="FONT-SIZE: 14px">֧������:<? echo $v_moneytype?></FONT></B></div></TD>
			</TR>
		  </TBODY>
		</TABLE>
		<?

}else{
	echo "<br>У��ʧ��,���ݿ���";
}
?>
</BODY>
</HTML>