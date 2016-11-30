package ${package}.action;
 
import javax.annotation.Resource;
import org.springframework.stereotype.Controller;
import com.core.code.action.BaseAction;

import com.lssd.cms.domain.${vo};
import com.lssd.cms.domain.Page;
import com.lssd.cms.service.${vo}Service;
/**
 * ${comment}µÄ¿ØÖÆÆ÷
 * @author moon.l
 *
 */
@SuppressWarnings("serial")
@Controller
public class ${vo}Action extends BaseAction {
 
	
	private ${vo} ${vo?uncap_first};
	
	private Page pager;
	
	private int result;
	
	private String backurl;
	
	@Resource
	private ${vo}Service ${vo?uncap_first}Service;
 
	public String index(){
		pager = ${vo?uncap_first}Service.search(pager);
		return "index";
	}
	
	public String add(){
		result = ${vo?uncap_first}Service.save(${vo?uncap_first});
		backurl = "${vo?uncap_first}/add.jsp";
		return "result-jsp";
	}
	
	public String delete(){
		result = ${vo?uncap_first}Service.delete(${vo?uncap_first});
		return "result-json";
	}
	
	public String intoUpdate(){
		${vo?uncap_first} = ${vo?uncap_first}Service.searchById(${vo?uncap_first}.get${pk?cap_first}());
		return "intoUpdate";
	}
	
	public String update(){
		result = ${vo?uncap_first}Service.update(${vo?uncap_first});
		backurl = "front/${vo?uncap_first}_intoUpdate.action?${vo?uncap_first}.${pk}="+${vo?uncap_first}.get${pk?cap_first}();
		return "result-jsp";
	}
	
	public ${vo} get${vo}(){
		return ${vo?uncap_first};
	}
	public void set${vo}(${vo} ${vo?uncap_first}){
		this.${vo?uncap_first} = ${vo?uncap_first};
	}
	public int getResult() {
		return result;
	}
	public void setResult(int result) {
		this.result = result;
	}
	public Page getPager() {
		return pager;
	}
	public void setPager(Page pager) {
		this.pager = pager;
	}
	public String getBackurl() {
		return backurl;
	}
	public void setBackurl(String backurl) {
		this.backurl = backurl;
	}
}