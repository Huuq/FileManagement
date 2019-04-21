//package Cqut.Ds.Action;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import org.hibernate.Query;
//import org.hibernate.Session;
//import org.hibernate.SessionFactory;
//import org.hibernate.Transaction;
//import org.hibernate.cfg.Configuration;
//
//import com.opensymphony.xwork2.ActionContext;
//
//import Experiment.Entity.Student;
//public class seachStudentAction {	
//	private String choose;
//	private String Infor;
//	private String checkBox0;
//	private String checkBox1;
//	private String checkBox2;	
//	private List list = new ArrayList();
//	private int Size;
//	
//	
//	public List getList() {
//		return list;
//	}
//	public void setList(List list) {
//		this.list = list;
//	}
//	public int getSize() {
//		return Size;
//	}
//	public void setSize(int size) {
//		Size = size;
//	}
//	public String getChoose() {
//		return choose;
//	}
//	public void setChoose(String choose) {
//		this.choose = choose;
//	}
//	public String getInfor() {
//		return Infor;
//	}
//	public void setInfor(String infor) {
//		Infor = infor;
//	}
//	public String getCheckBox0() {
//		return checkBox0;
//	}
//	public void setCheckBox0(String checkBox0) {
//		this.checkBox0 = checkBox0;
//	}
//	public String getCheckBox1() {
//		return checkBox1;
//	}
//	public void setCheckBox1(String checkBox1) {
//		this.checkBox1 = checkBox1;
//	}
//	public String getCheckBox2() {
//		return checkBox2;
//	}
//	public void setCheckBox2(String checkBox2) {
//		this.checkBox2 = checkBox2;
//	}
//
//	private List seachStudent(){
//		Student stu = new Student();
//		//1.初始化,读取配置文件hibernate.cfg.xml
//		Configuration config=new Configuration().configure();
//		//2.读取并解析映射文件(Users.hbm.xml)，创建sessionFactory
//		@SuppressWarnings("deprecation")
//		SessionFactory sessionFactory=config.buildSessionFactory();
//		//3.打开session
//		Session session=sessionFactory.openSession();	
//		Transaction tx=session.beginTransaction();
//        List AnswerList = new ArrayList<Student>();     
//	  //  list.clear();
//	    System.out.println(Infor);
//	    System.out.println(checkBox0);
//	    System.out.println(checkBox1);
//	    System.out.println(checkBox2);	    
//		try {	
//			 if(checkBox1.equals("姓名")&& checkBox2.equals("等于")) {
//					 String hql ="from Student where Name =:Name and ClassNo =:ClassNo";
//				     System.out.println(hql);
//				     Query query = session.createQuery(hql);
//				     query.setParameter("Name",Infor);
//			         query.setParameter("ClassNo",checkBox0);	      
//			         AnswerList = query.list();
//			         System.out.println(query.list()+"查询结果");	
//			    }	   
//			    else if(checkBox1.equals("姓名")&& checkBox2.equals("包含")) {
//			    	 String hql ="from Student where Name like%:Name% and ClassNo =:ClassNo";
//			    	 System.out.println(hql);
//		    	     Query query = session.createQuery(hql);
//		    	     query.setString("Name","%"+Infor+"%");
//				     query.setParameter("ClassNo",checkBox0);	      
//				     AnswerList = query.list();
//				     System.out.println(query.list()+"查询结果");
//			    }	
//			   
//			    else if(checkBox1.equals("学号")&& checkBox2.equals("等于")) {
//			    	String hql ="from Student where StudentNo =:StudentNo and ClassNo =:ClassNo";
//			    	System.out.println(hql);
//		       		Query query = session.createQuery(hql);
//		       		query.setParameter("StudentNo",Infor);
//				    query.setParameter("ClassNo",checkBox0);	      
//				    AnswerList = query.list();
//				    System.out.println(query.list()+"查询结果");
//			    }
//			    
//			    else if(checkBox1.equals("学号")&& checkBox2.equals("包含")) {
//			    	String hql ="from Student where StudentNo like:StudentNo and ClassNo =:ClassNo";
//			    	System.out.println(hql);
//			    	Query query = session.createQuery(hql);
//			    	query.setString("StudentNo","%"+Infor+"%");
//				    query.setParameter("ClassNo",checkBox0);	      
//				    AnswerList = query.list();
//				    System.out.println(query.list()+"查询结果");
//			    }
//			   
//			    else if(checkBox1.equals("年龄")&& checkBox2.equals("等于")) {
//			       String hql ="from Student where Age =:Age and ClassNo =:ClassNo";
//			       System.out.println(hql);
//			       Query query = session.createQuery(hql);
//			       query.setParameter("Age",Integer.parseInt(Infor));
//			       query.setParameter("ClassNo",checkBox0);	      
//			       AnswerList = query.list();
//			       System.out.println(query.list()+"查询结果");
//			    }	
//			   
//			    else if(checkBox1.equals("年龄")&& checkBox2.equals("大于")) {
//			       String hql ="from Student where Age >:Age and ClassNo =:ClassNo";
//			       System.out.println(hql);
//			       Query query = session.createQuery(hql);
//			       query.setParameter("Age",Integer.parseInt(Infor));
//			       query.setParameter("ClassNo",checkBox0);	      
//			       AnswerList = query.list();
//			       System.out.println(query.list()+"查询结果");
//			    }			   
//			   
//			    else if(checkBox1.equals("年龄")&& checkBox2.equals("大于等于")) {
//			       String hql ="from Student where Age >=:Age and ClassNo =:ClassNo";
//			       System.out.println(hql);
//			       Query query = session.createQuery(hql);
//			       query.setParameter("Age",Integer.parseInt(Infor));
//			       query.setParameter("ClassNo",checkBox0);	      
//			       AnswerList = query.list();
//			       System.out.println(query.list()+"查询结果");
//			    }
//			   
//			    else if(checkBox1.equals("年龄")&& checkBox2.equals("小于")) {
//			    	 String hql ="from Student where Age <:Age and ClassNo =:ClassNo";
//			    	 System.out.println(hql);
//			    	 Query query = session.createQuery(hql);
//			    	 query.setParameter("Age",Integer.parseInt(Infor));
//				     query.setParameter("ClassNo",checkBox0);	      
//				     AnswerList = query.list();
//				     System.out.println(query.list()+"查询结果");
//			    }
//			   
//			    else if(checkBox1.equals("年龄")&& checkBox2.equals("小于等于")) {
//			       String hql ="from Student where Age <=:Age and ClassNo =:ClassNo";
//			       System.out.println(hql);
//			       Query query = session.createQuery(hql);
//			       query.setParameter("Age",Integer.parseInt(Infor));
//			       query.setParameter("ClassNo",checkBox0);	      
//			       AnswerList = query.list();
//			       System.out.println(query.list()+"查询结果");
//			    }         
//			tx.commit();                      //提交事务
//		} catch (Exception e) {
//			if(tx!=null){
//				tx.rollback();       //事务回滚				
//			}
//			e.printStackTrace();
//		}finally{
//			session.close();   //关闭session
//		}	
//		return AnswerList;
//	}	
//	
//	public String execute() {			
//		list = seachStudent();
//		System.out.println(list+"查询结果");
//	    if(list.size() > 0) {
//			   Size = list.size();
//			   ActionContext.getContext().put("list", list);				  
//			   return "index";
//		    }	
//	    else
//		   return"error";	
//	}
//
//
//}
