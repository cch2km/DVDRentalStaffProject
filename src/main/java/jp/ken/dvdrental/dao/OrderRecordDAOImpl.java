package jp.ken.dvdrental.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import jp.ken.dvdrental.entity.OrderRecord;
import jp.ken.dvdrental.entity.User;



public class OrderRecordDAOImpl implements OrderRecordDAO<OrderRecord>{
	
    private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory= sessionFactory;
	}
	
	
	
	@Override
	public boolean insertOrderRecordData(OrderRecord order) {
		Session session= this.sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		try {
			session.save(order);
			tx.commit();
			return true;
		}catch(HibernateException e) {
			tx.rollback();
			return false;
		}finally {
			session.close();
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<OrderRecord>findOrderByUserId(int userid){
		Session session = this.sessionFactory.openSession();
		Query query = session.createQuery
				("FROM OrderRecord WHERE user_id = ?");
		query.setParameter( 0,userid);
		List<OrderRecord>orderList = query.list();
		session.close();
		return orderList;
		
	}
	
	public int deleteRecord(int id) {
		Session session = this.sessionFactory.openSession();
		Transaction tx= session.beginTransaction();
		try {
			Query query =session.createQuery("FROM OrderRecord WHERE id=?");
			query.setParameter(0, id);
			OrderRecord order=(OrderRecord)query.uniqueResult();
			session.delete(order);
			tx.commit();
			return 1;
		}catch(HibernateException e) {
			e.printStackTrace();
			tx.rollback();
			return 0;
		}finally {
			session.close();
		}
    	
	}
	
}
