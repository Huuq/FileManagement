package Cqut.Ds.ServiceImpl;

import Cqut.Ds.DaoImpl.FolderDaoImpl;
import Cqut.Ds.Service.FileFolderService;

public class FileFolderServiceImpl implements FileFolderService{
	public FolderDaoImpl fileFolderDao;

	
	public FolderDaoImpl getFileFolderDao() {
		return fileFolderDao;
	}

	public void setFileFolderDao(FolderDaoImpl fileFolderDao) {
		this.fileFolderDao = fileFolderDao;
	}



	public boolean createFolder(String folderName,String keyInfor) {
		return fileFolderDao.createFolder(folderName,keyInfor);
	}
  
}
