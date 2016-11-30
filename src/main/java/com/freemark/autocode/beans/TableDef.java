package com.freemark.autocode.beans;

public class TableDef {

	public String column;// 字段

	public String name;// 中文名称

	public String type;// 数据类型

	public String column_type;// 在java中类型

	public String isnull;// 是否允许为空

	public String getCode() {
		return column;
	}

	public void setCode(String code) {
		this.column = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getFiled_type() {
		return column_type;
	}

	public void setFiled_type(String filed_type) {
		this.column_type = filed_type;
	}

	public String getIfnull() {
		return isnull;
	}

	public void setIfnull(String ifnull) {
		this.isnull = ifnull;
	}

}
