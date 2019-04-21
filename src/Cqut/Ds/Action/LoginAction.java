package Cqut.Ds.Action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import Cqut.Ds.Entity.User;
import Cqut.Ds.Service.UserService;

public class LoginAction  extends ActionSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private UserService userService;
	private  User user;
    private String userName;
    private String password;

    public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String execute(){  
    	ActionContext actionContext = ActionContext.getContext();	
		user = userService.findUser(userName);
		if(user==null) {
			 actionContext.put("msgs","Äú»¹Î´×¢²á£¬ÇëÏÈ×¢²á£¡");
	         return "Input";	
	    }
		else if(user.getUserName().equals(userName)&&user.getPassword().equals(password)) {
			//actionContext.put("user",user);	
			ActionContext.getContext().getSession().put("user",user);	
			return "successLogin";
		}	
		else {
			actionContext.put("msgs","ÃÜÂë´íÎó£¬ÇëÖØÐÂÊäÈë£¡");
			return"errorLogin";
		}
    }
}
