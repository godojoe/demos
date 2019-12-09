package com.luv2code.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class QueryStudentDemo {

	public static void main(String[] args) {
		
		// create session factory
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Student.class)
								.buildSessionFactory();
		
		// create session
		// use the session object to save Java object
		Session session = factory.getCurrentSession();
		
		try {
		
			// start a transaction
			session.beginTransaction();
			
			List<Student> theStudents = session.createQuery("from Student").list();
			
			displayStudents(theStudents);
			
			theStudents = session.createQuery("from Student s where s.lastName='Doe'").list();
			
			System.out.println("\nDisplay students who have last name of Doe");
			displayStudents(theStudents);	
			
			theStudents = session.createQuery("from Student s where s.lastName='Doe' or firstName='Daffy'").list();
			
			System.out.println("\nDisplay students who have last name of Doe or first name of Daffy");
			displayStudents(theStudents);	
			
			theStudents = session.createQuery("from Student s where s.email like '%luv%'").list();
			
			System.out.println("\nDisplay students who have email like luv");
			displayStudents(theStudents);				
			

			// commit transaction
			session.getTransaction().commit();
			
			System.out.println("Done!");
		}
		finally {
			factory.close();
		}

	}

	private static void displayStudents(List<Student> theStudents) {
		for (Student tempStudent: theStudents) {
			System.out.println(tempStudent);
		}
	}

}
