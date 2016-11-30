<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<% 
   String contextPath = request.getContextPath(); 
   request.setAttribute("contextPath", contextPath);
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>${comment} 操作结果</title>
<link type="text/css" rel="stylesheet" href="${r"${contextPath}"}/css/bootstrap.min.css" />
<link type="text/css" rel="stylesheet" href="${r"${contextPath}"}/css/bootstrap-responsive.min.css" />
<link type="text/css" rel="stylesheet" href="${r"${contextPath}"}/plugin/buttons/css/font-awesome.min.css" />
<link type="text/css" rel="stylesheet" href="${r"${contextPath}"}/plugin/buttons/css/buttons.css" />
<style type="text/css">
a:hover{color:white;text-decoration:none;}
table{border-collapse:separate;}
</style>
</head>
<body>
   <div class="container" style="margin-top:30px;">
    	<fieldset id="successInfo" style="display:none;">
		    <legend>操作成功  </legend>
		    <div class="alert alert-success" style="padding-top:10px;">
              <h3>${comment} 操作成功 !</h3> 数据成功提交....
              <div style="margin-left:300px;margin-top:10px;">
                  	 <a href="#" id="manage-btn" class="button button-rounded button-flat-primary">管理界面</a>
              </div>
            </div>
		</fieldset>
		<fieldset id="errorInfo" style="display:none;">
		    <legend>操作失败 </legend>
		    <div class="alert alert-error" style="padding-top:10px;">
              <h3>${comment} 操作失败 </h3> 提交数据未能成功....
              <div style="margin-left:300px;margin-top:10px;"> 
                  <a href="#" id="manage-btn" class="button button-rounded button-flat-primary">管理界面</a>
              </div>
            </div>
		</fieldset>
   </div><!-- container end -->
<script type="text/javascript" src="${r"${contextPath}"}/js/jquery-1.7.2.min.js"></script>
<script type="text/javascript" src="${r"${contextPath}"}/js/bootstrap.min.js"></script>
<script>
$(function(){
	if('${r"${result}"}' == 1){
		$("#successInfo").show();
	}else{
		$("#errorInfo").show();
	}
	
	$("#manage-btn").click(function(){
		window.self.location = "${r"${contextPath}"}/front/${vo?uncap_first}_index.action";
	});
});
</script>
</body>
</html>