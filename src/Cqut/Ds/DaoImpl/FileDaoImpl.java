package Cqut.Ds.DaoImpl;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.struts2.ServletActionContext;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.orm.hibernate3.HibernateTemplate;

import Cqut.Ds.Dao.FileDao;
import Cqut.Ds.Entity.FileM;
import Cqut.Ds.Entity.History;
import Cqut.Ds.Entity.RecycleBin;


public class FileDaoImpl implements FileDao{
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
	
    public boolean fieUpload(File myFile,String fileFolder,String userName,String fileName) throws FileNotFoundException {
    	if(myFile.exists()) { 
    		Session session=getHibernateTemplate().getSessionFactory().openSession();
    		Transaction tx = session.beginTransaction();
    		FileM file = new FileM();     
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        	file.setUploadUserName(userName);
    		file.setFileName(fileName);
    		file.setFileFolder(fileFolder);
            file.setFileSize(sizeFormat(myFile.length()));
            file.setFilePath(myFile.getPath());                 
            file.setOperation("上传");
            file.setDate(df.format(new Date()));
            session.save(file);
			tx.commit();    //6.提交事务	
			session.close();   //7.关闭session       		
    	}
    	return true;
    }
    @SuppressWarnings("unchecked")
	public List<FileM> findFileList(){
    	String hql="from FileM";
    	List<FileM> f = new ArrayList<FileM>();
    	Session session=getHibernateTemplate().getSessionFactory().openSession();    		    
   		Query query = session.createQuery(hql);
   		f=query.list();
   		session.close();
    	return f;
    }
   
	@SuppressWarnings("unchecked")
	public List<FileM> findFileListByFolder(String folderName){		
    	String hql="from FileM";
    	List<FileM> list = new ArrayList<FileM>(); 
    	List<FileM> fileListByFolder = new ArrayList<FileM>();
    	Session session=getHibernateTemplate().getSessionFactory().openSession();    	    
   		Query query = session.createQuery(hql);    		
   		list = (List<FileM>)query.list();   	
   		for(int i=0;i<list.size();i++) {
   			if(list.get(i).getFileFolder().equals(folderName)) {
   				fileListByFolder.add(list.get(i));
   			}
   		}   
   		session.close();
    	return fileListByFolder;     
    }
	@SuppressWarnings("unchecked")
	public List<FileM> findFileListBySearch(String searchInfo){		
    	String hql="from FileM";
    	List<FileM> list = new ArrayList<FileM>(); 
    	List<FileM> fileListByFolder = new ArrayList<FileM>();
    	Session session=getHibernateTemplate().getSessionFactory().openSession();    	    
   		Query query = session.createQuery(hql);    		
   		list = (List<FileM>)query.list(); 	
		for(int i=0;i<list.size();i++) {
   			if((list.get(i).getFileName().equals(searchInfo))||list.get(i).getFileName().indexOf(searchInfo)!=-1) {
   				fileListByFolder.add(list.get(i));
   			}   			
   		}  
		session.close();
    	return fileListByFolder;    	
    	
    }
    @SuppressWarnings("unchecked")
	public List<FileM> findFolderList(){
    	String hql="from FileFolder";
    	List<FileM> list = new ArrayList<FileM>();     
    	Session session=getHibernateTemplate().getSessionFactory().openSession();    		    
   		Query query = session.createQuery(hql);
   		list = query.list();
   		session.close();
    	return list;    	
    }
    public InputStream downloadFile(String fileName) {	
		return ServletActionContext.getServletContext().getResourceAsStream("/upload/"+fileName);
    }
    public boolean deleteFile(int fileID) {
    	Session session=getHibernateTemplate().getSessionFactory().openSession();	
    	Transaction tx=session.beginTransaction();
	    FileM file = new FileM();
	    System.out.println(fileID+"文件ID");
	    file.setFileID(fileID);
		try {					
			session.delete(file);             
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
    
    public boolean updateFile(int fileID,String fileName) {
    	FileM file = new FileM();    	
    	file.setFileID(fileID);
    	file.setFileName(fileName);
    	Session session=getHibernateTemplate().getSessionFactory().openSession();	
    	Transaction tx=session.beginTransaction();    	
    	try {					
    		session.update(file);        	        
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
 	   session.close();   //7.关闭session   
     }
     public boolean deleteRecord(int historyID) {       
       Session session=getHibernateTemplate().getSessionFactory().openSession();
   	   Transaction tx = session.beginTransaction();      
   	   History history = new History();
   	   history.setHistoryID(historyID);
   	   session.delete(history);
 	   tx.commit();
 	   session.close();   //7.关闭session
 	   return true;
     }
     @SuppressWarnings("unchecked")
 	public List<History> HistoryList(){
     	List<History> list = new ArrayList<History>();
     	Session session=getHibernateTemplate().getSessionFactory().openSession();
 		String hql ="from History";     	
     	Query query = session.createQuery(hql);
		list=query.list();
		session.close();
     	return list;
     }
     
     public InputStream downloadHistoryRecord(String history) {
        InputStream is = new ByteArrayInputStream(history.toString().getBytes()); 
        return is;
     }
     
     public static String sizeFormat(long size) {
    	double pers = 1048576;
     	String s = "";
     	if(size>1024*1024)
     		s=String.format("%.2f", (double)size/pers)+"M";
     	else if(size>1024*1024*1024)
     		s=String.format("%.2f", (double)size/(1024*1024*1024))+"G";
     	else 
     		s=String.format("%.2f", (double)size/(1024))+"KB";
 		return s;
 	}
     
    @SuppressWarnings("unchecked")
	public List<RecycleBin> recyleBinList(){
    	List<RecycleBin> list = new ArrayList<RecycleBin>();
     	Session session=getHibernateTemplate().getSessionFactory().openSession();
 		String hql ="from RecycleBin";     	
     	Query query = session.createQuery(hql);
		list=query.list();
		session.close();
     	return list;
    }
    public boolean cleanRecycle(String fileName,int recycleID) {   
    	Session session=getHibernateTemplate().getSessionFactory().openSession();	
    	Transaction tx=session.beginTransaction();
	    RecycleBin file = new RecycleBin();
	    System.out.println(fileName+"文件ID");
	    file.setRecycleID(recycleID);
		try {					
			session.delete(file);             
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
    	String filePath = "E:\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp1\\wtpwebapps\\CurriculumDesign\\upload\\"+fileName;
    	System.out.println(filePath);
    	java.io.File myDelFile=new java.io.File(filePath);
    	System.out.println(myDelFile.exists());
    	if(myDelFile.delete())    
    	   return true;
    	return false;
    }
    
    @SuppressWarnings("unchecked")
	public void addRecycle(int fileID) {    	
    	Session session=getHibernateTemplate().getSessionFactory().openSession();	
    	Transaction tx=session.beginTransaction();
    	List<FileM> list = new ArrayList<FileM>();    
    	String hql ="from FileM where fileID =:fileID";       	
     	Query query = session.createQuery(hql);
     	query.setParameter("fileID",fileID);	
		list=query.list();
    	SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	    RecycleBin bin = new RecycleBin();	   
	    bin.setFileName(list.get(0).getFileName());
	    bin.setFilePath(list.get(0).getFilePath());
	    bin.setFileFolder(list.get(0).getFileFolder());
	    bin.setFileSize(list.get(0).getFileSize());
	    bin.setDate(df.format(new Date()));
		try {					
			session.save(bin);             
			tx.commit();                     
		} catch (Exception e) {
			if(tx!=null){
				tx.rollback(); 			
			}
			e.printStackTrace();
		}finally{
			session.close(); 
		}			
    }
    
    @SuppressWarnings("unchecked")
	public boolean recoverFile(int recycleID) {
    	List<RecycleBin> list = new ArrayList<RecycleBin>();
     	Session session=getHibernateTemplate().getSessionFactory().openSession();     	
     	String hql ="from RecycleBin where recycleID =:recyleID";
    	System.out.println(hql);  
   		Query query = session.createQuery(hql);
   		query.setParameter("recyleID",recycleID);	  
		list=query.list();
		System.out.println(list.get(0)+"回收站的内容");
		System.out.println(list.get(0).getDate());
		System.out.println(list.get(0).getFileName());			
		addFile(list.get(0).getFileName(),list.get(0).getFileSize(),list.get(0).getFilePath(),list.get(0).getFileFolder());
		return true;
    }
    
    public void addFile(String fileName,String fileSize,String filePath,String fileFolder) {
    	Session session=getHibernateTemplate().getSessionFactory().openSession();
     	Transaction tx=session.beginTransaction();
     	SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		FileM file = new FileM();		
	    file.setFileName(fileName);
	    file.setFilePath(filePath);
	    file.setFileFolder(fileFolder);
	    file.setOperation("恢复文件");
	    file.setFileSize(fileSize);
	    file.setUploadUserName("管理员");
	    file.setDate(df.format(new Date()));
		try {					
			session.save(file);             
			tx.commit();                     
		} catch (Exception e) {
			if(tx!=null){
				tx.rollback(); 			
			}
			e.printStackTrace();
		}finally{	
			session.close(); 
		}
    }
    
    public boolean createNewFile(String fileName,String content,String filePath,
    		String fileFolder,String userName) {
    	String l = filePath+fileName+content;    	
    	File file = new File(l);
    	System.out.println(file.exists());
    	if(!file.exists()) { 
    		try {
				file.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    		Session session=getHibernateTemplate().getSessionFactory().openSession();
    		Transaction tx = session.beginTransaction();
        	FileM fileM = new FileM();
        	fileM.setFileFolder(fileFolder);
        	fileM.setFilePath(l);
        	fileM.setFileName(fileName+content);
        	fileM.setFileSize(sizeFormat(file.length()));
        	fileM.setUploadUserName(userName);
        	fileM.setOperation("新建");   
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");        	
            fileM.setDate(df.format(new Date()));
            session.save(fileM);
			tx.commit();    //6.提交事务	
			session.close();   //7.关闭session  
			return true;
    	}
    	return false;
    }
}
