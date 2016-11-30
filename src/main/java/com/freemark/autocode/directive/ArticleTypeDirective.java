package com.freemark.autocode.directive;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.freemark.autocode.beans.Article_type;
import com.freemark.autocode.utils.FreeMarkertUtil;

import freemarker.core.Environment;
import freemarker.template.TemplateDirectiveBody;
import freemarker.template.TemplateDirectiveModel;
import freemarker.template.TemplateException;
import freemarker.template.TemplateModel;
import freemarker.template.TemplateModelException;
import freemarker.template.TemplateNumberModel;
import freemarker.template.TemplateScalarModel;
import freemarker.template.WrappingTemplateModel;

public class ArticleTypeDirective implements TemplateDirectiveModel {

	private static final String VARIABLE_NAME = "articles";

	private static final String PARAM_NAME_COUNT = "count";

	private static final String PARAM_NAME_NAME = "name";

	public void execute(Environment env, Map params, TemplateModel[] loopVars, TemplateDirectiveBody body)
			throws TemplateException, IOException {
		int countParam = 0;
		String name = "";
		// 获取传入的参数组
		Set keys = params.keySet();
		for (Object key : keys) {
			TemplateModel paramValue = (TemplateModel) params.get(key);
			if (key.equals(PARAM_NAME_COUNT)) {
				if (!(paramValue instanceof TemplateNumberModel)) {
					throw new TemplateModelException(
							"The \"" + PARAM_NAME_COUNT + "\" parameter " + "must be a number.");
				}
				countParam = ((TemplateNumberModel) paramValue).getAsNumber().intValue();
			} else if (key.equals(PARAM_NAME_NAME)) {
				if (!(paramValue instanceof TemplateScalarModel)) {
					throw new TemplateModelException(
							"The \"" + PARAM_NAME_NAME + "\" parameter " + "must be a boolean.");
				}
				name = ((TemplateScalarModel) paramValue).getAsString();
			}
		}
		List<Article_type> articles = getArticleTypeList(countParam, name);
		if (body != null) {
			// loopVars[0] = articles;
			TemplateModel tm = WrappingTemplateModel.getDefaultObjectWrapper().wrap(articles);
			loopVars[0] = null;
			// 执行标签内容(same as <#nested> in FTL).
			body.render(env.getOut());
		}
		// setLocalVariable(VARIABLE_NAME, articles, env, body);
	}

	public List<Article_type> getArticleTypeList(int count, String name) {
		if (count < 1) {
			count = 1;
		}
		List<Article_type> list = new ArrayList<Article_type>();
		for (int i = 0; i < count; i++) {
			Article_type vo = new Article_type();
			vo.setId(i + "");
			vo.setName(name);
			vo.setEn_name("en_" + name);
			vo.setOrders(i);
			list.add(vo);
		}
		return list;
	}

}
