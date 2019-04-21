package Cqut.Ds.Entity;

public class FileFolder {
    private Integer fileFolderID;
    private String fileFolderName;	
    private String keyInfor;
    
	public FileFolder() {
		super();
		// TODO Auto-generated constructor stub
	}
	public FileFolder(Integer fileFolderID, String fileFolderName, String keyInfor) {
		super();
		this.fileFolderID = fileFolderID;
		this.fileFolderName = fileFolderName;
		this.keyInfor = keyInfor;
	}
	public Integer getFileFolderID() {
		return fileFolderID;
	}
	public void setFileFolderID(Integer fileFolderID) {
		this.fileFolderID = fileFolderID;
	}
	public String getFileFolderName() {
		return fileFolderName;
	}
	public void setFileFolderName(String fileFolderName) {
		this.fileFolderName = fileFolderName;
	}
	public String getKeyInfor() {
		return keyInfor;
	}
	public void setKeyInfor(String keyInfor) {
		this.keyInfor = keyInfor;
	}
    
	
}
