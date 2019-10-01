package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class IndexController {//extends MultiActionController{
	@RequestMapping("/index0")
	public ModelAndView handleRequest(HttpServletRequest req, HttpServletResponse res) {
		ModelAndView mav = new ModelAndView("index.jsp");
		mav.addObject("msg","Hello handleRequest-method Sprint MVC");
		return mav;
	}
	
	@RequestMapping("/index")
	public ModelAndView show(HttpServletRequest req, HttpServletResponse res) {
		ModelAndView mav = new ModelAndView("index.jsp");
		mav.addObject("msg","Hello show-method Sprint MVC");
		return mav;
	}
}
