package web01;

import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import web01.common.NexacroMapDTO;
import web01.common.applyController;

@Controller
public class NexaExampleController extends applyController{ //applyController에서 상속받아 setSessionInfo 메서드를 불러 옴.
	
	@Resource(name="nexaExampleService") //서비스이름을 이렇게 지정해줘야함
	protected NexaExampleService nexaExampleService; 
	
	@RequestMapping(value = {"/something.do"})	
	@SuppressWarnings("unchecked") //검증되지 않은 연산자 경고만 무시	
	public NexacroResult something(NexacroMapDTO xpdto, NexacroResult result, HttpServletRequest request) throws Exception{
		
		Map<String, Object> paramMap 	= xpdto.getMap("dsParam");
		Map<String, Object> applyMap	= xpdto.getApplyMap("dsApply", xpdto, request);
		paramMap = setSessionInfo(paramMap);
		applyMap.put("dsParam", paramMap);
		nexaExampleService.something(paramMap,applyMap);
		
		return result;
	}
}
