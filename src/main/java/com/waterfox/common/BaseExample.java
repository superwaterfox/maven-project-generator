package com.waterfox.common;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

/**
 * bug: 1.insert update select delete因为条件拼凑是统一的离线条件
 * 那么是否为""有效，就不能统一概括了。这里是不对""进行判断的，任然有效
 * 
 * 
 * insert对""无效 
 * update对""有效
 * 
 * 
 * @author ch
 *
 */
public class BaseExample {
	protected String orderByClause;// column desc/asc 排序的字段

	protected boolean distinct;// true 去重复

	protected List<Criteria> oredCriteria;// 利用list进行封装条件参数

	public BaseExample() {
		oredCriteria = new ArrayList<Criteria>();
	}

	public void setOrderByClause(String orderByClause) {
		this.orderByClause = orderByClause;
	}

	public String getOrderByClause() {
		return orderByClause;
	}

	public void setDistinct(boolean distinct) {
		this.distinct = distinct;
	}

	public boolean isDistinct() {
		return distinct;
	}

	public List<Criteria> getOredCriteria() {
		return oredCriteria;
	}

	public void or(Criteria criteria) {
		oredCriteria.add(criteria);
	}

	public Criteria or() {
		Criteria criteria = createCriteriaInternal();
		oredCriteria.add(criteria);
		return criteria;
	}

	public Criteria createCriteria() {
		Criteria criteria = createCriteriaInternal();
		if (oredCriteria.size() == 0) {
			oredCriteria.add(criteria);
		}
		return criteria;
	}

	protected Criteria createCriteriaInternal() {
		Criteria criteria = new Criteria();
		return criteria;
	}

	public void clear() {
		oredCriteria.clear();
		orderByClause = null;
		distinct = false;
	}

	protected abstract static class GeneratedCriteria {
		protected List<Criterion> criteria;

		protected GeneratedCriteria() {
			super();
			criteria = new ArrayList<Criterion>();
		}

		public boolean isValid() {// 判断list条件集合是否有效
			return criteria.size() > 0;
		}

		public List<Criterion> getAllCriteria() {
			return criteria;
		}

		public List<Criterion> getCriteria() {
			return criteria;
		}

		protected void addCriterion(String condition) {

			if (condition == null) {
				throw new RuntimeException("Value for condition cannot be null");
			}
			criteria.add(new Criterion(condition));
		}

		protected void addCriterion(String condition, Object value, String property) {
			if (value == null) {
				throw new RuntimeException("Value for " + property + " cannot be null");
			}
			criteria.add(new Criterion(condition, value));
		}

		protected void addCriterion(String condition, Object value1, Object value2, String property) {
			if (value1 == null || value2 == null) {
				throw new RuntimeException("Between values for " + property + " cannot be null");
			}
			criteria.add(new Criterion(condition, value1, value2));
		}

		protected void addCriterionForJDBCDate(String condition, Date value, String property) {
			if (value == null) {
				throw new RuntimeException("Value for " + property + " cannot be null");
			}
			addCriterion(condition, new java.sql.Date(value.getTime()), property);
		}

		protected void addCriterionForJDBCDate(String condition, List<Date> values, String property) {
			if (values == null || values.size() == 0) {
				throw new RuntimeException("Value list for " + property + " cannot be null or empty");
			}
			List<java.sql.Date> dateList = new ArrayList<java.sql.Date>();
			Iterator<Date> iter = values.iterator();
			while (iter.hasNext()) {
				dateList.add(new java.sql.Date(iter.next().getTime()));
			}
			addCriterion(condition, dateList, property);
		}

		protected void addCriterionForJDBCDate(String condition, Date value1, Date value2, String property) {
			if (value1 == null || value2 == null) {
				throw new RuntimeException("Between values for " + property + " cannot be null");
			}
			addCriterion(condition, new java.sql.Date(value1.getTime()), new java.sql.Date(value2.getTime()), property);
		}

		// 查询条件start------------------------------------------
		// 新增方法
		public Criteria andColumnIsNull(String baseColumn) {
			addCriterion(baseColumn + " is null");
			return (Criteria) this;
		}

		public Criteria andColumnIsNotNull(String baseColumn) {
			addCriterion(baseColumn + " is not null");
			return (Criteria) this;
		}

		public Criteria andColumnEqualTo(String baseColumn, Object value) {
			addCriterion(baseColumn + " =", value, baseColumn);
			return (Criteria) this;
		}

		public Criteria andColumnNotEqualTo(String baseColumn, Object value) {
			addCriterion(baseColumn + " <>", value, baseColumn);
			return (Criteria) this;
		}

		public Criteria andColumnGreaterThan(String baseColumn, Object value) {
			addCriterion(baseColumn + " >", value, baseColumn);
			return (Criteria) this;
		}

		public Criteria andColumnGreaterThanOrEqualTo(String baseColumn, Object value) {
			addCriterion(baseColumn + " >=", value, baseColumn);
			return (Criteria) this;
		}

		public Criteria andColumnLessThan(String baseColumn, Object value) {
			addCriterion(baseColumn + " <", value, baseColumn);
			return (Criteria) this;
		}

		public Criteria andColumnLessThanOrEqualTo(String baseColumn, Object value) {
			addCriterion(baseColumn + " <=", value, baseColumn);
			return (Criteria) this;
		}

		public Criteria andColumnIn(String baseColumn, List<String> values) {
			addCriterion(baseColumn + " in", values, baseColumn);
			return (Criteria) this;
		}

		public Criteria andColumnNotIn(String baseColumn, List<String> values) {
			addCriterion(baseColumn + " not in", values, baseColumn);
			return (Criteria) this;
		}

		public Criteria andColumnBetween(String baseColumn, Object value1, Object value2) {
			addCriterion(baseColumn + " between", value1, value2, baseColumn);
			return (Criteria) this;
		}

		public Criteria andColumnNotBetween(String baseColumn, Object value1, Object value2) {
			addCriterion(baseColumn + " not between", value1, value2, baseColumn);
			return (Criteria) this;
		}

		/**
		 * 需要手动添加 % %
		 * 
		 * @param baseColumn
		 * @param value
		 * @return
		 */
		public Criteria andColumnLike(String baseColumn, Object value) {
			addCriterion(baseColumn + " like", value, baseColumn);
			return (Criteria) this;
		}

		public Criteria andColumnNotLike(String baseColumn, Object value) {
			addCriterion(baseColumn + " not like", value, baseColumn);
			return (Criteria) this;
		}

		// 查询条件end------------------------------------------
	}

	public static class Criteria extends GeneratedCriteria {

		protected Criteria() {
			super();
		}
	}

	public static class Criterion {
		private String condition;// 封装语句 baseColumn+ "like"

		private Object value;

		private Object secondValue;
		// and的参数start-------------
		private boolean noValue;// 无参

		private boolean singleValue;// 一个参数 and value

		private boolean betweenValue;// 两个参数 and value1 and value2

		private boolean listValue;// 参数集合 使用list将foreach遍历 value: value1 and
									// value2
		// and的参数end--------------
		private String typeHandler;

		public String getCondition() {
			return condition;
		}

		public Object getValue() {
			return value;
		}

		public Object getSecondValue() {
			return secondValue;
		}

		public boolean isNoValue() {
			return noValue;
		}

		public boolean isSingleValue() {
			return singleValue;
		}

		public boolean isBetweenValue() {
			return betweenValue;
		}

		public boolean isListValue() {
			return listValue;
		}

		public String getTypeHandler() {
			return typeHandler;
		}

		protected Criterion(String condition) {
			super();
			this.condition = condition;
			this.typeHandler = null;
			this.noValue = true;
		}

		protected Criterion(String condition, Object value, String typeHandler) {
			super();
			this.condition = condition;
			this.value = value;
			this.typeHandler = typeHandler;
			if (value instanceof List<?>) {
				this.listValue = true;
			} else {
				this.singleValue = true;
			}
		}

		protected Criterion(String condition, Object value) {
			this(condition, value, null);
		}

		/**
		 * 
		 * @param condition
		 *            封装条件String
		 * @param value
		 *            字段
		 * @param secondValue
		 * @param typeHandler
		 */
		protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
			super();
			this.condition = condition;
			this.value = value;
			this.secondValue = secondValue;
			this.typeHandler = typeHandler;
			this.betweenValue = true;
		}

		protected Criterion(String condition, Object value, Object secondValue) {
			this(condition, value, secondValue, null);
		}
	}
}