package br.com.config;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import br.com.model.Employee;
import br.com.model.Task;

public class HibernateUtils {
	private static final SessionFactory sessionFactory;

	static {
		try {
			Configuration configuration = new Configuration().configure("hibernate.cfg.xml");

			configuration.addAnnotatedClass(Task.class);
			configuration.addAnnotatedClass(Employee.class);

			sessionFactory = configuration.buildSessionFactory();

		} catch (Throwable ex) {
			System.err.println("Erro ao criar SessionFactory");
			throw new ExceptionInInitializerError(ex);
		}
	}

	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}

}
