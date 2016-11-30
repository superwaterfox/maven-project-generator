package com.freemark.autocode.test;

import java.io.File;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;

import com.freemark.autocode.directive.ArticleTypeDirective;
import com.freemark.autocode.utils.FreeMarkertUtil;

public class RepeatTest {

	public static void main(String[] args) {

		Map<String, Object> root = new HashMap<String, Object>();
		root.put("articles", new ArticleTypeDirective());

		new FreeMarkertUtil().setSrc_Template(new File("./src/main/resources/freemark/template/article.ftl"))
				.setDesc(new File("D:/123.html")).processTemplate(root);
	}
}
