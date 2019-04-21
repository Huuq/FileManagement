package Cqut.Ds.Entity;

public class RecycleBin {
	private Integer recycleID;	
	private String fileName;
	private String fileFolder;
	private String filePath;
	private String fileSize;
    private String date;    
    

	public RecycleBin() {
		super();
		// TODO Auto-generated constructor stub
	}
	public RecycleBin(Integer recycleID,String fileName, String fileFolder, String filePath,
			String fileSize, String date) {
		super();
		this.recycleID = recycleID;		
		this.fileName = fileName;
		this.fileFolder = fileFolder;
		this.filePath = filePath;
		this.fileSize = fileSize;
		this.date = date;
	}
	public Integer getRecycleID() {
		return recycleID;
	}
	public void setRecycleID(Integer recycleID) {
		this.recycleID = recycleID;
	}

	public String getFileName() {
		return fileName;
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
	public String getFilePath() {
		return filePath;
	}
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
	public String getFileSize() {
		return fileSize;
	}
	public void setFileSize(String fileSize) {
		this.fileSize = fileSize;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
    
    
	
    

}
