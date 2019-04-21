package Cqut.Ds.Action;

import com.opensymphony.xwork2.ActionSupport;

import Cqut.Ds.Service.FileService;

public class UpdateFileNameAction extends ActionSupport{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String fileName;
	private int fileID;
	private FileService fileService;
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
	public String execute() {
		boolean B=fileService.updateFile(fileID, fileName);
		if(B)
		  return "successUpdate";
		else
		  return"error";
	}
}
