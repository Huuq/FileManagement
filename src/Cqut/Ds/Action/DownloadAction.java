package Cqut.Ds.Action;

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import com.opensymphony.xwork2.ActionSupport;

import Cqut.Ds.Entity.User;
import Cqut.Ds.Service.FileService;
import sun.misc.BASE64Encoder;





 
public class DownloadAction extends ActionSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String fileName;	
    private  HttpServletRequest request =null;
    private FileService fileService;
    private User user;
    
    public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
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
	public String getFileName() throws UnsupportedEncodingException {		
		
		return encodeDownloadFilename(fileName,ServletActionContext.getRequest().getHeader("User-Agent"));
	}

	public void setFileName(String fileName) {
	
		this.fileName = fileName;
	}

	public InputStream getDownloadFile() throws IOException {			
		System.out.println(fileName);
		//fileService.Record("胡建权", "下载文件", fileName);	
        return fileService.downloadFile(fileName,"Tom");
	}
	@Override
	public String execute() throws Exception {	
        return"downloadFileSuccess";
	}	
	
	public String encodeDownloadFilename(String name,String agent) throws UnsupportedEncodingException {
		if(agent.contains("Firefox")) {
			name="=?utf-8?B?"+new BASE64Encoder().encode(name.getBytes("utf-8"))+"?=";
		}
		else {
			name=URLEncoder.encode(name, "utf-8");
		}
		return name;			
	}
	
}
