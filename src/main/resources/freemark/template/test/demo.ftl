<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
    "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta http-equiv="content-type" content="text/html; charset=utf-8" />
	<meta http-equiv="X-UA-Compatible" content="IE=edge" />
	
		<title>${head.title!''}</title>
		<meta name="author" content="${head.author!''}" />
		<meta name="copyright" content="${head.copyright!''}" />
		<meta name="keywords" content="${head.keywords!''}" />
		<meta name="description" content="${head.description!''}" />
</head>
<body>
	<table>
		<thead>
			<tr>编号</tr>
			<tr>中文名</tr>
			<tr>英文名</tr>
			<tr>排序</tr>
		</thead>
		<tbody>
			 <#list ArticleTypes as article_type>       
                <tr>
                	<td>${article_type.id!''}</td>
                	<td>${article_type.name!''}</td>
                	<td>${article_type.en_name!''}</td>
                	<td>${article_type.orders!''}</td>
                	<td>${name!''}</td>
                </tr>
            </#list>
		</tbody>
	</table>
</body>
</html>
