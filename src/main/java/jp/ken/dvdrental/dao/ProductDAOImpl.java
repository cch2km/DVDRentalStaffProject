package jp.ken.dvdrental.dao;

import java.util.List;




import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;



import jp.ken.dvdrental.entity.Product;





public class ProductDAOImpl implements ProductDAO<Product>{
	
	 private SessionFactory sessionFactory;
		
		public void setSessionFactory(SessionFactory sessionFactory) {
			this.sessionFactory= sessionFactory;
		}
	
	//�����ޤ�����
	@Override
	@SuppressWarnings("unchecked")
	public List<Product> vagueNameList(String vauge){
		Session session = sessionFactory.openSession();
		Query query = session.createQuery
				("FROM Product WHERE product_name LIKE :inputVague");
		
		query.setParameter("inputVague", "%"+vauge+"%");
		List<Product> vagueList =query.list();
		session.close();
		return vagueList;
	}
	
	
	
	//在庫商品登録
	@Override
	public boolean insertProductData(Product product) {
		Session session= this.sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		try {
			session.saveOrUpdate(product);
			tx.commit();
			return true;
		}catch(HibernateException e) {
			tx.rollback();
			return false;
		}finally {
			session.close();
		}
	}
	
//	//IDで検索
//	public Product idSearch(int id) {
//		Session session= this.sessionFactory.openSession();
//    	Query query = session.createQuery("from Product where product_Id=?");
//	    query.setParameter(0, id);
//	    Product product = (Product)query.uniqueResult();
//	    session.close();
//	    return product;
//    }
		
	@SuppressWarnings("unchecked")
	public List<Product> directorSearch(String dir) {
		
		Session session = sessionFactory.openSession();
		Query query = session.createQuery
				("FROM Product WHERE dir = ?");
		
		query.setParameter(0,dir);
		 List<Product>directorList = query.list();
		session.close();
		return directorList;
	}
		
	
	
	
	
	//商品名で検索
	public Product nameSearch(String productName) {
		
		Session session = sessionFactory.openSession();
		Query query = session.createQuery
				("FROM Product WHERE ename = ?");
		
		query.setParameter(0,productName);
		Product product = (Product)query.uniqueResult();
		session.close();
		return product;
	}
	
		public void updateNum(Product product) {
		Session session = sessionFactory.openSession();
		Transaction tx= session.beginTransaction();
		try {
					
		session.update(product);
		tx.commit();
		}catch(HibernateException e) {
		e.printStackTrace();
		tx.rollback();
		
		}finally {
			session.close();
			
		}
		
		}
		
		//ID
		public Product idSearch(int id) {
			Session session= this.sessionFactory.openSession();
	    	Query query = session.createQuery("from Product where product_Id=?");
		    query.setParameter(0, id);
		    Product product = (Product)query.uniqueResult();
		    session.close();
		    return product;
	    }
			
	
		

		
		@SuppressWarnings("unchecked")
		public List<Product> allList(){
			Session session= this.sessionFactory.openSession();
	    	Query query = session.createQuery("from Product");
		    List<Product> productList = query.list();
		    session.close();
		    return productList;
	    }
		
		 @Override
		    public int updateProduct(Product product) {
		    	
		    	Session session = this.sessionFactory.openSession();
		    	Transaction tx = session.beginTransaction();
		    	try {
		    		session.update(product);
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
			
		
		public int deleteProduct(int pId) {
			Session session = this.sessionFactory.openSession();
			Transaction tx= session.beginTransaction();
			try {
				Query query =session.createQuery("FROM Product WHERE product_Id=?");
				query.setParameter(0, pId);
				Product product=(Product)query.uniqueResult();
				session.delete(product);
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
		
		
		
		
//Transaction tx= session.beginTransaction();
//		Product product=(Product)query.uniqueResult();
//		session.update(product);
//		tx.commit();
//		}catch(HibernateException e) {
//		e.printStackTrace();
//		tx.rollback();
//		
//		}finally {
//			
//		}
//}
	

	
}
