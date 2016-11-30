package com.waterfox.junit;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import common.util.DateUtil;
import common.util.PropertiesUtil;

public class JDBCTest {

	private static Connection con;
	private static PreparedStatement pstmt;
	private static ResultSet rs;

	/**
	 * JDBC的方式获得connection
	 * @return
	 */
	public static Connection getJDBCConnection() {
		Map<String, String> configMap = PropertiesUtil.getConfigMap("db.properties");
		String classForName = configMap.get("db.driver");
		String connectionName = configMap.get("db.url");
		String conUser = configMap.get("db.username");
		String conPwd = configMap.get("db.password");

		try {
			if (con == null) {
				Class.forName(classForName);
				Properties info = new Properties();
				info.put("user", conUser);
				info.put("password", conPwd);
				con = DriverManager.getConnection(connectionName, info);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return con;
	}

	public static ResultSet getResultSet(String sql) {
		con = getJDBCConnection();
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rs;
	}

	public static List<Map<String, Object>> executeQueryToList(String sql) {
		List<Map<String, Object>> result = null;
		con = getJDBCConnection();
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if (null == rs)
				return result;
			result = new ArrayList<Map<String, Object>>();
			while (rs.next()) {
				HashMap<String, Object> row = new HashMap<String, Object>();
				java.sql.ResultSetMetaData rsmd = rs.getMetaData();
				for (int i = 1; i <= rsmd.getColumnCount(); i++) {
					if (null == rs.getObject(i))
						continue;
					row.put(rsmd.getColumnName(i), rs.getObject(i));
				}
				result.add(row);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeAll();
		}
		return result;
	}

	/**
	 * 将运行的sql数据结果转换为String 
	 * @param sql
	 * @return
	 */
	public static String executeQueryToStr(String sql) {
		String result = "";
		con = getJDBCConnection();
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if (null == rs)
				return "运行该脚本没有产生数据....";
			while (rs.next()) {
				ResultSetMetaData rsmd = rs.getMetaData();
				for (int i = 1; i <= rsmd.getColumnCount(); i++) {
					String col_name = rsmd.getColumnName(i);
					System.out.print(col_name + "	");
				}
				System.out.println();
				for (int i = 1; i <= rsmd.getColumnCount(); i++) {
					Object object = rs.getObject(i);
					System.out.print(object + "	");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeAll();
		}
		return result;
	}

	public static int executeUpdate(String sql) {
		int result = 0;
		con = getJDBCConnection();
		try {
			pstmt = con.prepareStatement(sql);
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeAll();
		}
		return result;
	}

	/**
	 * 反射全部的数据名称
	 * @return
	 */
	public Field[] getField(String className) {
		Field[] fields = null;
		try {
			Object o = Class.forName(className).newInstance();
			fields = o.getClass().getDeclaredFields();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return fields;
	}

	public static void closeAll() {
		try {
			if (null != rs) {
				rs.close();
				rs = null;
			}
			if (null != pstmt) {
				pstmt.close();
				pstmt = null;
			}
			if (null != con) {
				con.close();
				con = null;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void main(String[] args) throws Exception {
		JDBCTest db = new JDBCTest();
		
		String sql = "select * from tbl_order_secondhand_house  where createTime>"+DateUtil.dateToString(new Date(), "yyyy-MM-dd");
		String executeQueryToStr = JDBCTest.executeQueryToStr(sql);
		System.out.println(executeQueryToStr);
	}
}
