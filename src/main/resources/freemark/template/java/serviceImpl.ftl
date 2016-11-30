package ${package}.service.impl;

import java.io.UnsupportedEncodingException;
import java.sql.Blob;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.hibernate.Hibernate;
import org.springframework.stereotype.Service;

import com.lssd.cms.dao.BaseDAO;
import com.lssd.cms.domain.${vo};
import com.lssd.cms.domain.Page;
import com.lssd.cms.service.${vo}Service;
import com.lssd.cms.util.DataType;

/**
 * ${comment}业务实现
 * @author moon.l
 *
 */
@Service("${vo?uncap_first}Service")
public class ${vo}ServiceImpl implements ${vo}Service {
	
	@Resource
	private BaseDAO baseDAO;
	
	
	/**
	 * 查询数据的方法
	 */
	public Page search(Page pager) {
		if(pager == null){
			pager =  new Page();
		}
		pager.setBean("${package}.domain.${vo}");
		pager = baseDAO.pageQuery(pager);
		return pager;
	}

	/**
	 * 保存数据的方法
	 */
	public int save(${vo} vo) {
		<#list tabledef as field>
		<#if field.type == "BLOB">
    	//存在blob 的情况
		try {
			if(StringUtils.isNotBlank(vo.getTemp_${field.code}())){
				vo.set${field.code?cap_first}(Hibernate.createBlob(vo.getTemp_${field.code}().getBytes("UTF-8")));
			}
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}	
    	</#if>
		</#list>
		//
		int result = baseDAO.save(vo);
		return result;
	}

	/**
	 * 修改数据的方法
	 */
	public int update(${vo} vo) {
		<#list tabledef as field>
		<#if field.type == "BLOB">
   		//存在blob 的情况
		try {
			if(StringUtils.isNotBlank(vo.getTemp_${field.code}())){
				vo.set${field.code?cap_first}(Hibernate.createBlob(vo.getTemp_${field.code}().getBytes("UTF-8")));
			}
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}	
    	</#if>
		</#list>
		//
		int result = baseDAO.update(vo);
		return result;
	}
	
	/**
	 * 删除数据
	 */
	public int delete(${vo} vo) {
		int result = baseDAO.delete(vo);
		return result;
	}

	/**
	 * 查询单条数据
	 */
	public ${vo} searchById(String ${pk}) {
		${vo} vo = (${vo})baseDAO.getObject(${vo}.class, ${pk});
		<#list tabledef as field>
		<#if field.type == "BLOB">
   		//存在blob 的情况
		Blob blob = vo.get${field.code?cap_first}();
		if(null != blob){
			String temp_${field.code} = DataType.convertBlobToString(blob);
			vo.setTemp_${field.code}(temp_${field.code});
		}
		</#if>
		</#list>
		//
		return vo;
	}

}
