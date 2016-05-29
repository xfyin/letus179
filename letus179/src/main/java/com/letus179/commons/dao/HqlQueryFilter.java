/**
 * File：HqlQueryFilter.java
 * Package：com.letus179.commons.dao
 * Author：xfyin
 * Date：2016-5-25 下午1:06:04
 * Copyright (C) 2016-2016 letus179-Copyright
 */
package com.letus179.commons.dao;

import java.io.Serializable;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.apache.commons.lang.StringUtils;
import org.hibernate.criterion.DetachedCriteria;

/**
 * Hibernate 查询过滤器，用于提供更加简洁的方法实现HQL查询操作，并支持分页排序功能。
 * <p>
 * 例如，对于下面的Hql语句：
 * 
 * <pre>
 * select user from User user where sex = "male" and salary >= 5000 order by name
 * </pre>
 * 
 * 可以构造一个HqlQueryFilter，完成相同的功能，如下：
 * 
 * <pre>
 * HqlQueryFilter filter = new HqlQueryFilter(User.class);
 * filter.addEq(&quot;sex&quot;, &quot;male&quot;);
 * filter.addGe(&quot;salary&quot;, 5000);
 * filter.addOrderByField(&quot;name&quot;, true);
 * </pre>
 * 
 * HqlQueryFilter将作为{@link CommonDaoSupport#queryList(HqlQueryFilter)}和
 * {@link CommonDaoSupport#queryByQueryInfo(HqlQueryFilter)} 的参数，执行查询。
 * 
 * @author xfyin
 */
public class HqlQueryFilter implements Serializable {
  
  /**
   * serialVersionUID
   */
  private static final long serialVersionUID = 2112355356413785385L;
  
  /**
   * Where逻辑表达式，表示Hql中的>，<，=等条件
   * 
   * 
   */
  enum WhereLogic {
    /**
     * 等于
     */
    equal("= :%s"),
    /**
     * 大于等于
     */
    greater_than_equal(">= :%s"),
    /**
     * 大于
     */
    greater_than("> :%s"),
    /**
     * 小于等于
     */
    less_than_equal("<= :%s"),
    /**
     * 小于
     */
    less_than("< :%s"),
    /**
     * 不等于
     */
    not_equal("<> :%s"),
    /**
     * left like
     */
    leftlike("like :%s"),
    /**
     * like
     */
    like("like :%s"),
    /**
     * right like
     */
    rightlike("like :%s"),
    /**
     * is null
     */
    is_null("is null"),
    /**
     * is not null
     */
    is_not_null("is not null"),
    /**
     * in
     */
    in("in(:%s)"),
    /**
     * not in
     */
    not_in("not in(:%s)");
    
    /**
     * 逻辑值
     */
    private final String logic;
    
    /**
     * 构造方法
     * 
     * @param logic
     *        逻辑值
     */
    WhereLogic(String logic) {
      this.logic = logic;
    }
    
    /**
     * 获取枚举值
     * 
     * @return 枚举值
     */
    public String getValue() {
      return logic;
    }
  }
  
  /**
   * 实体名称
   */
  private String entityName;
  
  /**
   * 是否将查询结果封装为指定的实体对象。默认为false
   */
  private boolean wrapResult = false;
  
  /**
   * left join字段 <li>key：参与left join查询的字段名，一般为一个Set集合，如：rules</li> <li>value：字段的别名，如：rule</li>
   */
  private Map<String, String> leftJoinFields = new LinkedHashMap<>();
  
  /**
   * select子句中包含的字段
   */
  private Set<String> selectFields = new LinkedHashSet<>();
  
  /**
   * 所有where子句
   */
  private Set<String> whereClauses = new LinkedHashSet<>();
  
  /**
   * 所有排序字段
   */
  private Set<String> orderByFields = new LinkedHashSet<>();
  
  /**
   * 所有group by字段
   */
  private Set<String> groupByFields = new LinkedHashSet<>();
  
  /**
   * 命名参数列表 <li>key：命名参数名</li> <li>value：命名参数值</li>
   */
  private Map<String, Object> paramNameValues = new LinkedHashMap<>();
  
  /**
   * 开始行索引，用于分页查询。默认值为0，表示不分页。
   */
  private int startRowIndex;
  
  /**
   * 每页显示的记录数，用于分页查询。默认值为-1，表示不分页。
   */
  private int rowCountPerPage = -1;
  
  /**
   * 查询 DetachedCriteria
   */
  private DetachedCriteria detachedCriteria;
  
  /**
   * 用户自定义Hql查询语句
   */
  private String hqlStr;
  
  /**
   * 查询语句参数列表
   */
  private List<Object> values;
  
  /**
   * 构造方法
   * 
   * @param entityType
   *        要查询的实体类型
   */
  public HqlQueryFilter(Class<?> entityType) {
    this.entityName = entityType.getSimpleName();
    
  }
  
  /**
   * 构造方法
   * 
   * @param entityClassName
   *        要查询的实体类名称
   */
  public HqlQueryFilter(String entityClassName) {
    this.entityName = entityClassName.trim();
  }
  
  /**
   * 增加“=”条件，即：<code>fieldName = fieldValue</code>
   * 
   * @param fieldName
   *        字段名
   * @param fieldValue
   *        字段值
   * @return HqlQueryFilter
   */
  public HqlQueryFilter addEq(String fieldName, Object fieldValue) {
    return addWhereCondition(fieldName, WhereLogic.equal, fieldValue);
  }
  
  /**
   * 增加“>=”条件，即：<code>fieldName >= fieldValue</code>
   * 
   * @param fieldName
   *        字段名
   * @param fieldValue
   *        字段值
   * @return HqlQueryFilter
   */
  public HqlQueryFilter addGe(String fieldName, Object fieldValue) {
    return addWhereCondition(fieldName, WhereLogic.greater_than_equal, fieldValue);
  }
  
  /**
   * 增加“>”条件，即fieldName > fieldValue
   * 
   * @param fieldName
   *        字段名
   * @param fieldValue
   *        字段值
   * @return HqlQueryFilter
   */
  public HqlQueryFilter addGt(String fieldName, Object fieldValue) {
    return addWhereCondition(fieldName, WhereLogic.greater_than, fieldValue);
  }
  
  /**
   * 增加“<”条件，即：<code>fieldName < fieldValue</code>
   * 
   * @param fieldName
   *        字段名
   * @param fieldValue
   *        字段值
   * @return HqlQueryFilter
   */
  public HqlQueryFilter addLt(String fieldName, Object fieldValue) {
    return addWhereCondition(fieldName, WhereLogic.less_than, fieldValue);
  }
  
  /**
   * 增加“<=”条件，即：<code>fieldName <= fieldValue</code>
   * 
   * @param fieldName
   *        字段名
   * @param fieldValue
   *        字段值
   * @return HqlQueryFilter
   */
  public HqlQueryFilter addLe(String fieldName, Object fieldValue) {
    return addWhereCondition(fieldName, WhereLogic.less_than_equal, fieldValue);
  }
  
  /**
   * 增加“!=”条件，即：<code>fieldName != fieldValue</code>
   * 
   * @param fieldName
   *        字段名
   * @param fieldValue
   *        字段值
   * @return HqlQueryFilter
   */
  public HqlQueryFilter addNe(String fieldName, Object fieldValue) {
    return addWhereCondition(fieldName, WhereLogic.not_equal, fieldValue);
  }
  
  /**
   * 增加“like”条件，即：<code>fieldName like fieldValue</code>
   * 
   * @param fieldName
   *        字段名
   * @param fieldValue
   *        字段值
   * @return HqlQueryFilter
   */
  public HqlQueryFilter addLike(String fieldName, Object fieldValue) {
    return addWhereCondition(fieldName, WhereLogic.like, fieldValue);
  }
  
  /**
   * 增加右边模糊匹配：“like aaa%”条件，即：<code>fieldName like fieldValue</code>
   * 
   * @param fieldName
   *        字段名
   * @param fieldValue
   *        字段值
   * @return HqlQueryFilter
   */
  public HqlQueryFilter addRightLike(String fieldName, Object fieldValue) {
    return addWhereCondition(fieldName, WhereLogic.rightlike, fieldValue);
  }
  
  /**
   * 增加右边模糊匹配：“like %aaa”条件，即：<code>fieldName like fieldValue</code>
   * 
   * @param fieldName
   *        字段名
   * @param fieldValue
   *        字段值
   * @return HqlQueryFilter
   */
  public HqlQueryFilter addLeftLike(String fieldName, Object fieldValue) {
    return addWhereCondition(fieldName, WhereLogic.leftlike, fieldValue);
  }
  
  /**
   * 增加“in”条件，即：<code>fieldName in (fieldValue1, fieldValue2,...)</code>
   * 
   * @param fieldName
   *        字段名
   * @param fieldValue
   *        字段值
   * @return HqlQueryFilter
   */
  public HqlQueryFilter addIn(String fieldName, Collection<?> fieldValue) {
    return addWhereCondition(fieldName, WhereLogic.in, fieldValue);
  }
  
  /**
   * 增加“not in”条件，即：<code>fieldName not in (fieldValue1, fieldValue2,...)</code>
   * 
   * @param fieldName
   *        字段名
   * @param fieldValue
   *        字段值
   * @return HqlQueryFilter
   */
  public HqlQueryFilter addNotIn(String fieldName, Collection<?> fieldValue) {
    return addWhereCondition(fieldName, WhereLogic.not_in, fieldValue);
  }
  
  /**
   * 增加“is null”条件，即：<code>fieldName is null</code>
   * 
   * @param fieldName
   *        字段名
   * @return HqlQueryFilter
   */
  public HqlQueryFilter addNull(String fieldName) {
    return addWhereCondition(fieldName, WhereLogic.is_null, null);
  }
  
  /**
   * 增加“is not null”条件，即：<code>fieldName is not null</code>
   * 
   * @param fieldName
   *        字段名
   * @return HqlQueryFilter
   */
  public HqlQueryFilter addNotNull(String fieldName) {
    return addWhereCondition(fieldName, WhereLogic.is_not_null, null);
  }
  
  /**
   * 增加“count()”条件，即：<code>select <b>count(fieldName)</b> from ...</code>
   * 
   * @param fieldName
   *        字段名
   * @return HqlQueryFilter
   */
  public HqlQueryFilter addCountField(String fieldName) {
    if (StringUtils.isNotBlank(fieldName)) {
      this.selectFields.add("count(" + getFullFieldName(fieldName) + ")");
    }
    else {
      this.selectFields.add("count(*)");
    }
    
    return this;
  }
  
  /**
   * 增加“sum()”条件，即：<code>select <b>sum(fieldName)</b> from ...</code>
   * 
   * @param fieldName
   *        字段名
   * @return HqlQueryFilter
   */
  public HqlQueryFilter addSumField(String fieldName) {
    if (StringUtils.isNotBlank(fieldName)) {
      this.selectFields.add("sum(" + getFullFieldName(fieldName) + ")");
    }
    
    return this;
  }
  
  /**
   * 增加“max()”条件，即：<code>select <b>max(fieldName)</b> from ...</code>
   * 
   * @param fieldName
   *        字段名
   * @return HqlQueryFilter
   */
  public HqlQueryFilter addMaxField(String fieldName) {
    if (StringUtils.isNotBlank(fieldName)) {
      this.selectFields.add("max(" + getFullFieldName(fieldName) + ")");
    }
    return this;
  }
  
  /**
   * 增加“min()”条件，即：<code>select <b>min(fieldName)</b> from ...</code>
   * 
   * @param fieldName
   *        字段名
   * @return HqlQueryFilter
   */
  public HqlQueryFilter addMinField(String fieldName) {
    if (StringUtils.isNotBlank(fieldName)) {
      this.selectFields.add("min(" + getFullFieldName(fieldName) + ")");
    }
    return this;
  }
  
  /**
   * 增加分组字段，即：<code>group by </code>
   * 
   * @param fieldName
   *        字段名
   * @return HqlQueryFilter
   */
  public HqlQueryFilter addGroupByField(String fieldName) {
    if (StringUtils.isNotBlank(fieldName)) {
      this.groupByFields.add(getFullFieldName(fieldName));
    }
    
    return this;
  }
  
  /**
   * 增加要查询的字段，即：<code>select <b>fieldName</b> from ...</code>
   * 
   * <p>
   * 注：如果没有增加任何查询字段，则查询默认返回整个实体对象，否则只返回addQueryField指定的字段。
   * 
   * @param fieldName
   *        字段名
   * @return HqlQueryFilter
   */
  public HqlQueryFilter addQueryField(String fieldName) {
    return addQueryField(fieldName, false);
  }
  
  /**
   * 增加要查询的字段，即：<code>select <b>fieldName</b> from ...</code>
   * 
   * <p>
   * 注：如果没有增加任何查询字段，则查询默认返回整个实体对象，否则只返回addQueryField指定的字段。
   * 
   * @param fieldName
   *        字段名
   * @param isDistinct
   *        是否为distinct，即：<code>select <b>distinct(fieldName)</b></code>
   * @return HqlQueryFilter
   */
  public HqlQueryFilter addQueryField(String fieldName, boolean isDistinct) {
    if (StringUtils.isBlank(fieldName)) {
      return this;
    }
    
    if (isDistinct) {
      this.selectFields.add("distinct(" + getFullFieldName(fieldName) + ")");
    }
    else {
      this.selectFields.add(getFullFieldName(fieldName));
    }
    
    return this;
  }
  
  /**
   * 增加要查询的字段，即：<code>select <b>fieldName1, fieldName12,...</b> from ...</code>
   * 
   * <p>
   * 注：如果没有增加任何查询字段，则查询默认返回整个实体对象，否则只返回addQueryField指定的字段。
   * 
   * @param fieldNames
   *        字段名列表
   * @return HqlQueryFilter
   */
  public HqlQueryFilter addQueryField(String... fieldNames) {
    for (String str : fieldNames) {
      addQueryField(str);
    }
    
    return this;
  }
  
  /**
   * 增加要排序的字段，即：<code>order by fieldName</code>
   * 
   * @param fieldName
   *        字段名
   * @param isAsc
   *        是否升序
   * @return HqlQueryFilter
   */
  public HqlQueryFilter addOrderByField(String fieldName, boolean isAsc) {
    if (StringUtils.isNotBlank(fieldName)) {
      if (isAsc) {
        orderByFields.add(getFullFieldName(fieldName) + " asc");
      }
      else {
        orderByFields.add(getFullFieldName(fieldName) + " desc");
      }
    }
    
    return this;
  }
  
  /**
   * 重置HqlQueryFilter，即清空所有以前设置的内容
   * 
   * @return HqlQueryFilter
   */
  public HqlQueryFilter reset() {
    this.selectFields.clear();
    this.whereClauses.clear();
    this.orderByFields.clear();
    this.groupByFields.clear();
    this.paramNameValues.clear();
    this.leftJoinFields.clear();
    
    return this;
  }
  
  /**
   * 重置HqlQueryFilter的orderByFields，即清空排序设置
   * 
   * @return HqlQueryFilter
   */
  public HqlQueryFilter clearOrderFields() {
    this.orderByFields.clear();
    return this;
  }
  
  /**
   * 增加左外连接（left join）查询，即：<code>left join operator.rules rule</code>
   * 
   * @param joinFieldName
   *        参与左外连接查询的字段名，一般为实体中的某个映射为OneToMany或者ManyToMany的字段。
   * @param alias
   *        为参与左外连接查询的字段所起的别名，如：字段operator.rules参与左外连接，则其alias可设置为rule。
   *        <p>
   *        <b>注意：</b>必须为参与左外连接查询的字段设置别名，以便在构造where查询条件时，能正确区分字段到底是本实体中的字段还是其左外连接实体中的字段。例如：
   * 
   *        <pre>
   * HqlQueryFilter filter = new HqlQueryFilter(Operator.class);
   * 
   * filter.addEq("name", "zhangsan");
   * <b>filter.addLeftJoin("rules", "rule");</b>
   * filter.addEq("<b>rule</b>.name", "admin");
   * filter.addEq("<b>rule</b>.type", "1");
   * </pre>
   * 
   *        这里，"name"是实体Operator中的字段，而"rule.name"和"rule.type"是Operator关联的实体Rule中的字段，
   *        因此必须为字段"rules"设置别名"rule"，并使用"rule.name"和"rule.type"以表示字段是Rule实体中的字段。
   * @return HqlQueryFilter
   */
  public HqlQueryFilter addLeftJoin(String joinFieldName, String alias) {
    if (StringUtils.isBlank(joinFieldName)) {
      return this;
    }
    
    leftJoinFields.put(joinFieldName.trim(), alias.trim());
    return this;
  }
  
  /**
   * 使用DetachedCriteria查询
   * 
   * @param detachedCriteria
   *        查询detachedCriteria
   */
  public void addDetachedCriteria(DetachedCriteria detachedCriteria) {
    this.detachedCriteria = detachedCriteria;
  }
  
  /**
   * 直接增加一个where条件
   * 
   * @param whereHql
   *        hql where条件 <br>
   *        例如：参数为(a='1' or b='1')
   * @return
   */
  public HqlQueryFilter addWhereHql(String whereHql) {
    whereClauses.add(whereHql);
    return this;
  }
  
  /**
   * 返回解析好的Hql语句
   * 
   * @return 解析好的Hql语句
   */
  String getQueryString() {
    
    if (!StringUtils.isBlank(hqlStr)) {
      return hqlStr;
    }
    
    StringBuilder sb = new StringBuilder();
    
    // 增加 select 语句
    sb.append(getSelectClause());
    
    // 增加 from 语句
    sb.append(getFromClause());
    
    // 增加 left join 语句
    sb.append(getLeftJoinClauses());
    
    // 增加 where 语句
    sb.append(getWhereClauses());
    
    // 增加 group by 语句
    sb.append(getGroupClauses());
    
    // 增加 order by 语句
    sb.append(getSortClauses());
    
    return sb.toString();
  }
  
  /**
   * 获取实体别名，即Hql： <code>select user from User user</code>中的<code>user</code>
   * 
   * @return 实体别名
   */
  private String getAlias() {
    // 将实体类名的首字母改为小写后作为alias，如：Operator改为operator
    return entityName.substring(0, 1).toLowerCase() + entityName.substring(1);
  }
  
  /**
   * 获取Hql中的left join子句
   * 
   * @return Hql中的where子句
   */
  private String getLeftJoinClauses() {
    if (leftJoinFields.isEmpty()) {
      return "";
    }
    
    StringBuilder sb = new StringBuilder();
    
    for (Entry<String, String> entry : leftJoinFields.entrySet()) {
      sb.append(" left join ");
      sb.append(getFullFieldName(entry.getKey()) + " " + entry.getValue());
    }
    
    return sb.toString();
  }
  
  /**
   * 获取Hql中的where子句
   * 
   * @return Hql中的where子句
   */
  private String getWhereClauses() {
    if (whereClauses.isEmpty()) {
      return "";
    }
    
    return " where " + StringUtils.join(this.whereClauses.iterator(), " and ");
  }
  
  /**
   * 获取Hql中的group by子句
   * 
   * @return group by子句
   */
  private String getGroupClauses() {
    if (groupByFields.isEmpty()) {
      return "";
    }
    
    return " group by " + StringUtils.join(groupByFields.iterator(), ", ");
  }
  
  /**
   * 获取Hql中的order by子句
   * 
   * @return order by子句
   */
  private String getSortClauses() {
    if (orderByFields.isEmpty()) {
      return "";
    }
    
    return " order by " + StringUtils.join(orderByFields.iterator(), ", ");
  }
  
  /**
   * 获取Hql中的select子句
   * 
   * @return select子句
   */
  private String getSelectClause() {
    StringBuilder sb = new StringBuilder("select ");
    
    if (!selectFields.isEmpty()) {
      if (this.wrapResult) {
        sb.append("new ").append(entityName).append("(")
            .append(StringUtils.join(selectFields.iterator(), ", "));
        sb.append(")");
      }
      
      else {
        sb.append(StringUtils.join(selectFields.iterator(), ", "));
      }
      
    }
    
    else {
      sb.append(getAlias());
    }
    
    return sb.toString();
  }
  
  /**
   * 获取查询记录数的Hql即：<code>select count(*) from ...</code>
   * 
   * @return 查询记录数的Hql
   */
  String getQueryTotalCountString() {
    String strQueryCount = "";
    String queryString = getQueryString();
    
    if (StringUtils.contains(queryString, "order by")) {
      strQueryCount = "select count(*) from "
          + StringUtils.substringBetween(queryString, "from", "order");
    }
    else {
      strQueryCount = "select count(*) from " + StringUtils.substringAfter(queryString, "from");
    }
    
    return strQueryCount;
  }
  
  /**
   * 增加一个where条件，即：<code>where fieldName logic(=,<,>,...) fieldValue</code>
   * 
   * @param fieldName
   *        字段名
   * @param logic
   *        逻辑值，见{@link WhereLogic}
   * @param fieldValue
   *        字段值
   * @return HqlQueryFilter
   */
  private HqlQueryFilter addWhereCondition(String fieldName, WhereLogic logic, Object fieldValue) {
    // 如果字段名为空，则返回
    if (StringUtils.isBlank(fieldName)) {
      return this;
    }
    
    // 对于is null和is not null，由于是一元查询条件，因此不需要参数值
    if (logic == WhereLogic.is_not_null || logic == WhereLogic.is_null) {
      whereClauses.add(parseWhereCondition(fieldName, logic));
      return this;
    }
    
    // 如果fieldValue为null或者为空串，则忽略该查询条件
    if (fieldValue == null || StringUtils.isBlank(fieldValue.toString())) {
      return this;
    }
    
    whereClauses.add(parseWhereCondition(fieldName, logic));
    
    // 构造SQL语句中的命名参数，如：optLog.date > :optLog_date
    String namedParam = parseNamedParam(getFullFieldName(fieldName), logic);
    
    if (logic == WhereLogic.like) {
      paramNameValues.put(namedParam, "%" + fieldValue.toString().trim() + "%");
    }
    else if (logic == WhereLogic.rightlike) {
      paramNameValues.put(namedParam, fieldValue.toString().trim() + "%");
    }
    else if (logic == WhereLogic.leftlike) {
      paramNameValues.put(namedParam, "%" + fieldValue.toString().trim());
    }
    else {
      paramNameValues.put(namedParam, fieldValue);
    }
    
    return this;
  }
  
  /**
   * 构造Hql中where子句中的命名参数。
   * <p>
   * 命名参数命名约定为：实体别名_字段名_逻辑名。其中，如果字段名中含有"."，则需要转换为"_"，如user.company.name转换为user_company_name
   * <p>
   * 例如：对于别名为user的User实体，如果where中含有字段name，则对应的命名参数为：user_name，where子句为：
   * <p>
   * <code>where user.date &gt; :<b>user_date_greater_than</b> && </b>user.date &lt; :<b>user_date_less_than</b></code>
   * 
   * @param fieldName
   *        字段名
   * @param logic
   *        逻辑值，见{@link WhereLogic}
   * @return fieldName对应的where子句中的命名参数
   */
  private String parseNamedParam(String fieldName, WhereLogic logic) {
    return StringUtils.replace(fieldName, ".", "_") + "_" + logic.name();
  }
  
  /**
   * 获取Hql中的from子句。
   * 
   * @return Hql中的from子句。
   */
  private String getFromClause() {
    return " from " + this.entityName + " " + getAlias();
  }
  
  /**
   * 解析Hql中的where语句
   * 
   * @param fieldName
   *        字段名
   * @param logic
   *        逻辑表达式，见{@link WhereLogic}
   * @return where语句
   */
  private String parseWhereCondition(String fieldName, WhereLogic logic) {
    StringBuilder sb = new StringBuilder();
    
    String fullFieldName = getFullFieldName(fieldName);
    
    // 将逻辑表达式中的%s替换为命名参数，比如，将"= :%"替换为"< :optLog_date_equal"
    String strLogic = String.format(logic.getValue(), parseNamedParam(fullFieldName, logic));
    
    // 如：optLog.date > :optLog_date_equal
    sb.append(fullFieldName).append(" ").append(strLogic);
    
    return sb.toString();
  }
  
  /**
   * 获取完整的查询字段名，即实体属性名.字段名
   * 
   * @param fieldName
   *        字段名
   * @return 完整的字段名
   */
  private String getFullFieldName(String fieldName) {
    String trimFieldName = fieldName.trim();
    // 如果fieldName以left join的字段别名开头（如：rule.name），则不需要再增加该实体的别名
    String leftJoinAlias = StringUtils.substringBefore(trimFieldName, ".");
    if (leftJoinFields.containsValue(leftJoinAlias)) {
      return trimFieldName;
    }
    
    return getAlias() + "." + trimFieldName;
  }
  
  /**
   * @return rowCountPerPage
   */
  public int getRowCountPerPage() {
    return rowCountPerPage;
  }
  
  /**
   * @param rowCountPerPage
   *        set rowCountPerPage
   */
  public void setRowCountPerPage(int rowCountPerPage) {
    this.rowCountPerPage = rowCountPerPage;
  }
  
  /**
   * @return selectFields
   */
  public Set<String> getSelectFields() {
    return selectFields;
  }
  
  /**
   * @param selectFields
   *        set selectFields
   */
  public void setSelectFields(Set<String> selectFields) {
    this.selectFields = selectFields;
  }
  
  /**
   * @return startRowIndex
   */
  public int getStartRowIndex() {
    return startRowIndex;
  }
  
  /**
   * @param startRowIndex
   *        set startRowIndex
   */
  public void setStartRowIndex(int startRowIndex) {
    this.startRowIndex = startRowIndex;
  }
  
  /**
   * @return paramNameValues
   */
  Map<String, Object> getParamNameValues() {
    return paramNameValues;
  }
  
  /**
   * @return wrapResult
   */
  public boolean isWrapResult() {
    return wrapResult;
  }
  
  /**
   * @param wrapResult
   *        set wrapResult
   */
  public void setWrapResult(boolean wrapResult) {
    this.wrapResult = wrapResult;
  }
  
  /**
   * @return hqlStr
   */
  public String getHqlStr() {
    return hqlStr;
  }
  
  /**
   * @param hqlStr
   *        set hqlStr
   */
  public void setHqlStr(String hqlStr) {
    this.hqlStr = hqlStr;
  }
  
  /**
   * @return values
   */
  public List<Object> getValues() {
    return values;
  }
  
  /**
   * @param values
   *        set values
   */
  public void setValues(List<Object> values) {
    this.values = values;
  }
  
  /**
   * @return detachedCriteria
   */
  public DetachedCriteria getDetachedCriteria() {
    return detachedCriteria;
  }
  
  /**
   * @param detachedCriteria
   *        set detachedCriteria
   */
  public void setDetachedCriteria(DetachedCriteria detachedCriteria) {
    this.detachedCriteria = detachedCriteria;
  }
}