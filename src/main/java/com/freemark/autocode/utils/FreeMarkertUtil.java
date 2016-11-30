package com.freemark.autocode.utils;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.Map;

import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyEmitterReturnValueHandler;

import freemarker.template.Configuration;
import freemarker.template.DefaultObjectWrapper;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import freemarker.template.TemplateModelException;

/** 
 *  
 * 模板工具类 
 */
public class FreeMarkertUtil {

	private String templateEncoding = "UTF-8";

	private File desc;

	private File src_Template;

	/**
	 * 生成指定文件
	 * @param root 数据源
	 * @param out  流
	 * @param fileUrl 文件路径
	 * @param fileName 文件名称
	 */
	public FreeMarkertUtil processTemplate(Object root) {
		if (null == desc) {
			try {
				throw new TemplateModelException("请选择保存目标文件desc");
			} catch (TemplateModelException e) {
				e.printStackTrace();
				return this;
			}
		}

		if (null == src_Template || !src_Template.exists()) {
			try {
				throw new TemplateModelException("请选择模板文件src_Template");
			} catch (TemplateModelException e) {
				e.printStackTrace();
				return this;
			}
		}
		Writer out = null;
		try {
			Configuration config = new Configuration();
			// 设置要解析的模板所在的目录，并加载模板文件
			config.setDirectoryForTemplateLoading(src_Template.getParentFile());
			// 设置包装器，并将对象包装为数据模型
			config.setObjectWrapper(new DefaultObjectWrapper());
			// 获取模板,并设置编码方式，这个编码必须要与页面中的编码格式一致
			Template template = config.getTemplate(src_Template.getName(), templateEncoding);
			// 合并数据模型与模板
			out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(desc), templateEncoding));
			template.process(root, out);
			out.flush();
			System.out.println(desc.getAbsolutePath() + "  clear");
		} catch (Exception e) {
			e.printStackTrace();
			try {
				out.close();
				desc.delete();// 既然废了，就不要有返回了
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		} finally {
			try {
				if (null != out) {
					out.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return this;
	}

	public FreeMarkertUtil setTemplateEncoding(String templateEncoding) {
		this.templateEncoding = templateEncoding;
		return this;
	}

	public File getDesc() {
		return desc;
	}

	public FreeMarkertUtil setDesc(File desc) {
		this.desc = desc;
		return this;
	}

	public File getSrc_Template() {
		return src_Template;
	}

	public FreeMarkertUtil setSrc_Template(File src_Template) {
		this.src_Template = src_Template;
		return this;
	}

}