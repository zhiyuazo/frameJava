package trytest.example.controller;

import java.text.DateFormat;
import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {
	
	@ResponseBody
	@RequestMapping("/hello")
	public String hello() {
		return "Hello spring Boot...";
	}

	@RequestMapping("/hellojsp")
	public String hellojsp(Model m) {
		m.addAttribute("now" , DateFormat.getDateTimeInstance().format(new Date()));
		return "hello_springboot/hellojsp";
	}
	
	@RequestMapping("/helloerr")
	public String helloerr(Model m) throws Exception {
		throw new Exception("MeetSomeExceptions...");
	}
}
