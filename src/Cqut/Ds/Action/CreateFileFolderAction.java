package Cqut.Ds.Action;

import com.opensymphony.xwork2.ActionSupport;

import Cqut.Ds.Service.FileFolderService;

public class CreateFileFolderAction extends ActionSupport{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String folderName;
	private String keyInfor;
	private FileFolderService folderService;		

	public String getKeyInfor() {
		return keyInfor;
	}

	public void setKeyInfor(String keyInfor) {
		this.keyInfor = keyInfor;
	}

	public FileFolderService getFolderService() {
		return folderService;
	}

	public void setFolderService(FileFolderService folderService) {
		this.folderService = folderService;
	}

	public String getFolderName() {
		return folderName;
	}

	public void setFolderName(String FolderName) {
		folderName = FolderName;
	}
	public String execute() {
		if(folderService.createFolder(folderName,keyInfor)) 
			return "createSuccess";
		else
			return "error";
		
	}
	

}
