package com.freemark.autocode.assemble;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.freemark.autocode.beans.TableDef;
import com.waterfox.junit.JDBCTest;
/**
 * 从数据库的INFORMATION_SCHEMA.COLUMNS  获取要进行操作数据库的所有基本数据
 * @Title TableInit
 * @Description 
 * @author ch
 * @Date 2016年4月6日 上午11:20:37
 */
public class TableInit {

	/**
	 * 
	 * @param lib	库
	 * @param table	表
	 * @param primaryKey	要操作的主键，例如orderNo进行操作业务，而不是id
	 * @return
	 * @throws SQLException
	 */
	public static List<TableDef> getList(String lib, String table, String primaryKey) throws SQLException {
		List<TableDef> list = new ArrayList<TableDef>();

		StringBuffer sql = new StringBuffer();
		sql.append(" SELECT CS.TABLE_NAME  ,CS.COLUMN_NAME ,CS.DATA_TYPE ,CS.COLUMN_COMMENT ,CS.IS_NULLABLE ");
		sql.append(" FROM INFORMATION_SCHEMA.COLUMNS CS WHERE TABLE_SCHEMA ='" + lib + "' ");
		sql.append(" AND TABLE_NAME = '" + table + "' ORDER BY CS.ORDINAL_POSITION ");

		ResultSet rs = JDBCTest.getResultSet(sql.toString());
		while (rs.next()) {
			TableDef vo = new TableDef();
			String code = (String) rs.getObject("COLUMN_NAME");
			String type = (String) rs.getObject("TYPE");
			String name = (String) rs.getObject("NAME");
			// 是否允许为空 yes 允许，no 不允许
			String ifnull = (String) rs.getObject("IFNULL");
			// 跳过主键
			if (primaryKey.equals(code)) {
				continue;
			}
			if ("TS".equals(code.toUpperCase())) {
				continue;
			}

			String fileType = "";
			if ("VARCHAR".equals(type.toUpperCase())) {
				fileType = "String";
			} else if ("CHAR".equals(type.toUpperCase())) {
				fileType = "String";
			} else if ("INTEGER".equals(type.toUpperCase())) {
				fileType = "Integer";
			} else if ("INT".equals(type.toUpperCase())) {
				fileType = "Integer";
			} else if ("DECIMAL".equals(type.toUpperCase())) {
				fileType = "BigDecimal";
			} else if ("TINYINT".equals(type.toUpperCase())) {
				fileType = "Boolean";
			} else if ("BLOB".equals(type.toUpperCase())) {
				fileType = "Blob";
			}
			vo.setCode(code);
			vo.setName(name);
			vo.setType(type.toUpperCase());
			vo.setFiled_type(fileType);
			vo.setIfnull(ifnull);
			System.out.println(code + ".." + name + "  " + fileType + "  " + type.toUpperCase());
			list.add(vo);
		}
		return list;
	}

	// public static List<TableDef> getList(String table,String pk) throws
	// SQLException{
	// List<TableDef> list = new ArrayList<TableDef>();
	// String sql = "select * from "+table +" limit 0, 1";
	// ResultSet rs = DbUtility.getResultSet(sql);
	// while (rs.next()) {
	// ResultSetMetaData rsmd = rs.getMetaData();
	// for (int i = 1; i <= rsmd.getColumnCount(); i++) {
	// //字段名称(小写)
	// String col_name = rsmd.getColumnName(i).toLowerCase();
	// // 数据类型
	// String col_type = rsmd.getColumnTypeName(i);
	// //跳过主键
	// if(pk.equals(col_name)){
	// continue;
	// }
	// if("TS".equals(col_type)){
	// continue;
	// }
	// String fileType = "";
	// if("VARCHAR".equals(col_type)){
	// fileType = "String";
	// } else if("CHAR".equals(col_type)){
	// fileType = "String";
	// } else if("INTEGER".equals(col_type)){
	// fileType = "Integer";
	// } else if("INT".equals(col_type)){
	// fileType = "Integer";
	// } else if("DECIMAL".equals(col_type)){
	// fileType = "BigDecimal";
	// } else if("TINYINT".equals(col_type)){
	// fileType = "Boolean";
	// }
	// TableDef vo = new TableDef();
	// vo.setCode(col_name);
	// vo.setType(col_type);
	// vo.setFiled_type(fileType);
	// list.add(vo);
	// }
	// }
	// return list;
	// }
	public static void main(String[] args) throws SQLException {
		List<TableDef> list = getList("waterfox-mortgage-test", "tbl_pictures", "id");
		for (TableDef tableDef : list) {
			System.out.println(tableDef.getName());
		}
	}
}
