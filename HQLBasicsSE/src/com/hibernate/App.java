package com.hibernate;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.entity.Users;

public class App {
	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration()
									.configure("hibernate.cfg.xml")
									.addAnnotatedClass(Users.class)
									.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		try {
			// start the transacion
			session.beginTransaction();
//			List<Users> users = session.createQuery("from users").getResultList(); ----------->>>>>   for listing all records
			List<Users> users = session.createQuery("from users where first_name='Thor'" + "or last_name='banner'").getResultList();
			for (Users temp : users) {
				System.out.println(temp);
			}
			
		} finally {
			session.close();
			factory.close();
		}
	}
}
