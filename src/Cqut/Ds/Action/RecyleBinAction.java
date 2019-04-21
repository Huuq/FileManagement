package Cqut.Ds.Action;

import java.util.ArrayList;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import Cqut.Ds.Entity.RecycleBin;
import Cqut.Ds.Service.FileService;

public class RecyleBinAction  extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private FileService fileService;
	
	public FileService getFileService() {
		return fileService;
	}
	public void setFileService(FileService fileService) {
		this.fileService = fileService;
	}
	public String execute() {
		ArrayList<RecycleBin> recyleList = (ArrayList<RecycleBin>) fileService.recyleBinList();		
		ActionContext actionContext = ActionContext.getContext();
		if(recyleList.size()>0) {			
			actionContext.put("recyleList",recyleList); 			
			return "recylistList";
		}	
		else {			
			actionContext.put("msg","暂时没有任何操作记录"); 
			return "recylistList";
		}
	}
	

}
