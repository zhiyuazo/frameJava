package test;

import java.sql.SQLException;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import service.ProductService2;

public class SprintAOP_an {
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		ApplicationContext context = new ClassPathXmlApplicationContext(new String[] {"applicationContext_AOP_an.xml"});
		ProductService2 ps2 = (ProductService2) context.getBean("ps2");
		ps2.doSomeService();
		
//		List<String> res = s.selectP();
		
	}
}
