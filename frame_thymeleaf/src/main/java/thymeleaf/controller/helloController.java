package thymeleaf.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import thymeleaf.bean.Product;

@Controller
public class helloController {
	
	@RequestMapping("/test1")
	public String hello(Model m) {
		//boolean 条件判断
		//字符串拼接
		//包含
		m.addAttribute("name", "thymeleaf!!!!");
        boolean testBoolean = true; 
        m.addAttribute("testBoolean", testBoolean);
		return "test1";
	}
	
	@RequestMapping("/test2")
	public String test(Model m) {
		//取值方式
		//表达式
		String htmlContent = "<p style='color:red'> 红色文字</p>";
        Product currentProduct =new Product(5,"product e", 200);
        boolean testBoolean = true; 
        
        m.addAttribute("htmlContent", htmlContent);
        m.addAttribute("currentProduct", currentProduct);
        System.out.println("d");
        return "test2";
	}
	@RequestMapping("/test3")
	public String test2(Model m) {
		//迭代与循环
		String htmlContent = "<p style='color:red'> 红色文字</p>";
        Product currentProduct =new Product(5,"product e", 200);
        boolean testBoolean = true;
         
        List<Product> ps = new ArrayList<>();
        ps.add(new Product(1,"product a", 50));
        ps.add(new Product(2,"product b", 100));
        ps.add(new Product(3,"product c", 150));
        ps.add(new Product(4,"product d", 200));
        ps.add(currentProduct);
        ps.add(new Product(6,"product f", 200));
        ps.add(new Product(7,"product g", 200));       
         
        m.addAttribute("ps", ps);
        m.addAttribute("htmlContent", htmlContent);
        m.addAttribute("currentProduct", currentProduct);
        m.addAttribute("testBoolean", testBoolean);
         
        return "test3";
	}
	
}
