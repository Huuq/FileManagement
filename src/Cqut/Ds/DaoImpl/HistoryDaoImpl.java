package Cqut.Ds.DaoImpl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.orm.hibernate3.HibernateTemplate;

import Cqut.Ds.Dao.HistoryDao;
import Cqut.Ds.Entity.History;

public class HistoryDaoImpl implements HistoryDao{
	private SessionFactory sessionFactory;
	private HibernateTemplate hibernatetemplate;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;

	}
	private HibernateTemplate getHibernateTemplate() {
		if (hibernatetemplate == null)
			hibernatetemplate = new HibernateTemplate(sessionFactory);
		System.out.println("hava to running!!!");
		return hibernatetemplate;
	}	
    public void Record(String name,String operation,String fileName) {
       Session session=getHibernateTemplate().getSessionFactory().openSession();
	   Transaction tx = session.beginTransaction();
       SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	   History history = new History();
	   history.setUserName(name);
	   history.setDate(df.format(new Date()));
	   history.setOperation(operation);
	   history.setFileID(fileName);
	   session.save(history);
	   tx.commit();
	   session.close();   //7.¹Ø±Õsession   
    }
    public boolean deleteRecord(int historyID) {       
       Session session=getHibernateTemplate().getSessionFactory().openSession();
  	   Transaction tx = session.beginTransaction();      
  	   History history = new History();
  	   history.setHistoryID(historyID);
  	   session.delete(history);
	   tx.commit();
	   session.close();   //7.¹Ø±Õsession
	   return true;
    }
    @SuppressWarnings("unchecked")
	public List<History> HistoryList(){
    	List<History> list = new ArrayList<History>();
    	Session session=getHibernateTemplate().getSessionFactory().openSession();
		String hql ="from History";
    	System.out.println(hql);	    
   		Query query = session.createQuery(hql);
   		list=query.list();
   		session.close();
    	return list;
    }

}
