package Cqut.Ds.Dao;

import java.util.List;

import Cqut.Ds.Entity.History;

public interface HistoryDao {
   public void Record(String name,String operation,String fileName);
   public boolean deleteRecord(int historyID);
   public List<History> HistoryList();
}
