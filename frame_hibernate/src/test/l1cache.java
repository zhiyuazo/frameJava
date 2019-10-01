package test;

import java.util.Set;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;

import entity.Category;
import entity.Product;

public class l1cache {
	public static void main(String[] args) {
		
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session s = sf.openSession();
		s.beginTransaction();
		
		System.out.println("log1");
		Category c1 = (Category) s.get(Category.class, 2);
		System.out.println("log2");
		Category c2 = (Category) s.get(Category.class, 2);
		System.out.println("log3");
		
		s.getTransaction().commit(); //commit后数据才进入数据库...
		s.close();
		sf.close();
		
		
		
	}
	
}
