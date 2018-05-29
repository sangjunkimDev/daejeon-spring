package kr.or.ddit.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class ProfileInterceptController extends HandlerInterceptorAdapter{
	Logger logger = LoggerFactory.getLogger(getClass());
	
	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		
		long START_TIME = System.currentTimeMillis();
		request.setAttribute("START_TIME", START_TIME);
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		
		long START_TIME = (long) request.getAttribute("START_TIME");
		long END_TIME = System.currentTimeMillis();
		long DURATION = END_TIME - START_TIME;
		
		logger.debug("DURATION : {}", DURATION+"ms");
	}
	
}
