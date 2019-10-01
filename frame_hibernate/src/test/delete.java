package test;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;
import org.hibernate.criterion.Restrictions;

import entity.Category;
import entity.Product;

public class delete {
	
	public static void main(String[] args) {
		
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session s = sf.openSession();
		s.beginTransaction();
		//delete from DB, get it first by id=1
		Category c = (Category)s.get(Category.class, 1);
		s.delete(c);
		
		s.getTransaction().commit(); //commit后数据才进入数据库...
		s.close();
		sf.close();
	}
}
