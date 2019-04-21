package Cqut.Ds.Action;

import com.opensymphony.xwork2.ActionSupport;

import Cqut.Ds.Service.FileService;

public class ClearAction extends ActionSupport{
   /**
	 * 
	 */
   private static final long serialVersionUID = 1L;
   private String fileName;
   private int recycleID;
   private FileService fileService;
   public int getRecycleID() {
		return recycleID;
	}
	
	public void setRecycleID(int recycleID) {
		this.recycleID = recycleID;
	}


   
   public FileService getFileService() {
	return fileService;
   }

   public void setFileService(FileService fileService) {
	this.fileService = fileService;
   } 

 
   
   public String getFileName() {
	return fileName;
	}
	
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String execute() {
		   System.out.println(fileName);	
		   System.out.println(recycleID);	
	       boolean B = fileService.cleanRecycle(fileName,recycleID);
	       if(B)
		     return "successClear";
	       return "error";
	   }
}
