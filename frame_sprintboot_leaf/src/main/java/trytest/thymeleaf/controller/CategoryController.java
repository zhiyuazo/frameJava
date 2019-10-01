package trytest.thymeleaf.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import trytest.thymeleaf.bean.Category;
import trytest.thymeleaf.mapper.CategoryMapper;

@Controller
public class CategoryController {
	@Autowired CategoryMapper categoryMapper;

	@RequestMapping("lscategory")
	public String listCategory(Model m ,
							  @RequestParam(value="start" ,defaultValue="0")int start, 
							  @RequestParam(value="size" ,defaultValue="5")int size )throws Exception {
		PageHelper.startPage(start,size,"id desc");
		List<Category> cs = categoryMapper.findAll();
		PageInfo<Category> page=new PageInfo<>(cs);
		m.addAttribute("page",page);
		return "crud/lscategory";
	}
	
	@RequestMapping("addcategory")
	public String addCategory(Category c )throws Exception {
		categoryMapper.save(c);
		return "redirect:lscategory";
	}
	@RequestMapping("delcategory")
	public String delCategory(Category c )throws Exception {
		categoryMapper.delete(c.getId());;
		return "redirect:lscategory";
	}
	@RequestMapping("updatecategory")
	public String updateCategory(Category c )throws Exception {
		categoryMapper.save(c);
		return "redirect:lscategory";
	}
	
	@RequestMapping("editcategory")
	public String editCategory(Model m , int id )throws Exception {
		Category c = categoryMapper.get(id);
		m.addAttribute("c",c);
		return "crud/editcategory";
	}
}
