package com.buyfy.hibernate.util;
 
import org.hibernate.Session;
import org.hibernate.SessionFactory;
//import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
     
    private static final SessionFactory sessionFactory;
     
    static{
        try {
//        	sessionFactory = new Configuration().configure().buildSessionFactory();
        	sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
         } catch (Throwable ex) { 
            System.err.println("Failed to create sessionFactory object." + ex);
            throw new ExceptionInInitializerError(ex); 
         }
    }
     
    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
		public static Session getSession() {

		    final SessionFactory sf = new Configuration()
		        .configure("hibernate.cfg.xml").buildSessionFactory();
	
		    // factory = new Configuration().configure().buildSessionFactory();
		    final Session session = sf.openSession();
		    return session;
	    }
     
}