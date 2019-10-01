package test;

import java.util.Set;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;

import entity.Category;
import entity.Product;

public class l2cache {
	public static void main(String[] args) {
		
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		
		Session s = sf.openSession();
		s.beginTransaction();
		System.out.println("in s session");
		Category c1 = (Category) s.get(Category.class, 2);
		Category c2 = (Category) s.get(Category.class, 2);
		s.getTransaction().commit();
		s.close();
		//----
		Session s2 = sf.openSession();
		s2.beginTransaction();
		System.out.println("in s2 session");
		Category c3 = (Category) s2.get(Category.class, 2);
		s2.getTransaction().commit();
		s2.close();
		
		sf.close();
		
		
		
	}
	
}
