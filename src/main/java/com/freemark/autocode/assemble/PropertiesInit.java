package com.freemark.autocode.assemble;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.apache.commons.lang.StringUtils;

import com.freemark.autocode.beans.BaseDef;

/**
 * 通过配置文件，初始化，要生成的包名称，对象名称，数据表名称，主键名称
 * @author Administrator
 *
 */
public class PropertiesInit {

	private static InputStream is = null;

	/**
	 * 从配置文件中初始化商家地图信息
	 * @return
	 */
	public static List<BaseDef> getBaseDefList() {
		List<BaseDef> list = new ArrayList<BaseDef>();
		try {
			is = PropertiesInit.class.getClassLoader().getResourceAsStream("freemark/base.properties");
			if (is != null) {
				Properties properties = new Properties();
				properties.load(is);
				for (int i = 1; i <= properties.size(); i++) {
					String file_type = (String) properties.get(i + "");
					if (StringUtils.isBlank(file_type)) {
						continue;
					}
					String nft = new String(file_type.getBytes("ISO-8859-1"), "UTF-8");
					String[] sp = nft.split(",");
					BaseDef vo = new BaseDef();
					vo.setPackages(sp[0]);
					vo.setVo(sp[1]);
					vo.setTable_name(sp[2]);
					vo.setPrimaryKey(sp[3]);
					vo.setTable_comment(sp[4]);
					//
					list.add(vo);
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (null != is) {
				try {
					is.close();
					is = null;
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return list;
	}

	public static void main(String[] args) {
		List<BaseDef> baseDefList = new PropertiesInit().getBaseDefList();
		for (BaseDef baseDef : baseDefList) {
			System.out.println(baseDef.getTable_name());
		}
	}
}
