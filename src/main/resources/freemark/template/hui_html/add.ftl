<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<% 
   String contextPath = request.getContextPath(); 
   request.setAttribute("contextPath", contextPath);
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>${comment}-添加数据</title>
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
	form.form-horizontal label.error, label.error {  
		color: red;  
		font-style: italic;  
	}  
</style>
</head>
<body>
   <div class="container" style="margin-top:30px;">
    	<fieldset>
		    <legend>
			${comment}数据添加
			<a id="index-btn" href="#" class="button button-rounded button-flat-primary" style="margin-left:300px;margin-bottom:10px;">
			<i class="icon-home"></i>
			<span>返回数据列表</span>
			</a>
		    </legend>
		    	<form class="form-horizontal" id="commentForm" method="post" action="${r"${contextPath}"}/front/${vo?uncap_first}_add.action">
				
				  <#list tabledef as field>
				    <#if field.filed_type != "Blob">
					<div class="control-group">
				    	<label class="control-label" for="input${field.code?cap_first}">${field.name}</label>
				    	<div class="controls">
				     	  <input type="text" id="input${field.code?cap_first}" name="${vo?uncap_first}.${field.code}" />
				    	</div>
				  	</div>
					</#if>
					<#if field.filed_type == "Blob">
					<div class="control-group">
				    	<label class="control-label" for="input${field.code?cap_first}">${field.name}</label>
				    	<div class="controls">
							<textarea name="${vo?uncap_first}.temp_${field.code}" id="inputTemp_${field.code}" class="content" style="width:700px;height:250px;"></textarea>
				    	</div>
				  	</div>
					</#if>
					</#list>
				    <div class="control-group">
				         <div class="controls">
				      	      <input class="button button-rounded button-flat-primary" type="submit" value="提交"/>
				      	      <input class="button button-rounded button-flat-primary" id="cancel-btn" type="button" value="取消"/>
				    	</div>
				  	</div>
				</form>
		</fieldset>
   </div><!-- container end -->
<script type="text/javascript" src="${r"${contextPath}"}/js/jquery-1.7.2.min.js"></script>
<script type="text/javascript" src="${r"${contextPath}"}/js/bootstrap.min.js"></script>
<script type="text/javascript" src="${r"${contextPath}"}/js/jquery.validate.min.js"></script>
<script language="javascript" type="text/javascript" src="${r"${contextPath}"}/jslib/kindeditor-min.js"></script>
<script language="javascript" type="text/javascript" src="${r"${contextPath}"}/jslib/lang/zh_CN.js"></script>
<script>
$(function(){
	createEditor();
	$("#cancel-btn").click(function(){
		window.self.location = "${r"${contextPath}"}/front/${vo?uncap_first}_index.action";
	});
	$("#index-btn").click(function(){
		window.self.location = "${r"${contextPath}"}/front/${vo?uncap_first}_index.action";
	});
	
	$("#commentForm").validate({
                rules: {  
                    <#list tabledef as field>
					<#if field.ifnull == "NO">
					'${vo?uncap_first}.${field.code}': {  
                        required:true
                    },
					</#if>
					<#if field.filed_type == "Int">
					'${vo?uncap_first}.${field.code}': {  
                        number:true
                    },
					</#if>
					<#if field.filed_type == "Integer">
					'${vo?uncap_first}.${field.code}': {  
                        number:true
                    },
					</#if>
					</#list>
					&**&*去掉逗号
                },  
                messages: {
					<#list tabledef as field>
					<#if field.ifnull == "NO">
					'${vo?uncap_first}.${field.code}': {  
                        required:${field.name}"还没有填写"
                    },
					</#if>
					<#if field.filed_type == "Int">
					'${vo?uncap_first}.${field.code}': {  
                        number:"请输入数字,必须为整数"
                    },
					</#if>
					<#if field.filed_type == "Integer">
					'${vo?uncap_first}.${field.code}': {  
                        number:"请输入数字,必须为整数"
                    },
					</#if>
					</#list>
					&**&*去掉逗号
                }  
        });  
});
var editor;


var createEditor = function(){
	editor = KindEditor.create('textarea[class="content"]', {
		items : [ 'fontname', 'fontsize', '|', 'forecolor',
				'hilitecolor', 'bold', 'italic', 'underline',
				'removeformat', '|', 'justifyleft', 'justifycenter',
				'justifyright', 'insertorderedlist',
				'insertunorderedlist', '|', 'emoticons','image',
				'link', 'preview' ]
	});
}
</script>
</body>
</html>