package test;



import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import entity.Category;
import entity.Category2;
import entity.Product;
import entity.Product2;

public class SprintIOC_DI_an {
	
	
	
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext(new String[] {"applicationContextIOC_DI_an.xml"});
		Category2 c = (Category2) context.getBean("c2");
		System.out.println(c.getName());
		
		Product2  p = (Product2)  context.getBean("p2");
		System.out.println(p.getName());
		System.out.println(p.getCategory().getName());
	}
}
