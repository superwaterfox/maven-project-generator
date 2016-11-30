package com.freemark.autocode.directive;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.freemark.autocode.beans.Article_type;

import freemarker.core.Environment;
import freemarker.template.TemplateDirectiveBody;
import freemarker.template.TemplateDirectiveModel;
import freemarker.template.TemplateException;
import freemarker.template.TemplateModel;
import freemarker.template.TemplateNumberModel;
import freemarker.template.WrappingTemplateModel;

public class CandidateDirective implements TemplateDirectiveModel {

	public void execute(Environment env, Map map, TemplateModel[] loopVars, TemplateDirectiveBody body)
			throws TemplateException, IOException {
		long pid = 0;
		int limit = 10;
		int start = 1;
		Object paramValue = map.get("pid");
		if (paramValue instanceof TemplateNumberModel) {
			pid = ((TemplateNumberModel) paramValue).getAsNumber().longValue();
			System.out.println("this is pid ..." + pid);
		}
		paramValue = map.get("start");
		if (paramValue instanceof TemplateNumberModel) {
			start = ((TemplateNumberModel) paramValue).getAsNumber().intValue();
			System.out.println("this is start ..." + start);
		}
		paramValue = map.get("limit");
		if (paramValue instanceof TemplateNumberModel) {
			limit = ((TemplateNumberModel) paramValue).getAsNumber().intValue();
			System.out.println("this is limit ..." + limit);
		}

		List<Article_type> us = getUsers();

		if (body != null) {
			loopVars[0] = WrappingTemplateModel.getDefaultObjectWrapper().wrap(us);
			// 执行标签内容(same as <#nested> in FTL).
			body.render(env.getOut());
		} else {
			throw new RuntimeException("missing body");
		}
	}

	protected List<Article_type> getUsers() {
		List<Article_type> list = new ArrayList<Article_type>();
		for (int i = 0; i < 4; i++) {
			Article_type vo = new Article_type();
			vo.setId(i + "");
			vo.setName("ly111");

			list.add(vo);
		}
		return list;

	}
}