package Cqut.Ds.DaoImpl;

import java.util.ArrayList;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.orm.hibernate3.HibernateTemplate;

import Cqut.Ds.Dao.UserDao;
import Cqut.Ds.Entity.User;

public class UserDaoImpl implements UserDao{
	private SessionFactory sessionFactory;
	private HibernateTemplate hibernatetemplate;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	private HibernateTemplate getHibernateTemplate() {
		if (hibernatetemplate == null)
			hibernatetemplate = new HibernateTemplate(sessionFactory);		
		return hibernatetemplate;
	}
	public User findUser(String userName) {
			Session session=getHibernateTemplate().getSessionFactory().openSession();
			String hql ="from User where userName =:userName";	    		    
	   		Query query = session.createQuery(hql);
	   		query.setParameter("userName",userName);
	   		@SuppressWarnings("unchecked")
			ArrayList<User> list = (ArrayList<User>) query.list();	 
	   		System.out.println(list);
	   		session.close();
	   		if(list.size()>0) {
	   			return list.get(0);
	   		}
	   		else
	   			return null;			
	   }
	   public boolean addUser(String userName,String password,String nickName) {
		    Session session=getHibernateTemplate().getSessionFactory().openSession();
		    Transaction tx = session.beginTransaction();
			try {			
				User user = new User();
				user.setUserName(userName);
				user.setPassword(password);	 
				user.setNickName(nickName);
			    getHibernateTemplate().save(user);
				tx.commit();  //6.提交事务
			} catch (Exception e) {
				if(tx!=null){
					tx.rollback();  //事务回滚	
					return false;
				}	
				e.printStackTrace();
			}finally{
				session.close();   //7.关闭session			
			}		   
		   return true;
	   }
}
