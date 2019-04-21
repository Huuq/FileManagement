package Cqut.Ds.Dao;

import Cqut.Ds.Entity.User;

public interface UserDao {
   public User findUser(String userName);
   public boolean addUser(String userName,String password,String nickName);
}
