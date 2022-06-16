package web01;

import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.tomcat.util.buf.StringUtils;
import org.springframework.stereotype.Service;
import web01.common.StringUtil;

@Service("applyService")
public class applyService extends abstractService{
	//final 변수
	/**
	 * final은 '제한한다'라는 공통적 의미. 변수에 붙이면 "수정할 수 없다" | 메서드에 붙이면 override 제한 |클래스에 붙이면 상속불가능
	 */
	public static final String PARAM_APPLY 			= "applyParam";
	public static final String ORIGIN_UNI_RCV_NO	= "0000000000000";
	
	@Resource(name="dsExampleMapper")
	private DsExampleMapper dsExampleMapper;
	
	
	public static void insertApply(Map<String, Object> applyMap) {
		// WORK
		HttpServletRequest req 			= (HttpServletRequest) applyMap.get("req");
		Map<String, Object> applyParam	= (Map<String, Object>)applyMap.get(PARAM_APPLY);
		
		if(log.isDebugEnabled()) {
			log.debug(StringUtil.mapKeyValue(applyParam));
			log.debug("알아보고 싶은거" + applyParam.get("parameter") + "]");
		}
		
		int insertResult = 0; //처리결과 담아주는 변수
		int updateResult = 0; //임시접수건 정식접수 결과
		if(ORIGIN_UNI_RCV_NO.equals("IDontWantThisNumber"))
		{
			//work true
		}
		else
		{
			//work false
		};
		if (log.isDebugEnabled()) {
			log.debug(StringUtil.mapKeyValue(applyParam)); //debug모드일 때만 출력.
		}
		
		//민원저장
		//insertResult = dsExampleMapper.insert("dsExample-web01/something.do",applyParam);
	}

}
