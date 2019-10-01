package service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import bean.Category;
import mapper.CategoryMapper;
import service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService{
	
	@Autowired
	CategoryMapper categoryMapper; 
	
	@Override
	public List<Category> list() {
		return categoryMapper.list();
	}
	
	@Override
	public Category get(int id) {
		// TODO Auto-generated method stub
		return categoryMapper.get(id);
	}

	@Override
	public int add(Category c) {
		return categoryMapper.add(c);
	}
	@Override
	public void del(Category c) {
		categoryMapper.delete(c.getId());
	}

	@Override
	public int update(Category c) {
		return categoryMapper.update(c);
	}

	@Override
	//@Transactional(propagation=Propagation.REQUIRED,rollbackForClassName="Exception")
	public void addTwo() {
		Category c1 = new Category();
		c1.setName("shortname");
		Category c2 = new Category();
		c2.setName("long-name-long-long-long-long-long-long-long-long");
		add(c1);
		add(c2);
	}

	@Override
	public void deleteAll() {
		List<Category>  cs = list();
		for(Category c : cs) {
			del(c);
		}
	}

}