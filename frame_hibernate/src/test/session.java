package test;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

import entity.Product;

public class session {
	
        static Session s5 ;
        static Session s6 ;
	public static void main(String[] args) throws InterruptedException {
		
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		
		Session s0 = sf.openSession();
		Criteria c = s0.createCriteria(Product.class);
		c.add(Restrictions.like("name", "%iphone%"));
		List<Product> ps = c.list();
		ps.forEach(p->System.out.println(p.getName()));
		s0.close();
		
        Session s1 = sf.openSession();
        Session s2 = sf.openSession();
        System.out.println(s1==s2);
        		
        Session s3 = sf.getCurrentSession();
        Session s4 = sf.getCurrentSession();
        System.out.println(s3==s4);
       
        Thread t1 = new Thread() {
        	public void run() {
        		s5=sf.getCurrentSession();
        	}
        };
        
        Thread t2 = new Thread() {
        	public void run() {
        		s6=sf.getCurrentSession();
        	}
        };
        t1.start(); t2.start(); t1.join(); t2.join();
        System.out.println(s5==s6);
        		
        s1.close();
        s2.close();
        s3.close();
        //s4.close();
        s5.close();
        s6.close();
        sf.close();
	}
}
