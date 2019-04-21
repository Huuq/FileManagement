package Cqut.Ds.ServiceImpl;

import Cqut.Ds.Dao.UserDao;
import Cqut.Ds.Entity.User;
import Cqut.Ds.Service.UserService;

public class UserServiceImpl implements UserService{
	public UserDao userDao;
	   
	public UserDao getUserDao() {
		return userDao;
	}
	public void setUserDao(UserDao userDao) {
	    this.userDao = userDao;
	}
	public User findUser(String userName) {
		return userDao.findUser(userName); 
	}
	public boolean addUser(String userName,String password,String nickName) {
		return userDao.addUser(userName, password,nickName);
	}
}
