package test;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;
import org.hibernate.criterion.Restrictions;

import entity.Product;



public class select_criteria {

	public static void main(String[] args) {
		SessionFactory  sf = new Configuration().configure().buildSessionFactory();
		Session s = sf.openSession();
		s.beginTransaction();
		
		String name = "iphone";
		Criteria c = s.createCriteria(Product.class);
		c.add(Restrictions.like("name", "%" + name+ "%"));
		List<Product> ps = c.list();
		ps.forEach(p->System.out.println(p.getName()));
		
		s.getTransaction().commit();
		s.close();
		sf.close();
	}
	
}
