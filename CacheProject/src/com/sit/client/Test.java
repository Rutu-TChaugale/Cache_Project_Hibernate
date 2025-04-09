package com.sit.client;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.sit.configuration.HibernateUtil;
import com.sit.model.Student;

public class Test {
	public static void main(String[] args) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		// create object of session factory
		Session session = sessionFactory.openSession();
		
		Student stu=new Student();
		stu.setId(1);
		stu.setName("Prithviraj");
		stu.setEmail("lallya@gmail.com");
		stu.setAddr("Kharigalii");
		
		session.save(stu);
		session.beginTransaction().commit(); 
		session.clear();
		
		System.out.println("------------using 1st objcet of session--------------");
		
		Student student = session.get(Student.class, 1);
		System.out.println(student.getName());
		System.out.println(student.getEmail());
		System.out.println(student.getAddr());
		
		System.out.println("------------------------------");
		Student stu1=session.get(Student.class, 2);
		stu1.setName("Vishal");
		stu1.setEmail("vishu@gmail.com");
		stu1.setAddr("Kop");
		
		session.update(stu);
		session.beginTransaction().commit(); 

		
		System.out.println("------------------------------");
		Student stu2=session.get(Student.class, 2);
		session.delete(stu2);
		
	}
}


