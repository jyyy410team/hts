import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;


public class Test {
 
         private String sourceStr1 = "/hqapp/tcm/3/attachments/paper";        
         private String replaceStr1 = "www.hq.unicom.local/tcm_unicom/tcm_unicom/3/attachments/paper";
        
         private String sourceStr2 = "http://www.unicom.local/tcm/3/ewebeditor/uploadfile";       
         private String replaceStr2 = "http://www.unicom.local/tcm_unicom/3/ewebeditor/uploadfile";
        
         private String sourceStr3 = "http://www.unicom.local/tcm/ewebeditor/uploadfile";  
         private String replaceStr3 = "http://www.unicom.local/tcm_unicom/3/ewebeditor/uploadfile";
        
         /**
          * 修改目录下的.html文件
          * @param filePath 读取文件路径
          * @param prefix 文件前缀
          * @param savePath 文件保存路径
          */
         public void modifyFileInDirectory(String filePath, String savePath, String prefix) {
                   List list = readFileInDirectory(filePath, prefix);
                   try {
                            for(int i=0; i<list.size(); i++) {
                                     readFile(filePath +"\\"+ list.get(i), savePath+"\\" + list.get(i));
                                     System.out.println("读取了第" + (i+1) + "个文件，文件路径：" + filePath +"\\"+ list.get(i));
                            }
                   } catch (Exception e) {
                            e.printStackTrace();
                   }
         }       
        
         /**
          * 读取文件并替换其中的路径，然后保存文件
          * @param filePath 读取文件路径
          * @param savePath 保存文件路径
          */
         public void readFile(String filePath, String savePath) {
                   BufferedReader br = null;
                   BufferedWriter bw = null;
                   /**
                    * \="    \=\  .replaceAll("<table", "<table class=\"tablelist\"")
                    */
                   String tString="</title> <LINK rel=stylesheet type=text/css href=\"../css/style2.css\">    " + "\r\n"+
                   		"<LINK rel=stylesheet type=text/css href=\"../css/select.css\">" +"\r\n"+
                   		"<SCRIPT language=javascript type=text/javascript src=\"../css/j_dialog.js\"></SCRIPT>  " +"\r\n"+
                   		"<SCRIPT language=javascript type=text/javascript src=\"../css/jquery.js\"></SCRIPT> "+"\r\n";
                   String content = "";
                   try {
                            br = new BufferedReader(new FileReader(filePath));
                            bw = new BufferedWriter(new FileWriter(savePath));
                            String line;
                            while((line = br.readLine()) != null && (line != "")) {
                                     content = line  +"\r\n";
                                     bw.write(content.replaceAll("</TITLE>", "</title>   ").replace("<TABLE", "<table").replaceAll("</title>", "</title>   "+tString).replaceAll("<table", "<table class=\"tablelist\"").replace("<?phpinclude", "<?php include").replace("css/style.css", "").replace("bgColor=#e2e2e2", ""));
                            }
                            bw.flush();
                   } catch (Exception e) {
                            e.printStackTrace();
                   } finally {
                            try {
                                     if(br != null) br.close();
                                     if(bw != null) bw.close();
                            } catch (Exception e) {
                                     e.printStackTrace();
                            }
                   }
         }
        
 
         /**
          * 遍历某目录下的所有.html文件
          * @param filePath
          * @param prefix
          * @return html文件名数组
          */
         public List readFileInDirectory(String filePath, String prefix) {
                   File fileDir = new File(filePath);
                   File[] files = fileDir.listFiles();
                   List list = new ArrayList();
                   for(int i=0; i<files.length; i++) {
                            if(files[i].getName().endsWith(prefix)) {
                                     list.add(files[i].getName());
                            }
                   }
                   return list;
         }
                  
         /**
          * 测试方法
          */
         public static void main(String[] args) {
                   Test readFile = new Test();
                   readFile.modifyFileInDirectory("C:\\Users\\Administrator\\git\\hts\\WebRoot\\WEB-INF\\php0\\admin", "C:\\Users\\Administrator\\git\\hts\\WebRoot\\WEB-INF\\php2", ".php");
         }
}
