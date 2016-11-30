<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="pg" uri="http://jsptags.com/tags/navigation/pager"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<% 
   String contextPath = request.getContextPath(); 
   request.setAttribute("contextPath", contextPath);
%>
<!DOCTYPE HTML>
<html>
<head>
<meta charset="utf-8">
<meta name="renderer" content="webkit|ie-comp|ie-stand">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta http-equiv="Cache-Control" content="no-siteapp" />
<link href="${r"${contextPath}"}/managers/css/H-ui.min.css" rel="stylesheet" type="text/css" />
<link href="${r"${contextPath}"}/managers/css/H-ui.admin.css" rel="stylesheet" type="text/css" />
<link href="${r"${contextPath}"}/managers/lib/Hui-iconfont/1.0.1/iconfont.css" rel="stylesheet" type="text/css" />
<link type="text/css" rel="stylesheet" href="${r"${contextPath}"}/css/bootstrap.min.css" />
<link type="text/css" rel="stylesheet" href="${r"${contextPath}"}/css/bootstrap-responsive.min.css" />
<title>${comment}-管理界面</title>
</head>
<body>
<div class="pd-20">
	<div class="cl pd-5 bg-1 bk-gray mt-20">
		查询条件：<br/>
		<#list tabledef as field>
			<#if field.filed_type == "String">
				<span>${field.name}:</span>
				<input type="text" id="s_${field.code}"/>			
			</#if>
		</#list>
		
	</div>
	<div class="cl pd-5 bg-1 bk-gray mt-20">
		<a id="sel_btn" href="#" class="btn btn-success radius"><i class="Hui-iconfont">&#xe665;</i>查询</a>
		<a id="sel_rest" href="#" class="btn btn-danger radius"><i class="Hui-iconfont">&#xe631;</i>重置</a>
		<a id="add-btn" href="#" class="btn btn-primary radius"><i class="Hui-iconfont">&#xe600;</i>添加数据</a>
  	</div>
	<div class="mt-20">
	<table class="table table-border table-bordered table-hover table-bg table-sort">
		<thead>
			<tr class="text-c">
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
	               <a href="#" tbid="${f_1}${pk}${f_2}" ts="${f_1}ts${f_2}"  class="button button-rounded button-flat-primary btn_del">
						<i class="Hui-iconfont">&#xe6e2;</i>
						<span>删除</span>
				   </a>
	               <a href="#" tbid="${f_1}${pk}${f_2}"  class="button button-rounded button-flat-primary btn_update">
						<i class="Hui-iconfont">&#xe6df;</i>
						<span>修改</span>
				   </a>
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
	</div>
</div>
<script type="text/javascript" src="${r"${contextPath}"}/js/jquery-1.7.2.min.js"></script>
<script type="text/javascript" src="${r"${contextPath}"}/plugin/lhgdialog/lhgdialog.js?skin=mac"></script>
<script type="text/javascript" src="${r"${contextPath}"}/js/jquery.json.js"></script>
<script type="text/javascript" src="${r"${contextPath}"}/managers/lib/layer/1.9.3/layer.js"></script>
<script type="text/javascript" src="${r"${contextPath}"}/managers/lib/laypage/1.2/laypage.js"></script> 
<script type="text/javascript" src="${r"${contextPath}"}/managers/lib/My97DatePicker/WdatePicker.js"></script> 
<script type="text/javascript" src="${r"${contextPath}"}/managers/lib/datatables/1.10.0/jquery.dataTables.min.js"></script> 
<script type="text/javascript" src="${r"${contextPath}"}/managers/js/H-ui.js"></script> 
<script type="text/javascript" src="${r"${contextPath}"}/managers/js/H-ui.admin.js"></script> 
<script type="text/javascript">
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
		window.self.location = "${r"${contextPath}"}/managers/${vo?uncap_first}/add.jsp";
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