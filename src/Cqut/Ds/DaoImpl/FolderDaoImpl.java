package Cqut.Ds.DaoImpl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.orm.hibernate3.HibernateTemplate;

import Cqut.Ds.Dao.FolderDao;
import Cqut.Ds.Entity.FileFolder;

public class FolderDaoImpl implements FolderDao{
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
	
	public boolean createFolder(String folderName,String keyInfor) {
		FileFolder folder = new FileFolder();
		folder.setFileFolderName(folderName);
		folder.setKeyInfor(keyInfor);
		Session session=getHibernateTemplate().getSessionFactory().openSession();
		Transaction tx=session.beginTransaction();
		try {					
			session.save(folder);            
			tx.commit();                     
		} catch (Exception e) {
			if(tx!=null){
				tx.rollback(); 
				return false;
			}
			e.printStackTrace();
		}finally{
			session.close(); 
		}			
		return true;		
	}
}
