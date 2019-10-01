package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
@Controller
public class Index2Controller {
	@RequestMapping("/index2")
	public ModelAndView handleRequest(HttpServletRequest req, HttpServletResponse res) {
		ModelAndView mav = new ModelAndView("index");
		mav.addObject("msg","Hello Sprint anoation MVC");
		return mav;
	}
	
	
	@RequestMapping("/jump")
	public ModelAndView jump() {
		ModelAndView mav = new ModelAndView("redirect:/index2");
		return mav;
	}
	
  @RequestMapping("/check")
	public ModelAndView check(HttpSession session) {
		Integer i = (Integer) session.getAttribute("count");
		if (i == null)
			i = 0;
		i++;
		session.setAttribute("count", i);
		ModelAndView mav = new ModelAndView("check");
		return mav;
	}
  @RequestMapping("/clear")
	public ModelAndView clear(HttpSession session) {
		session.removeAttribute("count");
		ModelAndView mav = new ModelAndView("redirect:/check");
		return mav;
	}
}
