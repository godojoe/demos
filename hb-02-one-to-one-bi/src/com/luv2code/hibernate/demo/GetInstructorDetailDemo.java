package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
import com.luv2code.hibernate.demo.entity.Student;

public class GetInstructorDetailDemo {

	public static void main(String[] args) {
		
		// create session factory
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Instructor.class)
								.addAnnotatedClass(InstructorDetail.class)								
								.buildSessionFactory();
		
		// create session
		// use the session object to save Java object
		Session session = factory.getCurrentSession();
		
		try {

			
			// start a transaction
			session.beginTransaction();
			
			int theID = 333333;
			InstructorDetail tempInstructorDetail = session.get(InstructorDetail.class, theID);
			System.out.println("tempInstructorDetail: " + tempInstructorDetail);
			Instructor tempInstructor = tempInstructorDetail.getInstructor();
			System.out.println("the associated instructor: " + tempInstructor);
			
			session.getTransaction().commit();
			
			System.out.println("Done!");
		}
		catch(Exception exc) {
			exc.printStackTrace();
		}
		finally {
			session.close();
			factory.close();
		}

	}

}
