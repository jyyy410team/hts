<?
//��������
require_once("../pay/payconfig.php");
//****************************************	//MD5��ԿҪ�������ύҳ��ͬ����Send.asp��� key = "test" ,�޸�""���� test Ϊ������Կ
											//�������û������MD5��Կ���½����Ϊ���ṩ�̻���̨����ַ��https://merchant3.chinabank.com.cn/
	$key=$bkey;							//��½��������ĵ�����������ҵ���B2C�����ڶ������������С�MD5��Կ���á�
											//����������һ��16λ���ϵ���Կ����ߣ���Կ���64λ��������16λ�Ѿ��㹻��
//****************************************

$v_oid     =trim($_POST['v_oid']);      
$v_pmode   =trim($_POST['v_pmode']);      
$v_pstatus =trim($_POST['v_pstatus']);      
$v_pstring =trim($_POST['v_pstring']);      
$v_amount  =trim($_POST['v_amount']);     
$v_moneytype  =trim($_POST['v_moneytype']);     
$remark1   =trim($_POST['remark1' ]);     
$remark2   =trim($_POST['remark2' ]);     
$v_md5str  =trim($_POST['v_md5str' ]);     
/**
 * ���¼���md5��ֵ
 */
                           
$md5string=strtoupper(md5($v_oid.$v_pstatus.$v_amount.$v_moneytype.$key)); //ƴ�ռ��ܴ�
if ($v_md5str==$md5string)
{
	
   if($v_pstatus=="20")
	{
	   //֧���ɹ�
	   //�̻�ϵͳ���߼����������жϽ��ж�֧��״̬(20�ɹ�,30ʧ��),���¶���״̬�ȵȣ�......
	   //�������ݿ�����
		include ("../include/config.php");
		include ("../include/function.php");
		$VipUser=$_COOKIE["VipUser"];
		$flag=1;
		$data=date("Y-m-d h:i:s");
	    $sqlc="select * from caiwu where order_id='".$v_oid."'";
	    $resultc=mysql_db_query($dbname,$sqlc);
	    $rsc=mysql_fetch_array($resultc);
		if($rsc==NULL)
		{
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
		}
		
	}
  echo "ok";
	
}else{
	echo "error";
}
?>