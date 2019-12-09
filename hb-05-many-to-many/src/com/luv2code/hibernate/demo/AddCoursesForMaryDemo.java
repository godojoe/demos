package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
import com.luv2code.hibernate.demo.entity.Review;
import com.luv2code.hibernate.demo.entity.Student;

public class AddCoursesForMaryDemo {

	public static void main(String[] args) {
		
		// create session factory
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Instructor.class)
								.addAnnotatedClass(InstructorDetail.class)	
								.addAnnotatedClass(Course.class)
								.addAnnotatedClass(Review.class)	
								.addAnnotatedClass(Student.class)
								.buildSessionFactory();
		
		// create session
		// use the session object to save Java object
		Session session = factory.getCurrentSession();
		
		try {

			session.beginTransaction();
			
			int studentId = 2;
			Student tempStudent = session.get(Student.class, 2);
			
			System.out.println("Loaded student:" + tempStudent);
			System.out.println("Course:" + tempStudent.getCourses());
			
			Course tempCourse1 = new Course("Rubik's cube - How to Speed Cube");
			Course tempCourse2 = new Course("Atari 2600 - Game Development");
						
			tempCourse1.addStudent(tempStudent);
			tempCourse2.addStudent(tempStudent);
			session.save(tempCourse1);
			session.save(tempCourse2);
			
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
