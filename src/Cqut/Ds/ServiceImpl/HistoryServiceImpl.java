package Cqut.Ds.ServiceImpl;

import java.util.List;

import Cqut.Ds.Dao.HistoryDao;
import Cqut.Ds.Entity.History;
import Cqut.Ds.Service.HistoryService;

public class HistoryServiceImpl implements HistoryService {
	public HistoryDao historyDao;
	  
	public HistoryDao getHistoryDao() {
	    return historyDao;
	}
	public void setHistoryDao(HistoryDao historyDao) {
		this.historyDao = historyDao;
	}
	public void Record(String name,String operation,String fileName) {
		historyDao.Record(name, operation, fileName);
	}
	public boolean deleteRecord(int historyID) {		
		return historyDao.deleteRecord(historyID);	  
	}
    public List<History> HistoryList(){
	    return historyDao.HistoryList();
    }
}
