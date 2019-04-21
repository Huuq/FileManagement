package Cqut.Ds.Service;

import Cqut.Ds.Entity.User;

public interface UserService {
   public User findUser(String userName);
   public boolean addUser(String userName,String password,String nickName);
}
