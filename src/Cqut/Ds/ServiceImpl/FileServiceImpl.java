package Cqut.Ds.ServiceImpl;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.List;

import Cqut.Ds.DaoImpl.FileDaoImpl;
import Cqut.Ds.Entity.FileM;
import Cqut.Ds.Entity.History;
import Cqut.Ds.Entity.RecycleBin;
import Cqut.Ds.Service.FileService;

public class FileServiceImpl implements FileService{
	public FileDaoImpl fileDao;

	public FileDaoImpl getFileDao() {
		return fileDao;
	}
	public void setFileDao(FileDaoImpl fileDao) {
		this.fileDao = fileDao;
	}
	
	public boolean fieUpload(File myFile,String fileFolder,String userName,String fileName) throws FileNotFoundException{
		return fileDao.fieUpload(myFile,fileFolder,userName,fileName);
	}
	
    public List<FileM> findFileList(){    	
		return fileDao.findFileList();
    }
    public List<FileM> findFolderList(){
    	return fileDao.findFolderList();
    }
    
    public List<FileM> findFileListByFloder(String folderName){    	
		return fileDao.findFileListByFolder(folderName);
    }
    
    public boolean deleteFile(int fileID,String fileName,String userName) {    	
    	fileDao.addRecycle(fileID);
    	fileDao.Record(userName,"删除文件", fileName);
    	return fileDao.deleteFile(fileID);
    }
    public InputStream downloadFile(String fileName,String userName) {    
    	fileDao.Record(userName,"下载文件", fileName);
    	return fileDao.downloadFile(fileName);
    }
    
    public boolean updateFile(int fileID,String fileName) {
    	return fileDao.updateFile(fileID,fileName);
    }
    
	public void Record(String name,String operation,String fileName) {
		fileDao.Record(name, operation, fileName);
	}
	
	public boolean deleteRecord(int historyID) {		
		return fileDao.deleteRecord(historyID);	  
	}
	
    public List<History> HistoryList(){
	    return fileDao.HistoryList();
    }
    
    public InputStream downloadHistoryRecord(String h) {    	
    	return fileDao.downloadHistoryRecord(h);
    }
    
    public List<FileM> findFileListBySearch(String searchInfo){
    	return fileDao.findFileListBySearch(searchInfo);
    }
    
    public List<RecycleBin> recyleBinList(){
    	return fileDao.recyleBinList();
    }
    
    public boolean cleanRecycle(String fileName,int recycleID) {
    	return fileDao.cleanRecycle(fileName,recycleID);
    }
    
    public boolean recoverFile(int recycleID) {
    	return fileDao.recoverFile(recycleID);
    }
    
    public boolean createNewFile(String fileName,String content,String filePath,String fileFolder,String userName) {
    	return fileDao.createNewFile(fileName, content, filePath,fileFolder,userName);
    }
}
