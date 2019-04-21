package Cqut.Ds.Entity;


public class FileM {
	private Integer fileID;
	private String fileName;
	private String fileFolder;
	private String filePath;
	private String uploadUserName;	
	private String fileSize;
	private String operation;
    private String date;
    
    
	public FileM() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public FileM(Integer fileID, String fileName, String fileFolder, String filePath, String uploadUserName,
			String fileSize, String operation, String date) {
		super();
		this.fileID = fileID;
		this.fileName = fileName;
		this.fileFolder = fileFolder;
		this.filePath = filePath;
		this.uploadUserName = uploadUserName;
		this.fileSize = fileSize;
		this.operation = operation;
		this.date = date;
	}

	public Integer getFileID() {
		return fileID;
	}

	public void setFileID(Integer fileID) {
		this.fileID = fileID;
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

	public String getUploadUserName() {
		return uploadUserName;
	}

	public void setUploadUserName(String uploadUserName) {
		this.uploadUserName = uploadUserName;
	}

	public String getFileSize() {
		return fileSize;
	}

	public void setFileSize(String string) {
		this.fileSize = string;
	}
	public String getOperation() {
		return operation;
	}

	public void setOperation(String operation) {
		this.operation = operation;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}
    

}
