package interceptor;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class IndexInterceptor extends HandlerInterceptorAdapter{
	    public boolean preHandle(HttpServletRequest request,   
	            HttpServletResponse response, Object handler) throws Exception {
	        System.out.println("preHandle(), �ڷ���Controller֮ǰ������"); 
	        return true;
	         
	    } 
	 
	    public void postHandle(HttpServletRequest request,   
					HttpServletResponse response, Object handler,   
					ModelAndView modelAndView) throws Exception { 
	        System.out.println("postHandle(), �ڷ���Controller֮�󣬷�����ͼ֮ǰ������,�������ע��һ��ʱ�䵽modelAndView�У����ں�����ͼ��ʾ");
	        modelAndView.addObject("date","�����������ɵ�ʱ��:" + new Date());
	    } 
	 
	     
	    public void afterCompletion(HttpServletRequest request,   
	            					HttpServletResponse response, Object handler, Exception ex) throws Exception { 
	        System.out.println("afterCompletion(), �ڷ�����ͼ֮�󱻵���"); 
	    }  
}
