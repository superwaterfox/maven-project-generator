<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE struts PUBLIC
	"-//Apache Software Foundation//DTD Struts Configuration 2.3//EN"
	"http://struts.apache.org/dtds/struts-2.3.dtd">

<struts>

	<constant name="struts.devMode" value="false" />
	<constant name="struts.objectFactory" value="spring" />
	<constant name="struts.i18n.encoding" value="UTF-8" />
	<constant name="struts.ui.theme" value="simple" />
	<constant name="struts.locale" value="zh_CN" />
	<constant name="struts.multipart.maxSize" value="20971520"/>

	<package name="front" extends="json-default" namespace="/front">
	
		<action name="${vo?lower_case}_*" class="${package}.action.${vo}Action" method="{1}">
			<result name="result-json" type="json">
				<param name="root">result</param>
			</result>
			<result name="result-jsp">/managers/${vo?lower_case}/result.jsp</result>
			<result name="index">/managers/${vo?lower_case}/index.jsp</result>
			<result name="intoUpdate">/managers/${vo?lower_case}/update.jsp</result>
		</action>

	</package>
</struts>
