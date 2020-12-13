package com.buyfy.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.buyfy.hibernate.util.HibernateUtil;
import com.buyfy.model.Image;
import com.buyfy.model.Order;

public class ImageDAOImpl implements ImageDAO {

	@Override
	public long saveImage(Image image) {
		// creating transaction variable
		Transaction tx = null;
		// creating session factory variable
		SessionFactory factory = null;
		// creating session variable
		Session session = null;
		try {
			// Preparing session factory for work
			factory = HibernateUtil.getSessionFactory();
			session = factory.getCurrentSession();
			tx = session.getTransaction();
			tx.begin();
			// saving an image
			long orderId = (long) session.save(image);
			// committing the data
			tx.commit();
			return orderId;
		} catch (Exception ex) {
			if (tx != null) {
				// if exception occurs
				tx.rollback();
			}
			ex.printStackTrace();
			return -1;
		}
	}

	@Override
	public boolean deleteImage(long imageId) {
		// creating transaction variable
		Transaction tx = null;
		// creating session factory variable
		SessionFactory factory = null;
		// creating session variable
		Session session = null;
		Order order = null;
		try {
			// Preparing session factory for work
			factory = HibernateUtil.getSessionFactory();
			session = factory.getCurrentSession();
			tx = session.getTransaction();
			tx.begin();
			// getting order using oid
			order = (Order) session.get(Order.class, imageId);
			// deleting order
			session.delete(order);
			// committing the data
			tx.commit();
			return true;
		} catch (Exception ex) {
			if (tx != null) {
				// if exception occurs
				tx.rollback();
			}
			ex.printStackTrace();
			return false;
		}
	}

}
