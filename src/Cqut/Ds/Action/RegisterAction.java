package Cqut.Ds.Action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import Cqut.Ds.Service.UserService;

public class RegisterAction  extends ActionSupport  {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private UserService userService;
    private String userName;
    private String password;
    private String password1;
    private String nickName;

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
	
	public String getPassword1() {
		return password1;
	}

	public void setPassword1(String password1) {
		this.password1 = password1;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String execute(){  
		if(password.equals(password1)) {
	    	ActionContext actionContext = ActionContext.getContext();
			boolean register = userService.addUser(userName, password,nickName);
			if(!register) {
				 actionContext.put("msg","×¢²áÊ§°Ü£¡");
		         return "registerFailure";	
		    }	
		}
		return"registerSuccess";	
    }
}
