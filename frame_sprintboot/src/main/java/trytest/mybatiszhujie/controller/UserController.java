package trytest.mybatiszhujie.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import trytest.mybatiszhujie.bean.User;
import trytest.mybatiszhujie.mapper.UserMapper;

@Controller
public class UserController {
	@Autowired	
	UserMapper userMapper;
	
	@RequestMapping("listuser")
	public String listUser(Model m,
						   @RequestParam(value="start",defaultValue="1")int start,
						   @RequestParam(value="size",defaultValue="5")int size) throws Exception{
		PageHelper.startPage(start,size,"id desc");
		List<User> us = userMapper.findAll();
		PageInfo<User> page=new PageInfo<>(us);
		m.addAttribute("page",page);
		return "mybatis_try_zhujie/listUser";
	}
	
	@RequestMapping("adduser")
	public String addUser(User u) throws Exception{
		userMapper.save(u);
		return "redirect:listuser";
	}
	
	@RequestMapping("deluser")
	public String delUser(User u) throws Exception{
		userMapper.del(u.getId());
		return "redirect:listuser";
	}
	@RequestMapping("updateuser")
	public String updateCategory(User u ) throws Exception{
		userMapper.update(u);
		return "redirect:listuser";
	}
	@RequestMapping("edituser")
	public String editCategory(Model m, int id) throws Exception{
		User u = userMapper.get(id);
		m.addAttribute("u",u);
		return "mybatis_try_zhujie/editUser";
	}
}
