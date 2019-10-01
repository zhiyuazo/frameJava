package trytest.jpa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import trytest.jpa.bean.Category;
import trytest.jpa.dao.CategoryDao;

@Controller
public class CategoryController {
	@Autowired CategoryDao categoryDao;

	@RequestMapping("listcategory")
	public String listCategory(Model m ,
							  @RequestParam(value="start" ,defaultValue="0")int start, 
							  @RequestParam(value="size" ,defaultValue="5")int size )throws Exception {
		Sort sort = new Sort(Sort.Direction.DESC,"id");
		Pageable pa = PageRequest.of(start, size, sort);
		Page<Category> page = categoryDao.findAll(pa);
		System.out.println("page.getNumber: " + page.getNumber());
        System.out.println("page.getNumberOfElements: " + page.getNumberOfElements());
        System.out.println("page.getSize: "+page.getSize());
        System.out.println("page.getTotalElements: " + page.getTotalElements());
        System.out.println("page.getTotalPages" + page.getTotalPages());
		m.addAttribute("page",page);
		return "jpa_try/listCategory";
	}
	
	@RequestMapping("addcategory")
	public String addCategory(Category c )throws Exception {
		categoryDao.save(c);
		return "redirect:listcategory";
	}
	@RequestMapping("delcategory")
	public String delCategory(Category c )throws Exception {
		categoryDao.delete(c);;
		return "redirect:listcategory";
	}
	@RequestMapping("updatecategory")
	public String updateCategory(Category c )throws Exception {
		categoryDao.save(c);
		return "redirect:listcategory";
	}
	
	@RequestMapping("editcategory")
	public String editCategory(Model m , int id )throws Exception {
		Category c = categoryDao.getOne(id);
		m.addAttribute("c",c);
		return "jpa_try/editCategory";
	}
}
