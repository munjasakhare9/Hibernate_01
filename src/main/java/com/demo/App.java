package com.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.demo.model.Student;

public class App {
	public static void main(String[] args) {
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");

		SessionFactory factory = cfg.buildSessionFactory();

		Session session = factory.openSession();
		Transaction tx = null;

		try {
			tx = session.beginTransaction();

			Student s = new Student();
			s.setName("Rani");
			s.setCity("Latur");
			s.setPercentage(90.60);

			session.save(s);

			tx.commit();

			System.out.println("Student added successfully!");
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
			factory.close();
		}
	}
}
