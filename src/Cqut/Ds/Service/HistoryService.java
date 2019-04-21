package Cqut.Ds.Service;

import java.util.List;

import Cqut.Ds.Entity.History;

public interface HistoryService {
	  public void Record(String name,String operation,String fileName);
	  public boolean deleteRecord(int historyID);
	  public List<History> HistoryList();
}
