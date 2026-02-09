package br.com.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import br.com.config.HibernateUtils;
import br.com.model.Employee;
import br.com.model.Task;

public class OnlyPracticeDAO {

	public List<Task> allTaskJoinEmployee() {

		Session session = HibernateUtils.getSessionFactory().openSession();

		try {

			session.beginTransaction();

			String hql = "FROM Task t ";

			Query<Task> query = session.createQuery(hql, Task.class);

			List<Task> resultList = (ArrayList<Task>) query.list();

			session.getTransaction().commit();

			return resultList;

		} catch (Exception e) {

			e.printStackTrace();

			session.getTransaction().rollback();

		} finally {

			session.close();

		}

		return null;

	}

	public List<Employee> listByLetter() {

		Session session = HibernateUtils.getSessionFactory().openSession();

		List<Employee> resultList = null;

		try {

			session.beginTransaction();

			String a = "y";

			String hql = "FROM Employee WHERE firstName LIKE :regex";

			Query<Employee> query = session.createQuery(hql, Employee.class);

			query.setParameter("regex", a + "%");

			resultList = new ArrayList<>(query.list());

			session.getTransaction().commit();

		} catch (Exception e) {

			session.getTransaction().rollback();

			e.printStackTrace();

		} finally {

			session.close();

		}

		return resultList;

	}
	
	public List<Employee> listFilter(String busca){
		
		Session session = HibernateUtils.getSessionFactory().openSession();
		
		List<Employee> resultList = null;
		
		try {
			
			session.getTransaction().begin();
			
			String hql = null;
			
			if(busca == null) {
				hql = "FROM Employee";
			}
			
			else {
				hql = "FROM Employee WHERE LOWER(CONCAT(firstName, ' ', lastName)) LIKE :nomeBuscar";
			}
			
			Query<Employee> query = session.createQuery(hql, Employee.class);
			
			if(busca != null) {
				query.setParameter("nomeBuscar", "%"+busca.toLowerCase()+"%");
			}
						
			resultList = new ArrayList<>(query.list());
			
			session.getTransaction().commit();
			
		} catch (Exception e) {
			
			session.getTransaction().rollback();
			
			e.printStackTrace();
			
		} finally {
			
			session.close();
			
		}
		
		return resultList;
		
	}
	
}
