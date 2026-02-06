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

			if(session.getTransaction() !=null && session.getTransaction().isActive()) {
				session.getTransaction().rollback();
	    	}
		}finally {
			session.close();
		}

		return null;
	}

	public void save(Task task) {
		Session session = HibernateUtils.getSessionFactory().openSession();
		try {
			session.beginTransaction();

			session.save(task);

			session.getTransaction().commit();

		} catch (Exception e) {
			e.printStackTrace();
			if(session.getTransaction() != null && session.getTransaction().isActive()) {
				session.getTransaction().rollback();
	    	}
		}finally {
			session.close();
		}

	}
}
