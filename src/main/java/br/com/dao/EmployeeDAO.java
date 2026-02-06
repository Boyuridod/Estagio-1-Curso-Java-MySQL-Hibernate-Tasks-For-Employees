package br.com.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import br.com.config.HibernateUtils;
import br.com.model.Employee;

public class EmployeeDAO {

	public List<Employee> findAll(){

		Session session = HibernateUtils.getSessionFactory().openSession();

		try {

			String hql = "FROM Employee";

			Query<Employee> query = session.createQuery(hql, Employee.class);

			List<Employee> resultList = query.list();

			return resultList;

		} catch(Exception e) {

			e.printStackTrace();

		} finally {

			session.close();

		}

		return null;

	}

	public Employee findById(int id) {
		Session session = HibernateUtils.getSessionFactory().openSession();

		try {

			String hql = "FROM Employee WHERE ID = :id";

			Query<Employee> query = session.createQuery(hql, Employee.class);

			query.setParameter("id", id);

			Employee employee = query.getSingleResult();

			return employee;

		} catch(Exception e) {

			e.printStackTrace();

		} finally {

			session.close();

		}

		return null;
	}

	public void save(Employee employee) {

		Session session = HibernateUtils.getSessionFactory().openSession();

		try {

			session.getTransaction().begin();

			session.save(employee);

			session.getTransaction().commit();

		} catch(Exception e) {
			e.printStackTrace();

			if(session.getTransaction() != null && session.getTransaction().isActive()) {

				session.getTransaction().rollback();

			}

		} finally {

			session.close();

		}

	}

	public void updateEmployee(Employee employee) {

		Session session = HibernateUtils.getSessionFactory().openSession();

		try {

			session.beginTransaction();

			session.update(employee);

			session.getTransaction().commit();

		} catch (Exception e) {

			e.printStackTrace();

			if(session.getTransaction() != null && session.getTransaction().isActive()) {

				session.getTransaction().rollback();

			}

		} finally {

			session.close();

		}

	}
	
	public void deleteById(int id) {
		
		Session session = HibernateUtils.getSessionFactory().openSession();
		
		try {
			
			session.beginTransaction();
			
			String hql = "DELETE FROM Employee WHERE id = :id";
			
			Query<?> query = session.createQuery(hql);
			
			query.setParameter("id", id);
			
			int rowsAffected = query.executeUpdate();
			
			System.out.println(rowsAffected + " " + (rowsAffected > 1 ? "funcionários" : "funcionario")
					+ " deletado(a) com sucesso");
			
			session.getTransaction().commit();
			
		} catch(Exception e) {
			
			e.printStackTrace();
			
		} finally {
			
			session.close();
			
		}
		
	}

	public void deleteEmployee(Employee employee) {

		Session session = HibernateUtils.getSessionFactory().openSession();

		try {

			session.beginTransaction();

			session.delete(employee);

			session.getTransaction().commit();

		} catch (Exception e) {

			e.printStackTrace();

			if(session.getTransaction() != null && session.getTransaction().isActive()) {

				session.getTransaction().rollback();

			}

		} finally {

			session.close();

		}

	}

}
