package web01;

import java.util.Map;

import org.springframework.stereotype.Service;

@Service("nexaExampleService") //스프링프레임워크 stereotype.Service를 통해서 서비스 제공가능.
public class NexaExampleService extends abstractService{
	public void something(Map<String, Object> paramMap, Map<String, Object> applyMap) {
		//파일정보 저장
		applyService.insertApply(applyMap);
		
		//220615_책갈피
		//트랜젝션
//		dsSomethingMapper.update("dsExample-web01/nexaExample", paramMap);
		
	}

}
