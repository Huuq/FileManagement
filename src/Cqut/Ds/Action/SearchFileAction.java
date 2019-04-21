package Cqut.Ds.Action;

import java.util.ArrayList;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import Cqut.Ds.Entity.FileM;
import Cqut.Ds.Service.FileService;

public class SearchFileAction extends ActionSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String searchInfo;
	private FileService fileService;
	
	
	public String getSearchInfo() {
		return searchInfo;
	}
	public void setSearchInfo(String searchInfo) {
		this.searchInfo = searchInfo;
	}
	
	public FileService getFileService() {
		return fileService;
	}
	public void setFileService(FileService fileService) {
		this.fileService = fileService;
	}
	public String execute() throws Exception {	
		System.out.println(searchInfo);
		ArrayList<FileM> fileList = new ArrayList<FileM>();		
		fileList=(ArrayList<FileM>)fileService.findFileListBySearch(searchInfo);	
		System.out.println(fileList);
		ActionContext actionContext = ActionContext.getContext();
		if(fileList.size()>0) {			
			actionContext.put("fileListSearch",fileList);
			return "successSearch";
		}	
		else {			
			actionContext.put("msg","没有找到相关文件！！！"); 
			return "successSearch";
		}
	}

}
