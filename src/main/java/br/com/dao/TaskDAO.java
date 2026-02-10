package br.com.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import br.com.config.HibernateUtils;
import br.com.model.Task;

public class TaskDAO {

	public List<Task> findAll() {

		Session session = HibernateUtils.getSessionFactory().openSession();
		try {

			session.beginTransaction();

			Query<Task> query = session.createQuery("from Task", Task.class);
			List<Task> resultList = query.list();

			session.getTransaction().commit();

			return resultList;
		} catch (Exception e) {
			e.printStackTrace();

			if (session.getTransaction() != null && session.getTransaction().isActive()) {
				session.getTransaction().rollback();
			}
		} finally {
			session.close();
		}

		return null;
	}
	
	public Task getTaskById(int id) {
		Session session = HibernateUtils.getSessionFactory().openSession();
		
		Task task = null;
		
		try {

			session.beginTransaction();

			Query<Task> query = session.createQuery("FROM Task WHERE id = :id", Task.class);
			
			query.setParameter("id", id);
			
			task = query.getSingleResult();

			session.getTransaction().commit();

			return task;
			
		} catch (Exception e) {
			e.printStackTrace();

			session.getTransaction().rollback();
			
		} finally {
			session.close();
		}
		
		System.out.println(id + task.getTitle());

		return task;
	}

	public void save(Task task) {
		Session session = HibernateUtils.getSessionFactory().openSession();
		try {
			session.beginTransaction();

			session.save(task);

			session.getTransaction().commit();

		} catch (Exception e) {
			e.printStackTrace();
			if (session.getTransaction() != null && session.getTransaction().isActive()) {
				session.getTransaction().rollback();
			}
		} finally {
			session.close();
		}

	}
	
	public void update(Task task) {
		
		Session session = HibernateUtils.getSessionFactory().openSession();
		
		try {
			
			session.beginTransaction();
			
			session.update(task);
			
			session.getTransaction().commit();
			
		} catch(Exception e) {
			
			session.getTransaction().rollback();
			
			e.printStackTrace();
			
		} finally {
			
			session.close();
			
		}
		
	}
	
	public void deleteById(Long id) {
		
		Session session = HibernateUtils.getSessionFactory().openSession();

	    try {
	        session.beginTransaction();

	        Task task = session.get(Task.class, id);

	        if (task != null) {
	            task.setEmployee(null);
	            session.remove(task);
	        }

	        session.getTransaction().commit();

	    } catch (Exception e) {
	        session.getTransaction().rollback();
	        e.printStackTrace();

	    } finally {
	        session.close();
	    }
		
	}
	
	public void delete(Task task) {
		
		Session session = HibernateUtils.getSessionFactory().openSession();
		
		try {
			
			session.beginTransaction();
			
			session.delete(task);
			
			session.getTransaction().commit();
			
		} catch(Exception e) {
			
			session.getTransaction().rollback();
			
			e.printStackTrace();
			
		} finally {
			
			session.close();
			
		}
		
	}
}
