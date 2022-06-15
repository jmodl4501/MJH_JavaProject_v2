package web01.common;
import web01.Contants;
import web01.UserSessionVO;

import java.util.HashMap;
/*스프링 주석 제거를 위해 사용*/
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

public class NexacroMapDTO extends applyController{

	public Map<String, Object> getMap(String string) {
		// TODO Auto-generated method stub
		return null;
	}

	public Map<String, Object> getApplyMap(String applyDSName, NexacroMapDTO xpdto, HttpServletRequest request) {
		
		Map<String, Object> result		= new HashMap<String, Object>();
		Map<String, Object> applyMap	= xpdto.getMap(applyDSName);
		result.put("req", request);
		//세션 정보
		applyMap = this.setSessionInfo (applyMap);
		
		
		return null;
	}
}
