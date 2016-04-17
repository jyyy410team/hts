package com.jeecms.until;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

public class Test {  
    public static void main(String[] args) throws IOException, TemplateException {  
  
        //1.创建配置实例Cofiguration  
        Configuration cfg = new Configuration();  
  
        //2.设置模板文件目录  
        //（1）src目录下的目录（template在src下）  
        //cfg.setDirectoryForTemplateLoading(new File("src/template"));  
        //（2）完整路径（template在src下）  
        //cfg.setDirectoryForTemplateLoading(new File(  
        //      "D:/cpic-env/workspace/javaFreemarker/src/template"));  
        //cfg.setDirectoryForTemplateLoading(new File("src/template"));  
        //（3）工程目录下的目录（template/main在工程下）--推荐  
        cfg.setDirectoryForTemplateLoading(new File("template"));  
        //cfg.setObjectWrapper(new DefaultObjectWrapper());  
        //获取模板（template）  
        Template template = cfg.getTemplate("hello.ftl");  
        //建立数据模型（Map）  
        Map<String, String> root = new HashMap<String, String>();  
        root.put("name", "cxl");  
        root.put("age", "25");  
        //获取输出流（指定到控制台（标准输出））  
        
        File file = new File("template/hello.html");
            if (!file.exists()) {
                 file.createNewFile();
             }
            Writer writer= new FileWriter(file);
        
        //StringWriter out = new StringWriter();  
        //System.out.println(out.toString());  
        //数据与模板合并（数据+模板=输出）  
        template.process(root, writer);  
     
    }  
}  