package test;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;

import entity.Category;
import entity.Product;

public class many2one {
	
	public static void main(String[] args) {
		
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session s = sf.openSession();
		s.beginTransaction();
		
		Category c = new Category();
		c.setName("man");
		s.save(c);
		Product p = (Product) s.get(Product.class, 5);
		p.setCategory(c);
		s.update(p);
		
		s.getTransaction().commit(); //commit后数据才进入数据库...
		s.close();
		sf.close();
	}
}
