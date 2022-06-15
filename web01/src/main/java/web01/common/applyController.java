package web01.common;

import java.util.Map;

import web01.Contants;
import web01.UserSessionVO;

public class applyController extends coreController {

	public final Map<String, Object> setSessionInfo(Map<String, Object> applyMap) {
		//대충 세션정보 넣는 메소드
		UserSessionVO vo = (UserSessionVO) getSessionAttribute(Contants.USER_SESSION);
		return null;
	}
}
