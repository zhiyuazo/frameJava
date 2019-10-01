package trytest.mybatisxml.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import trytest.mybatisxml.bean.Product;
import trytest.mybatisxml.mapper.ProductMapper;
import trytest.mybatiszhujie.bean.User;

@Controller
public class ProductController {
	@Autowired	
	ProductMapper productMapper;
	
	@RequestMapping("listproduct")
	public String listCategory(Model m) throws Exception{
		List<Product> ps = productMapper.findAll();
		m.addAttribute("ps",ps);
		return "mybatis_try_xml/listProduct";
		
	}
	
	
}
