package test;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;

import entity.User;


public class shuxinglazytest {

	public static void main(String[] args) {
		
		SessionFactory   sf = new Configuration().configure().buildSessionFactory();
		Session s = sf.openSession();
		s.beginTransaction();
			
		User u1 = (User) s.get(User.class, 1);
		System.out.println("log1");
		User u2 = (User) s.load(User.class, 2);
		System.out.println("log2");
		System.out.println(u2.getName());
		System.out.println("log3");
		
		s.getTransaction();
		s.close();
		sf.close();
		
	}
	
	
	
}
