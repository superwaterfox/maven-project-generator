package ${package}.service;

import com.lssd.cms.domain.${vo};
import com.lssd.cms.domain.Page;
/**
 * ${comment}业务接口
 * @author moon.l
 *
 */
public interface ${vo}Service {

	
	public Page search(Page pager);
	
	public int save(${vo} vo);
	
	public int update(${vo} vo);
	
	public int delete(${vo} vo);
	
	${vo} searchById(String ${pk});
}
