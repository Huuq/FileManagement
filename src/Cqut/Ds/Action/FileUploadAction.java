package Cqut.Ds.Action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;


import org.apache.struts2.ServletActionContext;
import Cqut.Ds.Entity.User;
import Cqut.Ds.Service.FileService;




public class FileUploadAction {		
	private File myFile;//上传的文件，对应表单的file的name属性	
	private String fileFolder;
	private String myFileFileName;		
	private FileService fileService;
	private String savePath;
	//public HistoryDao historyDao;
	private User user;

	
	public String getSavePath() {
		return savePath;
	}

	public void setSavePath(String savePath) {
		this.savePath = savePath;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getFileFolder() {
		return fileFolder;
	}

	public void setFileFolder(String fileFolder) {
		this.fileFolder = fileFolder;
	}	
	public FileService getFileService() {
		return fileService;
	}

	public void setFileService(FileService fileService) {
		this.fileService = fileService;
	}

	public File getMyFile() {
		return myFile;
	}

	public void setMyFile(File myFile) {
		this.myFile = myFile;
	}
	
	public String getMyFileFileName() {
		return myFileFileName;
	}

	public void setMyFileFileName(String myFileFileName) {
		this.myFileFileName = myFileFileName;
	}
	 
	public String execute() throws Exception {
		System.out.println(myFileFileName+"文件名");
		if (myFile == null) {			
			return "error";
		} else {			
			InputStream is = new FileInputStream(myFile);
			String uploadPath = ServletActionContext.getServletContext().getRealPath("/upload/");			
			File toFile = new File(uploadPath,myFileFileName);			
			OutputStream os =new FileOutputStream(toFile);
			byte[] buffer=new byte[1024];		
			while(-1!=(is.read(buffer, 0, buffer.length))) {
				os.write(buffer);
			}
			is.close();
			os.close();			
			fileService.fieUpload(toFile,fileFolder,"胡建权",myFileFileName);
			fileService.Record("胡建权", "上传文件", myFileFileName);		      
		}
		return "uploadFileSuccess";		
	}
 


}
