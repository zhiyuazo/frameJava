package test;



import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import entity.Category;
import entity.Product;

public class SprintIOC_DI {
	
	
	
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext(new String[] {"applicationContextIOC_DI.xml"});
		Category c = (Category) context.getBean("c");
		System.out.println(c.getName());
		
		Product  p = (Product)  context.getBean("p");
		System.out.println(p.getName());
		System.out.println(p.getCategory().getName());
		
	}
}
