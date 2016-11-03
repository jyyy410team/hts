package com.jeecms.until;

import java.io.UnsupportedEncodingException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;

import org.springframework.jdbc.core.JdbcTemplate;

import com.sun.org.apache.bcel.internal.generic.NEW;

public class Test2
{
    
    
public static void main(String[] args) throws UnsupportedEncodingException {
   try {
    //InetAddress inetAddress = InetAddress.getLocalHost();
       //System.out.println(inetAddress.getHostName());
     //  System.out.println(inetAddress.getHostAddress());
  // byte[] hello = inetAddress.getAddress();
 //  System.out.println(new String(hello));
    //   System.out.println(Arrays.toString(hello));
    //   System.out.println(inetAddress);//计算机名字和ip地址
    //   System.out.println(inetAddress.getByAddress(addr));
       
       //可以根据主机名和ip地址获取inetaddress
      InetAddress dAddress = InetAddress.getByName("10.200.104.198");
       System.out.println(dAddress);//计算机名字和ip地址
}
catch (UnknownHostException e) {
    // TODO Auto-generated catch block
    e.printStackTrace();
}
}
}
