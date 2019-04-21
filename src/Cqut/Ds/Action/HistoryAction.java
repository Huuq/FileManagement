package Cqut.Ds.Action;

import java.util.List;

import com.opensymphony.xwork2.ActionContext;

import Cqut.Ds.Entity.History;
import Cqut.Ds.Service.HistoryService;

public class HistoryAction {
    public HistoryService historyService;
    public String userName;
    public String operation;
	public HistoryService getHistoryService() {
		return historyService;
	}
	public void setHistoryService(HistoryService historyService) {
		this.historyService = historyService;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getOperation() {
		return operation;
	}
	public void setOperation(String operation) {
		this.operation = operation;
	}
	public String execute(){		
		List<History> listHistory = historyService.HistoryList();		
		ActionContext actionContext = ActionContext.getContext();
		if(listHistory.size()>0) {			
			actionContext.put("listHistory",listHistory); 		
			ActionContext.getContext().getSession().put("downloadHistory",listHistory);	
			return "successRecord";
		}	
		else {			
			actionContext.put("msg","暂时没有任何操作记录"); 
			return "successRecord";
		}		
	}
	   
}
