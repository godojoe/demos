package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;

public class FetchJoinDemo {

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

			session.beginTransaction();
			
			// option 2: Hibernate query with HQL
			
			int theId = 1;
			
			Query<Instructor> query = session.createQuery("select i from Instructor i "
					 + "JOIN FETCH i.courses where i.id = :theInstructorId", 
					 Instructor.class);
			query.setParameter("theInstructorId", theId);
			
			Instructor tempInstructor = query.getSingleResult();
			System.out.println("luv2code: Instructor: " + tempInstructor);
			
						
			// commit transaction
			session.getTransaction().commit();
			
			session.close();
			System.out.println("The session is now closed!");
			
			// since courses are lazy loaded...this should fail
			
			System.out.println("luv2code: Courses: " + tempInstructor.getCourses());
			
			System.out.println("luv2code: Done!");
		}
		finally {
			session.close();
			factory.close();
		}

	}

}
