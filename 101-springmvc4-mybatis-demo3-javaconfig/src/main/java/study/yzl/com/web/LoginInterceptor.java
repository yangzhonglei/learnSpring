package study.yzl.com.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import lombok.extern.slf4j.Slf4j;
import study.yzl.com.model.SysLoginAcct;
import study.yzl.com.utils.ResponseMessage;

@Slf4j
public class LoginInterceptor extends HandlerInterceptorAdapter {

	
	
//	@Override
//	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
//		
//		RequestMapping rm = ((HandlerMethod) handler).getMethodAnnotation(RequestMapping.class);
//		boolean alreadyLoggedIn = request.getSession().getAttribute("SysLoginAcct") != null;
//		boolean loginPageRequested = rm != null && rm.value().length > 0 && "login".equals(rm.value()[0]);
//
//		if (alreadyLoggedIn && loginPageRequested) {
//			response.sendRedirect(request.getContextPath() + "/app/main-age");
//			return false;
//		} else if (!alreadyLoggedIn && !loginPageRequested) {
//			response.sendRedirect(request.getContextPath() + "/login");
//			return false;
//		}
//
//		return true;
//	}
	
	@Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

    	
    	log.info("LoginInterceptor ");
        boolean flag = false;
        String servletPath = request.getServletPath();
//        for(String s : IGNORE_URI) {
//            if(servletPath.contains(s)) {
//                flag = true;
//                break;
//            }
//        }
        if(flag == false) {
        	
        	SysLoginAcct acct  = (SysLoginAcct) request.getSession().getAttribute("sysLoginAcct");
            if(acct == null) {
//                request.setAttribute("error", "您还没有登录，请登录！");
//                request.getRequestDispatcher("login").forward(request, response);
                SendMsgUtil.sendJsonMessage(response, ResponseMessage.failMessage("未登录"));
                
            }else {
                flag = true;
            }
        }
        return flag;
    }

}
