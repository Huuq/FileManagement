package Cqut.Ds.Action;

import java.util.ArrayList;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import Cqut.Ds.Entity.FileM;
import Cqut.Ds.Service.FileService;

public class FileListAction extends ActionSupport{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public String fileFolderName;
	private FileService fileService;
	 
	public FileService getFileService() {
		return fileService;
	}

	public void setFileService(FileService fileService) {
		this.fileService = fileService;
	}
	
	public String getFileFolderName() {
		return fileFolderName;
	}

	public void setFileFolderName(String fileFolderName) {
		this.fileFolderName = fileFolderName;
	}
	public String execute() throws Exception {			
		ArrayList<FileM> fileList = new ArrayList<FileM>();		
		fileList=(ArrayList<FileM>) fileService.findFileListByFloder(fileFolderName);	
		ActionContext actionContext = ActionContext.getContext();
		if(fileList.size()>0) {			
			actionContext.put("fileList",fileList);
			return "successFileList";
		}	
		else {			
			actionContext.put("msg","暂时没有任何操作记录"); 
			return "successFileList";
		}
	}

}
