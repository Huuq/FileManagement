package Cqut.Ds.Action;

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import Cqut.Ds.Entity.History;
import Cqut.Ds.Entity.User;
import Cqut.Ds.Service.FileService;

public class DownloadHistoryAction extends ActionSupport{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public String historyFileName;
	
	private  HttpServletRequest request =null;
	
	public FileService fileService;
	
	public User user;	
	
    public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public void setHistoryFileName(String historyFileName) {
		this.historyFileName = historyFileName;
	}

	public FileService getFileService() {
		return fileService;
	}

	public void setFileService(FileService fileService) {
		this.fileService = fileService;
	}

	public HttpServletRequest getRequest() {
		return request;
	}

	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}

	public String getHistoryFileName() {
		return historyFileName;
	}

	public void setFileName(String historyFileName) {
		try {
			historyFileName = new String(historyFileName.getBytes("ISO8859-1"),"UTF-8");
		}
		catch(UnsupportedEncodingException e) {
			throw new RuntimeException(e);
		}
		this.historyFileName = historyFileName;
	}

	public InputStream getDownloadFile() throws IOException {		
 		ActionContext actionContext = ActionContext.getContext();	    
	    StringBuffer str = new StringBuffer();	  
		@SuppressWarnings("unchecked")		
		ArrayList<History> list = ( ArrayList<History>)actionContext.getSession().get("downloadHistory");
		for(int i = 0;i<list.size();i++) {
	    	str.append(list.get(i).getUserName()+list.get(i).getDate()+list.get(i).getOperation()+list.get(i).getFileName()+"\n");
	    }	
	    fileService.Record("胡建权","导出历史记录","历史记录.txt");	 
        return fileService.downloadHistoryRecord(str.toString());
	}
	
	@Override
	public String execute() throws Exception {	
		System.out.println("执行历史纪录下载");
        return "historySuccess";
	}		
	

}
