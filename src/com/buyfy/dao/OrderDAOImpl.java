//Model package
package com.buyfy.dao;

// Import java statements for the program
import java.util.List;
// Importing hibernate statements for the program
import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
// Import HibenateUtil for SessionFactory
import com.buyfy.hibernate.util.HibernateUtil;
// Importing Order Model
import com.buyfy.model.Order;

public class OrderDAOImpl implements OrderDAO {
	// Method for saving an order
	@Override
	public long saveOrder(Order order) {
		//creating transaction variable
		Transaction tx = null;
		// creating session factory variable
		SessionFactory factory = null;
		// creating session variable
		Session session = null;
		try {
			// Preparing session factory for work
			factory = HibernateUtil.getSessionFactory();
//			session = HibernateUtil.getSession();
			// instantiating session factory
			session = factory.getCurrentSession();
			tx = session.getTransaction();
			tx.begin();
			// saving an order
			long orderId = (long) session.save(order);
			// committing the data
			tx.commit();
//			session.close();
			return orderId;
		}
		catch(Exception ex){
			if(tx!=null) {
				// if exception occurs
				tx.rollback();
			}
			ex.printStackTrace();
//			session.close();
			return -1;
		}
	}
	
	//  Method for updating order
	@Override
	public boolean updateOrder(Order order) {
		// creating transaction variable
		Transaction tx = null;
		//creating session factory variable
		SessionFactory factory = null;
		// creating session variable
		Session session = null;
		try {
			// Preparing session factory for work
			factory = HibernateUtil.getSessionFactory();
//			session = HibernateUtil.getSession();
			// instantiating session factory
			session = factory.getCurrentSession();
			tx = session.getTransaction();
			tx.begin();
			// updating order
			session.update(order);
			//committing the data
			tx.commit();
//			session.close();
			return true;
		}
		catch(Exception ex){
			if(tx!=null) {
				// if exception occurs
				tx.rollback();
			}
			ex.printStackTrace();session.close();
			return false;
		}
	}
	
	// Method for deleting order by oid
	@Override
	public boolean deleteOrder(long oid) {
		// creating trasaction variable
		Transaction tx = null;
		// creating session factory variable
		SessionFactory factory = null;
		// creating session variable
		Session session = null;
		Order order = null;
		try {
			// Preparing session factory for work
			factory = HibernateUtil.getSessionFactory();
//			session = HibernateUtil.getSession();
			// instantiating session factory
			session = factory.getCurrentSession();
			tx = session.getTransaction();
			tx.begin();
			// getting order using oid
			order = (Order)session.get(Order.class, oid);
			// deleting order
			session.delete(order);
			// committing the data
			tx.commit();
//			session.close();
			return true;
		}catch(Exception ex) {
			if(tx!= null) {
				// if exception occurs
				tx.rollback();
			}
			ex.printStackTrace();
//			session.close();
			return false;
		}
	}
	
	// Method for getting order by orderId
	@Override
	public Order getOrderById(long orderId) {
		// creating transaction variable
		Transaction tx = null;
		// creating session factory variable
		SessionFactory factory = null;
		//creating session variable
		Session session = null;
		//creating order variable
		Order order = null;
		try {
			// Preparing session factory for work
			factory = HibernateUtil.getSessionFactory();
//			session = HibernateUtil.getSession();
			// instantiating session factory
			session = factory.getCurrentSession();
			tx = session.getTransaction();
			tx.begin();
			// getting order by orderId
			order = (Order)session.get(Order.class, orderId);
			// committing the data
			tx.commit();
//			session.close();
			return order;
		}catch(Exception ex) {
			if(tx!= null) {
				// if exception occurs
				tx.rollback();
//				session.close();
			}
			ex.printStackTrace();
			return null;
		}
	}
	
	// List for displaying all orders
	@Override
	public List<Order> getAllOrders() {
		// creating transaction variable
		Transaction tx = null;
		// creating session factory variable
		SessionFactory factory = null;
		//creating session variable
		Session session = null;
		List<Order> orders = null;
		try {
			// Preparing session factory for work
			factory = HibernateUtil.getSessionFactory();
//			session = HibernateUtil.getSession();
			// instantiating session factory
			session = factory.getCurrentSession();
			tx = session.getTransaction();
			tx.begin();
			// HQL query  to get all the orders through list
			Query qry = session.createQuery("FROM Order o");
			orders = qry.list();
			tx.commit();
//			session.close();
		}catch(Exception ex) {
			if(tx!=null) {
				// if exception occurs
				tx.rollback();
			}
			ex.printStackTrace();
//			session.close();
		}
		return orders;
	}	
}
