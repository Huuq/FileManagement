package Cqut.Ds.Action;

import java.util.ArrayList;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import Cqut.Ds.Dao.FileDao;
import Cqut.Ds.Entity.FileM;
import Cqut.Ds.Entity.User;
import Cqut.Ds.Service.FileService;

public class IndexAction extends ActionSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private FileService fileService;
	private User user;
	private FileDao fileDao;
	
	public FileService getFileService() {
		return fileService;
	}
	public void setFileService(FileService fileService) {
		this.fileService = fileService;
	}
	public FileDao getFileDao() {
		return fileDao;
	}
	public void setFileDao(FileDao fileDao) {
		this.fileDao = fileDao;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}	
	public String execute() throws Exception {	
		System.out.println("运行打点"+user);	
		ActionContext actionContext = ActionContext.getContext();
		if(user!=null) {
			actionContext.put("msg",user.getNickName()); 
		}
		else {
			actionContext.put("msg","欢迎登录");  
		}
    	ArrayList<FileM> listFile =(ArrayList<FileM>) fileService.findFileList();	
    	ArrayList<FileM> listFolder =(ArrayList<FileM>) fileService.findFolderList();
    	actionContext.put("listFile",listFile); 
    	actionContext.put("listFolder",listFolder);    	
    	return "success";	
	 
	}
}
