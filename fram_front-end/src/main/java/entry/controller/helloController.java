package entry.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class helloController {
	
	
	@RequestMapping("/test")
	@ResponseBody
	public String test() {
		return "Hello SprintBoot TmallCat...";
	}
	
	
	@RequestMapping("/include")
	public String include() {
		return "test";
	}

}
