package frame_sprintboot.test;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import boot.entry;
import trytest.jpa.bean.Category;
import trytest.jpa.dao.CategoryDao;

@RunWith(SpringRunner.class) 
@SpringBootTest(classes=entry.class)
public class TestJPA {
	@Autowired 
	CategoryDao  cd;
	
	@Before
	public void before() {
		
		List<Category> cs = cd.findAll();
		for(Category c : cs ) {
			cd.delete(c);
		}
		
		for (int i = 0; i < 10; i++) {
			Category c = new Category();
			c.setName("category " + i);
			cd.save(c);
		}
		
	}
	
	@Test
	public void test() {
	}
	@Test
	public void test1() {
		List<Category> cs =cd.findByName("category 1");
		System.out.println("***************All items with specific NAME");
		cs.forEach(c->System.out.println(c.getName()));
	}
	
	@Test
	public void test2() {
		List<Category> cs =cd.findByNameLikeAndIdGreaterThanOrderByNameAsc("categ", 2);
		System.out.println("***************All items with NAME pattern and id limition");
		cs.forEach(c->System.out.println(c.getName()));
	}
}
