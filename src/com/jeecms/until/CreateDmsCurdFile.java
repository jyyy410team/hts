package com.jeecms.until;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.http.impl.cookie.DateUtils;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

public class CreateDmsCurdFile {

	private static String tableName = "Insurances";

	private static String username = "靳阳阳";

	public static void main(String[] args) throws IOException,
			TemplateException {
		Configuration cfg = new Configuration();
		cfg.setDirectoryForTemplateLoading(new File("template"));
		Map<String, String> root = new HashMap<String, String>();
		root.put("name", username);
		root.put("date", DateUtils.formatDate(new Date(), "yyyy-mm-dd"));
		root.put("tableName", tableName);
		// 获取输出流（指定到控制台（标准输出））
		createFile1(cfg, root);
		createFile2(cfg, root);
		createFile3(cfg, root);

	}

	public static void createFile1(Configuration cfg, Map<String, String> root)
			throws IOException, TemplateException {
		Template template = cfg.getTemplate("ifaceTemp.ftl");
		// 建立数据模型（Map）
		File file1 = new File("src/temp/I" + tableName + ".java");
		Writer writer1 = new FileWriter(file1);
		// StringWriter out = new StringWriter();
		// System.out.println(out.toString());
		// 数据与模板合并（数据+模板=输出）
		template.process(root, writer1);

	}

	// 实现类
	public static void createFile2(Configuration cfg, Map<String, String> root)
			throws IOException, TemplateException {
		Template template = cfg.getTemplate("implTemp.ftl");
		File file1 = new File("src/temp/" + tableName + "Impl.java");
		Writer writer1 = new FileWriter(file1);
		template.process(root, writer1);

	}

	// 配置文件
	public static void createFile3(Configuration cfg, Map<String, String> root)
			throws IOException, TemplateException {
		Template template = cfg.getTemplate("xmlTemp.ftl");
		File file1 = new File("src/temp/" + tableName + ".xml");
		Writer writer1 = new FileWriter(file1);
		template.process(root, writer1);

	}
}