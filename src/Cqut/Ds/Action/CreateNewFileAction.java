package Cqut.Ds.Action;

import com.opensymphony.xwork2.ActionSupport;

import Cqut.Ds.Entity.User;
import Cqut.Ds.Service.FileService;

public class CreateNewFileAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private User user;
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}

	private String fileName;
	private String fileFolder;
	private String content;
	private FileService fileService;
	private static final String filePath="E:\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp1\\wtpwebapps\\CurriculumDesign\\upload\\";
	
	public String getFileName() {
		return fileName;
	}
	public FileService getFileService() {
		return fileService;
	}
	public void setFileService(FileService fileService) {
		this.fileService = fileService;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getFileFolder() {
		return fileFolder;
	}
	public void setFileFolder(String fileFolder) {
		this.fileFolder = fileFolder;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
    public String execute() {
    	System.out.println(user);
    	System.out.println(fileName);
    	System.out.println(fileFolder);
    	System.out.println(content);
    	boolean B = fileService.createNewFile(fileName, content, filePath, fileFolder,"ºú½¨È¨");
    	if(B) {
    		return "CreateSuccess";
    	}
    	return "error";
    	
    }

	
}
