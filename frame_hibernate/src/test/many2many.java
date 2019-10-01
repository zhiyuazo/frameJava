package test;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;

import entity.Product;
import entity.User;

public class many2many {
	
	public static void main(String[] args) {
		
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session s = sf.openSession();
		s.beginTransaction();
		
		//��ȡUser
		Set<User> users = new HashSet<>();
		User u1 = (User) s.get(User.class, 1);
		User u2 = (User) s.get(User.class, 2);
		User u3 = (User) s.get(User.class, 3);
		users.add(u1);
		users.add(u2);
		users.add(u3);
		//��Ʒ1���û�1,2,3����
		Product p1 = (Product) s.get(Product.class, 3);
		p1.setUsers(users);
		s.save(p1);
		
		s.getTransaction().commit(); //commit�����ݲŽ������ݿ�...
		s.close();
		sf.close();
	}
}
