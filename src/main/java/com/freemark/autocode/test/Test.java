package com.freemark.autocode.test;

import java.io.File;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.io.FileUtils;

import com.freemark.autocode.beans.Article_type;
import com.freemark.autocode.beans.Head;
import com.freemark.autocode.utils.FreeMarkertUtil;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

public class Test {

	public static void main(String[] args) throws IOException, TemplateException {

		// 1.创建配置实例Cofiguration
		Configuration cfg = new Configuration();

		// 2.设置模板文件目录
		// （1）src目录下的目录（template在src下）
		// cfg.setDirectoryForTemplateLoading(new File("src/template"));
		// （2）完整路径（template在src下）
		// cfg.setDirectoryForTemplateLoading(new File(
		// "D:/cpic-env/workspace/javaFreemarker/src/template"));
		// cfg.setDirectoryForTemplateLoading(new File("src/template"));
		// （3）工程目录下的目录（template/main在工程下）--推荐
		// cfg.setObjectWrapper(new DefaultObjectWrapper());
		// 获取模板（template）
		// 建立数据模型（Map）
		Map<String, Object> root = new HashMap<String, Object>();
		root.put("name", "cxl");
		root.put("age", "25");
		root.put("head", getHead());
		root.put("ArticleTypes", getArticleTypes());

		new FreeMarkertUtil().setSrc_Template(new File("./src/main/resources/freemark/template/test/demo.ftl"))
				.setDesc(new File("D:/demo.html")).processTemplate(root);

	}

	/**
	 * 网页头部-seo
	 * @return
	 */
	public static Head getHead() {
		Head vo = new Head();
		vo.setTitle("网页生成测试");
		vo.setCopyright("2015...");
		vo.setAuthor("moon.l");
		vo.setDescription("网页生成测试描述");
		vo.setKeywords("我就是关键字");
		return vo;
	}

	public static List<Article_type> getArticleTypes() {
		List<Article_type> list = new ArrayList<Article_type>();
		for (int i = 0; i < 10; i++) {
			Article_type vo = new Article_type();
			vo.setId(i + "");
			vo.setName("moonl" + i);
			vo.setEn_name("en_moonl" + i);
			vo.setOrders(i);
			list.add(vo);
		}
		return list;
	}
}