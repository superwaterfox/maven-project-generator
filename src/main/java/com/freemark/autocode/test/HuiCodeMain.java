package com.freemark.autocode.test;

import java.io.File;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.freemark.autocode.assemble.PropertiesInit;
import com.freemark.autocode.assemble.TableInit;
import com.freemark.autocode.beans.BaseDef;
import com.freemark.autocode.beans.TableDef;
import com.freemark.autocode.utils.FreeMarkertUtil;

import freemarker.template.TemplateException;

public class HuiCodeMain {
	public static void main(String[] args) throws IOException, TemplateException, SQLException {
		List<BaseDef> list = PropertiesInit.getBaseDefList();
		for (BaseDef def : list) {
			String table = def.getTable_name();
			String pk = def.getPrimaryKey();
			List<TableDef> tables = TableInit.getList("zxsf360-mortgage-test", table, pk);
			createHbm(def, tables);
			createstrutsXml(def, tables);
			createVO(def, tables);
			createService(def, tables);
		}
	}

	/**
	 * 生成hbm对象
	 * @param def
	 * @throws IOException
	 * @throws TemplateException
	 * @throws SQLException
	 */
	private static void createHbm(BaseDef def, List<TableDef> tables)
			throws IOException, TemplateException, SQLException {

		Map<String, Object> root = new HashMap<String, Object>();
		root.put("package", def.getPackages());
		root.put("vo", def.getVo());
		root.put("table_name", def.getTable_name());
		root.put("pk", def.getPrimaryKey());
		root.put("tabledef", tables);

		new FreeMarkertUtil().setSrc_Template(new File("./src/main/resources/freemark/template/config/hbm.ftl"))
				.setDesc(new File("D:/" + def.getVo() + ".hbm.xml")).processTemplate(root);
	}

	/**
	 * 生成struts.xml对象
	 * @param def
	 * @param tables
	 * @throws IOException
	 * @throws TemplateException
	 * @throws SQLException
	 */
	private static void createstrutsXml(BaseDef def, List<TableDef> tables)
			throws IOException, TemplateException, SQLException {
		Map<String, Object> root = new HashMap<String, Object>();
		root.put("package", def.getPackages());
		root.put("vo", def.getVo());
		root.put("table_name", def.getTable_name());
		root.put("pk", def.getPrimaryKey());
		new FreeMarkertUtil().setSrc_Template(new File("./src/main/resources/freemark/template/config/struts.ftl"))
				.setDesc(new File("D:/struts.xml")).processTemplate(root);
	}

	/**
	 * 生成vo对象
	 * @param def
	 * @param tables
	 * @throws IOException
	 * @throws TemplateException
	 * @throws SQLException
	 */
	private static void createVO(BaseDef def, List<TableDef> tables)
			throws IOException, TemplateException, SQLException {
		Map<String, Object> root = new HashMap<String, Object>();
		root.put("package", def.getPackages());
		root.put("vo", def.getVo());
		root.put("comment", def.getTable_comment());
		root.put("table_name", def.getTable_name());
		root.put("pk", def.getPrimaryKey());
		root.put("tabledef", tables);
		new FreeMarkertUtil().setSrc_Template(new File("./src/main/resources/freemark/template/java/bean.ftl"))
				.setDesc(new File("D:/beans.java")).processTemplate(root);
	}

	/**
	 * 生成Service对象
	 * @param def
	 * @param tables
	 * @throws IOException
	 * @throws TemplateException
	 * @throws SQLException
	 */
	private static void createService(BaseDef def, List<TableDef> tables)
			throws IOException, TemplateException, SQLException {
		Map<String, Object> root = new HashMap<String, Object>();
		root.put("package", def.getPackages());
		root.put("vo", def.getVo());
		root.put("comment", def.getTable_comment());
		root.put("table_name", def.getTable_name());
		root.put("pk", def.getPrimaryKey());

		new FreeMarkertUtil().setSrc_Template(new File("./src/main/resources/freemark/template/service.ftl"))
				.setDesc(new File("D:/Service.java")).processTemplate(root);

	}
}
