package service;

import java.util.List;

import bean.Category;

public interface CategoryService {
	List<Category> list();
	Category get(int id);
	int add(Category c);
	void del(Category c);
	int update(Category c);
	
	void addTwo();
	void deleteAll();
}
