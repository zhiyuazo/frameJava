package test;

import java.sql.SQLException;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import service.ProductService;

public class SprintAOP {
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		ApplicationContext context = new ClassPathXmlApplicationContext(new String[] {"applicationContext_AOP.xml"});
		ProductService s = (ProductService) context.getBean("s");
		s.doSomeService();
		
		List<String> res = s.selectP();
		
	}
}
