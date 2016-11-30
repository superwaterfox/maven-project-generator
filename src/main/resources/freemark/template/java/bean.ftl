package ${package}.domain;

import java.util.Date;
import java.util.Set;
import java.math.BigDecimal;
import java.sql.Blob;


/**
 * ${comment}模型对象
 * @author moon.l
 *
 */
public class ${vo} extends AbstractValueObject {


	public String ${pk};//主键
<#list tabledef as field>
	public ${field.filed_type} ${field.code}; //${field.name}
	<#if field.filed_type == "Blob">
	public String temp_${field.code}; //${field.name}转String
	</#if>
</#list>
	//
 	public String getPrimaryKey() {
        return ${pk};
    }

    public void setPrimaryKey(String key) {
        this.${pk} = key;
    }

	public String get${pk?cap_first}(){
        return ${pk};
    }
	//${pk} set
    public void set${pk?cap_first}(String ${pk}){
        this.${pk} = ${pk};
    }

<#list tabledef as field>
	//${field.name} get
	public ${field.filed_type} get${field.code?cap_first}(){
        return ${field.code};
    }
	//${field.name} set
    public void set${field.code?cap_first}(${field.filed_type} ${field.code}){
        this.${field.code} = ${field.code};
    }
	
	<#if field.filed_type == "Blob">
	//存在Blob的情况
	//${field.name} get
	public String getTemp_${field.code}(){
        return temp_${field.code};
    }
	//${field.name} set
    public void setTemp_${field.code}(String temp_${field.code}){
        this.temp_${field.code} = temp_${field.code};
    }
	</#if>
</#list>

}