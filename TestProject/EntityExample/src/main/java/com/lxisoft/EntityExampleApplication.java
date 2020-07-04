package com.lxisoft;

import org.hibernate.Session;
import org.hibernate.Transaction;
import com.lxisoft.entity.Department;
import com.lxisoft.entity.Employee;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EntityExampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(EntityExampleApplication.class, args);
		Session session = null;
	    Transaction transaction = null;
	    try {
	      session = HibernateUtil.getSessionFactory().openSession();
	      transaction = session.beginTransaction();
	      transaction.begin();

	      Department department=new Department();
	      department.setName("IT Department");
	      
	      Employee employee1=new Employee();
	      employee1.setName("SCOTT");
	      employee1.setDesignation("Developer");
	      employee1.setDepartment(department);
	      
	      Employee employee2=new Employee();
	      employee2.setName("ADAMS");
	      employee2.setDesignation("Sr. Developer");
	      employee2.setDepartment(department);
	      
	      Employee employee3=new Employee();
	      employee3.setName("MILLER");
	      employee3.setDesignation("Manager");
	      employee3.setDepartment(department);
	      
	      session.save(department);
	      session.save(employee1);
	      session.save(employee2);
	      session.save(employee3);
	      
	      transaction.commit();
	      
	    } catch (Exception e) {
	      if (transaction != null) {
	        transaction.rollback();
	      }
	      e.printStackTrace();
	    } finally {
	      if (session != null) {
	        session.close();
	      }
	    }

	    HibernateUtil.shutdown();
	  }
}
