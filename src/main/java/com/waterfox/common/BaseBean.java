package com.waterfox.common;

/**
 * 提供SQL语句中，要使用的通用字段
 * 
 */
public class BaseBean {

	/** 分页开始数 */
	private int start;
	/** 分页记录数 */
	private int pagesize;
	/**
	 * SQL语句中a关联查询b， where b.id in "1,2,3" 这里就是保存以逗号分隔的id值,在mapper中直接可以使用
	 */
	private String ids;
	// 返回的分页总数
	private int count;
	/** 临时记录用户UID */
	private String uid;
	/** 标记字段 */
	private int flag;//标记位
	
	private String target;

	public int getStart() {
		return start;
	}

	public void setStart(int start) {
		this.start = start;
	}

	public int getPagesize() {
		return pagesize;
	}

	public void setPagesize(int pagesize) {
		this.pagesize = pagesize;
	}

	public String getIds() {
		return ids;
	}

	public void setIds(String ids) {
		this.ids = ids;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public int getFlag() {
		return flag;
	}

	public void setFlag(int flag) {
		this.flag = flag;
	}

	public String getTarget() {
		return target;
	}

	public void setTarget(String target) {
		this.target = target;
	}

}
