package jp.ken.dvdrental.dao;



import java.util.List;

import org.hibernate.HibernateException;


import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;



import jp.ken.dvdrental.entity.User;


public class UserDAOImpl implements UserDAO<User> {
	
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory= sessionFactory;
	}
	
	@Override
	public boolean insertUserData(User user) {
		Session session= this.sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		try {
			session.saveOrUpdate(user);
			tx.commit();
			return true;
		}catch(HibernateException e) {
			tx.rollback();
			return false;
		}finally {
			session.close();
		}
	}


	    @Override
	    public User login(String email,String password) {
	    Session session= this.sessionFactory.openSession();
	    Query query = session.createQuery("from User where email=? and password=?");
	    query.setParameter(0, email);
	    query.setParameter(1, password);
	        
	        return (User)query.uniqueResult();
	    }
	    
	    public User getById(int id) {
	    	Session session= this.sessionFactory.openSession();
	    	Query query = session.createQuery("from User where id=?");
		    query.setParameter(0, id);
		    User user = (User)query.uniqueResult();
		    session.close();
		    return user;
	    }
	    
	    @Override
	    public int updateUser(User user) {
	    	
	    	Session session = this.sessionFactory.openSession();
	    	Transaction tx = session.beginTransaction();
	    	try {
	    		session.update(user);
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
		
		
	    
	    
	    public int deleteUser(int id) {
	    	Session session = this.sessionFactory.openSession();
			Transaction tx= session.beginTransaction();
			try {
				Query query =session.createQuery("FROM User WHERE user_Id=?");
				query.setParameter(0, id);
				User user=(User)query.uniqueResult();
				session.delete(user);
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
	    
	    @Override
	    @SuppressWarnings("unchecked")
		public List<User> allList(){
	    	Session session= this.sessionFactory.openSession();
	    	Query query = session.createQuery("from User");
		    List<User> userList = query.list();
		    session.close();
		    return userList;
	    }

}
