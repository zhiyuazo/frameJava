package test;

import java.util.Arrays;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;



public class select_sql {

	public static void main(String[] args) {
		SessionFactory  sf = new Configuration().configure().buildSessionFactory();
		Session s = sf.openSession();
		s.beginTransaction();
		
		String name = "iphone";
		String sql = "select * from product_ p where p.name like '%" +  name+ "%'";
		Query q = s.createSQLQuery(sql);
		List<Object[]> ps = q.list();
		System.out.println(Arrays.toString(ps.get(1)));
		s.getTransaction().commit();
		s.close();
		sf.close();
	}
	
}
