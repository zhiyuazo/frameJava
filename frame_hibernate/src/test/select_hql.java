package test;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;

import entity.Product;



public class select_hql {

	public static void main(String[] args) {
		SessionFactory  sf = new Configuration().configure().buildSessionFactory();
		Session s = sf.openSession();
		s.beginTransaction();
		
		String name = "iphone";
		//from Product, Product是类名，不是表明，趋近oo思想
		Query q = s.createQuery("from Product p where p.name like ?");
		q.setString(0, "%" + name+ "%");
		List<Product> ps = q.list();
		ps.forEach(p->System.out.println(p.getName()));
		
		s.getTransaction().commit();
		s.close();
		sf.close();
	}
	
}
