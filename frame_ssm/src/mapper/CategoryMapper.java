package mapper;

import java.util.List;

import bean.Category;
import util.Page;

public interface CategoryMapper {
	public int count();
	public int add(Category c);
	public int update(Category c);
	public void delete (int id);
	public Category get(int id);
	public List<Category> list();
}
