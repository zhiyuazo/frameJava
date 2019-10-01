package controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.support.HttpRequestHandlerServlet;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import bean.Category;
import service.CategoryService;
import util.Page;

@Controller
@RequestMapping("")
public class CategoryController  {
	@Autowired
	CategoryService categoryService; //自动装配CategoryServiceImpl类
	
	@RequestMapping(value="/category" , method=RequestMethod.GET)
	public ModelAndView listCategory(Page page,HttpServletRequest req) {
		System.out.println(req.getMethod().toString());
		ModelAndView mav = new ModelAndView();
		PageHelper.offsetPage(page.getStart(),page.getCount());
		List<Category> cs = categoryService.list();
		PageInfo pageinfo =  new PageInfo<>(cs);
		int total = (int) pageinfo.getTotal();
		page.caculateLast(total);
		mav.addObject("cs",cs);
		mav.setViewName("listCategory");
		return mav;
	}
	
	@RequestMapping(value="/category",method=RequestMethod.POST)
	public ModelAndView addCategory(Category c,HttpServletRequest req ) {
		System.out.println(req.getMethod().toString());
		categoryService.add(c);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("redirect:/category");
		return mav;
	}
	
	@RequestMapping(value="/category/{id}",method=RequestMethod.DELETE)
	public ModelAndView delCategory(Category c,HttpServletRequest req) {
		System.out.println(req.getMethod().toString());
		categoryService.del(c);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("redirect:/category");
		return mav;
	}
	
	@RequestMapping(value="/category/{id}",method=RequestMethod.GET)
	public ModelAndView editCategory(Category cc,HttpServletRequest req) {
		System.out.println(req.getMethod().toString());
		Category c = categoryService.get(cc.getId());
		ModelAndView mav = new ModelAndView();
		mav.setViewName("editCategory");
		mav.addObject("c",c);
		return mav;
	}
	
	@RequestMapping(value="/category/{id}",method=RequestMethod.PUT)
	public ModelAndView updateCategory(Category c,HttpServletRequest req ) {
		System.out.println(req.getMethod().toString());
		int res = categoryService.update(c);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("redirect:/category");
		return mav;
	}
	
	
	@ResponseBody
    @RequestMapping("/submitJson")
    public String submitJson(@RequestBody Category category) {
        System.out.println("SSM接受到浏览器提交的json，并转换为Category对象:"+category);
        return "ok";
    }
	
	@ResponseBody
    @RequestMapping("/getOneJson")
    public String getOneJson() {
		System.out.println("getone request");
         Category c = new Category();
         c.setId(100);
         c.setName("第100个分类");
         JSONObject json= new JSONObject();
         json.put("category", JSONObject.toJSON(c));
         return json.toJSONString();
    }
	
	@ResponseBody
	@RequestMapping("/getManyJson")
	public String getManyJson() {
		System.out.println("getmany request");
		List<Category> cs = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			Category c = new Category();
			c.setId(i);
			c.setName("分类名称:"+i);
			cs.add(c);
		}
		return JSONObject.toJSON(cs).toString();
	}
	
}
