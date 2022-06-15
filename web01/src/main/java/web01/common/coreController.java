package web01.common;

import javax.servlet.http.HttpSession;

import org.springframework.web.context.request.RequestContextHolder;

import web01.UserSessionVO;

public class coreController {
	public static final Object getSessionAttribute(String userSession) {
		try {
			HttpSession session = (HttpSession) RequestContextHolder.getRequestAttributes().getAttribute("WEB01_REQUESTHOLDER_SESSION_ATTRIBUTE", 1); //임의로 WEB01 설정
			return session.getAttribute(userSession);
		} catch(Exception localException){
		}
		return null;
	}
}
