package Cqut.Ds.Action;

import com.opensymphony.xwork2.ActionSupport;

import Cqut.Ds.Entity.User;
import Cqut.Ds.Service.FileService;

public class DeleteFileAction extends ActionSupport  {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public int fileID;
	public User user;	

	private String fileName;
    private FileService fileService;     
	
    public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public int getFileID() {
		return fileID;
	}
	public void setFileID(int fileID) {
		this.fileID = fileID;
	}
	public FileService getFileService() {
		return fileService;
	}
	public void setFileService(FileService fileService) {
		this.fileService = fileService;
	}
	public String execute() throws Exception {	
		System.out.println(fileID);		
		boolean B=fileService.deleteFile(fileID,fileName,"胡建权");
		if(B){
			System.out.println("删除成功");
			return "success";
			
		}
		return "error";
        
	}	

}
