package com.freemark.autocode.beans;
/**
 * 表
 * @Title BaseDef
 * @Description 
 * @author ch
 * @Date 2016年4月7日 上午11:42:24
 */
public class BaseDef {

	public String packages;// 包名称

	public String vo;// 对象名称

	public String table_name;// 表名称

	public String primaryKey;// 主键

	public String table_comment; // 表注释

	public String getPackages() {
		return packages;
	}

	public void setPackages(String packages) {
		this.packages = packages;
	}

	public String getVo() {
		return vo;
	}

	public void setVo(String vo) {
		this.vo = vo;
	}

	public String getTable_name() {
		return table_name;
	}

	public void setTable_name(String table_name) {
		this.table_name = table_name;
	}

	public String getPrimaryKey() {
		return primaryKey;
	}

	public void setPrimaryKey(String primaryKey) {
		this.primaryKey = primaryKey;
	}

	public String getTable_comment() {
		return table_comment;
	}

	public void setTable_comment(String table_comment) {
		this.table_comment = table_comment;
	}

}
