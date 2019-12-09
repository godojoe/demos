package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;

public class CreateInstructorDemo {

	public static void main(String[] args) {
		
		// create session factory
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Instructor.class)
								.addAnnotatedClass(InstructorDetail.class)	
								.addAnnotatedClass(Course.class)	
								.buildSessionFactory();
		
		// create session
		// use the session object to save Java object
		Session session = factory.getCurrentSession();
		
		try {
			// create the objects
			
			Instructor tempInstructor = new Instructor("Susan", "Public", "susan.public@luv2code.com");
			InstructorDetail tempInstructorDetail = new InstructorDetail(
					"http://youtube.com", "Video Games");			
			
			tempInstructor.setInstructorDetail(tempInstructorDetail);
			
			// start a transaction
			session.beginTransaction();
			
			// save the instructor
			// note: this will ALSO save the details objects
			// because of CascadeType.ALL
			System.out.println("Saving instructor:" + tempInstructor);
			session.save(tempInstructor);
			
			// commit transaction
			session.getTransaction().commit();
			
			System.out.println("Done!");
		}
		finally {
			session.close();
			factory.close();
		}

	}

}
