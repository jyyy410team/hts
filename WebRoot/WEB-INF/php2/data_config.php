<?php
# Name: PHP��MySQL��ݿ�־?�ݹ���
# Author: �껪<nianhua.liu@gmail.com> [QQ:4908220]
# Homepage:http://master8.net/
include ("../include/db.php");
$db_pconnect = 1;			//�Ƿ����ó־�����
$db_charset = 'gb2312';		//��ݿ��ַ�(����ֵΪGBK��UFT8��...MySQL�汾4.1��������������)
$pws = '';					//����Ա��½����
$deletetable = 0;			//�Ƿ��������ɾ��?��Σ�գ�Ĭ�Ͻ�ֹ
$runsql = 0;				//�Ƿ�����ִ��SQL��䣬��Σ�գ���������Ҫʱ������Ĭ�Ͻ�ֹ
$uploadsql = 1;				//�Ƿ������ϴ�SQL�ļ�����Σ�գ���������Ҫʱ������Ĭ�Ͻ�ֹ
?>
