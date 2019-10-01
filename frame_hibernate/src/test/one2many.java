package test;

import java.util.Set;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;

import entity.Category;
import entity.Product;

public class one2many {
	
	public static void main(String[] args) {
		
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session s = sf.openSession();
		s.beginTransaction();
		
        Category c = (Category) s.get(Category.class, 3);
        Set<Product> ps = c.getProducts();
        ps.forEach(p->System.out.println(p.getName()));
        
		s.getTransaction().commit(); //commit后数据才进入数据库...
		s.close();
		sf.close();
	}
}
