<?xml version="1.0"?>
<!DOCTYPE hibernate-mapping
PUBLIC "-//Hibernate/Hibernate Mapping DTD 3.0//EN"
"http://hibernate.sourceforge.net/hibernate-mapping-3.0.dtd">
<hibernate-mapping>
<class name="${package}.domain.${vo}" table="${table_name}">
 	<id name="${pk}" type="string" column="${pk}">
     <generator class="${package}.util.HibernateOIDGenerator"/>
    </id>
    <version name="ts" type="${package}.util.CharTimestampType"/>
	<#list tabledef as field>
	<#if field.type == "CHAR">
    <property name="${field.code}" type="string" column="${field.code}"/>
    </#if>
	<#if field.type == "VARCHAR">
    <property name="${field.code}" type="string" column="${field.code}"/>
    </#if>
	<#if field.type == "INTEGER">
    <property name="${field.code}" type="integer" column="${field.code}"/>
    </#if>
	<#if field.type == "INT">
    <property name="${field.code}" type="integer" column="${field.code}"/>
    </#if>
    <#if field.type == "DECIMAL">
    <property name="${field.code}" type="big_decimal" column="${field.code}"/>
    </#if>
    <#if field.type == "LONG">
    <property name="${field.code}" type="long" column="${field.code}"/>
    </#if>
    <#if field.type == "BLOB">
    <property name="${field.code}" type="java.sql.Blob" column="${field.code}"/>
    </#if>
	</#list>
</class>
</hibernate-mapping>
