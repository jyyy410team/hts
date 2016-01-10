package 测试包;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.UnknownHostException;

public class MyTest {

	/**
	 * @author jinyy
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) {
		/*File file = new File(
				"D:\\Workspaces\\jyyworkspace\\hello3\\src\\测试包\\hello.txt");
		file.getName();

		try {
			FileInputStream fileInputStream = new FileInputStream(file);
			byte[] b = new byte[1024];
			int length = fileInputStream.read(b);

			System.out.println(new String(b, 0, length));
			fileInputStream.close();
		} catch (Exception e) {
		}*/ // 
		InetAddress inetAddress =null;
		
		try {
			/*inetAddress=InetAddress.getLocalHost();
			
			String name= inetAddress.getHostName();//本机名字
			String add=inetAddress.getHostAddress();//本地地址
			System.out.println("name :"+name);
			System.out.println("add :"+add);*/
			
			
			ServerSocket serverSocket = new ServerSocket(1212);
			System.out.println("等待");
			serverSocket.accept();
			System.out.println("成功");
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		/*
		 * 
		*/
	}

}
