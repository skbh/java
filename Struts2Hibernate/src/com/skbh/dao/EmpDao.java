package com.skbh.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.skbh.model.Employee;
import com.skbh.model.User;

public class EmpDao {
	private SessionFactory sessionFactory;
	private Session session;

	public Session getSession() {
		return session;
	}

	public void setSession(Session session) {
		this.session = session;
	}

	public EmpDao() {
		if (sessionFactory == null) {
			sessionFactory = new Configuration().configure().buildSessionFactory();
			System.out.println("sessionFactory created");
			session = sessionFactory.openSession();
		}
	}// end empDao constructor

	public String createUser(User user) {
		System.out.println(user);
		session.beginTransaction().begin();
		System.out.println("session created");
		session.persist(user);
		session.getTransaction().commit();
		System.out.println("User Created by dao");
		return "User Created";
	}

	public User signUser(String username, String password) {
		User user = null;
		try {
			session.beginTransaction().begin();
			Query query = session.createQuery("from User where username=:username and password=:password");
			query.setString("username", username);
			query.setString("password", password);
			user = (User) query.uniqueResult();
			if (user != null) {
				System.out.println("User Retrieved from Database::" + user);
			}
			session.getTransaction().commit();
			session.close();
		} catch (HibernateException he) {
			System.out.println(he);
		}
		return user;

	}

	public String addEmp(Employee emp) {
		session.beginTransaction().begin();
		session.save(emp);
		session.getTransaction().commit();
		return "Employee record Inserted";
	}

	public String deleteEmp(Employee emp) {
		String status = "Not deleted";
		session.beginTransaction().begin();
		Employee emp1 = (Employee) session.get(Employee.class, emp.getEid());
		if (emp1 != null) {
			session.delete(emp1);
			status = "Employe Deleted";
		}
		session.beginTransaction().commit();
		return status;
	}

	public String updateEmp(Employee emp) {
		String status = "Not updated";
		session.beginTransaction().begin();
		Employee emp1 = (Employee) session.get(Employee.class, emp.getEid());
		if (emp1 != null) {
			emp1.setName(emp.getName());
			emp1.setCity(emp.getCity());
			emp1.setSalary(emp.getSalary());
			session.update(emp1);
			status = "Employe updated";
		}
		session.beginTransaction().commit();
		return status;
	}

	public Employee queryEmp(Employee emp) {
		Employee emp1 = (Employee) session.get(Employee.class, emp.getEid());
		return emp1;
	}

	@SuppressWarnings("unchecked")
	public List<Employee> showallEmp() {
		Query qr = session.createQuery("from Employee");
		List<Employee> emps = qr.list();
		return emps;
	}

}
