package test;


import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import entity.Category;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContextIOC_DI.xml")
public class SprintTestJunit {
	@Resource(name="c")
	Category c;
	@Test
	public void test() {
		System.out.println(c.getName());
		
	}
	@Test
	public void test2() {
		System.out.println(c.getId());
		
	}
}
