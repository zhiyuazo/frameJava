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

public class update {
	
	public static void main(String[] args) {
		
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session s = sf.openSession();
		s.beginTransaction();
		//update,get first, set it,then update
		Category c = (Category)s.get(Category.class, 2);
		c.setName("movie");
		s.update(c);
		
		s.getTransaction().commit(); //commit后数据才进入数据库...
		s.close();
		sf.close();
	}
}
