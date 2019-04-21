package Cqut.Ds.Entity;

public class History {
	private Integer historyID;
	private String userName;
	private String date;
	private String operation;
	private String fileName;
	
	public History() {
		super();
		// TODO Auto-generated constructor stub
	}
	public History(Integer historyID, String userName, String date, String operation,String fileName) {
		super();
		this.historyID = historyID;
		this.userName = userName;
		this.date = date;
		this.operation = operation;
		this.fileName = fileName;
	}
	public Integer getHistoryID() {
		return historyID;
	}
	public void setHistoryID(Integer historyID) {
		this.historyID = historyID;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getOperation() {
		return operation;
	}
	public void setOperation(String operation) {
		this.operation = operation;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileID(String fileName) {
		this.fileName = fileName;
	}

}
