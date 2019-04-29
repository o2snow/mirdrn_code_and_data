package edu.map.ws.persistent.connection;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateConfig {

	private static Configuration cfg;
	private static SessionFactory factory;
	private static Session session;
	
	public static void createSessionFactory(){
		
		cfg = new Configuration().configure();
		factory = cfg.buildSessionFactory();
		
	}

	
	public static SessionFactory getSessionFactory(){
		return factory;
	}
}
