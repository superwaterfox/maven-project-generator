<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<% 
   String contextPath = request.getContextPath(); 
   request.setAttribute("contextPath", contextPath);
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>${comment}-数据修改</title>
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
		    <legend>${vo} Update<a id="index-btn" href="#" class="button button-rounded button-flat-primary" style="margin-left:300px;margin-bottom:10px;"><i class="icon-home"></i>${comment}数据列表</a>
		    </legend>
		    	<form class="form-horizontal" id="commentForm" method="post" action="${r"${contextPath}"}/front/${vo?uncap_first}_update.action">
				  <div class="control-group" style="display:none;">
				    <label class="control-label" for="input${pk?cap_first}">主键</label>
				    <div class="controls">
				      <input type="text" id="input${pk?cap_first}" name="${vo?uncap_first}.${pk}" value="${f_1}${vo?uncap_first}.${pk}${f_2}" />
					  <input type="text" id="inputTs" name="${vo?uncap_first}.ts" value="${f_1}${vo?uncap_first}.ts${f_2}" />
				    </div>
				  </div>
				  
				  <#list tabledef as field>
				    <#if field.filed_type != "Blob">
					<div class="control-group">
				    	<label class="control-label" for="input${field.code?cap_first}">${field.name}</label>
				    	<div class="controls">
				     	  <input type="text" id="input${field.code?cap_first}" name="${vo?uncap_first}.${field.code}" value="${f_1}${vo?uncap_first}.${field.code}${f_2}" />
				    	</div>
				  	</div>
					</#if>
					<#if field.filed_type == "Blob">
					<div class="control-group">
				    	<label class="control-label" for="input${field.code?cap_first}">${field.name}</label>
				    	<div class="controls">
							<textarea name="${vo?uncap_first}.temp_${field.code}" id="inputTemp_${field.code}" class="content" style="width:700px;height:250px;">
								${f_1}${vo?uncap_first}.temp_${field.code}${f_2}
							</textarea>
				    	</div>
				  	</div>
					</#if>
					</#list>
				  <div class="control-group">
				    <div class="controls">
				      <input class="button button-rounded button-flat-primary" id="update-btn" type="submit" value="提交"/>
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
	$("#update-btn").click(function(){
		$(".form-horizontal").submit();
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