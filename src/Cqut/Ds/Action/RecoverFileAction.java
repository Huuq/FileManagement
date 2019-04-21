package Cqut.Ds.Action;

import com.opensymphony.xwork2.ActionSupport;

import Cqut.Ds.Service.FileService;

public class RecoverFileAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private FileService fileService;
	private int recycleID;
	
	public FileService getFileService() {
		return fileService;
	}
	public void setFileService(FileService fileService) {
		this.fileService = fileService;
	}
	public int getRecycleID() {
		return recycleID;
	}
	public void setRecycleID(int recyleID) {
		this.recycleID = recyleID;
	}
	
	public String execute() {
		fileService.recoverFile(recycleID);
		return "successRecover";
	}

}
