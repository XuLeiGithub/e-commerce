package util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class SessionUtil {
	private static Configuration configuration;
	private static SessionFactory sessionFactory;
	public static SessionFactory getSessionFactory(){
		configuration = new Configuration().configure();
		sessionFactory = configuration.buildSessionFactory();
		return sessionFactory;
	}
}
