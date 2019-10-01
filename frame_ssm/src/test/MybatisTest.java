package test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import service.CategoryService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class MybatisTest {

	@Autowired
	private CategoryService categoryService;
	
	/*
	@Test
	public void  testTranscation() {
		categoryService.deleteAll();
		categoryService.addTwo();
	}
	@Test
	public void testAdd() {
		Category category = new Category();
		category.setName("new Category");
		categoryMapper.add(category);
	}

	@Test
	public void testList() {
		System.out.println(categoryMapper);
		List<Category> cs=categoryMapper.list();
		for (Category c : cs) {
			System.out.println(c.getName());
		}
	}
	*/
	
	
	

}
