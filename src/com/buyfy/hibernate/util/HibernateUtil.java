package com.buyfy.hibernate.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	private static SessionFactory sessionFactory;
//    static{
//        try {
//        	sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
//         } catch (Throwable ex) { 
//            System.err.println("Failed to create sessionFactory object." + ex);
//            throw new ExceptionInInitializerError(ex); 
//         }
//    }

	public static SessionFactory getSessionFactory() {
		if (sessionFactory == null) {
			sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		}
		return sessionFactory;
	}
//    public static SessionFactory getSessionFactory() {
//        if (sessionFactory == null) {
//            // loads configuration and mappings
//            Configuration configuration = new Configuration().configure("hibernate.cfg.xml");
//            ServiceRegistry serviceRegistry
//                = new StandardServiceRegistryBuilder()
//                    .applySettings(configuration.getProperties()).build();
//             
//            // builds a session factory from the service registry
//            sessionFactory = configuration.buildSessionFactory(serviceRegistry);           
//        }
//         
//        return sessionFactory;
//    }
}
