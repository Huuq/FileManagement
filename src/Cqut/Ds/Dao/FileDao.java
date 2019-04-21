package Cqut.Ds.Dao;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.List;

import Cqut.Ds.Entity.FileM;
import Cqut.Ds.Entity.History;
import Cqut.Ds.Entity.RecycleBin;

public interface FileDao {
    public boolean fieUpload(File myFile,String fileFolder,String userName,String fileName) throws FileNotFoundException;
    public List<FileM> findFileList();
    public List<FileM> findFileListByFolder(String folderName);
    public List<FileM> findFolderList();    
    public boolean deleteFile(int fileID);
    public InputStream downloadFile(String fileName);
    public boolean updateFile(int fileID,String fileName);
    public void Record(String name,String operation,String fileName);
    public boolean deleteRecord(int historyID);
    public List<History> HistoryList();
    public InputStream downloadHistoryRecord(String history);
    public List<FileM> findFileListBySearch(String searchInfo);
    public List<RecycleBin> recyleBinList();
    public boolean cleanRecycle(String fileName,int recycleID);
    public void addRecycle(int fileID);
    public boolean recoverFile(int recyleID);
    public boolean createNewFile(String fileName,String content,String filePath,String fileFolder,String userName);
}
