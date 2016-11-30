<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="pg" uri="http://jsptags.com/tags/navigation/pager"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<% 
   String contextPath = request.getContextPath(); 
   request.setAttribute("contextPath", contextPath);
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>${comment}-管理界面</title>
<link type="text/css" rel="stylesheet" href="${r"${contextPath}"}/css/bootstrap.min.css" />
<link type="text/css" rel="stylesheet" href="${r"${contextPath}"}/css/bootstrap-responsive.min.css" />
<link type="text/css" rel="stylesheet" href="${r"${contextPath}"}/plugin/buttons/css/font-awesome.min.css" />
<link type="text/css" rel="stylesheet" href="${r"${contextPath}"}/plugin/buttons/css/buttons.css" />
<style type="text/css">
a:hover{
	color:white;
	text-decoration:none;
}
table{
	border-collapse:separate;
}
li {
	float:left;
	line-height:20px;
	text-indent:10px;
}
</style>
</head>
<body>
   <div class="container" style="margin-top:30px;">
		
    	<fieldset>
    		<legend>${comment}-管理列表</legend>
    		 
			<div id="sel_input" style="margin-bottom: 8px; width:100%;height:80px;" >
			<#list tabledef as field>
			<#if field.filed_type == "String">
			<ul class="inline">
				<li>${field.name}:</li>
				<li><input type="text" id="s_${field.code}"/></li>			
			</ul>
			</#if>
			</#list>
			</div>
		    
		    <div style="margin-bottom: 8px;">
		    	<a id="sel_btn" href="#" class="button button-rounded button-flat-primary">查询</a>
		    	<a id="sel_rest" href="#" class="button button-rounded button-flat-primary">重置</a>
		    	<a id="add-btn" href="#" class="button button-rounded button-flat-primary">添加</a>
		    	
		    </div>
			
			
			<table class="table table-bordered table-hover table-condensed table-striped">
              <thead>
                <tr>
				<#list tabledef as field>
				<#if field.filed_type != "Blob">
					<td>${field.name}</td>
				</#if>
				</#list>
					<td>数据操作</td>
                </tr>
              </thead>
              <tbody>
              	<s:iterator var="item" value="#request.pager.datas">
                	<tr>
					<#list tabledef as field>
					<#if field.filed_type != "Blob">
					<td>${f_1}${field.code}${f_2}</td>
					</#if>
					</#list>
	                <td>
	                	<a href="#" tbid="${f_1}${pk}${f_2}" ts="${f_1}ts${f_2}"  class="button button-rounded button-flat-primary btn_del">删除</a>
	                	<a href="#" tbid="${f_1}${pk}${f_2}"  class="button button-rounded button-flat-primary btn_update">修改</a>
	                </td>
                	</tr>
                 </s:iterator>
              </tbody>
            </table>
            <s:if test="%{#request.pager.total > 0}">
					<!-- 分页 -->
					<div id="pagination" class="pagination" >
						<ul>
							<!-- 分页控件，页显示行数 -->
							<pg:pager maxPageItems="10" url="${r"${contextPath}"}/front/${vo?uncap_first}_index.action" items="${r"${pager.total}"}"	
								export="currentPageNumber=pageNumber">
								
								<pg:param name="pager.json" value="${r"${pager.json}"}"/>
								<pg:first>
										<li class="" ><a id="firstPage" href="${r"${pageUrl}"}" >首页</a></li>
								</pg:first>
								<pg:prev>
									<li ><a id="nextPage" href="${r"${pageUrl}"}" >上一页</a></li>
								</pg:prev>
								<pg:pages>
									<c:choose> 
										<c:when test="${r"${currentPageNumber == pageNumber}"}">
											<li class="active"><a href="#"><s:property value="pageNumber"/>${r"${pageNumber}"}</a></li>
										</c:when>
										<c:otherwise>
											<li class=""><a href="${r"${pageUrl}"}">${r"${pageNumber}"}</a></li>
										</c:otherwise>
									</c:choose>
								</pg:pages>
								<pg:next>
									<li><a id="nextPage" href="${r"${pageUrl}"}" >下一页</a></li>
								</pg:next>
								<pg:last>
										<li><a id="endPage" href="${r"${pageUrl}"}" >尾页</a></li>
								</pg:last>
							</pg:pager>
						</ul>
					</div>
				   <!-- /分页 -->
				</s:if>
		  </fieldset>
   </div><!-- container end -->
<script type="text/javascript" src="${r"${contextPath}"}/js/jquery-1.7.2.min.js"></script>
<script type="text/javascript" src="${r"${contextPath}"}/js/bootstrap.min.js"></script>
<script type="text/javascript" src="${r"${contextPath}"}/plugin/lhgdialog/lhgdialog.js?skin=mac"></script>
<script type="text/javascript" src="${r"${contextPath}"}/js/jquery.json.js"></script>
<script type="text/javascript" src="${r"${contextPath}"}/js/qunit.js"></script>
<script>
$(function(){
	//重置查询框中的值
	$("#sel_rest").click(function(){
		<#list tabledef as field>
		<#if field.filed_type == "String">
		$("#s_${field.code}").val("");
		</#if>
		</#list>
	});
	//查询按钮
	$("#sel_btn").click(function(){
		<#list tabledef as field>
		<#if field.filed_type == "String">
			var ${field.code} = $("#s_${field.code}").val();
		</#if>
		</#list>
			var ${vo?uncap_first} = {
				<#list tabledef as field>
				<#if field.filed_type == "String">
				'${field.code}': ${field.code},
				</#if>
				</#list>
				##去掉最后一个,
			};
			var json = $.toJSON(${vo?uncap_first});
			window.self.location = "${r"${contextPath}"}/front/${vo?uncap_first}_index.action?pager.json="+json;
	});
	//点击添加跳转页面
	$("#add-btn").click(function(){
		window.self.location = "${r"${contextPath}"}/${vo?uncap_first}/add.jsp";
	});
	//点击删除事件
	$(".btn_del").click(function(){
		var tbid = $(this).attr("tbid");
		var ts = $(this).attr("ts");
		$.dialog({
			title:"确认删除",
			id:"delDialog",
		    lock: true,
		    content: '删除后信息后，信息将不再列表中显示。',
		    icon: 'prompt.gif',
		    time: 18,
		    ok: function () {
		    	/**确认信息*/
		    	$.post("${r"${contextPath}"}/front/${vo?uncap_first}_delete.action",{
					"${vo?uncap_first}.${pk}":tbid,
					"${vo?uncap_first}.ts":ts
				},function(msg){
					if(msg == 1){
						refresh();
					}
				});
		    },
		    cancel: true,
		    width:280
		});
	});
	//进入修改查询界面
	$(".btn_update").click(function(){
		var tbid = $(this).attr("tbid");
		window.self.location = "${r"${contextPath}"}/front/${vo?uncap_first}_intoUpdate.action?${vo?uncap_first}.${pk}="+tbid;
	});
});
//刷新当前页面
function refresh(){
	window.self.location = "${r"${contextPath}"}/front/${vo?uncap_first}_index.action?pager.offset=${r"${pager.offset}"}";
}
</script>
</body>
</html>