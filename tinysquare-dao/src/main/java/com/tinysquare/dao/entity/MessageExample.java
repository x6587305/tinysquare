package com.tinysquare.dao.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MessageExample {
    /**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table tiny_message
	 * @mbggenerated  Thu May 05 19:33:13 CST 2016
	 */
	protected String orderByClause;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table tiny_message
	 * @mbggenerated  Thu May 05 19:33:13 CST 2016
	 */
	protected boolean distinct;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table tiny_message
	 * @mbggenerated  Thu May 05 19:33:13 CST 2016
	 */
	protected List<Criteria> oredCriteria;

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table tiny_message
	 * @mbggenerated  Thu May 05 19:33:13 CST 2016
	 */
	public MessageExample() {
		oredCriteria = new ArrayList<Criteria>();
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table tiny_message
	 * @mbggenerated  Thu May 05 19:33:13 CST 2016
	 */
	public void setOrderByClause(String orderByClause) {
		this.orderByClause = orderByClause;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table tiny_message
	 * @mbggenerated  Thu May 05 19:33:13 CST 2016
	 */
	public String getOrderByClause() {
		return orderByClause;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table tiny_message
	 * @mbggenerated  Thu May 05 19:33:13 CST 2016
	 */
	public void setDistinct(boolean distinct) {
		this.distinct = distinct;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table tiny_message
	 * @mbggenerated  Thu May 05 19:33:13 CST 2016
	 */
	public boolean isDistinct() {
		return distinct;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table tiny_message
	 * @mbggenerated  Thu May 05 19:33:13 CST 2016
	 */
	public List<Criteria> getOredCriteria() {
		return oredCriteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table tiny_message
	 * @mbggenerated  Thu May 05 19:33:13 CST 2016
	 */
	public void or(Criteria criteria) {
		oredCriteria.add(criteria);
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table tiny_message
	 * @mbggenerated  Thu May 05 19:33:13 CST 2016
	 */
	public Criteria or() {
		Criteria criteria = createCriteriaInternal();
		oredCriteria.add(criteria);
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table tiny_message
	 * @mbggenerated  Thu May 05 19:33:13 CST 2016
	 */
	public Criteria createCriteria() {
		Criteria criteria = createCriteriaInternal();
		if (oredCriteria.size() == 0) {
			oredCriteria.add(criteria);
		}
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table tiny_message
	 * @mbggenerated  Thu May 05 19:33:13 CST 2016
	 */
	protected Criteria createCriteriaInternal() {
		Criteria criteria = new Criteria();
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table tiny_message
	 * @mbggenerated  Thu May 05 19:33:13 CST 2016
	 */
	public void clear() {
		oredCriteria.clear();
		orderByClause = null;
		distinct = false;
	}

	/**
	 * This class was generated by MyBatis Generator. This class corresponds to the database table tiny_message
	 * @mbggenerated  Thu May 05 19:33:13 CST 2016
	 */
	protected abstract static class GeneratedCriteria {
		protected List<Criterion> criteria;

		protected GeneratedCriteria() {
			super();
			criteria = new ArrayList<Criterion>();
		}

		public boolean isValid() {
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

		public Criteria andIdIsNull() {
			addCriterion("id is null");
			return (Criteria) this;
		}

		public Criteria andIdIsNotNull() {
			addCriterion("id is not null");
			return (Criteria) this;
		}

		public Criteria andIdEqualTo(Long value) {
			addCriterion("id =", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdNotEqualTo(Long value) {
			addCriterion("id <>", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdGreaterThan(Long value) {
			addCriterion("id >", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdGreaterThanOrEqualTo(Long value) {
			addCriterion("id >=", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdLessThan(Long value) {
			addCriterion("id <", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdLessThanOrEqualTo(Long value) {
			addCriterion("id <=", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdIn(List<Long> values) {
			addCriterion("id in", values, "id");
			return (Criteria) this;
		}

		public Criteria andIdNotIn(List<Long> values) {
			addCriterion("id not in", values, "id");
			return (Criteria) this;
		}

		public Criteria andIdBetween(Long value1, Long value2) {
			addCriterion("id between", value1, value2, "id");
			return (Criteria) this;
		}

		public Criteria andIdNotBetween(Long value1, Long value2) {
			addCriterion("id not between", value1, value2, "id");
			return (Criteria) this;
		}

		public Criteria andUserIdIsNull() {
			addCriterion("user_id is null");
			return (Criteria) this;
		}

		public Criteria andUserIdIsNotNull() {
			addCriterion("user_id is not null");
			return (Criteria) this;
		}

		public Criteria andUserIdEqualTo(Long value) {
			addCriterion("user_id =", value, "userId");
			return (Criteria) this;
		}

		public Criteria andUserIdNotEqualTo(Long value) {
			addCriterion("user_id <>", value, "userId");
			return (Criteria) this;
		}

		public Criteria andUserIdGreaterThan(Long value) {
			addCriterion("user_id >", value, "userId");
			return (Criteria) this;
		}

		public Criteria andUserIdGreaterThanOrEqualTo(Long value) {
			addCriterion("user_id >=", value, "userId");
			return (Criteria) this;
		}

		public Criteria andUserIdLessThan(Long value) {
			addCriterion("user_id <", value, "userId");
			return (Criteria) this;
		}

		public Criteria andUserIdLessThanOrEqualTo(Long value) {
			addCriterion("user_id <=", value, "userId");
			return (Criteria) this;
		}

		public Criteria andUserIdIn(List<Long> values) {
			addCriterion("user_id in", values, "userId");
			return (Criteria) this;
		}

		public Criteria andUserIdNotIn(List<Long> values) {
			addCriterion("user_id not in", values, "userId");
			return (Criteria) this;
		}

		public Criteria andUserIdBetween(Long value1, Long value2) {
			addCriterion("user_id between", value1, value2, "userId");
			return (Criteria) this;
		}

		public Criteria andUserIdNotBetween(Long value1, Long value2) {
			addCriterion("user_id not between", value1, value2, "userId");
			return (Criteria) this;
		}

		public Criteria andTitleIsNull() {
			addCriterion("title is null");
			return (Criteria) this;
		}

		public Criteria andTitleIsNotNull() {
			addCriterion("title is not null");
			return (Criteria) this;
		}

		public Criteria andTitleEqualTo(String value) {
			addCriterion("title =", value, "title");
			return (Criteria) this;
		}

		public Criteria andTitleNotEqualTo(String value) {
			addCriterion("title <>", value, "title");
			return (Criteria) this;
		}

		public Criteria andTitleGreaterThan(String value) {
			addCriterion("title >", value, "title");
			return (Criteria) this;
		}

		public Criteria andTitleGreaterThanOrEqualTo(String value) {
			addCriterion("title >=", value, "title");
			return (Criteria) this;
		}

		public Criteria andTitleLessThan(String value) {
			addCriterion("title <", value, "title");
			return (Criteria) this;
		}

		public Criteria andTitleLessThanOrEqualTo(String value) {
			addCriterion("title <=", value, "title");
			return (Criteria) this;
		}

		public Criteria andTitleLike(String value) {
			addCriterion("title like", value, "title");
			return (Criteria) this;
		}

		public Criteria andTitleNotLike(String value) {
			addCriterion("title not like", value, "title");
			return (Criteria) this;
		}

		public Criteria andTitleIn(List<String> values) {
			addCriterion("title in", values, "title");
			return (Criteria) this;
		}

		public Criteria andTitleNotIn(List<String> values) {
			addCriterion("title not in", values, "title");
			return (Criteria) this;
		}

		public Criteria andTitleBetween(String value1, String value2) {
			addCriterion("title between", value1, value2, "title");
			return (Criteria) this;
		}

		public Criteria andTitleNotBetween(String value1, String value2) {
			addCriterion("title not between", value1, value2, "title");
			return (Criteria) this;
		}

		public Criteria andSubjectIsNull() {
			addCriterion("subject is null");
			return (Criteria) this;
		}

		public Criteria andSubjectIsNotNull() {
			addCriterion("subject is not null");
			return (Criteria) this;
		}

		public Criteria andSubjectEqualTo(String value) {
			addCriterion("subject =", value, "subject");
			return (Criteria) this;
		}

		public Criteria andSubjectNotEqualTo(String value) {
			addCriterion("subject <>", value, "subject");
			return (Criteria) this;
		}

		public Criteria andSubjectGreaterThan(String value) {
			addCriterion("subject >", value, "subject");
			return (Criteria) this;
		}

		public Criteria andSubjectGreaterThanOrEqualTo(String value) {
			addCriterion("subject >=", value, "subject");
			return (Criteria) this;
		}

		public Criteria andSubjectLessThan(String value) {
			addCriterion("subject <", value, "subject");
			return (Criteria) this;
		}

		public Criteria andSubjectLessThanOrEqualTo(String value) {
			addCriterion("subject <=", value, "subject");
			return (Criteria) this;
		}

		public Criteria andSubjectLike(String value) {
			addCriterion("subject like", value, "subject");
			return (Criteria) this;
		}

		public Criteria andSubjectNotLike(String value) {
			addCriterion("subject not like", value, "subject");
			return (Criteria) this;
		}

		public Criteria andSubjectIn(List<String> values) {
			addCriterion("subject in", values, "subject");
			return (Criteria) this;
		}

		public Criteria andSubjectNotIn(List<String> values) {
			addCriterion("subject not in", values, "subject");
			return (Criteria) this;
		}

		public Criteria andSubjectBetween(String value1, String value2) {
			addCriterion("subject between", value1, value2, "subject");
			return (Criteria) this;
		}

		public Criteria andSubjectNotBetween(String value1, String value2) {
			addCriterion("subject not between", value1, value2, "subject");
			return (Criteria) this;
		}

		public Criteria andAuthorIsNull() {
			addCriterion("author is null");
			return (Criteria) this;
		}

		public Criteria andAuthorIsNotNull() {
			addCriterion("author is not null");
			return (Criteria) this;
		}

		public Criteria andAuthorEqualTo(String value) {
			addCriterion("author =", value, "author");
			return (Criteria) this;
		}

		public Criteria andAuthorNotEqualTo(String value) {
			addCriterion("author <>", value, "author");
			return (Criteria) this;
		}

		public Criteria andAuthorGreaterThan(String value) {
			addCriterion("author >", value, "author");
			return (Criteria) this;
		}

		public Criteria andAuthorGreaterThanOrEqualTo(String value) {
			addCriterion("author >=", value, "author");
			return (Criteria) this;
		}

		public Criteria andAuthorLessThan(String value) {
			addCriterion("author <", value, "author");
			return (Criteria) this;
		}

		public Criteria andAuthorLessThanOrEqualTo(String value) {
			addCriterion("author <=", value, "author");
			return (Criteria) this;
		}

		public Criteria andAuthorLike(String value) {
			addCriterion("author like", value, "author");
			return (Criteria) this;
		}

		public Criteria andAuthorNotLike(String value) {
			addCriterion("author not like", value, "author");
			return (Criteria) this;
		}

		public Criteria andAuthorIn(List<String> values) {
			addCriterion("author in", values, "author");
			return (Criteria) this;
		}

		public Criteria andAuthorNotIn(List<String> values) {
			addCriterion("author not in", values, "author");
			return (Criteria) this;
		}

		public Criteria andAuthorBetween(String value1, String value2) {
			addCriterion("author between", value1, value2, "author");
			return (Criteria) this;
		}

		public Criteria andAuthorNotBetween(String value1, String value2) {
			addCriterion("author not between", value1, value2, "author");
			return (Criteria) this;
		}

		public Criteria andContentIsNull() {
			addCriterion("content is null");
			return (Criteria) this;
		}

		public Criteria andContentIsNotNull() {
			addCriterion("content is not null");
			return (Criteria) this;
		}

		public Criteria andContentEqualTo(String value) {
			addCriterion("content =", value, "content");
			return (Criteria) this;
		}

		public Criteria andContentNotEqualTo(String value) {
			addCriterion("content <>", value, "content");
			return (Criteria) this;
		}

		public Criteria andContentGreaterThan(String value) {
			addCriterion("content >", value, "content");
			return (Criteria) this;
		}

		public Criteria andContentGreaterThanOrEqualTo(String value) {
			addCriterion("content >=", value, "content");
			return (Criteria) this;
		}

		public Criteria andContentLessThan(String value) {
			addCriterion("content <", value, "content");
			return (Criteria) this;
		}

		public Criteria andContentLessThanOrEqualTo(String value) {
			addCriterion("content <=", value, "content");
			return (Criteria) this;
		}

		public Criteria andContentLike(String value) {
			addCriterion("content like", value, "content");
			return (Criteria) this;
		}

		public Criteria andContentNotLike(String value) {
			addCriterion("content not like", value, "content");
			return (Criteria) this;
		}

		public Criteria andContentIn(List<String> values) {
			addCriterion("content in", values, "content");
			return (Criteria) this;
		}

		public Criteria andContentNotIn(List<String> values) {
			addCriterion("content not in", values, "content");
			return (Criteria) this;
		}

		public Criteria andContentBetween(String value1, String value2) {
			addCriterion("content between", value1, value2, "content");
			return (Criteria) this;
		}

		public Criteria andContentNotBetween(String value1, String value2) {
			addCriterion("content not between", value1, value2, "content");
			return (Criteria) this;
		}

		public Criteria andIsReadIsNull() {
			addCriterion("is_read is null");
			return (Criteria) this;
		}

		public Criteria andIsReadIsNotNull() {
			addCriterion("is_read is not null");
			return (Criteria) this;
		}

		public Criteria andIsReadEqualTo(Byte value) {
			addCriterion("is_read =", value, "isRead");
			return (Criteria) this;
		}

		public Criteria andIsReadNotEqualTo(Byte value) {
			addCriterion("is_read <>", value, "isRead");
			return (Criteria) this;
		}

		public Criteria andIsReadGreaterThan(Byte value) {
			addCriterion("is_read >", value, "isRead");
			return (Criteria) this;
		}

		public Criteria andIsReadGreaterThanOrEqualTo(Byte value) {
			addCriterion("is_read >=", value, "isRead");
			return (Criteria) this;
		}

		public Criteria andIsReadLessThan(Byte value) {
			addCriterion("is_read <", value, "isRead");
			return (Criteria) this;
		}

		public Criteria andIsReadLessThanOrEqualTo(Byte value) {
			addCriterion("is_read <=", value, "isRead");
			return (Criteria) this;
		}

		public Criteria andIsReadIn(List<Byte> values) {
			addCriterion("is_read in", values, "isRead");
			return (Criteria) this;
		}

		public Criteria andIsReadNotIn(List<Byte> values) {
			addCriterion("is_read not in", values, "isRead");
			return (Criteria) this;
		}

		public Criteria andIsReadBetween(Byte value1, Byte value2) {
			addCriterion("is_read between", value1, value2, "isRead");
			return (Criteria) this;
		}

		public Criteria andIsReadNotBetween(Byte value1, Byte value2) {
			addCriterion("is_read not between", value1, value2, "isRead");
			return (Criteria) this;
		}

		public Criteria andStatusIsNull() {
			addCriterion("status is null");
			return (Criteria) this;
		}

		public Criteria andStatusIsNotNull() {
			addCriterion("status is not null");
			return (Criteria) this;
		}

		public Criteria andStatusEqualTo(Byte value) {
			addCriterion("status =", value, "status");
			return (Criteria) this;
		}

		public Criteria andStatusNotEqualTo(Byte value) {
			addCriterion("status <>", value, "status");
			return (Criteria) this;
		}

		public Criteria andStatusGreaterThan(Byte value) {
			addCriterion("status >", value, "status");
			return (Criteria) this;
		}

		public Criteria andStatusGreaterThanOrEqualTo(Byte value) {
			addCriterion("status >=", value, "status");
			return (Criteria) this;
		}

		public Criteria andStatusLessThan(Byte value) {
			addCriterion("status <", value, "status");
			return (Criteria) this;
		}

		public Criteria andStatusLessThanOrEqualTo(Byte value) {
			addCriterion("status <=", value, "status");
			return (Criteria) this;
		}

		public Criteria andStatusIn(List<Byte> values) {
			addCriterion("status in", values, "status");
			return (Criteria) this;
		}

		public Criteria andStatusNotIn(List<Byte> values) {
			addCriterion("status not in", values, "status");
			return (Criteria) this;
		}

		public Criteria andStatusBetween(Byte value1, Byte value2) {
			addCriterion("status between", value1, value2, "status");
			return (Criteria) this;
		}

		public Criteria andStatusNotBetween(Byte value1, Byte value2) {
			addCriterion("status not between", value1, value2, "status");
			return (Criteria) this;
		}

		public Criteria andEntrydateIsNull() {
			addCriterion("entrydate is null");
			return (Criteria) this;
		}

		public Criteria andEntrydateIsNotNull() {
			addCriterion("entrydate is not null");
			return (Criteria) this;
		}

		public Criteria andEntrydateEqualTo(Date value) {
			addCriterion("entrydate =", value, "entrydate");
			return (Criteria) this;
		}

		public Criteria andEntrydateNotEqualTo(Date value) {
			addCriterion("entrydate <>", value, "entrydate");
			return (Criteria) this;
		}

		public Criteria andEntrydateGreaterThan(Date value) {
			addCriterion("entrydate >", value, "entrydate");
			return (Criteria) this;
		}

		public Criteria andEntrydateGreaterThanOrEqualTo(Date value) {
			addCriterion("entrydate >=", value, "entrydate");
			return (Criteria) this;
		}

		public Criteria andEntrydateLessThan(Date value) {
			addCriterion("entrydate <", value, "entrydate");
			return (Criteria) this;
		}

		public Criteria andEntrydateLessThanOrEqualTo(Date value) {
			addCriterion("entrydate <=", value, "entrydate");
			return (Criteria) this;
		}

		public Criteria andEntrydateIn(List<Date> values) {
			addCriterion("entrydate in", values, "entrydate");
			return (Criteria) this;
		}

		public Criteria andEntrydateNotIn(List<Date> values) {
			addCriterion("entrydate not in", values, "entrydate");
			return (Criteria) this;
		}

		public Criteria andEntrydateBetween(Date value1, Date value2) {
			addCriterion("entrydate between", value1, value2, "entrydate");
			return (Criteria) this;
		}

		public Criteria andEntrydateNotBetween(Date value1, Date value2) {
			addCriterion("entrydate not between", value1, value2, "entrydate");
			return (Criteria) this;
		}
	}

	/**
	 * This class was generated by MyBatis Generator. This class corresponds to the database table tiny_message
	 * @mbggenerated  Thu May 05 19:33:13 CST 2016
	 */
	public static class Criterion {
		private String condition;
		private Object value;
		private Object secondValue;
		private boolean noValue;
		private boolean singleValue;
		private boolean betweenValue;
		private boolean listValue;
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

	/**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table tiny_message
     *
     * @mbggenerated do_not_delete_during_merge Wed May 04 20:43:10 CST 2016
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }
}